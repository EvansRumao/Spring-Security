package com.Security.SpringSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class springConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance(); // only for testing
    }

    @Bean
    public SecurityFilterChain chain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable());

        http.authorizeHttpRequests(auth ->
                auth.anyRequest().authenticated()
        );

        http.httpBasic(Customizer.withDefaults());

        http.sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );

        return http.build();
    }
}

//    @Bean
//    public UserDetailsService userDetailsService(){
////        UserDetails user = User.builder().build();
//        UserDetails user = User.withDefaultPasswordEncoder().username("anime").password("1234").roles("user").build();
//        return new InMemoryUserDetailsManager(user);
//    }
//}
