<%@ page language = "java" contentType = "text/html; charset=UTF-8" pageEncoding ="UTF-8" %>
<%@ include file="../layout/header.jsp" %>

<form action="/action_page.php" style = "width:800px; margin:auto;">
  <div class="form-group">
    <label for="username">User Name:</label>
    <input type="text" class="form-control" placeholder="Enter username" id="username">
  </div>
  <div class="form-group">
    <label for="password">Password:</label>
    <input type="password" class="form-control" placeholder="Enter password" id="password">
  </div>
  <div class="form-group form-check">
    <label class="form-check-label">
      <input class="form-check-input" type="checkbox"> Remember me
    </label>
  </div>
  <button type="submit" class="btn btn-primary">로그인</button>
</form>

<%@ include file="../layout/footer.jsp" %>
