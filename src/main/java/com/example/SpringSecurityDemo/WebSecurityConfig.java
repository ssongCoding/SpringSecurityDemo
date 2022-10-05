package com.example.SpringSecurityDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    /**
     * Security를 적용할 때, 기본 설정
     * 로그인 하면 ~로 가고
     * 로그아웃 하면 어떻게 되고
     * ~~ URL은 시큐리티 필요 없고
     * ~~ URL은 시큐리티 적용 해야 하고...
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/home", "/create").permitAll() // 매개변수 URL을 제외하고 시큐리티를 먹이겠다.
                .anyRequest().authenticated() // 위에꺼 제외 나머지 다 시큐리티 적용
                .and()
            .formLogin()
                .loginPage("/login").permitAll()
                .and()
            .logout().permitAll();

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}