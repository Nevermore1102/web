<%--
  Created by IntelliJ IDEA.
  User: 15353
  Date: 2020/6/12
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%String path = request.getContextPath();%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>院级管理员管理界面</title>
    <link rel="stylesheet" href="<%=path%>/CSS/HealthCodeLoginCSS.css">
</head>
<body style="background: #444444">
<div class="login">
    <div class="account">
        <div class="logo">院级管理员管理界面</div>
        <form action="<%=path%>/JSP/showAllMajorHealthyCode.jsp" method="post">
            <div class="login_btn">
                <input id="专业打卡情况统计" value="本专业打卡情况统计" type="submit">
            </div>
        </form>
        <form action="<%=path%>/JSP/searchMajorUsers.jsp" method="post">
            <div class="login_btn">
                <input id="本专业数据查询" value="本专业师生打卡情况查询" type="submit">
            </div>
        </form>
    </div>
</div>
</body>
</html>
