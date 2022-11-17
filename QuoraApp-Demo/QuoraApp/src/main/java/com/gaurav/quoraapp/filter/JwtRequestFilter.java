package com.gaurav.quoraapp.filter;

import com.gaurav.quoraapp.Dto.CustomUser;
import com.gaurav.quoraapp.Service.impl.CustomUserDetails;
import com.gaurav.quoraapp.error.QuoraException;
import com.gaurav.quoraapp.utils.AES;
import com.gaurav.quoraapp.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Map;

@Component
@Log4j2
public class JwtRequestFilter extends OncePerRequestFilter {

    @Value("${jwt.secret}")
    private String SECRET_KEY;

    @Autowired
    private CustomUserDetails userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AES aes;

//    @Autowired
//    KeysService keysService;
//
//    @Autowired
//    RSA rsa;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {
        try {
            String authorizationHeader = request.getHeader("Authorization");
            String username = null;
            String jwt = null;
            String superSecret = "supersecret";

            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                // get jwt(encrypted)  from header and decrypt
              //  jwt = aes.decryptText("AES", authorizationHeader.substring(7));
                username = jwtUtil.extractUsername(authorizationHeader.substring(7));
                Claims claims = Jwts.parser()
                        .setSigningKey(SECRET_KEY)
                        .parseClaimsJws(authorizationHeader.substring(7))
                        .getBody();

//                // if user is  not enabled throw exception
//                if(!(Boolean) claims.get("enabled")){
//                    throw new QuException("User not enabled");
//                }
            }
            if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
                // get userDetails from loadUserByUsername given Username as email
                CustomUser userDetails = userDetailsService.loadUserByUsername(username);

                // validate if token is valid or else throw an error
                if (jwtUtil.validateToken(authorizationHeader.substring(7), userDetails)) {
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken
                            .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                } else {
                    throw new QuoraException("Token is invalid.");
                }
            }

            // get header from  request and check if header signature encrypted text is decrypted by
//            Map<String, String>  publicPrivateKeys = keysService.SaveGetRSAKeys();
//            PrivateKey privateKey = keysService.decodePrivateKey(publicPrivateKeys.get("PRIVATE"));
//            String signature = rsa.decryptText(request.getHeader("signature"), privateKey);
//            System.out.println(signature);
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            log.error("Exception: ", e);
            throw new QuoraException(e.getMessage());
        }
    }

//    private JwtData generateJwtData(LinkedHashMap<String, Object> jwtHashMapper) {
//        JwtData jwtData = new JwtData();
//        jwtData.setName((String) jwtHashMapper.get("name")); jwtData.setId((Long) jwtHashMapper.get("id"));
    /*        jwtData.setEnabled((Boolean) jwtHashMapper.get("enabled")); return jwtData; }*/}
