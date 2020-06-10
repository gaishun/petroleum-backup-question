<%--
  Created by IntelliJ IDEA.
  User: gaishun
  Date: 2020-05-30
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>中国石油大学（华东）试题库后台管理系统</title>
</head>
<body>
    <div>
        <form id="loginform">
            <input id="username" name="username"/>
            <input id="passwd" name="passwd"/>
            <button type="button" onclick="login()" >登陆</button>
        </form>
    </div>

    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bysj.js"></script>
</body>
</html>
