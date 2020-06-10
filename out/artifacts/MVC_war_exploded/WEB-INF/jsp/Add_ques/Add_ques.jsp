<%--
  Created by IntelliJ IDEA.
  User: gaishun
  Date: 2020-04-06
  Time: 09:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--<!DOCTYPE html>--%>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lay.css" >
    <title>添加试题</title>
</head>
<body>
<!-- 头部 -->
<div class="header" >
    <div class="float-left header" >
        <input type="image" class="header" src="${pageContext.request.contextPath}/static/icon.jpeg" />
    </div>
    <div class="float-left header">
        <p >中国石油大学（华东）试题库后台管理系统</p>
    </div>
    <div class="float-right " style="width: 10%">
        <input type="button" style="width: 80%;height: 3em;" value=" ？？？" />
    </div>

    <div class="float-bind-father"></div>
</div>



<!-- 左边用来做查找，删除，修改题目的三个表 -->
<div>
    <!-- 左边选择课程和选择题目类型的选择框 -->
    <form id="add_ques_jump_form">
        <%--用来保存用户信息--%>
        <input name="user_id" id="user_id" value="${user_id}" type="hidden" />
        <div>
            <div>
                <select class="pg_add_wedgit" name="course_id">
                    <c:forEach items="${course}" var="course">
                        <option value="${course.cour_id}">${course.cour_name}</option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <select class="pg_add_wedgit" name="kindOfQues">
                    <option value="1">选择题</option>
                    <option value="2">判断题</option>
                    <option value="3">简答题</option>
                </select>
            </div>
            <div>
						<textarea  class="pg_add_wedgit" style="height: 31.25rem;resize: none;font-size: 10px;" name = "textarea">
请仔细阅读：（理解之后Ctrl+A全选 然后退格键删除即可）
	不必填写题号，直接写题目，第一行是题目，其余行为答案，问题与问题之间不必空一行
	选择题示例：
请问1+1=？
1
2
3
4
（将自动识别第一行为问题，第二行为答案）

	简答题示例：
请问1+1=？
2
（将自动识别第一行为问题，第二行为答案）

	判断题示例：
请问1+1=2？
1
（将自动识别第一行为问题，第二行为答案，我们约定0是错，1是对，该题正确答案是对）
						</textarea>
            </div>

            <div>
                <div class="float-left" style="width: 50%;height: auto;" >
                    <input class="blank-button add-ques-but" type="button" onclick="add_ques_jump(1)"  value="预览" />
                </div>
                <div class="float-right" style="width: 50%;height: auto;" >
                    <input class="blank-button add-ques-but" type="button" onclick="add_ques_jump(2)" value="提交" />
                </div>
                <div class="float-bind-father"></div>
            </div>

        </div>
    </form>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/bysj.js"></script>

</body>
</html>
