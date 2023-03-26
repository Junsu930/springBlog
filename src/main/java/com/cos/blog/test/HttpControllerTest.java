package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 사용자가 요청 -> 응답(HTML)
// @Controller

// 사용자가 요청 -> 응답(Data)
@RestController
public class HttpControllerTest {
	
	// 인터넷 브라우저 요청은 get방식만 가능하다
	// http://localhost:8080/http/get
	@GetMapping("/http/get")
	public String getTest(@RequestParam int id) {
		return "get 요청 : " + id;
	}
	
	// http://localhost:8080/http/post
	@PostMapping("http/post")
	public String postTest(@RequestBody Member m ) {
		return "post 요청 : "  + m.getId() + ", " + m.getPassword() + ", " + m.getUserName() + ", " + m.getEmail();
	}
	
	// http://localhost:8080/http/put
	@PutMapping("http/put")
	public String putTest() {
		return "put 요청";
	}
	
	// http://localhost:8080/http/delete
	@DeleteMapping("http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
}
