package com.cos.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.blog.model.BlogUser;

//DAO
//자동으로 bean등록이 된다.
//@Repository 생략 가능
public interface UserRepository extends JpaRepository<BlogUser, Integer>{

	
	Optional<BlogUser> findByUsername(String username);
	// JPA 네이밍 전략
	//BlogUser findByUserNameAndPassword(String userName, String password);
}
