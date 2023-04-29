package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cos.blog.model.BlogUser;
import com.cos.blog.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void joinMember(BlogUser user) {
			userRepository.save(user);
	}

}
