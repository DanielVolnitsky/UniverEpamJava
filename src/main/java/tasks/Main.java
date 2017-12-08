package tasks;

import org.xml.sax.SAXException;
import tasks.task8_28_11_2017.entities.CandyStock;
import tasks.task8_28_11_2017.entities.XMLParsers.CandyParser;
import tasks.task8_28_11_2017.entities.XMLParsers.DOMCandyParser;
import tasks.task8_28_11_2017.entities.XMLParsers.SAXCandyParser;
import tasks.task8_28_11_2017.entities.XMLValidator.CandiesXSDValidator;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    private static final String XML_PATH = "src\\main\\resources\\Candy.xml";
    private static final String XSD_PATH = "src\\main\\resources\\Candy.xsd";

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
       // if (CandiesXSDValidator.validate(XML_PATH, XSD_PATH)) {
            CandyStock domStock = new CandyStock();
            CandyStock saxStock = new CandyStock();
            CandyStock staxStock = new CandyStock();

//            CandyParser domParser = new DOMCandyParser(XML_PATH);
//            domParser.parse();
//            domStock.addCandyList(domParser.getResultantCandies());
//
            try{
                SAXCandyParser saxCandyParser = new SAXCandyParser(XML_PATH);
                saxCandyParser.parse();
                saxStock.addCandyList(saxCandyParser.getResultantCandies());
            } catch (SAXException ex){

            }

//
//            StAXCandyParser stAXCandyParser = new StAXCandyParser(XML_PATH);
//            stAXCandyParser.parse();
//            staxStock.addCandyList(stAXCandyParser.getResultantCandies());

//            System.out.println("\nDOM");
//            System.out.println(domStock);
            System.out.println("SAX");
            System.out.println(saxStock);
//            System.out.println("StAX");
//            System.out.println(staxStock);

//            Collections.sort(domStock.getCandies(), new CandyComparator());
//            System.out.println(domStock);
      // }
    }
}