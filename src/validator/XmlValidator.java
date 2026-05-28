package validator;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import java.io.File;
import java.io.IOException;

public class XmlValidator {

    public static void validate(
            String xmlPath,
            String xsdPath) {

        try {

            SchemaFactory factory =
                    SchemaFactory.newInstance(
                            XMLConstants
                                    .W3C_XML_SCHEMA_NS_URI
                    );

            Schema schema =
                    factory.newSchema(
                            new File(xsdPath)
                    );

            Validator validator =
                    schema.newValidator();

            validator.validate(
                    new StreamSource(
                            new File(xmlPath)
                    )
            );

            System.out.println(
                    "\nXML IS VALID!"
            );

        } catch (SAXException e) {

            System.out.println(
                    "\nXML IS NOT VALID!"
            );

            System.out.println(
                    e.getMessage()
            );

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}