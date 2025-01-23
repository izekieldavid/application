package hello;



import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;

import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Plot {

	public static void main(String[] args) throws Exception {
		
		String[][] employee = {
	            {"John Doe", "30", "New York"},
	            {"Izekiel David", "25", "Angeles City"},
	            {"Plot", "24", "Sanfernando City"},
	            {"Denzel Manangu", "26", "Candaba CIty"},
	            {"Jay Sosa", "27", "Dinalupian City"}
	        };
		
		
		// Create a DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        
     // Create a new Document
        Document document = builder.newDocument();
        
     // Create root element
        Element root = document.createElement("employees");
        document.appendChild(root);
        
        for (String[] emp : employee) {
        	Element employeeElement = document.createElement("employee");
        	root.appendChild(employeeElement);
        	
        	Element name = document.createElement("name");
        	name.appendChild(document.createTextNode(emp[0]));
        	employeeElement.appendChild(name);
        	
        	Element age = document.createElement("age");
        	age.appendChild(document.createTextNode(emp[1]));
        	employeeElement.appendChild(age);
        	
        	Element city = document.createElement("city");
        	city.appendChild(document.createTextNode(emp[2]));
        	employeeElement.appendChild(city);
        	
		}
        
        
        
        
        
        
        
        
     // Write to XML file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        
        // Specify your local file path
        StreamResult result = new StreamResult("C:/Users/Ezekiel/Desktop/Java/looping.xml"); 
        transformer.transform(source, result);

        System.out.println("XML file created successfully!");
	}

}
