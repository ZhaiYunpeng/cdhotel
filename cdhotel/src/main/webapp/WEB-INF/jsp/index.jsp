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

<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/static/source/layui/css/layui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/homePage.css"> 


<base href=" <%=basePath%>">
<title>Title</title>

</head>
<script type="text/javascript" src="static/js/common/jquery.min.js"></script>
<script type="text/javascript">
function login(){
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

<div id="top_nav">
		<div id="top_welcom">欢迎登录成都酒店管理系统系统</div>
		<div id="top_about">
			<span onclick="Module.forgetPwd()">忘记密码？</span><span>帮助</span><span>关于</span>
		</div>
	</div>
	<div id="cont">
		<!-- <p id="welcom_p">欢迎登录地址分发系统</p> -->
		<div id="register_login_tip">
			<div id="circle_cont">
				<div id="circle_left"></div>
				<p>酒店管理</p>
			</div>
			<div id="table_right">
				<form class="layui-form" style="margin: 100px 100px 0 0;">
					<div class="layui-form-item">
						<label class="layui-form-label">用户名<span
							class="layui-icon" style="margin-left: 10px;">&#xe612;</span></label>
						<div class="layui-input-block">
							<input type="text" required name="username" lay-verify="required"
								placeholder="请输入用户名" autocomplete="off"
								class="layui-input id_val" id="id_val">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">密码<span class="layui-icon"
							style="margin-left: 10px;">&#xe63b;</span></label>
						<div class="layui-input-block">
							<input type="password" required name="password"
								lay-verify="required" placeholder="请输入密码" autocomplete="off"
								class="layui-input password_val" id="password_val">
						</div>
					</div>
					<div class="layui-form-item">
					    <label class="layui-form-label">角色</label>
					    <div class="layui-input-block">
					      <select name="interest" lay-filter="role" id="role">
					        <option value="">请选择登录角色</option>
					        <option value="客户" selected="">客户</option>
					        <option value="工作人员">工作人员</option>
					        <option value="管理员">管理员</option>
					      </select>
					    </div>
					  </div>
					<div
						style="text-align: center; margin-top: 30px; margin-right: 60px;">
						<button class="layui-btn login_btn" type="button"
							lay-filter="demo_login" onclick="Module.loginBtn_event()">登录</button>
						<button class="layui-btn layui-btn-primary">取消</button>
					</div>
				</form>
				<div id="register_ask">
					还没有账号？点击<span id="register_btn">注册</span>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath }/static/source/layui/layui.js"></script>
	<script type="text/javascript">
	layui.use(['layer', 'form', 'element'], function(){
		  var layer = layui.layer
		  ,form = layui.form
		  ,element = layui.element
		   window.test = function(){
		    //JS代码
		    }
	});

	</script>
</body>
</html>
<script src="${pageContext.request.contextPath }/static/source/jquery-3.2.1.min.js"></script>

<script src="${pageContext.request.contextPath }/static/js/homePage.js"></script> 

	<%-- <shiro:authenticated>
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
	<form id="submitForm" action="<c:url value="/login"/>">
		<div>
			用户名:<input id="username" name="username" type="text">
		</div>
		<div>
			密&nbsp;&nbsp;&nbsp;码:<input id="password" name="password" type="password">
		</div>
		<div>验证码:<input name="password" type="password" style="width: 60px;"><img src=""></div>
		<div id="error" style="color: red;"></div>
		<input id="submit" type="submit" onclick="login()" value="登录">
	<!-- </form> -->
	<div>
		<img alt="" src="static/world.jpg">
	</div> --%>
</body>
</html>
