<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="/userDemo/css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<Script>
    function deleteUser(id) {
        if (confirm("您确定要删除吗？")) {
            location.href = "${pageContext.request.contextPath}/deleteServlet?id=" + id;
        }
    }
</Script>
<Script>
    window.onload = function () {
        document.getElementById("deleteSelect").onclick = function () {

            //在提交表单之前先判断是否有条目被选中
            var uids = document.getElementsByName("uid");
            var flag = false;
            for (var i = 0; i < uids.length; i++) {
                if (uids[i].checked) {
                    flag = true;
                }
            }
            if (flag == true) {
                if (confirm("您确定要删除吗？")) {
                    document.getElementById("userForm").submit();
                }
            }
            if (flag == false) {
                alert("请选择想要删除的条目");
            }


        }

        document.getElementById("firstCb").onclick = function () {

            var uids = document.getElementsByName("uid");
            for (var i = 0; i < uids.length; i++) {
                uids[i].checked = this.checked;
            }
        }
    }
</Script>

<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <div style="float:right" margin:5px;>
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/userDemo/add.jsp">添加联系人</a>
        <a class="btn btn-primary" href="javascript:void(0);" id="deleteSelect">删除选中</a>

    </div>
    <div>
        <form class="form-inline" action="${pageContext.request.contextPath}/queryUserrServlet" method="post">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" class="form-control" id="exampleInputName2" name="name">
            </div>
            <div class="form-group">
                <label for="exampleInputName3">性别</label>
                <input type="text" class="form-control" id="exampleInputName3">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail2">Email</label>
                <input type="email" class="form-control" id="exampleInputEmail2">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>
    <%--通过表单提交来获取需要删除的id值--%>
    <form id="userForm" action="${pageContext.request.contextPath}/delSeleteUser" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th><input type="checkbox" id="firstCb"></th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${queryUserByGender.list}" var="user" varStatus="s">
                <tr>
                    <th><input type="checkbox" name="uid" value="${user.id}"></th>
                    <td>${s.count}</td>
                    <td>${user.name}</td>
                    <td>${user.gender}</td>
                    <td>${user.age}</td>
                    <td>${user.address}</td>
                    <td>${user.qq}</td>
                    <td>${user.email}</td>
                    <td><a class="btn btn-default btn-sm"
                           href="${pageContext.request.contextPath}/findUserServlet?id=${user.id} ">修改</a>
                        &nbsp;<a class="btn btn-default btn-sm" href="javaScript:deleteUser(${user.id});">删除</a></td>
                </tr>

            </c:forEach>
        </table>
    </form>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">

                <c:if test="${queryUserByGender.currentPage==1}">
                    <li class="disabled">
                </c:if>
                <c:if test="${queryUserByGender.currentPage!=1}">
                    <li >
                </c:if>

                    <a href="${pageContext.request.contextPath}/queryUserrServlet?currentPage=${queryResult.currentPage-1}&rows=5"
                       aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <c:forEach begin="1" end="${queryUserByGender.totalPage}" var="i">
                    <c:if test="${queryUserByGender.currentPage==i}">
                        <li class="active"><a
                                href="${pageContext.request.contextPath}/queryUserrServlet?currentPage=${i}&rows=5">${i}</a>
                        </li>
                    </c:if>

                    <c:if test="${queryUserByGender.currentPage!=i}">
                        <li>
                            <a href="${pageContext.request.contextPath}/queryUserrServlet?currentPage=${i}&rows=5">${i}</a>
                        </li>
                    </c:if> </c:forEach>


                <li>
                    <a href="${pageContext.request.contextPath}/queryUserrServlet?currentPage=${queryResult.currentPage+1}&rows=5"
                       aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <br><br>
                <span>
                    共${queryUserByGender.totalCount}条记录，共${queryUserByGender.totalPage}页
                </span>
            </ul>
        </nav>
    </div>
</div>
</body>


