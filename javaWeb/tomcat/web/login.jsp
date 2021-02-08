<%--
  Created by IntelliJ IDEA.
  User: Hzw
  Date: 2021/2/3
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆页面</title>
</head>
<body>

<form action="/loginServletSession">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username"></td>
        </tr>

        <tr>
            <td>密码</td>
            <td><input type="text" name="password"></td>
        </tr>

        <tr>
            <td>验证码</td>
            <td><input type="text" name="checkcode"></td>
        </tr>

        <tr>
            <td>
                <img id="checkCode" src="/responseDemo4" alt="">
            </td>
        </tr>

        <tr>
            <td>
                <input type="submit" value="登录">
            </td>
        </tr>


    </table>

    <div><%= request.getAttribute("password_error")%></div>
    <div><%= request.getAttribute("checkcode_error")%></div>


    <script>
        window.onload=function () {
            var img = document.getElementById("checkCode");
            img.onclick=function () {
                //加时间戳，避免使用缓存图片
                var date=new Date().getTime();
                img.src="/responseDemo4?"+date;
            }

            var change = document.getElementById("change");
            change.onclick=function () {
                var time = new Date().getTime();
                change.href="/responseDemo4?"+time;
            }

        }
    </script>

</form>










</body>
</html>
