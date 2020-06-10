<%--
  Created by IntelliJ IDEA.
  User: gaishun
  Date: 2020-04-06
  Time: 09:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<!DOCTYPE html>--%>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="lay.css" >
    <title>添加试题</title>
</head>
<body>
<!-- 头部 icon -->
<div class="header">
    <div class="float-left header">
        <input type="image" class="header" src="static/icon.jpeg"  alt="value"/>
    </div>
    <div class="float-left header">
        <p>中国石油大学（华东）试题库后台管理系统</p>
    </div>
    <div class="float-right " style="width: 10%">
        <input type="button" style="width: 80%;height: 3em;" value="登陆"/>
    </div>

    <div class="float-bind-father"></div>
</div>

<!-- 左边用来做查找，删除，修改题目的三个表 -->
<div>
    <!-- 左边选择课程和选择题目类型的选择框 -->
    <form>
        <div>
            <div>
                <select class="pg_add_wedgit">
                    <option>course1</option>
                    <option>course2</option>
                    <option>course2</option>
                </select>
            </div>
            <div>
                <select class="pg_add_wedgit">
                    <option>选择题</option>
                    <option>判断题</option>
                    <option>简答题</option>
                </select>
            </div>
            <div>
						<textarea class="pg_add_wedgit" style="height: 31.25rem;resize: none;font-size: 10px;">
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
                <div class="float-left" style="width: 50%;height: auto;">
                    <input class="blank-button add-ques-but" type="submit" value="预览"/>
                </div>
                <div class="float-right" style="width: 50%;height: auto;">
                    <input class="blank-button add-ques-but" type="submit" value="提交"/>
                </div>
                <div class="float-bind-father"></div>
            </div>

        </div>
    </form>
</div>


</body>
</html>
