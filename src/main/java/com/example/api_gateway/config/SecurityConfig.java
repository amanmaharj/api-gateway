package com.example.api_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    private final String[] resourceNoBoundToAuthenticate = {"/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**", "/swagger-resource/**" , "/api-docs/**", "/aggregate/**"};
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
      return httpSecurity.authorizeHttpRequests(authorize->authorize.requestMatchers(resourceNoBoundToAuthenticate).permitAll()
                      .anyRequest()
                .authenticated())
                .oauth2ResourceServer(oauth2->oauth2.jwt(Customizer.withDefaults()))
                .build();
    }
}
