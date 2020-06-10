<%--
  Created by IntelliJ IDEA.
  User: gaishun
  Date: 2020-04-06
  Time: 09:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lay.css" />
    <title>添加试题</title>
</head>
<body>
<!-- 头部 -->
<div class="header">
    <div class="float-left header">
        <input type="image" class="header" src="${pageContext.request.contextPath}/static/icon.jpeg" />
    </div>
    <div class="float-left header">
        <p>中国石油大学（华东）试题库后台管理系统</p>
    </div>
    <div class="float-right " style="width: 10%">
        <input type="button" style="width: 80%;height: 3em;" value=" ？？？" />
    </div>

    <div class="float-bind-father"></div>
</div>

<!-- 左边用来做查找，删除，修改题目的三个表 -->
<div>
    <!-- 左边选择课程和选择题目类型的选择框 -->
    <form id="query_form">
        <input name="user_id" type="hidden" />

        <div style="position: fixed;margin-top:10px;width: 140px;height:110px;background-color: #006697;border-radius: 0.525rem;border: 1px solid gray;">
            <div>
                <select style="width: 90%;height: 1.5rem;margin-left: 5%;margin-top: 10%;" name="course_id">
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
                <input class="blank-button"style="margin-top: 10%;margin-left: 60%;width:40%;" type="button" value="查询" onclick="query_ques()"/>
            </div>

        </div>
    </form>
    <form id="del_form">
        <input name="user_id" type="hidden" />
        <div style="position: fixed;margin-top:130px;width: 140px;height:115px;background-color: orange;border-radius: 0.525rem;border: 1px solid gray;">
            <div>
                <select style="width: 90%;height: 1.5rem;margin-left: 5%;margin-top: 10%;" name="kindOfQues" id="kindOfQues_d">
                    <option value="1">选择题</option>
                    <option value="2">判断题</option>
                    <option value="3">简答题</option>
                </select>
            </div>
            <div>
                <input style="width: 90%;height: 1.2rem;margin-left: 3%;margin-top: 10%;" type="number" />
            </div>
            <div>
                <input class="blank-button" style="margin-top: 10%;margin-left: 60%;width:40%;" type="button" value="删除" onclick="del_ques()"/>
            </div>
        </div>
    </form>
    <form id="edit_form">
        <input name="user_id" type="hidden" />

        <div style="position: fixed;margin-top:260px;width: 140px;height:115px;background-color: lightseagreen;border-radius: 0.525rem;border: 1px solid gray;">
            <div>
                <select style="width: 90%;height: 1.5rem;margin-left: 5%;margin-top: 10%;" name="kindOfQues" id="kindOfQues_e">
                    <option value="1">选择题</option>
                    <option value="2">判断题</option>
                    <option value="3">简答题</option>
                </select>
            </div>
            <div>
                <input style="width: 90%;height: 1.2rem;margin-left: 3%;margin-top: 10%;" type="number" />
            </div>
            <div>
                <input class="blank-button" style="margin-top: 10%;margin-left: 60%;width:40%;" type="button" value="修改" onclick="edit_ques()"/>
            </div>
        </div>
    </form>
</div>

<!-- 用来显示题目的块 -->
<div style="margin-left: 160px;margin-bottom: 30px;width: auto; ">

    <c:forEach items="${question}" var="ques">
        <!-- 先写一个题目的demo -->
        <div class="shadow graybgcolor" style="border: 1px solid #004466;border-radius: 2%;;width: 90%;margin: 0 auto; margin-top: 20px; font-size: 1rem;">

            <!-- 先给题目的编号 -->
            <div style="width: 100%; ">
                <p class="ans">&nbsp Ques_id: &nbsp &nbsp ${ques.ques_id}</p>
            </div>
            <hr class="line-ans" />

            <!-- 先写题干 -->
            <div style="width: 100%; ">
                <p class="ans">&nbsp Ques: &nbsp &nbsp
                        ${ques.ques}</p>
            </div>
            <hr class="line-ans" />

            <!-- 一个答案 -->
            <div style="width: 100%; ">
                <p class="ans">&nbsp Ans: &nbsp &nbsp ${ques.ans}</p>
            </div>

        </div>
    </c:forEach>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/bysj.js"></script>

</body>
</html>
