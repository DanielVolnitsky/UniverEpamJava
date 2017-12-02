package tasks;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import tasks.task8_28_11_2017.entities.Candy;
import tasks.task8_28_11_2017.entities.Ingredient;
import tasks.task8_28_11_2017.entities.Manufacturer;
import tasks.task8_28_11_2017.enumerations.NutrionalValue;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        DocumentBuilderFactory dbf = null;
        DocumentBuilder db = null;
        try {
            dbf = DocumentBuilderFactory.newInstance();
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.out.println("a");
        }

        Document doc = null;
        try {
            File file = new File("src\\main\\java\\tasks\\task8_28_11_2017\\documents\\CandyXML.xml");
            doc = db.parse(file);
        } catch (SAXException ex) {
            System.out.println("b");
        } catch (IOException ex) {
            System.out.println("c");
        }

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

                String id = candyElement.getElementsByTagName("id").item(0).getFirstChild().getNodeValue();
                candy.setId(Integer.parseInt(id));

                String name = candyElement.getElementsByTagName("name").item(0).getFirstChild().getNodeValue();
                candy.setName(name);

                String caloricity = candyElement.getElementsByTagName("caloricity").item(0).getFirstChild().getNodeValue();
                candy.setCaloricity(Integer.parseInt(caloricity));

                String filling = candyElement.getElementsByTagName("hasFilling").item(0).getFirstChild().getNodeValue();
                candy.setHasFilling(Boolean.parseBoolean(filling));

                String type = candyElement.getElementsByTagName("type").item(0).getFirstChild().getNodeValue();
                candy.setCandyType(Candy.CandyType.valueOf(type));

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
                                case "quantity":
                                    String quantity = ingredientValues.item(k).getFirstChild().getNodeValue();
                                    ingredient.setQuantity(Double.parseDouble(quantity));
                                    break;
                                case "description":
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

                //Работаем с питательные ценности
                Node nutrionalValues = candyElement.getElementsByTagName("nutrionalValues").item(0);
                // Получаем коллекцию питательных ценностей
                NodeList nutrionalValuesNodeList = nutrionalValues.getChildNodes();

                //проходим по питательным ценностям
                for (int j = 0; j < nutrionalValuesNodeList.getLength(); j++) {

                    Node nutrionalValuesNode = nutrionalValuesNodeList.item(j);
                    if (nutrionalValuesNode.getNodeName().equals("nutrionalValue")){

                        NutrionalValue nutrionalValue = null;
                        byte nutriQuantity = 0;

                        NodeList nutrionalValuesNodeValues = nutrionalValuesNode.getChildNodes();
                        for (int k = 0; k < nutrionalValuesNodeValues.getLength(); k++) {

                            String currNutrValuesNodeName = nutrionalValuesNodeValues.item(k).getNodeName();
                            switch (currNutrValuesNodeName) {
                                case "type":
                                    String nutrType = nutrionalValuesNodeValues.item(k).getFirstChild().getNodeValue();
                                    nutrionalValue = NutrionalValue.valueOf(nutrType);
                                    break;
                                case "quantity":
                                    String nutrQuantity = nutrionalValuesNodeValues.item(k).getFirstChild().getNodeValue();
                                    nutriQuantity = Byte.parseByte(nutrQuantity);
                                    break;
                                default:
                                    break;
                            }
                        }
                        candy.getNutrionalValues().put(nutrionalValue, nutriQuantity);
                    }
                }

                //Обработка выробника
                Node manufacturerNode = candyElement.getElementsByTagName("manufacturer").item(0);

                Manufacturer manufacturer = new Manufacturer();

                // Получаем коллекцию подтегов производителя
                NodeList manufacturerNodes = manufacturerNode.getChildNodes();
                for (int j = 0; j < manufacturerNodes.getLength(); j++) {

                    String currManufNodeName = manufacturerNodes.item(j).getNodeName();
                    switch (currManufNodeName) {
                        case "name":
                            String manufName = manufacturerNodes.item(j).getFirstChild().getNodeValue();
                            manufacturer.setName(manufName);
                            break;
                        case "description":
                            String manufDesc = manufacturerNodes.item(j).getFirstChild().getNodeValue();
                            manufacturer.setDescription(manufDesc);
                            break;
                        default:
                            break;
                    }
                }
                candy.setManufacturer(manufacturer);
                System.out.println(candy);
                System.out.println();
            }

        }
    }
}