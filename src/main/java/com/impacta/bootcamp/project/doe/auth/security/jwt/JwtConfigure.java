package com.impacta.bootcamp.project.doe.auth.security.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtConfigure extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    @Autowired
    private JwtTokenProvider tokenProvider;

    public JwtConfigure(JwtTokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }
    @Override
    public void configure(HttpSecurity http) throws  Exception{
        JwtTokenFilter customFilter =  new JwtTokenFilter(tokenProvider);
        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);

    }
}