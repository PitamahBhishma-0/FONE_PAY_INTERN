package com.gaurav.quoraapp.utils;

import com.gaurav.quoraapp.Repo.RoleRepo;
import com.gaurav.quoraapp.Repo.UsersRepo;
import com.gaurav.quoraapp.model.Roles;
import com.gaurav.quoraapp.model.Users;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
@Log4j2
public class JwtUtil {
    @Value("${jwt.secret}")
    private String SECRET_KEY;

    @Autowired
    private UsersRepo usersRepo;
    @Autowired
   private RoleRepo roleRepo;
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }


    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        Users users = usersRepo.findByEmail(userDetails.getUsername());
        claims.put("userId", users.getUid());
//        claims.put("enabled", user.getEnabled());
        claims.put("role", userDetails.getAuthorities());
//        claims.put("name", user.getName());
        return createToken(claims, userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {
        try {
            return Jwts.builder()
                    .setClaims(claims).setSubject(subject).setIssuedAt(Date.from(Instant.now()))

                    .setExpiration(DateUtil.generateExpiryDateForToken())
                    .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}