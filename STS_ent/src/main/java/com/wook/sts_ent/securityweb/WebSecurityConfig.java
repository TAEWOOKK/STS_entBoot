package com.wook.sts_ent.securityweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .cors().disable()
                .authorizeHttpRequests(request -> request
                        .antMatchers("/public/**","/assets/**","/vendors/**","/","/403error","/error").permitAll()
                        .antMatchers("/admin/**").hasRole("admin")
                        .antMatchers("/user/**").hasRole("user")
                )
                .formLogin(login -> {
                            try {
                                login
                                        .loginPage("/login")
                                        .defaultSuccessUrl("/index", true)
                                        .permitAll()
                                        .and()
                                        .exceptionHandling().accessDeniedPage("/403error");
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                )

                .logout(withDefaults()).logout().logoutSuccessUrl("/");

        return http.build();
    }

/*    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }*/

}
