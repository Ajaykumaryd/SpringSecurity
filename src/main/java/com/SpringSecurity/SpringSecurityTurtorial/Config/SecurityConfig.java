package com.SpringSecurity.SpringSecurityTurtorial.Config;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@Data
public class SecurityConfig {
    @Bean
    public PasswordEncoder getpasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    //User information
    public UserDetailsService userDetailsService(){

                UserDetails student = User.withUsername("student")
                        .password(getpasswordEncoder().encode("student123"))
                .roles("STUDENT")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password(getpasswordEncoder().encode("admin1234"))
                .roles("ADMIN")
                .build();


        return new InMemoryUserDetailsManager(student,admin);
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception{

        return httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("public/**")
                .permitAll()
                 .requestMatchers("/student/**")
                .hasRole("STUDENT")
                .requestMatchers("/admin/**")
                .hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                 .and().formLogin().and().build();
    }








    
}
