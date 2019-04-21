Module = {
	init: function() {
		Module.registerBtn_event();
	},
	win_tip: function(str) {
		layui.use('layer', function() {
			var layer = layui.layer;

			layer.msg(str, {
				time: 5000,
				btn: ['ok']
			});
		});
	},
	loginBtn_event: function() {
		var pathname = window.location.pathname.substr(1);
		var webname = pathname.substr(0, pathname.indexOf('/'));
		var path = window.location.protocol + "//" + window.location.host + "/"
				+ webname;
		alert(path);
		
		var id_val = $("#id_val").val();
		var pwd_val = $("#password_val").val();
		var role = $("#role").val();

		//alert(id_val);

		localStorage.login_username = id_val;

		$.post(path+'/users/login', {
			"username": id_val,
			"password": pwd_val,
			"role":role
		}, function(data) {
			//console.log(data);
			var obj = data;
			if (obj.code == 0) {
				if(obj.role == "客户"){
					window.location.href = path+'/userindex.jsp';
				}else if(obj.role == "管理员"){
					window.location.href = path+'/admin/index.jsp';
				}else if(obj.role == "工作人员"){
					window.location.href = path+'/member/index.jsp';
				}
				
			} else if (obj.code == 1) {
				Module.win_tip("密码或用户名错误，请重新输入!");
			}
		});
	},
	test_username: function() {
		var pathname = window.location.pathname.substr(1);
		var webname = pathname.substr(0, pathname.indexOf('/'));
		var path = window.location.protocol + "//" + window.location.host + "/"
				+ webname;
		var username_val = $("#username").val();
		//console.log(username_val);
		if (username_val != "") {
			$.post(path+"/users/checkusername", {
				"username": username_val
			}, function(data) {
				if (data == 1) {
					//$("#s1").html("<font color='green'>用户名可以使用</font>");
					Module.win_tip("用户名可以使用");
					$("#submit_form").removeClass("layui-btn-disabled");
				} else if (data == 2) {
					//$("#s1").html("<font color='red'>用户名已经被占用</font>");
					Module.win_tip("用户名已经被占用");
					$("#submit_form").addClass("layui-btn-disabled");
				}
			});
		}
	},
	testUsername_setting: function() {
		var pathname = window.location.pathname.substr(1);
		var webname = pathname.substr(0, pathname.indexOf('/'));
		var path = window.location.protocol + "//" + window.location.host + "/"
				+ webname;
		var username_val = $("#username").val();
		//console.log(username_val);
		if (username_val != "") {
			$.post(path+"/users/checkusername", {
				"username": username_val
			}, function(data) {
				if (data == 1) {
					layui.use('layer', function() {
						var layer = layui.layer;

						layer.msg('用户名不存在,请点击注册进行注册', {
							time: 5000,
							btn: ['去注册']
						}, function() {
							window.location.href = path+'index.jsp';
						});
					});
				} else if (data == 2) {
					//$("#s1").html("<font color='red'>用户名已经被占用</font>");
					//Module.win_tip("用户名已经被占用");
				}
			});
		}
	},
	registerBtn_event: function() {
		$("#register_btn").on('click', function() {
			layui.use(['layer', 'form', 'element', 'table'], function() {
				var layerEle = layui.layer;
				var form = layui.form;
				var table = layui.table;
				var register_win = layerEle.open({
					type: 1,
					title: '注册信息',
					content: '<div id="test_table" style="width: 280px;height: 220px;">' +
						'<form class="layui-form" action="" style="margin: 20px 0 0 0;">' +
						'<div class="layui-form-item">' +
						'<label class="layui-form-label">昵称</label>' +
						'<div class="layui-input-block">' +
						'<input type="text" id="nickname" name="nickname" required  lay-verify="nickname" placeholder="请输入昵称" autocomplete="off" class="layui-input">' +
						'</div>' +
						'</div>' +
						'<div class="layui-form-item">' +
						'<label class="layui-form-label">用户名</label>' +
						'<div class="layui-input-block">' +
						'<input type="text" onchange="Module.test_username()" id="username" name="username" required  lay-verify="username" placeholder="请输入用户名" autocomplete="off" class="layui-input">' +
						'<span id="s1"></span>' +
						'</div>' +
						'</div>' +
						'<div class="layui-form-item">' +
						'<label class="layui-form-label">密码</label>' +
						'<div class="layui-input-block">' +
						'<input type="password" id="password" name="password" required  lay-verify="password" placeholder="请输入密码" autocomplete="off" class="layui-input">' +
						'</div>' +
						'</div>' +
						'<div class="layui-form-item">' +
						'<label class="layui-form-label">确认密码</label>' +
						'<div class="layui-input-block">' +
						'<input type="password" name="repassword" required  lay-verify="repassword" placeholder="请输入密码" autocomplete="off" class="layui-input">' +
						'</div>' +
						'</div>' +
						'<div class="layui-form-item">' +
						'<div class="layui-input-block">' +
						'<button type="submit" class="layui-btn" id="submit_form" lay-submit="" lay-filter="demo1">立即提交</button>' +
						'<button type="reset" class="layui-btn layui-btn-primary">重置</button>' +
						'</div>' +
						'</div>' +
						'</form>' +
						'</div>',
					area: ['320px', '350px']
				});
				//密码验证
				form.verify({
					password: [/(.+){3,12}$/, '密码必须3到12位'],
					username: [/^[a-zA-Z0-9_-]{4,16}$/, '用户名为4到16位(字母，数字，下划线，减号)'],
					nickname: [/(.+){2,8}$/, '昵称必须2到8位'],
					repassword: function(value) {
						var repassvalue = $('#password').val();
						if (value != repassvalue) {
							return '两次输入的密码不一致!';
						}
					}
				});
				//监听提交
				form.on('submit(demo1)', function(data) {
					var pathname = window.location.pathname.substr(1);
					var webname = pathname.substr(0, pathname.indexOf('/'));
					var path = window.location.protocol + "//" + window.location.host + "/"
							+ webname;
					var json_str = JSON.stringify(data.field)
					var str = JSON.parse(json_str);
					alert(str.nickname);
					//把注册信息发给后台
					$.post(path+"/users/register", {
						"nickname": str.nickname,
						"username": str.username,
						"password": str.password,
						"repassword": str.repassword
					});

					layerEle.close(register_win);
					layerEle.msg('注册成功', {
						time: 1000
					});

					return false;
				});
			});
		});
	},
	forgetPwd: function() {
		window.location.href = 'http://localhost:8080/map/main/userSetting.html';
	}
}
$(function() {
	Module.init();
});