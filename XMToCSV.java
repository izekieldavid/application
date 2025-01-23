package hello;

import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMToCSV {

	public static void main(String[] args) {
		try{
			// Load and parse the XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("C:/Users/Ezekiel/Desktop/Java/looping.xml");
            doc.getDocumentElement().normalize();
			
         // Get all records
            NodeList records = doc.getElementsByTagName("employee");
         
         // Dynamically extract headers
            Set<String> headersSet = new HashSet<>();
            for (int i = 0; i < records.getLength(); i++) {
                Node node = records.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    NodeList children = element.getChildNodes();
                    for (int j = 0; j < children.getLength(); j++) {
                        if (children.item(j).getNodeType() == Node.ELEMENT_NODE) {
                            headersSet.add(children.item(j).getNodeName());
                        }
                    }
                }
            }
            
         // Convert headers to an array for ordering
            String[] headers = headersSet.toArray(new String[0]);
            
         // Write to CSV
            try (FileWriter csvWriter = new FileWriter("C:/Users/Ezekiel/Desktop/Java/plot.csv")) {
                // Write headers
                csvWriter.append(String.join(",", headers)).append("\n");
                
                
             // Write rows
                for (int i = 0; i < records.getLength(); i++) {
                    Node node = records.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        for (String header : headers) {
                            String value = element.getElementsByTagName(header).getLength() > 0
                                    ? element.getElementsByTagName(header).item(0).getTextContent()
                                    : "";
                            csvWriter.append(value).append(",");
                        }
                        csvWriter.append("\n");
                    }
                }
            }

            System.out.println("XML data has been successfully written to plot.csv");

			
			
		}catch (Exception e) {
            e.printStackTrace();
        }

	}

}
