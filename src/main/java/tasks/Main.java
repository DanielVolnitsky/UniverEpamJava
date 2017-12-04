package tasks;

import org.xml.sax.SAXException;
import tasks.task8_28_11_2017.entities.CandyStock;
import tasks.task8_28_11_2017.entities.XMLDeconstructors.DOMCandyCandyDeconstructor;
import tasks.task8_28_11_2017.entities.XMLDeconstructors.CandyDeconstructor;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String path = "src\\main\\java\\tasks\\task8_28_11_2017\\documents\\CandyXML.xml";

        try {

            CandyStock stock = new CandyStock();

            CandyDeconstructor domDeconstructor = new DOMCandyCandyDeconstructor(path);
            domDeconstructor.deconstruct();

            stock.addCandyList(domDeconstructor.getResultantCandies());

            System.out.println(stock);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            System.out.println("problem with deconstruct dom");
        }
    }
}