package tasks.task8_28_11_2017.entities.XMLParsers.StAX;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import tasks.task8_28_11_2017.entities.Candy;
import tasks.task8_28_11_2017.entities.Ingredient;
import tasks.task8_28_11_2017.entities.Manufacturer;
import tasks.task8_28_11_2017.entities.XMLParsers.CandyParser;
import tasks.task8_28_11_2017.enumerations.NutrionalValue;
import tasks.task8_28_11_2017.exceptions.CandyParseException;
import tasks.task8_28_11_2017.exceptions.InvalidQuantityException;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class StAXCandyParser extends CandyParser {

    static Logger log = Logger.getLogger("StAXCandyParser");

    static {
        new DOMConfigurator().doConfigure("src\\main\\resources\\log4j.xml", LogManager.getLoggerRepository());
    }

    private Candy candy;
    private Ingredient ingredient;
    private NutrionalValue nutrionalValueType;
    private double nutrionalValueQuantity;
    private Manufacturer manufacturer;

    public StAXCandyParser(String xmlPath) {
        this.xmlPath = xmlPath;
    }

    @Override
    public void parse() throws CandyParseException {
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
                            double iquantity = Double.parseDouble(reader.getElementText());
                            if (iquantity > 0)
                                ingredient.setQuantity(iquantity);
                            else
                                throw new InvalidQuantityException("was " + iquantity);
                            break;
                        case "ingredientDescription":
                            ingredient.setDescription(reader.getElementText());
                            break;
                        case "nutrionalValueType":
                            nutrionalValueType = NutrionalValue.valueOf(reader.getElementText().toUpperCase());
                            break;
                        case "nutrionalValueQuantity":
                            double quantity = Double.parseDouble(reader.getElementText());
                            if (quantity > 0)
                                nutrionalValueQuantity = quantity;
                            else
                                throw new InvalidQuantityException("was " + quantity);
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
                            log.info("successful parsing of candy with name " + candy.getName());
                            break;
                        case "manufacturer":
                            candy.setManufacturer(manufacturer);
                            break;
                    }
                }
            }
        } catch (IOException e) {
            log.error("failed to connect to xml by path: " + xmlPath);
            throw new CandyParseException();
        } catch (XMLStreamException e) {
            log.error(e.getMessage());
            throw new CandyParseException();
        } catch (InvalidQuantityException e) {
            log.error("failed to parse candy with name " + candy.getName() + ": " + e.getMessage() + " End of parsing");
            throw new CandyParseException();
        }
    }
}
