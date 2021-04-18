package com.springboot.forum.config.security;

import java.util.Date;

import com.springboot.forum.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${forum.jwt.expiration}")
	private String expiration;
	
	@Value("${forum.jwt.secret}")
	private String secret;
	
	public String generateToken(Authentication authentication) {
		User logged = (User) authentication.getPrincipal();
		Date today = new Date();
		Date ExpirationDate = new Date(today.getTime() + Long.parseLong(expiration));
		
		return Jwts.builder()
			.setIssuer("SPRING BOOT FORUM")
			.setSubject(logged.getId().toString())
			.setIssuedAt(today)
			.setExpiration(ExpirationDate)
			.signWith(SignatureAlgorithm.HS256, secret)
			.compact();
	}

	public boolean isValid(String token) {
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Long getIdUser(String token) {
		Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		return Long.parseLong(claims.getSubject());
	}
	
}