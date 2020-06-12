<%--
  Created by IntelliJ IDEA.
  User: 15353
  Date: 2020/6/12
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%String path = request.getContextPath();%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>校级管理员管理界面</title>
    <link rel="stylesheet" href="<%=path%>/CSS/HealthCodeLoginCSS.css">
</head>
<body style="background: #444444">
<div class="login">
    <div class="account">
        <div class="logo">校级管理员管理界面</div>
        <form action="<%=path%>/JSP/searchUsers.jsp" method="post">
            <div class="login_btn">
                <input id="全校打卡情况统计" value="全校打卡情况统计" type="submit">
            </div>
        </form>
        <form action="<%=path%>/JSP/showAllUsersHealthyCode.jsp" method="post">
            <div class="login_btn">
                <input id="数据查询" value="师生打卡情况查询" type="submit">
            </div>
        </form>
    </div>
</div>
</body>
</html>