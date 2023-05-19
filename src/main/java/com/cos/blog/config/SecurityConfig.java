package com.cos.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


import jakarta.servlet.DispatcherType;


@Configuration // IoC
public class SecurityConfig {
	
	
	@Bean // IoC (리턴하는 값을 스프링이 관리)
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http
				.csrf().disable() // csrf 토큰 비활성화 (테스트 시 걸어두는 게 좋음)
				.authorizeHttpRequests()
				.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
				.requestMatchers("/","/auth/**", "/js/**", "/css/**", "/image/**").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin().loginPage("/auth/loginForm")
				.loginProcessingUrl("/auth/loginProc")
				.defaultSuccessUrl("/"); // 스프링 시큐리티가 해당 주소로 오는 로그인을 가로채서 대신 로그인 해줌 
		
													
		return http.build();
	}
}


