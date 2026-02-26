package com.example.mgateway.utils;



import java.util.Date;
import java.util.List;
import java.util.function.Function;
import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
   
	
//	public String generateToken(String username) {
//		
//	}
	private String SECRET_KEY = "TaK+HaV^uvCHEFsEVfypW#7g9^k*Z8$V";

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

	 public String extractUsername(String token) {
		 return extractClaims(token, Claims::getSubject);
	 }

	 public List<String> extractRoles(String token) {
		 return extractClaims(token,claims -> claims.get("roles", List.class));
	 }
	
	private <T> T extractClaims(String token, Function<Claims,T> claimsResolver) {
		 Claims claim =  Jwts
				          .parserBuilder()
				          .setSigningKey(getSigningKey())
				          .build()
				          .parseClaimsJws(token)
				          .getBody();
		 
		 return claimsResolver.apply(claim);
				       
	}
	
	public boolean isValidate(String token) {
		return !isExpired(token);
	}
	
	private boolean isExpired(String token) {
		Date expiryDate = extractClaims(token, Claims::getExpiration);
		System.out.println("Hello");
		return expiryDate.before(new Date());
	}
}
