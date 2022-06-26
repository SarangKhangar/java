package client;

import java.util.Base64;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ClientBasic {

	public static void main(String[] args) {
       //following this the url on the server we want to access
		
		String url="http://localhost:9081/api/message";
		
		//RestTemplate is a class given by spring to consume rest web service 
		
		RestTemplate rt = new RestTemplate();
		String credentials = "zensar:zensar";
		
		//
		//
		//
		
		byte[] encode = Base64.getEncoder().encode(credentials.trim().getBytes());
		String encodedCredentials = new  String(encode).trim();
		System.out.println(encodedCredentials);
		
		//
		//
		//
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization","Basic " + encodedCredentials);
		HttpEntity<String> entity = new HttpEntity<>(headers);
		
		ResponseEntity<String> exchange = rt.exchange(url, HttpMethod.GET, entity, String.class);
		System.out.println(exchange.getBody());
	}

}
