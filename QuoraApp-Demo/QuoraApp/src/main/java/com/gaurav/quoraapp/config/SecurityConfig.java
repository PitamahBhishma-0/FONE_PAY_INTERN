package com.gaurav.quoraapp.config;

import com.gaurav.quoraapp.filter.JwtRequestFilter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Log4j2
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private UserDetailsService userDetailsService;
    private static final String[] WHITE_LIST_URLS = {
            "/auth/register/",
            "/auth/login/","/expertise/find","users/download/users.xlsx",
            "/users/download/users.xlsx",
            "/downloadXls","/users/file/*"
    };
  /*  private static final String[] user_role = {
            "USER"
    };
    private static final String[] moderator_role = {
            "USER", "MODERATOR"
    };*/

    // admin urls
    private static final String[] ADMIN_URLS = {
            "/users/update/*","/users/getAllUsers",  "/question/ask","/role/*"
    };
    private static final String[] Moderator_url = {
            "/users/update/*","/users/getAllUsers"
    };
    private static final String[] user_url = {
             "/question/ask","/users/getAllUsers"
    };
    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        try {
            http
                    .cors()
                    .and()
                    .csrf()
                    .disable()
                    .authorizeHttpRequests()
                    .antMatchers(WHITE_LIST_URLS).permitAll()
                    .antMatchers(ADMIN_URLS).hasAuthority("ADMIN")
                    .antMatchers(Moderator_url).hasAnyAuthority("ADMIN", "MODERATOR")
                    .antMatchers(user_url).hasAnyAuthority("USER")
                    .anyRequest().authenticated().and()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

            http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        } catch (Exception e) {
            log.error("exception: ", e);
        }
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }
}