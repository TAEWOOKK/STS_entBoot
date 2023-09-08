package com.wook.sts_ent.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.servlet.DispatcherType;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                 http
                .csrf().disable()
                .authorizeRequests()
                .and()
                .formLogin()
                        .defaultSuccessUrl("/index", true).permitAll()
                        .loginPage("/login_form")
                        .loginProcessingUrl("/login")
                        .usernameParameter("id")
                        .passwordParameter("password");

        return http.build();
    }
}
