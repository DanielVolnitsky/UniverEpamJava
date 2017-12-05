package tasks.task8_28_11_2017.entities.XMLParsers.StAX;

import tasks.task8_28_11_2017.entities.Candy;
import tasks.task8_28_11_2017.entities.Ingredient;
import tasks.task8_28_11_2017.entities.Manufacturer;
import tasks.task8_28_11_2017.entities.XMLParsers.CandyParser;
import tasks.task8_28_11_2017.enumerations.NutrionalValue;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class StAXCandyParser extends CandyParser {

    private Candy candy;
    private Ingredient ingredient;
    private NutrionalValue nutrionalValueType;
    private double nutrionalValueQuantity;
    private Manufacturer manufacturer;

    public StAXCandyParser(String xmlPath) {
        this.xmlPath = xmlPath;
    }

    @Override
    public void parse() throws IOException {
        try (StaxStreamProcessor processor = new StaxStreamProcessor(Files.newInputStream(Paths.get(xmlPath)))) {
            XMLStreamReader reader = processor.getReader();

            while (reader.hasNext()) {
                int event = reader.next();
                if (event == XMLEvent.START_ELEMENT) {
                    switch (reader.getLocalName()) {
                        case "candies":
                            resultantCandies = new ArrayList<>();
                            break;
                        case "candy":
                            candy = new Candy();
                            break;
                        case "candyId":
                            candy.setId(reader.getElementText());
                            break;
                        case "candyName":
                            candy.setName(reader.getElementText());
                            break;
                        case "candyCaloricity":
                            candy.setCaloricity(Integer.parseInt(reader.getElementText()));
                            break;
                        case "candyType":
                            candy.setCandyType(Candy.CandyType.valueOf(reader.getElementText().toUpperCase()));
                            break;
                        case "candyHasFilling":
                            candy.setHasFilling(Boolean.parseBoolean(reader.getElementText()));
                            break;
                        case "ingredient":
                            ingredient = new Ingredient();
                            break;
                        case "ingredientQuantity":
                            ingredient.setQuantity(Double.parseDouble(reader.getElementText()));
                            break;
                        case "ingredientDescription":
                            ingredient.setDescription(reader.getElementText());
                            break;
                        case "nutrionalValueType":
                            nutrionalValueType = NutrionalValue.valueOf(reader.getElementText().toUpperCase());
                            break;
                        case "nutrionalValueQuantity":
                            nutrionalValueQuantity = Double.parseDouble(reader.getElementText());
                            break;
                        case "manufacturer":
                            manufacturer = new Manufacturer();
                            break;
                        case "manufacturerName":
                            manufacturer.setName(reader.getElementText());
                            break;
                        case "manufacturerDescription":
                            manufacturer.setDescription(reader.getElementText());
                            break;
                    }
                } else if (event == XMLEvent.END_ELEMENT) {
                    switch (reader.getLocalName()) {
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
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
