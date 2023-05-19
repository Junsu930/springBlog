package com.cos.blog.config.auth;

import java.util.Collection;
import java.util.ArrayList;
import org.hibernate.cfg.beanvalidation.BeanValidationIntegrator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.blog.model.BlogUser;

// 스프링 시큐리티가 로그인 요청을 가로채서 로그인을 진행하고 완료가 되면 UserDetails 타입의 오브젝트를
// 스프링 시큐리티의 고유한 세션 저장소에 저장
public class PrincipalDetail implements UserDetails{
	
	private BlogUser user; // Composition


	public PrincipalDetail(BlogUser user) {
		this.user = user;
	}

	@Override
	public String getPassword() {

		
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	// 계정이 만료되지 않았는지를 리턴한다. ( true: 만료 안 됨 ) 
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	// 계정이 잠겨있는지 않았는지 리턴 ( true : 잠겨있지 않음 )
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	// 비밀번호가 만료되지 않았는지 ( true : 만료 안 됨 )
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	// 계정이 사용 가능한지
	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> collectors = new ArrayList<>();

		// 계정이 가진 권한 목록을 리턴
		collectors.add(()->{return "ROLE_" + user.getRole();} );
		
		System.out.println("로그인 로직 호출됨");
		
		return collectors;
	}
	
	
}
