<%--
  Created by IntelliJ IDEA.
  User: gaishun
  Date: 2020-04-06
  Time: 09:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lay.css"/>
    <title></title>
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

<c:choose>
    <c:when test="${kind==1}">
        <!-- 选择题 -->
        <div style="margin-left: 160px;margin-bottom: 30px;width: auto; ">

            <c:forEach items="${question}" var="ques">
                <!-- 先写一个题目的demo -->
                <div class="shadow graybgcolor"
                     style="border: 1px solid #004466;border-radius: 2%;;width: 90%;margin: 0 auto; margin-top: 20px; font-size: 1rem;">

                    <!-- 先写题干 -->
                    <div style="width: 100%; ">
                        <p class="ans">&nbsp Ques: &nbsp &nbsp
                                ${ques.ques}</p>
                    </div>
                    <hr class="line-ans"/>

                    <!-- 四个选项 -->
                    <div style="width: 100%; ">
                        <p class="ans">&nbsp A: &nbsp &nbsp ${ques.ans1}</p>
                    </div>
                    <hr class="line-ans"/>
                    <div style="width: 100%; ">
                        <p class="ans">&nbsp B: &nbsp &nbsp ${ques.ans2}</p>
                    </div>
                    <hr class="line-ans"/>
                    <div style="width: 100%; ">
                        <p class="ans">&nbsp C: &nbsp &nbsp ${ques.ans3}</p>
                    </div>
                    <hr class="line-ans"/>
                    <div style="width: 100%; ">
                        <p class="ans">&nbsp D: &nbsp &nbsp ${ques.ans4}</p>
                    </div>

                </div>

            </c:forEach>

        </div>

    </c:when>

    <c:otherwise>


        <c:if test="${kind==2}">
            <!-- 判断题 -->
            <div style="margin-left: 160px;margin-bottom: 30px;width: auto; ">
                <!-- 先写一个题目的demo -->
                <c:forEach items="${question}" var="ques">
                    <div class="shadow graybgcolor"
                         style="border: 1px solid #004466;border-radius: 2%;;width: 90%;margin: 0 auto; margin-top: 20px; font-size: 1rem;">

                        <!-- 先写题干 -->
                        <div style="width: 100%; ">
                            <p class="ans">&nbsp Ques: &nbsp &nbsp ${ques.ques}</p>
                        </div>
                        <hr class="line-ans"/>

                        <!-- 四个选项 -->
                        <div style="width: 100%; ">
                            <p class="ans">&nbsp Ans: &nbsp &nbsp ${ques.ans}</p>
                        </div>

                    </div>
                </c:forEach>
            </div>
        </c:if>


        <c:if test="${kind==3}">
            <!-- 简答题 -->
            <div style="margin-left: 160px;margin-bottom: 30px;width: auto; ">

                <c:forEach items="${question}" var="ques">
                    <!-- 先写一个题目的demo -->
                    <div class="shadow graybgcolor"
                         style="border: 1px solid #004466;border-radius: 2%;;width: 90%;margin: 0 auto; margin-top: 20px; font-size: 1rem;">


                        <!-- 先写题干 -->
                        <div style="width: 100%; ">
                            <p class="ans">&nbsp Ques: &nbsp &nbsp
                                    ${ques.ques}</p>
                        </div>
                        <hr class="line-ans"/>

                        <!-- 一个答案 -->
                        <div style="width: 100%; ">
                            <p class="ans">&nbsp Ans: &nbsp &nbsp ${ques.ans}</p>
                        </div>

                    </div>
                </c:forEach>
            </div>
        </c:if>
    </c:otherwise>
</c:choose>

<script type="text/javascript" src="${pageContext.request.contextPath}/bysj.js"></script>

</body>
</html>
