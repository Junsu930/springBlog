package com.cos.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.blog.model.BlogUser;

//DAO
//자동으로 bean등록이 된다.
//@Repository 생략 가능
public interface UserRepository extends JpaRepository<BlogUser, Integer>{
}
