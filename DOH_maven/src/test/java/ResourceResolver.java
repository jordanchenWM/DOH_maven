
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Objects;

import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSResourceResolver;



public class ResourceResolver implements LSResourceResolver {

    private String basePath;

    public ResourceResolver(String basePath) {
        this.basePath = basePath;
    }

    @Override
    public LSInput resolveResource(String type, String namespaceURI, String publicId, String systemId, String baseURI) {
        // note: in this sample, the XSD's are expected to be in the root of the classpath
    	/*	
    		System.out.println(buildPath(systemId));
        InputStream resourceAsStream = null;
		try {
			resourceAsStream = new FileInputStream(buildPath(systemId));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        		
        Objects.requireNonNull(resourceAsStream, String.format("Could not find the specified xsd file: %s", systemId));
        return new DOMInputImpl(publicId, systemId, baseURI, resourceAsStream, "UTF-8");
        */
    	return null;
    }

    private String buildPath(String systemId) {
        return basePath == null ? systemId : String.format("%s/%s", basePath, systemId);
    }
}