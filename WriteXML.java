package hello;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;

import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class WriteXML {

	public static void main(String[] args) throws Exception {
		// Create a DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        
     // Create a new Document
        Document document = builder.newDocument();
        
        // Create root element
        Element root = document.createElement("root");
        document.appendChild(root);
        
        //Create first record
        Element record1 = document.createElement("record");
        root.appendChild(record1);
        
        //Add elements to first record
        Element name1 = document.createElement("name");
        name1.appendChild(document.createTextNode("John Doe"));
        record1.appendChild(name1);
        
        Element age1 = document.createElement("age");
        age1.appendChild(document.createTextNode("30"));
        record1.appendChild(age1);
        
        Element city1 = document.createElement("city");
        city1.appendChild(document.createTextNode("Angeles City"));
        record1.appendChild(city1);
        
        //Create second record
        Element record2 = document.createElement("record");
        root.appendChild(record2);
        
        //add elements to second record
        Element name2 = document.createElement("name");
        name2.appendChild(document.createTextNode("Plotypus"));
        record2.appendChild(name2);
        
        Element age2 = document.createElement("age");
        age2.appendChild(document.createTextNode("25"));
        record2.appendChild(age2);
        
        Element city2 = document.createElement("city");
        city2.appendChild(document.createTextNode("Sanfernando"));
        record2.appendChild(city2);
        
        
        
        
        
     // Write to XML file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        
        // Specify your local file path
        StreamResult result = new StreamResult("C:/Users/Ezekiel/Desktop/Java/sample.xml"); 
        transformer.transform(source, result);

        System.out.println("XML file created successfully!");
	}

}
