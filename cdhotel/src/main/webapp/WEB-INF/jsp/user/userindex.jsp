<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网站后台管理模版</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/admin/layui/css/layui.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/admin/css/admin.css"/>
</head>
<body>
<div class="main-layout" id='main-layout'>
			<!--侧边栏-->
			<div class="main-layout-side">
				<div class="m-logo">
				</div>
				<ul class="layui-nav layui-nav-tree" lay-filter="leftNav">
				  <li class="layui-nav-item layui-nav-itemed">
				    <a href="javascript:;"><i class="iconfont">&#xe607;</i>酒店管理</a>
				    <dl class="layui-nav-child">
				      <dd><a href="javascript:;" data-url="menu1.html" data-id='1' data-text="酒店信息"><span class="l-line"></span>酒店信息</a></dd>
				     <!-- <dd><a href="javascript:;" data-url="menu2.html" data-id='2' data-text="前台菜单"><span class="l-line"></span>前台菜单</a></dd>-->
				    </dl>
				  </li>
				  <li class="layui-nav-item">
				    <a href="javascript:;"><i class="iconfont">&#xe608;</i>客户操作</a>
				    <dl class="layui-nav-child">
				      <dd><a href="javascript:;" data-url="article-list.html" data-id='3' data-text="客房预订"><span class="l-line"></span>客房预订</a></dd>
				      <dd><a href="javascript:;" data-url="danye-list.html" data-id='9' data-text="客房续约"><span class="l-line"></span>客房续约</a></dd>
				      <dd><a href="javascript:;" data-url="article-list.html" data-id='3' data-text="退房"><span class="l-line"></span>退房</a></dd>
				      <dd><a href="javascript:;" data-url="danye-list.html" data-id='9' data-text="咨询"><span class="l-line"></span>咨询</a></dd>
				    </dl>
				  </li>
				  <li class="layui-nav-item">
				    <a href="javascript:;" data-url="admin-info.html" data-id='5' data-text="个人信息"><i class="iconfont">&#xe606;</i>个人信息</a>
				  </li>
				  
				</ul>
			</div>ke'fang'
			<!--右侧内容-->
			<div class="main-layout-container">
				<!--头部-->
				<div class="main-layout-header">
					<div class="menu-btn" id="hideBtn">
						<a href="javascript:;">
							<span class="iconfont">&#xe60e;</span>
						</a>
					</div>
					<ul class="layui-nav" lay-filter="rightNav">
					  <li class="layui-nav-item"><a href="javascript:;" data-url="email.html" data-id='4' data-text="邮件系统"><i class="iconfont">&#xe603;</i></a></li>
					  <li class="layui-nav-item">
					    <a href="javascript:;" data-url="admin-info.html" data-id='5' data-text="个人信息">超级管理员</a>
					  </li>
					  <li class="layui-nav-item"><a href="javascript:;">退出</a></li>
					</ul>
				</div>
				<!--主体内容-->
				<div class="main-layout-body">
					<!--tab 切换-->
					<div class="layui-tab layui-tab-brief main-layout-tab" lay-filter="tab" lay-allowClose="true">
					  <ul class="layui-tab-title">
					    <li class="layui-this welcome">后台主页</li>
					  </ul>
					  <div class="layui-tab-content">
					    <div class="layui-tab-item layui-show" style="background: #f5f5f5;">
					    	<!--1-->
					    	<iframe src="menu1.html" width="100%" height="100%" name="iframe" scrolling="auto" class="iframe" framborder="0"></iframe>
					    	<!--1end-->
					    </div>
					  </div>
					</div>
				</div>
			</div>
			<!--遮罩-->
			<div class="main-mask">
				
			</div>
		</div>
		<script type="text/javascript">
			var scope={
				link:'./welcome.html'
			}
		</script>
		<script src="${pageContext.request.contextPath }/static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath }/static/admin/js/common.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath }/static/admin/js/main.js" type="text/javascript" charset="utf-8"></script>
		
	</body>
</body>
</html>