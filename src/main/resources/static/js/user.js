let index = {
	init:function(){
		$("#btn-save").on("click", ()=>{ // function(){}, 이 아닌 ()=>를 쓰는 이유는 this를 index변수에 바인딩하기 위해서
		// function()을 했을 때 this 값은 $("#btn-save")를 가리키게 된다. 
			this.save();
		});
		
	},
	
	save:function(){
		let data = {
			userName : $("#userName").val(),
			password : $("#password").val(),
			email : $("#email").val()	
		};
		
		// console.log(data);
		
		$.ajax({
			// ajax 통신을 통해서 3개의 데이터를 JSON으로 변경하여 insert요청
			// 회원가입 수행 요청
			// ajax는 default가 비동기 호출
			type : "POST",
			url : "/auth/joinProc",
			data : JSON.stringify(data),
			contentType : "application/json;charset=utf-8", // body 데이터가 어떤 타입인지
			dataType : "json", // 요청이 서버로 왔을 때 어떤 타입일지, 기본적으로는 String 
			// (데이터타입을 json으로 명시하고, 생긴 게 json이면 javascript object로 변경해줌)
			
		}).done(function(resp){
			// 수행 결과가 정상일 때
			console.log(resp);
			alert("회원가입이 완료되었습니다.");
			location.href="/";
		}).fail(function(error){
			// 수행 결과가 실패할 때
			alert(JSON.stringify(error));
		}); 
	}
}

index.init();