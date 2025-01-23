package hello;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXML {

	public static void main(String[] args) throws Exception {
        // Specify the file path as a File object
        File xmlFile = new File("C:/Users/Ezekiel/Desktop/Java/output.xml");

        // Create a DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parse the XML file
        Document document = builder.parse(xmlFile);

        // Access elements by tag name
        NodeList nodeList = document.getElementsByTagName("library");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            System.out.println("Element Content: " + node.getTextContent());
        }
    }

}
