package app;

import sax.TagPrinterHandler;
import sax.EthnicityHandler;
import sax.PopularNamesHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

import dom.XmlWriter;
import dom.XmlReader;

import validator.XmlValidator;

public class Main {

    public static void main(String[] args) {

        try {

            File xmlFile =
                    new File(
                            "Popular_Baby_Names_NY.xml"
                    );

            SAXParserFactory factory =
                    SAXParserFactory.newInstance();

            SAXParser saxParser =
                    factory.newSAXParser();

            TagPrinterHandler handler =
                    new TagPrinterHandler();

            saxParser.parse(
                    xmlFile,
                    handler
            );

            handler.printTags();

            EthnicityHandler ethnicityHandler =
                    new EthnicityHandler();

            saxParser.parse(
                    xmlFile,
                    ethnicityHandler
            );

            ethnicityHandler.printEthnicities();

            PopularNamesHandler popularHandler =
                    new PopularNamesHandler(
                            "HISPANIC"
                    );

            saxParser.parse(
                    xmlFile,
                    popularHandler
            );

            System.out.println(
                    "\nTOP NAMES:"
            );

            for (var baby :
                    popularHandler.getTopNames(10)) {

                System.out.println(baby);
            }

            XmlWriter.saveToXml(
                    popularHandler.getTopNames(10),
                    "popular_names.xml"
            );

            XmlReader.readXml(
                    "popular_names.xml"
            );

            XmlValidator.validate(
                    "Popular_Baby_Names_NY.xml",
                    "baby_names.xsd"
            );

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}