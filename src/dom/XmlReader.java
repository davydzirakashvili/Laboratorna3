package dom;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XmlReader {

    public static void readXml(
            String fileName) {

        try {

            File xmlFile =
                    new File(fileName);

            DocumentBuilderFactory factory =
                    DocumentBuilderFactory
                            .newInstance();

            DocumentBuilder builder =
                    factory.newDocumentBuilder();

            Document document =
                    builder.parse(xmlFile);

            document.getDocumentElement()
                    .normalize();

            NodeList nodeList =
                    document.getElementsByTagName(
                            "baby"
                    );

            System.out.println(
                    "\nDATA FROM NEW XML:"
            );

            for (int i = 0;
                 i < nodeList.getLength();
                 i++) {

                Node node =
                        nodeList.item(i);

                if (node.getNodeType()
                        == Node.ELEMENT_NODE) {

                    Element element =
                            (Element) node;

                    String name =
                            element
                                    .getElementsByTagName(
                                            "name"
                                    )
                                    .item(0)
                                    .getTextContent();

                    String gender =
                            element
                                    .getElementsByTagName(
                                            "gender"
                                    )
                                    .item(0)
                                    .getTextContent();

                    String count =
                            element
                                    .getElementsByTagName(
                                            "count"
                                    )
                                    .item(0)
                                    .getTextContent();

                    String rank =
                            element
                                    .getElementsByTagName(
                                            "rank"
                                    )
                                    .item(0)
                                    .getTextContent();

                    System.out.println(
                            "Name: " + name
                    );

                    System.out.println(
                            "Gender: " + gender
                    );

                    System.out.println(
                            "Count: " + count
                    );

                    System.out.println(
                            "Rank: " + rank
                    );

                    System.out.println(
                            "----------------"
                    );
                }
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}