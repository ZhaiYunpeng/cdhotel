<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/static/source/layui/css/layui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/homePage.css"> 

</head>
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
