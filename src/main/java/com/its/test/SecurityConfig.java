package com.its.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration  // 메모리에 떠야해서
@EnableWebSecurity  // 활성화 (스프링 시큐리티 필터(Securityconfig)가 스프링 기본 필터체인에 등록됨)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/js/**","/css/**","/images/**");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();  // 비활성화
        http.authorizeRequests()
                    // 해당 주소는 인증이 필요하다 (role)
                    .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
//                    .antMatchers("/member/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
                    .antMatchers("/board/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
                    // 해당 주소는 모두다 그냥 보기 O
                    .antMatchers("/js/**", "/css/**", "/images/**").permitAll()
                    // 그 외 다 허용
                    .anyRequest().permitAll()
                    .and()
                .formLogin()
                    .loginPage("/member/login-form")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .loginProcessingUrl("/login")
                    .defaultSuccessUrl("/")
                    .failureUrl("/member/login-fail")
                    .and()
                .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
                    .logoutSuccessUrl("/")
                    .invalidateHttpSession(true)
                    .and()
                .exceptionHandling().accessDeniedPage("/member/login");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
