<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <form action="<c:url value="/loginsubmit.html"/>" method="post" id="loginform">
			<div Style="font-size: 20px; width:285px;height: 72px;float: right;
    margin-right: 341px;">
			 <div Style="width:95px;margin:10px;">用户登录</div>
			 <div Style="width: 95px; margin-top: -32px;margin-left: 187px;"> <img src=".../../img/web/weixin.png"/></div>
				</div>
			<div class="login_table">
			<table cellpadding="0" cellspacing="0" border="0">
					<tr>
						<td colspan="2"><div class="username"></div><input type="text" name="j_username" id="j_username" value="" onclick="JavaScript:this.value=''" maxlength="30" autocomplete="off" /></td>
					</tr>
					<tr>
						<td colspan="2"><div class="password"></div><input type="password" name="j_password" id="j_password" value="" onclick="JavaScript:this.value=''" maxlength="30" autocomplete="off" /></td>
					</tr>
					<tr>
						<td width="85"><input type="text" name="j_verify" maxlength="4" onclick="JavaScript:this.value=''" style=" width:75px;" value="" /></td>
						<td><img id="authImg" onclick="refresh();" src="<c:url value="/getVerify.html"/>" class="yzm" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" class="login_btn" value="登    录" /></td>
					</tr>
					<tr style="height:20px;">
	                	<td colspan="2" >
	                		<span style="color:#F00;font-size: 16px;margin-left: 27px;">${message }</span>
	                	</td>
	                </tr>
				</table>
			</div>
			<div class="zhichi">
				<!-- <a href="javascript:void(0)">技术支持：XXXXXX技术有限公司</a> -->
			</div>
		</form>
</body>
</html>