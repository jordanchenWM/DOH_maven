package unit;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

public class MaggieHttpTry {
	public static void main(String args[]) throws IOException, InterruptedException{
		String username = "Administrator";
        String password = "manage";
        String xml = "<DoHPORequest></DoHPORequest>";
		String basicAuth = "Basic " + new String(Base64.getEncoder().encode((username+":"+password).getBytes()));
		HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://192.168.11.121:5105/invoke/wm.tn/receive"))
                .header("Content-Type","text/xml")
                .header("Authorization", basicAuth)
                .POST(HttpRequest.BodyPublishers.ofString(xml))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
	}
}
