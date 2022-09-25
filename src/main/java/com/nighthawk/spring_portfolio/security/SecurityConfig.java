package com.nighthawk.spring_portfolio.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor //RequiredArgsConstructor makes the line below be able to pass that variable in on the fly
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /* security rules ...
            ... initial implementation is focused on protecting database information
         */
        http
            .authorizeRequests()
                .antMatchers( "/api/jokes/**").permitAll()
        ;
        // Cross-Site Request Forgery needs to be disabled to allow activation of JS Fetch URIs
        http.csrf().disable();
    }
}
