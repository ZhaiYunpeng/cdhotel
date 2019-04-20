<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta charset="UTF-8">

<title>Index</title>
</head>
<body>
<h3>Index JSP</h3><br>
<h4>path:<%=path%></h4><br>
<h4>basePath:<%=basePath%></h4><br>
<div style="width: 200px;height: 400px">
	<img alt="world.jpg" src="<%=basePath%>static/world.jpg">
</div>
</body>
</html>