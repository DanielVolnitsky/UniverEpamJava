package tasks.task8_28_11_2017.entities.XMLParsers;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import tasks.task8_28_11_2017.entities.Candy;
import tasks.task8_28_11_2017.entities.Ingredient;
import tasks.task8_28_11_2017.entities.Manufacturer;
import tasks.task8_28_11_2017.enumerations.NutrionalValue;
import tasks.task8_28_11_2017.exceptions.CandyParseException;
import tasks.task8_28_11_2017.exceptions.InvalidQuantityException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOMCandyParser extends CandyParser {

    static Logger log = Logger.getLogger("DOMCandyParser");

    static {
        new DOMConfigurator().doConfigure("src\\main\\resources\\log4j.xml", LogManager.getLoggerRepository());
    }

    private Document doc;

    public DOMCandyParser(String xmlPath) throws ParserConfigurationException, IOException, SAXException {
        this.xmlPath = xmlPath;

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        File file = new File(this.xmlPath);
        doc = db.parse(file);
    }

    @Override
    public void parse() throws CandyParseException {
        /*Корневой элемент*/
        Element root = doc.getDocumentElement();
        if (root.getTagName().equals("candies")) {
            // Получаем коллекцию конфет
            NodeList listCandies = root.getElementsByTagName("candy");
            // Проходим по конфетам
            for (int i = 0; i < listCandies.getLength(); i++) {

                Candy candy = new Candy();

                // Получаем текущую конфету
                Element candyElement = (Element) listCandies.item(i);

                candy.setId(candyElement.getElementsByTagName("candyId").item(0).getFirstChild().getNodeValue());
                candy.setName(candyElement.getElementsByTagName("candyName").item(0).getFirstChild().getNodeValue());
                candy.setCaloricity(Integer.parseInt(
                        candyElement.getElementsByTagName("candyCaloricity").item(0).getFirstChild().getNodeValue()));

                String candyType = candyElement.getElementsByTagName("candyType").item(0).getFirstChild().getNodeValue();
                candy.setCandyType(Candy.CandyType.valueOf(candyType.toUpperCase()));

                candy.setHasFilling(Boolean.parseBoolean(
                        candyElement.getElementsByTagName("candyHasFilling").item(0).getFirstChild().getNodeValue()));

                handleManufacturer(candy, candyElement);

                try {
                    handleNutrionalValues(candy, candyElement);
                    handleIngredients(candy, candyElement);

                    resultantCandies.add(candy);
                    log.info("successful parsing of candy with name " + candy.getName());
                } catch (InvalidQuantityException e) {
                    log.error("failed to parse candy with name " + candy.getName() + ": " + e.getMessage());
                    throw new CandyParseException();
                }
            }
        }
    }

    private void handleManufacturer(Candy candy, Element candyElement) {
        Node manufacturerNode = candyElement.getElementsByTagName("manufacturer").item(0);

        Manufacturer manufacturer = new Manufacturer();

        // Получаем коллекцию подтегов производителя
        NodeList manufacturerNodes = manufacturerNode.getChildNodes();
        for (int j = 0; j < manufacturerNodes.getLength(); j++) {

            String currManufNodeName = manufacturerNodes.item(j).getNodeName();
            switch (currManufNodeName) {
                case "manufacturerName":
                    String manufName = manufacturerNodes.item(j).getFirstChild().getNodeValue();
                    manufacturer.setName(manufName);
                    break;
                case "manufacturerDescription":
                    String manufDesc = manufacturerNodes.item(j).getFirstChild().getNodeValue();
                    manufacturer.setDescription(manufDesc);
                    break;
                default:
                    break;
            }
        }
        candy.setManufacturer(manufacturer);
    }

    private void handleNutrionalValues(Candy candy, Element candyElement) throws InvalidQuantityException {
        Node nutrionalValues = candyElement.getElementsByTagName("nutrionalValues").item(0);
        // Получаем коллекцию питательных ценностей
        NodeList nutrionalValuesNodeList = nutrionalValues.getChildNodes();

        for (int j = 0; j < nutrionalValuesNodeList.getLength(); j++) {

            Node nutrionalValuesNode = nutrionalValuesNodeList.item(j);
            if (nutrionalValuesNode.getNodeName().equals("nutrionalValue")) {

                NutrionalValue nutrionalValue = null;
                double nutriQuantity = 0.0;

                NodeList nutrionalValuesNodeValues = nutrionalValuesNode.getChildNodes();
                for (int k = 0; k < nutrionalValuesNodeValues.getLength(); k++) {

                    String currNutrValuesNodeName = nutrionalValuesNodeValues.item(k).getNodeName();
                    switch (currNutrValuesNodeName) {
                        case "nutrionalValueType":
                            String nutrType = nutrionalValuesNodeValues.item(k).getFirstChild().getNodeValue();
                            nutrionalValue = NutrionalValue.valueOf(nutrType.toUpperCase());
                            break;
                        case "nutrionalValueQuantity":
                            Double nutrQuantity = Double.parseDouble(nutrionalValuesNodeValues.item(k).getFirstChild().getNodeValue());
                            if (nutrQuantity > 0)
                                nutriQuantity = nutrQuantity;
                            else
                                throw new InvalidQuantityException("was " + nutrQuantity);
                            break;
                        default:
                            break;
                    }
                }
                candy.getNutrionalValues().put(nutrionalValue, nutriQuantity);
            }
        }
    }

    private void handleIngredients(Candy candy, Element candyElement) throws InvalidQuantityException {
        //Берем узел с коллекцией ингредиентов
        Node ingredientsNode = candyElement.getElementsByTagName("ingredients").item(0);
        // Получаем коллекцию ингредиентов
        NodeList ingredientNodeList = ingredientsNode.getChildNodes();

        // Проходим по ингредиентам
        for (int j = 0; j < ingredientNodeList.getLength(); j++) {

            Node ingredientNode = ingredientNodeList.item(j);
            if (ingredientNode.getNodeName().equals("ingredient")) {

                Ingredient ingredient = new Ingredient();

                NodeList ingredientValues = ingredientNode.getChildNodes();
                for (int k = 0; k < ingredientValues.getLength(); k++) {

                    String currIngrValuesNodeName = ingredientValues.item(k).getNodeName();
                    switch (currIngrValuesNodeName) {
                        case "ingredientQuantity":
                            Double quantity = Double.parseDouble(ingredientValues.item(k).getFirstChild().getNodeValue());
                            if (quantity > 0)
                                ingredient.setQuantity(quantity);
                            else
                                throw new InvalidQuantityException("was " + quantity);
                            break;
                        case "ingredientDescription":
                            String description = ingredientValues.item(k).getFirstChild().getNodeValue();
                            ingredient.setDescription(description);
                            break;
                        default:
                            break;
                    }
                }
                candy.getIngredients().add(ingredient);
            }
        }
    }
}
