package client;

import java.util.Base64;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.zensar.messageapi.entity.ZensarUser;

public class ClientBasic {

	public static void main(String[] args) {
		//following this the url on the server we want to access
		RestTemplate rt = new RestTemplate();

		String loginUrl = "http://localhost:9081/api/authenticate";
		ZensarUser request = new ZensarUser();
		request.setName("zensar");
		request.setPassword("zensar");
		
		String token = rt.postForObject(loginUrl, request, String.class);
		System.out.println(token);
		
		String messageUrl = "http://localhost:9081/api/message";
		HttpHeaders headers = new HttpHeaders();
	    headers.add("Authorization", "Bearer " + token);
		
	    HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<String> exchange = rt.exchange(messageUrl, HttpMethod.GET, entity, String.class);
		System.out.println(exchange.getBody());

		//RestTemplate is a class given by spring to consume rest web service
				
		//RestTemplate rt = new RestTemplate();
		//String credentials = "zensar:zensar";

		//Following line is used to convert String to Base64 encoded form
		//Using Base64 class given by java
		//Because server expect credential in the form

		//byte[] encode = Base64.getEncoder().encode(credentials.trim().getBytes());
		//String encodedCredentials = new String(encode).trim();
		//System.out.println(encodedCredentials);

		//This encoded credential need to be passed to server using Http Header 
		//Name of the Header is Authorization 
		//It is done as follows

		//HttpHeaders headers = new HttpHeaders();
		//headers.add("Authorization", "Bearer " + encodedCredentials);
		//HttpEntity<String> entity = new HttpEntity<>(headers);

		//ResponseEntity<String> exchange = rt.exchange(url, HttpMethod.GET, entity, String.class);
		//System.out.println(exchange.getBody());
	}

}
