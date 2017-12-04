package tasks.task8_28_11_2017.entities.XMLParsers.StAX;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.InputStream;

public class StaxStreamProcessor implements AutoCloseable {
    private static final XMLInputFactory FACTORY = XMLInputFactory.newInstance();

    private final XMLStreamReader reader;


    public StaxStreamProcessor(InputStream is) throws XMLStreamException {
        reader = FACTORY.createXMLStreamReader(is);
    }

    public XMLStreamReader getReader() {
        return reader;
    }

    public String getAttribute(String name) throws XMLStreamException {
        return reader.getAttributeValue(null, name);
    }

    public String getText() throws XMLStreamException {
        return reader.getElementText();
    }

    /**сканирует XML до конца файла, останавливаясь на заданном теге*/
    public boolean doUntil(int stopEvent, String value) throws XMLStreamException {
        while (reader.hasNext()) {
            int event = reader.next();
            if (event == stopEvent && value.equals(reader.getLocalName())) {
                return true;
            }
        }
        return false;
    }

    /**сканирует XML либо до конца тэга родителя, либо до заданного элемента*/
    public boolean startElement(String element, String parent) throws XMLStreamException {
        while (reader.hasNext()) {
            int event = reader.next();
            if (parent != null && event == XMLEvent.END_ELEMENT &&
                    parent.equals(reader.getLocalName())) {
                return false;
            }
            if (event == XMLEvent.START_ELEMENT && element.equals(reader.getLocalName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void close() {
        if (reader != null) {
            try {
                reader.close();
            } catch (XMLStreamException e) {
            }
        }
    }
}