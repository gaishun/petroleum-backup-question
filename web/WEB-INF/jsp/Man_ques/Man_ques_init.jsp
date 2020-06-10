<%--
  Created by IntelliJ IDEA.
  User: gaishun
  Date: 2020-04-06
  Time: 09:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lay.css"/>
    <title>添加试题</title>
</head>
<body>

<%--用来保存用户信息--%>
<input name="user_id" id="user_id" value="${user_id}" type="hidden" />

<!-- 头部 -->
<div class="header" >
    <div class="float-left header">
        <input type="image" class="header" src="${pageContext.request.contextPath}/static/icon.jpeg"/>
    </div>
    <div class="float-left header" >
        <p>中国石油大学（华东）试题库后台管理系统</p>
    </div>
    <div class="float-right " style="width: 10%">
        <input type="button" style="width: 80%;height: 3em;" value="？？？"/>
    </div>

    <div class="float-bind-father"></div>
</div>

<!-- 左边用来做查找，删除，修改题目的三个表 -->
<div>
    <!-- 左边选择课程和选择题目类型的选择框 -->
    <form id="query_form">
        <input name="path" id="path" type="hidden" value="${pageContext.request.contextPath}" />

        <div style="position: fixed;margin-top:10px;width: 140px;height:110px;background-color: #006697;border-radius: 0.525rem;border: 1px solid gray;">
            <div>
                <select style="width: 90%;height: 1.5rem;margin-left: 5%;margin-top: 10%;" name="course_id" id="course_id">
                    <c:forEach items="${course}" var="course">
                        <option value="${course.cour_id}">${course.cour_name}</option>
                    </c:forEach>
                </select>
            </div>

            <div>
                <select style="width: 90%;height: 1.5rem;margin-left: 5%;margin-top: 10%;" name="kindOfQues" id="kindOfQues_q">
                    <option value="1">选择题</option>
                    <option value="2">判断题</option>
                    <option value="3">简答题</option>
                </select>
            </div>

            <div>
                <input class="blank-button" style="margin-top: 10%;margin-left: 60%;width:40%;" type="button" onclick="query_ques()"
                       value="查询"/>
            </div>

        </div>
    </form>
    <form id="del_form">
        <input name="user_id" type="hidden" />

        <div style="position: fixed;margin-top:130px;width: 140px;height:65px;background-color: orange;border-radius: 0.525rem;border: 1px solid gray;">
            <div>
                <input style="width: 90%;height: 1.2rem;margin-left: 3%;margin-top: 10%;" type="number" id="del_id"/>
            </div>
            <div>
                <input class="blank-button" style="margin-top: 10%;margin-left: 60%;width:40%;" type="button" onclick="del_ques()"
                       value="删除"/>
            </div>
        </div>
    </form>
    <form id="edit_form">
        <input name="user_id" type="hidden" />

        <div style="position: fixed;margin-top:208px;width: 140px;height:65px;background-color: lightseagreen;border-radius: 0.525rem;border: 1px solid gray;">
            <div>
                <input style="width: 90%;height: 1.2rem;margin-left: 3%;margin-top: 10%;" type="number" id="edit_id"/>
            </div>
            <div>
                <input class="blank-button" style="margin-top: 10%;margin-left: 60%;width:40%;" type="button" onclick="edit_ques()"
                       value="修改" />
            </div>
        </div>
    </form>
</div>
<div hidden>
    <form id="edit_sub">
        <input id="edit_course_id" name ="edit_course_id"  />
        <input id="edit_kind" name = "edit_kind"/>
        <input id="edit_ques_id" name = "edit_ques_id"/>
    </form>
</div>

<div style="margin-left: 160px;margin-bottom: 30px;width: auto; " id="ques_div">


</div>

<%--<script type="text/javascript">var ctx="${contextPath}"; </script >--%>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bysj.js"></script>

</body>
</html>

