package tasks.task8_28_11_2017.entities.XMLParsers;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import static org.junit.jupiter.api.Assertions.*;

class SAXCandyParserTest {

    private static final String XML_PATH = "src\\test\\java\\tasks\\task8_28_11_2017\\entities\\resources\\invalidTestXML2";
    SAXCandyParser saxCandyParser;

    @Test
    void parse() {
        assertThrows(SAXException.class, () -> {
            saxCandyParser = new SAXCandyParser(XML_PATH);
            saxCandyParser.parse();
        });
    }
}