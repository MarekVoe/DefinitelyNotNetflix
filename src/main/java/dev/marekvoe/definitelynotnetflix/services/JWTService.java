package dev.marekvoe.definitelynotnetflix.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JWTService {

    // Nezapomenout, aby to bralo z .env souboru, a hlavně jebnout ten .env soubor do .gitignore
    private final String secret = "d6aFBavrdAxviBiBlR5EACj0q3sfuyeEQNYOUuDEvCm";

    public String generateToken(String username) {
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());


        // TODO: přidat - claim() pro roli uživatele
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(key)
                .compact();
    }

    public String extractUsername(String token) {
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());

        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }
}
