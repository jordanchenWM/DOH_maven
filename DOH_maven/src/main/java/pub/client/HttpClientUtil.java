package pub.client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Base64;

public class HttpClientUtil {
	
	public static void main(String[] args) {
		
	}
	
	public HttpResponse<String> send(String url, String method, Auth auth, String data) throws Exception  {
		
		HttpClient client = HttpClient.newHttpClient();  
		HttpRequest request = null;
		
		try {									
			var rqBuilder = HttpRequest.newBuilder()
					.headers("Content-Type", "text/xml")
					.timeout(Duration.ofSeconds(2))
				    .uri(URI.create(url));
			
			
			if (method.equals("POST")) {
				rqBuilder.POST(BodyPublishers.ofString(data));
			}
			
			if (auth != null) {
				String usernameColonPassword = auth.user + ":" +auth.password ;
	            String basicAuthPayload = "Basic " + Base64.getEncoder().encodeToString(usernameColonPassword.getBytes());
	            
	            rqBuilder.headers("Authorization", basicAuthPayload);
			}
					
			request = rqBuilder.build();
		} catch (Exception e) {
			throw e;
		}
		
		
		HttpResponse<String> response;
		
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (Exception e) {
			throw e;
		} 

		return response;
	}

	/*
	public HttpURLConnection send(String url, String method, Auth auth, String data) throws IOException {
		
		URL endpoint = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) endpoint.openConnection();
        
        conn.setRequestMethod(method);
        conn.setRequestProperty("Content-Type", "text/xml");
        conn.setConnectTimeout(2000);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        
        if (auth != null) {
			String usernameColonPassword = auth.user + ":" +auth.password ;
            String basicAuthPayload = "Basic " + Base64.getEncoder().encodeToString(usernameColonPassword.getBytes());
            
            conn.addRequestProperty("Authorization", basicAuthPayload);
		}
        
        DataOutputStream outputStream = new DataOutputStream(conn.getOutputStream());
        outputStream.write(data.getBytes("UTF-8"));
        outputStream.flush();
        outputStream.close();
        
        return conn;
	}
	*/
	
	public class Auth {
		String user;
		String password;
		
		public Auth(String user, String password) {
            this.user = user;
            this.password = password;
        }
	}
}
