package tasks.task8_28_11_2017.entities.XMLParsers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tasks.task8_28_11_2017.exceptions.CandyParseException;

class DOMCandyParserTest {

    private static final String XML_PATH = "src\\test\\java\\tasks\\task8_28_11_2017\\entities\\resources\\invalidTestXML2";
    CandyParser domParser;

    @Test
    void parse() {
        Assertions.assertThrows(CandyParseException.class, () -> {
            domParser = new DOMCandyParser(XML_PATH);
            domParser.parse();
        });
    }
}