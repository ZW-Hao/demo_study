<%--
  Created by IntelliJ IDEA.
  User: Hzw
  Date: 2021/2/3
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
        <h1>
            <%= request.getSession().getAttribute("user") %> 欢迎您！！
        </h1>
</body>
</html>
