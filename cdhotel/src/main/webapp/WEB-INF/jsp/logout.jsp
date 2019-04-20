<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/22
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logout</title>
</head>
<body>
<h3 style="color: red"> LogOut</h3>
<h3>sessionId:<%=session.getId()%></h3>
<h3>Port:<%=request.getLocalPort()%></h3>
</body>
</html>
