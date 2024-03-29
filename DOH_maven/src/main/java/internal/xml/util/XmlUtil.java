package internal.xml.util;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class XmlUtil {

	public static String jaxbObjectToXML(Object msg) throws JAXBException
    {
		String xmlContent = null;
       
        	
        //Create JAXB Context
        JAXBContext jaxbContext = JAXBContext.newInstance(msg.getClass());
         
        //Create Marshaller
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
 
        //Required formatting??
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        //jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.w3.org/2001/XMLSchema-instance");
        jaxbMarshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "..\\XML Schema\\MATPORequest.xsd");
 
        //Print XML String to Console
        StringWriter sw = new StringWriter();
         
        //Write XML to StringWriter
        jaxbMarshaller.marshal(msg, sw);
         
        
        //Verify XML Content
        xmlContent = sw.toString();
        //System.out.println( xmlContent );
 
       
        return xmlContent;
    }
	
}
