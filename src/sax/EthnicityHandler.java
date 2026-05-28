package sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashSet;
import java.util.Set;

public class EthnicityHandler
        extends DefaultHandler {

    private boolean isEthnicity =
            false;

    private StringBuilder currentValue =
            new StringBuilder();

    private Set<String> ethnicities =
            new HashSet<>();

    @Override
    public void startElement(
            String uri,
            String localName,
            String qName,
            Attributes attributes)
            throws SAXException {

        if (qName.equals("ethcty")) {

            isEthnicity = true;

            currentValue.setLength(0);
        }
    }

    @Override
    public void characters(
            char[] ch,
            int start,
            int length)
            throws SAXException {

        if (isEthnicity) {

            currentValue.append(
                    ch,
                    start,
                    length
            );
        }
    }

    @Override
    public void endElement(
            String uri,
            String localName,
            String qName)
            throws SAXException {

        if (qName.equals("ethcty")) {

            ethnicities.add(
                    currentValue
                            .toString()
                            .trim()
            );

            isEthnicity = false;
        }
    }

    public void printEthnicities() {

        System.out.println(
                "\nETHNIC GROUPS:"
        );

        for (String ethnicity :
                ethnicities) {

            System.out.println(
                    ethnicity
            );
        }
    }
}