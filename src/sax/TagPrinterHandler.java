package sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashSet;
import java.util.Set;

public class TagPrinterHandler
        extends DefaultHandler {

    private Set<String> tags =
            new HashSet<>();

    @Override
    public void startElement(
            String uri,
            String localName,
            String qName,
            Attributes attributes)
            throws SAXException {

        tags.add(qName);
    }

    public void printTags() {

        System.out.println(
                "\nTAGS IN XML:"
        );

        for (String tag : tags) {

            System.out.println(tag);
        }
    }
}