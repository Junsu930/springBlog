package com.cos.blog.test;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.BlogUser;
import com.cos.blog.model.RoleType;
import com.cos.blog.repository.UserRepository;

import jakarta.transaction.Transactional;


//html파일이 아니라 data를 리턴
@RestController
public class DummyController {
	
	@Autowired // 의존성 주입
	private UserRepository userRepository;
	
	// 전체 유저 조회이므로 특별한 파라미터를 받을 필요가 없다.
	@GetMapping("/dummy/users")
	public List<BlogUser> list(){
		return userRepository.findAll();
	}
	
	// 한 페이지당 두 건의 데이터를 리턴받아 볼 예정
	@GetMapping("/dummy/user")
	public Page<BlogUser> pageList(@PageableDefault(size=2, sort="id", direction=Sort.Direction.DESC) Pageable pageable){
		Page<BlogUser> users = userRepository.findAll(pageable);
		
		return users;
	}
	
	@DeleteMapping("/dummy/user/{id}")
	public String delete(@PathVariable int id){
		try {
					
			userRepository.deleteById(id);
		}catch(IllegalArgumentException e) {
			return "삭제에 실패하였습니다. 해당 id가 없습니다";
		}
		
		
		return "삭제되었습니다 id : " + id ;
	}
	
	
	// sava 함수는 id를 전달하지 않으면 insert
	// id가 있으면 update
	// email, password
	@Transactional
	@PutMapping("/dummy/user/{id}")
	public BlogUser updateUser(@PathVariable int id, @RequestBody BlogUser requestUser ) { //json 데이터를 요청 => JavaObject(MessageConverter의 Jackson 라이브러리가 변환)
		System.out.println("id : " + id);
		System.out.println("password : " + requestUser.getPassword()  );
		System.out.println("email : " + requestUser.getEmail());
		
		BlogUser user = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("수정 실패");
		});
		
		user.setPassword(requestUser.getPassword());
		user.setEmail(requestUser.getEmail());
		
		// 더티 체킹
		//userRepository.save(requestUser);
		return user;
	}
	
	
	// {id} 주소로 파라미터를 전달받을 수 있다.
	// http://localhost:8000/blog/dummy/user/3
	@GetMapping("/dummy/user/{id}")
	public BlogUser detail(@PathVariable int id) {
		
		//findById는 Optional로 return한다 null일 경우를 대비하기 위해서..
		// null인지 아닌지를 판단해야한다.
		/*
		BlogUser user = userRepository.findById(id).orElseGet(new Supplier<BlogUser>() {

			@Override
			public BlogUser get() {
				// TODO Auto-generated method stub
				return new BlogUser();
			}
			
		});
		*/
		
		BlogUser user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {

			@Override
			public IllegalArgumentException get() {
				return new IllegalArgumentException("해당 유저는 없습니다리빵빵. id : " + id);
			}
			
		});
		
		// 요청: 웹브라우저
		// user객체 = 자바 오브젝트 
		return user;
	}
	
	
	
	// http://localhost:8080/blog/dummy/join (요청)
	// http의 body에 userName, password, email 데이터를 가지고 (요청)
	@PostMapping("/dummy/join")
	public String join(BlogUser user) { // key = value 형태 (약속된 규칙)
		System.out.println("userName : " + user.getUserName());
		System.out.println("password : " + user.getPassword());
		System.out.println("email : " + user.getEmail());
		
		user.setRole(RoleType.USER);
		
		userRepository.save(user);
		
		return "회원가입이 완료되었습니다.";
		
	}

}
