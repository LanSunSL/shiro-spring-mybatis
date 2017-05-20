<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%!
	public static final String LOGIN_URL = "login";
%>
<body>
	<shiro:notAuthenticated>
		<h1>Please login first!</h1>
	</shiro:notAuthenticated>
	<shiro:authenticated>
		<h1><shiro:principal/></h1>
	</shiro:authenticated>
	<shiro:hasRole name="member"><h2>Can handle member</h2></shiro:hasRole>
	<shiro:lacksRole name="dept"><h2>Lack Role: dept</h2></shiro:lacksRole>
	<shiro:hasPermission name="news:add"><h3>News:Add</h3></shiro:hasPermission>
	<shiro:lacksPermission name="news:list"><h3>Lacks news:list</h3></shiro:lacksPermission>
	<shiro:guest><h1>I am a guest!</h1></shiro:guest>
	<form action="<%=LOGIN_URL%>" method="post">
		UserName: <input type="text" name="mid" id="mid"><br>
		Password: <input type="password" name="password" id="password"><br>
		<input type="submit" value="submit">
		<input type="reset" value="reset">
	</form>
</body>
</html>