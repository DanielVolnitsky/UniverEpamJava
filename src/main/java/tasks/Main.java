package tasks;

import org.xml.sax.SAXException;
import tasks.task8_28_11_2017.comparators.CandyComparator;
import tasks.task8_28_11_2017.entities.Candy;
import tasks.task8_28_11_2017.entities.CandyStock;
import tasks.task8_28_11_2017.entities.XMLParsers.CandyParser;
import tasks.task8_28_11_2017.entities.XMLParsers.DOMCandyParser;
import tasks.task8_28_11_2017.entities.XMLParsers.SAXCandyParser;
import tasks.task8_28_11_2017.entities.XMLParsers.StAX.StAXCandyParser;
import tasks.task8_28_11_2017.entities.XMLValidator.CandiesXSDValidator;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Collections;

public class Main {

    private static final String XML_PATH = "src\\main\\resources\\Candy.xml";
    private static final String XSD_PATH = "src\\main\\resources\\Candy.xsd";

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        if (CandiesXSDValidator.validate(XML_PATH, XSD_PATH)) {
            CandyStock domStock = new CandyStock();
            CandyStock saxStock = new CandyStock();
            CandyStock staxStock = new CandyStock();

            CandyParser domParser = new DOMCandyParser(XML_PATH);
            domParser.parse();
            domStock.addCandyList(domParser.getResultantCandies());

            SAXCandyParser saxCandyParser = new SAXCandyParser(XML_PATH);
            saxCandyParser.parse();
            saxStock.addCandyList(saxCandyParser.getResultantCandies());

            StAXCandyParser stAXCandyParser = new StAXCandyParser(XML_PATH);
            stAXCandyParser.parse();
            staxStock.addCandyList(stAXCandyParser.getResultantCandies());

            System.out.println("\nDOM");
            System.out.println(domStock);
            System.out.println("SAX");
            System.out.println(saxStock);
            System.out.println("StAX");
            System.out.println(staxStock);

            System.out.println("Comparing candies in different stock:");
            for (int i = 0; i < domStock.getCandies().size(); i++) {
                Candy domCandy = domStock.getCandies().get(i);
                boolean domSaxEquals = domCandy.equals(saxStock.getCandies().get(i));
                boolean domStaxEquals = domCandy.equals(staxStock.getCandies().get(i));
                System.out.println((i + 1) +" DOM candy equals same candy in SAX? - " + domSaxEquals);
                System.out.println((i + 1) +" DOM candy equals same candy in StAX? - " + domStaxEquals);
            }

            System.out.println("\nSorted DOM candies:");
            Collections.sort(domStock.getCandies(), new CandyComparator());
            System.out.println(domStock);
        }
    }
}