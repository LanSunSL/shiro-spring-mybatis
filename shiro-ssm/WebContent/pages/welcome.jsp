<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${name}大爷, 您来玩了！</h1>
	<h1>
		<shiro:hasPermission name="news:add">
			具备有添加新闻的权限
		</shiro:hasPermission>
		<shiro:lacksPermission name="news:add">
			不具备有添加新闻的权限 
		</shiro:lacksPermission>
	</h1>
</body>
</html>