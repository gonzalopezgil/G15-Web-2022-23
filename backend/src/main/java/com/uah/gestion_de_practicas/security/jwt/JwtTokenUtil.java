package com.uah.gestion_de_practicas.security.jwt;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Methods to generate and validate JWT tokens
 */
@Component
@Slf4j
public class JwtTokenUtil {

    /** 
     * Secret key to sign the JWT token
     */
    @Value("${app.jwt.secret}")
    private String jwtSecret;

    /** 
     * Expiration time of the JWT token
     */
    @Value("${app.jwt.expiration-ms}")
    private int jwtExpirationMs;

    /** 
     * Key to get the authorities from the JWT token
     */
    @Value("${app.jwt.authorities-key}")
    private String AUTHORITIES_KEY;

    /** 
     * Method to generate a JWT token
     * @param authentication, Authentication object
     * @param id, id of the user
     * @return String, JWT token
     */
    public String generateJwtToken(Authentication authentication, Long id) {

        UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();
        return Jwts.builder()
                .setId(id.toString())
                .setSubject((userPrincipal.getUsername()))
                .claim(AUTHORITIES_KEY, userPrincipal.getAuthorities())
                .claim("id", id)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    /** 
     * Method to get the username from the JWT token
     * @param token, JWT token
     * @return String, username
     */
    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    /** 
     * Method to validate the JWT token
     * @param authToken, JWT token to validate
     * @return true if the token is valid, false otherwise
     */
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            log.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }
}