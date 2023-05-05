package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.BlogUser;
import com.cos.blog.repository.UserRepository;


@Service
public class UserService {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void joinMember(BlogUser user) {
			
		userRepository.save(user);
	}



}
