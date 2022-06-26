import java.util.Scanner;

import com.zensar.messageapi.security.jwt.util.JWTUtil;

public class JWTUtilTest {

	public static void main(String[] args) {
		
		JWTUtil jwt = new JWTUtil();
		
		String token = jwt.generateToken("zensar");
		
		new Scanner(System.in).next();
		
		try 
		{
			jwt.validateToken(token);
			System.out.println("valid");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("not valid");
		}

	}

}
