package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.User;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .headers(headers -> headers.frameOptions(frame -> frame.disable())) // for H2 console
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll()
                        .requestMatchers("/users/**").hasRole("USER")
                        // .requestMatchers("/users/**").permitAll()
                        .anyRequest().authenticated())
                .httpBasic()
                .and()
                .build();
    }

    @Bean
    public UserDetailsService users() {
        var user = User
                .withUsername("user")
                .password("{noop}password")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}