<%--
  Created by IntelliJ IDEA.
  User: gaishun
  Date: 2020-04-06
  Time: 09:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<!DOCTYPE html>--%>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lay.css">
    <title>编辑试题</title>
</head>
<body>
<!-- 头部 -->
<div class="header">
    <div class="float-left header">
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
<!-- 左边用来做查找，删除，修改题目的三个表 -->
<div>
    <!-- 左边选择课程和选择题目类型的选择框 -->
    <form id="add_ques_jump_form">
        <input name="user_id" type="hidden"/>
        <div>
            <div hidden>
                <input name="course_id" id="course_id" value="${course_id}"/>
                <input name="kindOfQues" id="kindOfQues" value="${kind}"/>
                <input name="ques_id" id="ques_id" value="${ques_id}"/>
            </div>
            <div>
                <textarea class="pg_add_wedgit" style="height: 31.25rem;resize: none;font-size: 10px;" name="textarea"
                          id="ques">${ques_zongji}</textarea>
            </div>


            <div>
                <div class="float-left" style="width: 50%;height: auto;">
                    <input class="blank-button add-ques-but" type="button" onclick="add_ques_jump(1)" value="预览"/>
                </div>
                <div class="float-right" style="width: 50%;height: auto;">
                    <input class="blank-button add-ques-but" type="button" onclick="update()" value="提交"/>
                </div>
                <div class="float-bind-father"></div>
            </div>

        </div>
    </form>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bysj.js"></script>

</body>
</html>
