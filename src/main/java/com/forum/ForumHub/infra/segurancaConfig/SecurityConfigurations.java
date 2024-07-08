package com.forum.ForumHub.infra.segurancaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http.csrf(csrf -> csrf.disable())
                .sessionManagement(sm -> sm.sessionCreationPolicy(
                        SessionCreationPolicy.STATELESS))
//                .authorizeHttpRequests(req -> {
//
//                    req.requestMatchers("/login")
//                            .permitAll();
//
////                    req.requestMatchers("/v3/api-docs/**",
////                    "/swagger-ui.html",
////                    "/swagger-ui/**").permitAll();
//
//                    req.anyRequest().authenticated();
//                })
//                .addFilterBefore(
//                        securityFilter,
//                        UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
