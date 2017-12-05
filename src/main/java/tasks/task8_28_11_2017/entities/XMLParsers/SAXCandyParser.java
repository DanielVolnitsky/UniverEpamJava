package tasks.task8_28_11_2017.entities.XMLParsers;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import tasks.task8_28_11_2017.entities.Candy;
import tasks.task8_28_11_2017.entities.Ingredient;
import tasks.task8_28_11_2017.entities.Manufacturer;
import tasks.task8_28_11_2017.enumerations.NutrionalValue;
import tasks.task8_28_11_2017.exceptions.InvalidQuantityException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SAXCandyParser extends DefaultHandler {

    private SAXParserFactory factory;
    private SAXParser parser;
    private String xmlPath;

    private List<Candy> resultantCandies;
    private String elementName;
    private Candy candy;
    private Ingredient ingredient;
    private NutrionalValue nutrionalValueType;
    private double nutrionalValueQuantity;
    private Manufacturer manufacturer;

    public SAXCandyParser(String xmlPath) throws ParserConfigurationException, SAXException {
        this.xmlPath = xmlPath;

        factory = SAXParserFactory.newInstance();
        parser = factory.newSAXParser();
    }

    public List<Candy> getResultantCandies() {
        return resultantCandies;
    }

    public void setResultantCandies(List<Candy> resultantCandies) {
        this.resultantCandies = resultantCandies;
    }

    public void parse() throws IOException, SAXException {
        parser.parse(new File(xmlPath), this);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementName = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        switch (elementName) {
            case "candies":
                resultantCandies = new ArrayList<>();
                break;
            case "candy":
                candy = new Candy();
                break;
            case "candyId":
                candy.setId(new String(ch, start, length));
                break;
            case "candyName":
                candy.setName(new String(ch, start, length));
                break;
            case "candyCaloricity":
                candy.setCaloricity(new Integer(new String(ch, start, length)));
                break;
            case "candyType":
                candy.setCandyType(Candy.CandyType.valueOf(new String(ch, start, length).toUpperCase()));
                break;
            case "candyHasFilling":
                candy.setHasFilling(Boolean.parseBoolean(new String(ch, start, length)));
                break;
            case "ingredient":
                ingredient = new Ingredient();
                break;
            case "ingredientQuantity":
                double iquantity = Double.parseDouble(new String(ch, start, length));
                if(iquantity > 0)
                    ingredient.setQuantity(iquantity);
                else
                    System.out.println("quant problems");
                //logging
                ingredient.setQuantity(Double.parseDouble(new String(ch, start, length)));
                break;
            case "ingredientDescription":
                ingredient.setDescription(new String(ch, start, length));
                break;
            case "nutrionalValueType":
                nutrionalValueType = NutrionalValue.valueOf(new String(ch, start, length).toUpperCase());
                break;
            case "nutrionalValueQuantity":
                double quantity = Double.parseDouble(new String(ch, start, length));
                if(quantity > 0)
                    nutrionalValueQuantity = quantity;
                else
                    System.out.println("quant problems");
                    //logging
                break;
            case "manufacturer":
                manufacturer = new Manufacturer();
                break;
            case "manufacturerName":
                manufacturer.setName(new String(ch, start, length));
                break;
            case "manufacturerDescription":
                manufacturer.setDescription(new String(ch, start, length));
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "ingredient":
                candy.addIngredient(ingredient);
                break;
            case "nutrionalValue":
                candy.getNutrionalValues().put(nutrionalValueType, nutrionalValueQuantity);
                break;
            case "candy":
                resultantCandies.add(candy);
                break;
            case "manufacturer":
                candy.setManufacturer(manufacturer);
                break;
        }
        elementName = "";
    }
}
