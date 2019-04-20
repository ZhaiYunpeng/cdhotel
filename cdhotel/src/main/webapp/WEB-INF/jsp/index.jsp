<%@ page import="javax.sound.sampled.Port"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%
	String path = request.getContextPath();
	// 获得项目完全路径（假设你的项目叫MyApp，那么获得到的地址就是http://localhost:8080/MyApp/）: 
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href=" <%=basePath%>">
<title>Title</title>
</head>
<script type="text/javascript" src="static/js/common/jquery.min.js"></script>
<script type="text/javascript">
function login(){
	alert("test");
	 $.ajax({
	        type: "POST",
	        url: "<%=basePath%>login",
	        data: {username:$("#username").val(), password:$("#password").val()},
	        dataType: "json",
	        success: function(data){  
                console.log(data);  
             },  
		    error:function(e){  
                console.log(e);  
                $("#error").html("ERROR");
		    }  
	    });
}
</script>
<body>
	<shiro:authenticated>
		<label>用户身份验证已通过 </label>
	</shiro:authenticated>
	<shiro:guest>
		<label>您当前是游客，</label>
		<a href="/login.jsp">请登录</a>
	</shiro:guest>
	<shiro:hasAnyRoles name="admin,user">
		<label>这是拥有admin或者是user角色的用户</label>
	</shiro:hasAnyRoles>
	<shiro:hasPermission name="admin:add">
		<label>这个用户拥有admin:add的权限</label>
	</shiro:hasPermission>
	<shiro:hasRole name="admin">
		<label>这个用户拥有的角色是admin</label>
	</shiro:hasRole>
	<shiro:lacksPermission name="admin:delete">
		<label>这个用户不拥有admin:delete的权限</label>
	</shiro:lacksPermission>
	<shiro:lacksRole name="admin">
		<label>这个用户不拥有admin的角色</label>
	</shiro:lacksRole>
	<shiro:notAuthenticated>
		<label>用户身份验证没有通过（包括通过记住我（remember me）登录的） </label>
	</shiro:notAuthenticated>
	<shiro:user>
		<label>欢迎[<shiro:principal />]， </label>
		<a href="/logout">退出</a>
	</shiro:user>

	<h1>
		SessionID:<%=session.getId()%></h1>
	<h1>
		Port:<%=request.getLocalPort()%></h1>
	<%-- <form id="submitForm" action="<c:url value="/login"/>"> --%>
		<div>
			用户名:<input id="username" name="username" type="text">
		</div>
		<div>
			密&nbsp;&nbsp;&nbsp;码:<input id="password" name="password" type="password">
		</div>
		<%--<div>验证码:<input name="password" type="password" style="width: 60px;"><img src=""></div>--%>
		<div id="error" style="color: red;"></div>
		<input id="submit" type="submit" onclick="login()" value="登录">
	<!-- </form> -->
	<div>
		<img alt="" src="static/world.jpg">
	</div>
</body>
</html>
