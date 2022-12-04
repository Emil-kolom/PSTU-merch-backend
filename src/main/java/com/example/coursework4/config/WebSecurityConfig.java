package com.example.coursework4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .antMatchers(HttpMethod.POST, "/api/order-placement").permitAll()
                        .antMatchers(HttpMethod.GET, "/api/order-placement").authenticated()
                        .antMatchers(HttpMethod.GET,"/api/*").permitAll()
                        .antMatchers(HttpMethod.POST, "/api/*").authenticated()
                        .antMatchers(HttpMethod.DELETE, "/api/*").authenticated()
                        .antMatchers(HttpMethod.PUT, "/api/*").authenticated()
                        .anyRequest().permitAll()
                ).exceptionHandling()
                .and()
                .formLogin()
                .and()
                .logout()
                .and()
                .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer
                        .ignoringAntMatchers("/api/order-placement"))
        ;

        return http.build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
}