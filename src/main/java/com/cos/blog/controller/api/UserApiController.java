package com.cos.blog.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.dto.ResponseDTO;
import com.cos.blog.model.BlogUser;

@RestController
public class UserApiController {
	
	@PostMapping("/api/user")
	public ResponseDTO<Integer> save(@RequestBody BlogUser user) {
		
		System.out.println("UserApiController : save 호출됨");
		return new ResponseDTO<Integer>(HttpStatus.OK, 1) ; // 자바오브젝트를 JSON으로 변화해서 리턴
	}

}
