package com.zensar.messageapi.security.jwt.util;

import java.util.Date;

import org.springframework.stereotype.Component;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Component
public class JWTUtil {
	
	public String generateToken(String username)
    {
        String jwtToken = JWT.create()

                           //payload (Consists of username)   
                          .withClaim("name", username)

                           //payload (Consists of expiration time)
                          .withExpiresAt(new Date(System.currentTimeMillis()+16000))
                          
                          //Header + signature
                          .sign(Algorithm.HMAC512("zensarsecret"));

        System.out.println(jwtToken);

        //We have created JWT token
        return jwtToken;

    }
	
	public void validateToken(String token)
    {
        JWT.require(Algorithm.HMAC512("zensarsecret")).build().verify(token);
    }
}


