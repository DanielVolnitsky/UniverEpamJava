package tasks;

import org.xml.sax.SAXException;
import tasks.task8_28_11_2017.entities.CandyStock;
import tasks.task8_28_11_2017.entities.XMLDeconstructors.CandyParser;
import tasks.task8_28_11_2017.entities.XMLDeconstructors.DOMCandyParser;
import tasks.task8_28_11_2017.entities.XMLDeconstructors.SAXCandyParser;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        String path = "src\\main\\java\\tasks\\task8_28_11_2017\\documents\\CandyXML.xml";

        CandyStock stock = new CandyStock();

        CandyParser domParser = new DOMCandyParser(path);
        domParser.parse();

        stock.addCandyList(domParser.getResultantCandies());

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        SAXCandyParser saxCandyParser = new SAXCandyParser();
        parser.parse(new File(path), saxCandyParser);

        stock.addCandyList(saxCandyParser.getResultantCandies());

        System.out.println(stock);
    }
}