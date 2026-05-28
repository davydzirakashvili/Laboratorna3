package sax;

import model.BabyName;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PopularNamesHandler
        extends DefaultHandler {

    private List<BabyName> babyNames =
            new ArrayList<>();

    private String currentTag = "";

    private String name = "";
    private String gender = "";
    private String ethnicity = "";
    private int count = 0;
    private int rank = 0;

    private final String targetEthnicity;

    public PopularNamesHandler(
            String targetEthnicity) {

        this.targetEthnicity =
                targetEthnicity;
    }

    @Override
    public void startElement(
            String uri,
            String localName,
            String qName,
            Attributes attributes)
            throws SAXException {

        currentTag = qName;
    }

    @Override
    public void characters(
            char[] ch,
            int start,
            int length)
            throws SAXException {

        String value =
                new String(
                        ch,
                        start,
                        length
                ).trim();

        if (value.isEmpty()) {
            return;
        }

        switch (currentTag) {

            case "nm":
                name = value;
                break;

            case "gndr":
                gender = value;
                break;

            case "ethcty":
                ethnicity = value;
                break;

            case "cnt":
                count =
                        Integer.parseInt(
                                value
                        );
                break;

            case "rnk":
                rank =
                        Integer.parseInt(
                                value
                        );
                break;
        }
    }

    @Override
    public void endElement(
            String uri,
            String localName,
            String qName)
            throws SAXException {

        if (qName.equals("row")) {

            if (ethnicity.equalsIgnoreCase(
                    targetEthnicity)) {

                babyNames.add(
                        new BabyName(
                                name,
                                gender,
                                ethnicity,
                                count,
                                rank
                        )
                );
            }
        }
    }

    public List<BabyName> getTopNames(
            int limit) {

        babyNames.sort(
                Comparator.comparingInt(
                        BabyName::getRank
                )
        );

        if (babyNames.size() > limit) {

            return babyNames.subList(
                    0,
                    limit
            );
        }

        return babyNames;
    }
}