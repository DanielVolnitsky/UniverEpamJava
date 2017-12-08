package tasks.task8_28_11_2017.entities.XMLParsers.StAX;

import org.junit.jupiter.api.Test;
import tasks.task8_28_11_2017.exceptions.CandyParseException;

import static org.junit.jupiter.api.Assertions.*;

class StAXCandyParserTest {

    private static final String XML_PATH = "src\\test\\java\\tasks\\task8_28_11_2017\\entities\\resources\\invalidTestXML2";
    StAXCandyParser stAXCandyParser;

    @Test
    void parse() {
        assertThrows(CandyParseException.class, () ->{
            stAXCandyParser = new StAXCandyParser(XML_PATH);
            stAXCandyParser.parse();
        });
    }
}