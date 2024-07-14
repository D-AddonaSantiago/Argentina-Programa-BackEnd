package com.portfolio.sd.Security.jwt;

import com.portfolio.sd.Security.Entity.UsuarioPrincipal;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
public class JwtProvider {

    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private int expiration;

    @PostConstruct
    public void init() {
        logger.info("JWT Secret: " + secret);
        logger.info("JWT Expiration: " + expiration);
    }

    public String generateToken(Authentication authentication) {
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
        String token = Jwts.builder().setSubject(usuarioPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
        return token;
    }

    public String getNombreUSuarioFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("Token mal formado: " + token, e);
        } catch (UnsupportedJwtException e) {
            logger.error("Token no soportado: " + token, e);
        } catch (ExpiredJwtException e) {
            logger.error("Token expirado: " + token, e);
        } catch (IllegalArgumentException e) {
            logger.error("Token vacío: " + token, e);
        } catch (SignatureException e) {
            logger.error("Firma no válida: " + token, e);
        }
        return false;
    }
}
