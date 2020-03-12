package internal.server.util;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES {

	static String sKey = "ecomsoftware2019";
	
	// 加密
	public static String Encrypt(byte[] src) throws Exception {
				
		byte[] raw = sKey.getBytes();
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");//"算法/模式/补码方式"
		IvParameterSpec iv = new IvParameterSpec("0102030405060708".getBytes());//使用CBC模式，需要一个向量iv，可增加加密算法的强度
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
		byte[] encrypted = cipher.doFinal(src);
				
		return new String(Base64.getEncoder().encode(encrypted));
		//return new  Base64.gencode(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
	}
	
	public static String Encrypt(String sSrc) throws Exception {
		return Encrypt(sSrc.getBytes());
	}
	
	
	// 解密
	public static String Decrypt(String sSrc) throws Exception {
		
		try {						
			byte[] raw = sKey.getBytes("ASCII");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			IvParameterSpec iv = new IvParameterSpec("0102030405060708".getBytes());
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
			//byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);//先用base64解密
			byte[] encrypted1 = Base64.getDecoder().decode(sSrc);//先用base64解密
			
			byte[] original = cipher.doFinal(encrypted1);
			String originalString = new String(original);
			return originalString;
			
		} catch (Exception ex) {
			throw ex;
		}
	}
	
}


