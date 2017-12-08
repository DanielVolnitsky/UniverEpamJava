package tasks.task8_28_11_2017.entities.XMLValidator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CandiesXSDValidatorTest {

    private static final String VALID_XML_PATH = "src\\test\\java\\tasks\\task8_28_11_2017\\entities\\resources\\validTestXML";
    private static final String INVALID_XML_PATH = "src\\test\\java\\tasks\\task8_28_11_2017\\entities\\resources\\invalidTestXML";
    private static final String XSD_PATH = "src\\main\\resources\\Candy.xsd";

    @Test
    void validate() {
        boolean result = CandiesXSDValidator.validate(VALID_XML_PATH, XSD_PATH);
        assertTrue(result);
    }

    @Test
    void validate1() {
        boolean result = CandiesXSDValidator.validate(INVALID_XML_PATH, XSD_PATH);
        assertFalse(result);
    }
}