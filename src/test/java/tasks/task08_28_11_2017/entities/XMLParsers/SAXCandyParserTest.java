package tasks.task08_28_11_2017.entities.XMLParsers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;
import tasks.task08_28_11_2017.entities.Candy;
import tasks.task08_28_11_2017.entities.Ingredient;
import tasks.task08_28_11_2017.entities.Manufacturer;
import tasks.task08_28_11_2017.enumerations.NutrionalValue;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SAXCandyParserTest {

    private static final String INVALID_XML_PATH = "src\\test\\java\\tasks\\task08_28_11_2017\\entities\\resources\\invalidTestXML2";
    private static final String VALID_XML_PATH = "src\\test\\java\\tasks\\task08_28_11_2017\\entities\\resources\\validTestXML";

    SAXCandyParser saxCandyParser;
    Manufacturer manufacturer;

    @BeforeEach
    void setUp() {
        manufacturer = new Manufacturer("manuf1", "first manuf");
    }

    @Test
    void parse() {
        assertThrows(SAXException.class, () -> {
            saxCandyParser = new SAXCandyParser(INVALID_XML_PATH);
            saxCandyParser.parse();
        });
    }

    @Test
    void parse1() {
        try {
            Candy expected = new Candy("p_1", "candy1", 5, Candy.CandyType.CHOCOLATE, true, manufacturer);
            Ingredient ingredient = new Ingredient();
            ingredient.setDescription("varenije");
            ingredient.setQuantity(0.2);
            expected.addIngredient(ingredient);
            expected.getNutrionalValues().put(NutrionalValue.PROTEIN, 0.5);

            SAXCandyParser saxCandyParser = new SAXCandyParser(VALID_XML_PATH );
            saxCandyParser.parse();
            Candy result = saxCandyParser.getResultantCandies().get(0);

            assertEquals(expected, result);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            fail(e.getMessage());
        }
    }
}