<%--
  Created by IntelliJ IDEA.
  User: gaishun
  Date: 2020-04-06
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lay.css"/>

    <title>中国石油大学（华东）试题库后台管理系统</title>

</head>
<body>
<!-- 头部 -->
<div class="header shadow">
    <div class="float-left header ">
        <input type="image" class="header" src="${pageContext.request.contextPath}/static/icon.jpeg"/>
    </div>
    <div class="float-left header">
        <p>中国石油大学（华东）试题库后台管理系统</p>
    </div>
    <div class="float-right " style="width: 10%">
        <input type="button" style="width: 80%;height: 3em;" value=" ？？？"/>
    </div>

    <div class="float-bind-father"></div>
</div>

<form id="pg_Guide_Jump">
    <!-- 中间选项 , 选择是查看题目还是添加题目-->
    <div style="width: 100%;height: 600px;">
        <div hidden>
            <input id="user_id" name="user_id" value="${user_id}">
        </div>
        <div style="width: 50%;height: 100%;" class="float-left">
            <input type="button" onclick="to_Man()" class="guide-block blank-button" style="background-color: #006699;"
                   value="管理题目"/>
        </div>
        <div style="width: 50%;height: 100%;" class="float-left">
            <input type="button" onclick="to_Add()" class="guide-block blank-button" style="background-color: darkgrey;"
                   value="添加题目"/>
        </div>
        <div class="float-bind-father"></div>
    </div>
</form>

<script type="text/javascript" src="${pageContext.request.contextPath}/bysj.js"></script>
</body>
</html>

