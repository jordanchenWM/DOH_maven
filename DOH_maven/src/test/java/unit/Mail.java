package unit;

import java.util.ArrayList;
import java.util.List;

import pub.client.SendMail;

public class Mail {

	public static void main(String[] args) {
		//SendMail.sendHtml();
		List<String> mailTo = new ArrayList<>();
		mailTo.add("willy@192.168.11.240");
		//mailTo.add("w123256975@gmail.com");
		
		SendMail.send("192.168.11.240", mailTo, "test@192.168.11.240", "test-JavaMail", "<h1 style='color:red'>下午3：00會議室</h1> test-JavaMail12345", 
				null, null, null );
		
		System.out.println("123");
	}
}
