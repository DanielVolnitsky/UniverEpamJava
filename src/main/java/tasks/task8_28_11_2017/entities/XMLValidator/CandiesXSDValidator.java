package tasks.task8_28_11_2017.entities.XMLValidator;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class CandiesXSDValidator {

    static Logger log = Logger.getLogger("CandiesXSDValidator");

    static {
        new DOMConfigurator().doConfigure("src\\main\\resources\\log4j.xml", LogManager.getLoggerRepository());
    }

    public static boolean validate(String xmlFilePath, String xsdFilePath) {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = factory.newSchema(new File(xsdFilePath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlFilePath)));
            log.info("XML is valid!\n");
            return true;
        } catch (SAXException | IOException e) {
            log.error(xmlFilePath + " contains errors: " + e.getMessage());
            return false;
        }
    }
}
