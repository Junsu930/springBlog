<%@ page language = "java" contentType = "text/html; charset=UTF-8" pageEncoding ="UTF-8" %>
<%@ include file="../layout/header.jsp" %>
<div  style = "width:800px; margin:auto;">
	<form action="auth/loginProc" method="POST">
	  <div class="form-group">
	    <label for="userName">User Name:</label>
	    <input type="text" name="userName" class="form-control" placeholder="Enter username" id="userName">
	  </div>
	  <div class="form-group">
	    <label for="password">Password:</label>
	    <input type="password" name="password" class="form-control" placeholder="Enter password" id="password">
	  </div>
	  <button id="btn-login" class="btn btn-primary">로그인</button>
	</form>
</div>

<%@ include file="../layout/footer.jsp" %>

