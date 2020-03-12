package internal.extractor;

import internal.tn.FormatException;

public interface IExtractor {
	
	public Object initContent(String content) throws FormatException;
	public String extract(String path) throws FormatException;
	public String getRootTag();
	
	//public String getFieldValue(String pathColumn) throws FormatException;
	//public String getDocType();
	
}
