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

	@Transactional(readOnly=true) // select할 때 트랜잭션 시작, 서버스 종료시에 트랜잭션 종료(정합성)
	public BlogUser login(BlogUser user) {
		
		return userRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword());
	
	}

}
