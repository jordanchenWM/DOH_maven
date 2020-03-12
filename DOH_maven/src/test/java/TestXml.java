
import java.io.File;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;


public class TestXml {

	public static void main(String[] args) throws Exception {
		
		String schema_path = "/Users/ecomnb/custom_workspace/DOH_maven/src/main/resources/schema/MessageInfo.xsd";

		SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        try {
            Schema schema = schemaFactory.newSchema(new File(schema_path));

           
            InputSource is = new InputSource(new StringReader("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + 
            		"<MessageInfo>\n" + 
            		"		<ProcessID>01</ProcessID>\n" + 
            		"		<SenderID>01</SenderID>\n" + 
            		"		<ReceiverID>01</ReceiverID>\n" + 
            		"		<DocumentType>RF</DocumentType>\n" + 
            		"	</MessageInfo>" + 
            		""));
    		// parse the XML into a document object
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
    		Document document = builderFactory.newDocumentBuilder().parse(is);
    		
            Validator validator = schema.newValidator();
    		DOMSource sc = new DOMSource(document);
    		validator.validate(sc);
    		//return true;
        } catch (Exception e) {
            e.printStackTrace();
            //return false;
        }
		/*
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		builderFactory.setNamespaceAware(true);
		
		DocumentBuilder parser = builderFactory
				.newDocumentBuilder();
		
		InputSource is = new InputSource(new StringReader("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + 
        		"<MessageInfo>\n" + 
        		"		<ReceiverID>01</ReceiverID>\n" + 
        		"		<DocumentType>RF</DocumentType>\n" + 
        		"	</MessageInfo>" + 
        		""));
		// parse the XML into a document object
		Document document = parser.parse(is);
		
		SchemaFactory factory = SchemaFactory
				.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		factory.setResourceResolver(new ResourceResolver("/Users/ecomnb/Desktop"));
		
		Schema schema = factory.newSchema(new File("/Users/ecomnb/custom_workspace/DOH_maven/src/main/resources/schema/MessageInfo.xsd"));

		Validator validator = schema.newValidator();
		DOMSource sc = new DOMSource(document);
		validator.validate(sc);
		*/
		
	}
}
