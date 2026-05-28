package dom;

import model.BabyName;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;
import java.util.List;

public class XmlWriter {

    public static void saveToXml(
            List<BabyName> babyNames,
            String fileName) {

        try {

            DocumentBuilderFactory factory =
                    DocumentBuilderFactory
                            .newInstance();

            DocumentBuilder builder =
                    factory.newDocumentBuilder();

            Document document =
                    builder.newDocument();

            Element root =
                    document.createElement(
                            "popular_names"
                    );

            document.appendChild(root);

            for (BabyName baby :
                    babyNames) {

                Element babyElement =
                        document.createElement(
                                "baby"
                        );

                Element name =
                        document.createElement(
                                "name"
                        );

                name.setTextContent(
                        baby.getName()
                );

                Element gender =
                        document.createElement(
                                "gender"
                        );

                gender.setTextContent(
                        baby.getGender()
                );

                Element count =
                        document.createElement(
                                "count"
                        );

                count.setTextContent(
                        String.valueOf(
                                baby.getCount()
                        )
                );

                Element rank =
                        document.createElement(
                                "rank"
                        );

                rank.setTextContent(
                        String.valueOf(
                                baby.getRank()
                        )
                );

                babyElement.appendChild(name);
                babyElement.appendChild(gender);
                babyElement.appendChild(count);
                babyElement.appendChild(rank);

                root.appendChild(
                        babyElement
                );
            }

            TransformerFactory transformerFactory =
                    TransformerFactory
                            .newInstance();

            Transformer transformer =
                    transformerFactory
                            .newTransformer();

            transformer.setOutputProperty(
                    OutputKeys.INDENT,
                    "yes"
            );

            DOMSource source =
                    new DOMSource(document);

            StreamResult result =
                    new StreamResult(
                            new File(fileName)
                    );

            transformer.transform(
                    source,
                    result
            );

            System.out.println(
                    "\nXML FILE CREATED: "
                            + fileName
            );

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}