package tasks.task08_28_11_2017.entities.XMLParsers.StAX;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.task08_28_11_2017.entities.Candy;
import tasks.task08_28_11_2017.entities.Ingredient;
import tasks.task08_28_11_2017.entities.Manufacturer;
import tasks.task08_28_11_2017.enumerations.NutrionalValue;
import tasks.task08_28_11_2017.exceptions.CandyParseException;

import static org.junit.jupiter.api.Assertions.*;

class StAXCandyParserTest {

    private static final String XML_PATH = "src\\test\\java\\tasks\\task08_28_11_2017\\entities\\resources\\invalidTestXML2";
    private static final String VALID_XML_PATH = "src\\test\\java\\tasks\\task08_28_11_2017\\entities\\resources\\validTestXML";

    StAXCandyParser stAXCandyParser;
    Manufacturer manufacturer;

    @BeforeEach
    void setUp() {
        manufacturer = new Manufacturer("manuf1", "first manuf");
    }

    @Test
    void parse() {
        assertThrows(CandyParseException.class, () -> {
            stAXCandyParser = new StAXCandyParser(XML_PATH);
            stAXCandyParser.parse();
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

            stAXCandyParser = new StAXCandyParser(VALID_XML_PATH);
            stAXCandyParser.parse();
            Candy result = stAXCandyParser.getResultantCandies().get(0);

            assertEquals(expected, result);
        } catch (CandyParseException e) {
            fail(e.getMessage());
        }
    }
}