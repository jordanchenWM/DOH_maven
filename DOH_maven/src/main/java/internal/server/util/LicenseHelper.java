package internal.server.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Base64;

import org.json.JSONObject;


public class LicenseHelper {
		
	public static void main(String[] args) throws Exception {
		
		String crtPath = "/Users/ecomnb/Desktop/willy/Project/SeeBurger/巧新/porche/cer/Porsche/CA/SAI_DEV.crt";
		String lcPath = "/Users/ecomnb/Desktop/test.lc";
		
		
		License config = LicenseHelper.decode(Files.readString(Paths.get(lcPath)), crtPath);
		System.out.println(config.getEndDate());
		
	}
	
	public static License decode(String src, String crtPath) throws Exception {
				
		String token = AES.Decrypt(src);
		
		String[] aConfig = token.split("\\|");
		if (aConfig.length != 2) {
			throw new Exception("Invalid license.");
		}
		
		String config = aConfig[0];
		String signed = aConfig[1];
		
		byte[] bConfig = Base64.getDecoder().decode(config);
		byte[] bSigned = Base64.getDecoder().decode(signed);
		
		boolean valid = verify(bConfig, bSigned, crtPath);		
		if (!valid) {
			throw new Exception("Invalid license.");
		}
				
		System.out.println(new String(bConfig));
		
		JSONObject obj = new JSONObject(new String(bConfig));
		License l = new License();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		
		l.setStartDate(df.parse(obj.getString("start")));
		l.setEndDate(df.parse(obj.getString("end")));
		
		return l;
		
	}
		
	private static boolean verify(byte[] data, byte[] signature, String keyFile) throws Exception {
		
		Signature sig = Signature.getInstance("SHA1withRSA");
		sig.initVerify(getPubKey(keyFile));
		sig.update(data);
		
		return sig.verify(signature);
	}
	
	private static PublicKey getPubKey(String path) throws FileNotFoundException, CertificateException {
		
		FileInputStream fin = new FileInputStream(path);
		CertificateFactory f = CertificateFactory.getInstance("X.509");
		X509Certificate certificate = (X509Certificate)f.generateCertificate(fin);
		PublicKey pk = certificate.getPublicKey();
		
		return pk;
	}
}
