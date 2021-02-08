<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="JSTL.User" %><%--
  Created by IntelliJ IDEA.
  User: Hzw
  Date: 2021/2/4
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>jstl</title>
</head>
<body>
        <%--test的属性值结合el表达式使用--%>
        <%--判断request域中的集合是否为空--%>
        <%
            List list=new ArrayList();
            list.add("aaa");
            request.setAttribute("list",list);
        %>
        <c:if test="${not empty list}">
           <h1>whosho</h1>
        </c:if>

        <%
            int i=9;
            request.setAttribute("xiqi",i);
        %>

        <c:choose>
            <%--完成数字对应星期几案例--%>
            <c:when test="${xiqi==1}">星期一</c:when>
            <c:when test="${xiqi==2}">星期二</c:when>
            <c:when test="${xiqi==3}">星期三</c:when>
            <c:when test="${xiqi==4}">星期四</c:when>
            <c:when test="${xiqi==5}">星期五</c:when>
            <c:when test="${xiqi==6}">星期六</c:when>
            <c:when test="${xiqi==7}">星期日</c:when>
            <c:otherwise>输入有误</c:otherwise>

        </c:choose>



        <c:forEach begin="5" end="10" var="i" step="2" >
            ${i}<br>
            <%--属性：
            begin 开始值
            end 结束值
            var 临时变量
            step 步长--%>

        </c:forEach>

    <%--显示user的值--%>

    <%
        List list1=new ArrayList();
        list1.add(new User("张三",18));
        list1.add(new User("李四",20));
        list1.add(new User("王者",48));
        request.setAttribute("list1",list1);
    %>

    <table border="1" width="500">
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>年龄</th>
        </tr>
        <c:forEach items="${list1}" var="user" varStatus="s">
            <c:if test="${s.count%2==0}">
                <tr style="color: aqua">
                    <td>${s.count}</td>
                    <td>${user.name}</td>
                    <td>${user.age}</td>
                </tr>
            </c:if>
            <c:if test="${s.count %2!=0}">
                <tr style="background: rebeccapurple" >
                    <td>${s.count}</td>
                    <td>${user.name}</td>
                    <td>${user.age}</td>
                </tr>
            </c:if>

        </c:forEach>
    </table>

</body>
</html>
