package com.cos.blog.controller.api;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.dto.ResponseDTO;
import com.cos.blog.model.BlogUser;
import com.cos.blog.model.RoleType;
import com.cos.blog.service.UserService;

import jakarta.servlet.http.HttpSession;


@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/auth/joinProc")
	public ResponseDTO<Integer> save(@RequestBody BlogUser user) { //userName, password, email
		
		user.setRole(RoleType.USER);
		
		userService.joinMember(user);
		
		
		
		System.out.println("UserApiController : save 호출됨");
		return new ResponseDTO<Integer>(HttpStatus.OK.value(), 1); // 자바오브젝트를 JSON으로 변화해서 리턴
	}
	

	
	

}
