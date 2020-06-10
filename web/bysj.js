//查询，编辑，删除的时候附带上用户的id要
function get_user_info_from_cookie() {
    return "1";
}

function set_user_info_to_cookie() {
    return 0;
}

//加题目的页面的两个跳转的按钮，预览打开新的页面，否则添加题目，加上编辑问题需要的更新问题
function add_ques_jump(a) {
    var jump = document.getElementById("add_ques_jump_form");
    if (a == 1) {
        jump.action = "/Add/Preview";
        jump.target = "_blank";
    } else if (a==2)
        jump.action = "/Add/Addques";
    jump.submit();

}

//更新问题用的
function update() {
    console.log("updateasdfasdfasdfasdfasdfasdfasdfasdfasdfasdf");

    var ques = document.getElementById("ques").value;
    var ques_id = document.getElementById("ques_id").value;
    var kind = document.getElementById("kindOfQues").value;
    console.log(ques);
    $.ajax({
        url:"/Man/Update",
        datatype: "json",
        data:{"ques_id":ques_id,"kind":kind,"ques":ques},
        success : function (data) {
            if(data.length > 0)
                alert("修改成功");
            else
                alert("修改失败");
        }
    });

}

//查询问题用的
function que_select() {
    // //console.log("开始ajaxs");
    var sel = document.getElementById("course_id");
    // var div = document.getElementById("ques_div");
    var index = sel.selectedIndex;
    $.ajax({
        // url:"${pageContext.request.ContextPath}/Man/Select}",
        url: "/Man/Select",
        datatype: "json",
        data: {"course_id": sel.options[index].value},
        success: function (question) {
            // //console.log(question);
            $("#ques_div").empty();
            for (var i = 0; i < question.length; ++i) {
                $("#ques_div").append("<div class= \"shadow graybgcolor \"\n" +
                    "     style= \"border: 1px solid #004466;border-radius: 2%;;width: 90%;margin: 0 auto; margin-top: 20px; font-size: 1rem; \">\n" +
                    "\n" +
                    "    <!-- 先给题目的编号 -->\n" +
                    "    <div style= \"width: 100%;  \">\n" +
                    "        <p class= \"ans \">&nbsp Ques_id: &nbsp &nbsp" + question[i].ques_id + "</p>\n" +
                    "    </div>\n" +
                    "    <hr class= \"line-ans \"/>\n" +
                    "\n" +
                    "    <!-- 先写题干 -->\n" +
                    "    <div style= \"width: 100%;  \">\n" +
                    "        <p class= \"ans \">&nbsp Ques: &nbsp &nbsp\n" +
                    "            " + question[i].ques + "</p>\n" +
                    "    </div>\n" +
                    "    <hr class= \"line-ans \"/>\n" +
                    "\n" +
                    "    <!-- 四个选项 -->\n" +
                    "    <div style= \"width: 100%;  \">\n" +
                    "        <p class= \"ans \">&nbsp A: &nbsp &nbsp  " + question[i].ans1 + "</p>\n" +
                    "    </div>\n" +
                    "    <hr class= \"line-ans \"/>\n" +
                    "    <div style= \"width: 100%;  \">\n" +
                    "        <p class= \"ans \">&nbsp B: &nbsp &nbsp  " + question[i].ans2 + "</p>\n" +
                    "    </div>\n" +
                    "    <hr class= \"line-ans \"/>\n" +
                    "    <div style= \"width: 100%;  \">\n" +
                    "        <p class= \"ans \">&nbsp C: &nbsp &nbsp  " + question[i].ans3 + "</p>\n" +
                    "    </div>\n" +
                    "    <hr class= \"line-ans \"/>\n" +
                    "    <div style= \"width: 100%;  \">\n" +
                    "        <p class= \"ans \">&nbsp D: &nbsp &nbsp  " + question[i].ans4 + "</p>\n" +
                    "    </div>\n" +
                    "\n" +
                    "</div>\n");
            }
        },
        error: function (xhr, textStatus, errorThrown) {
            alert("查询失败，请稍后重试， \n" + errorThrown);
        }
    });
}
function que_judge() {
    //console.log("开始ajaxs");
    var sel = document.getElementById("course_id");
    var div = document.getElementById("ques_div");
    var index = sel.selectedIndex;
    $.ajax({
        // url:"${pageContext.request.ContextPath}/Man/Select}",
        url: "/Man/Judge",
        datatype: "json",
        data: {"course_id": sel.options[index].value},
        success: function (question) {
            //console.log(question);
            $("#ques_div").empty();
            for (var i = 0; i < question.length; ++i) {
                $("#ques_div").append(" <div class=\"shadow graybgcolor\"\n" +
                    "             style=\"border: 1px solid #004466;border-radius: 2%;;width: 90%;margin: 0 auto; margin-top: 20px; font-size: 1rem;\">\n" +
                    "\n" +
                    "            <!-- 先给题目的编号 -->\n" +
                    "            <div style=\"width: 100%; \">\n" +
                    "                <p class=\"ans\">&nbsp Ques_id: &nbsp &nbsp " + question[i].ques_id + "</p>\n" +
                    "            </div>\n" +
                    "            <hr class=\"line-ans\"/>\n" +
                    "\n" +
                    "            <!-- 先写题干 -->\n" +
                    "            <div style=\"width: 100%; \">\n" +
                    "                <p class=\"ans\">&nbsp Ques: &nbsp &nbsp " + question[i].ques + "</p>\n" +
                    "            </div>\n" +
                    "            <hr class=\"line-ans\"/>\n" +
                    "\n" +
                    "            <!-- 四个选项 -->\n" +
                    "            <div style=\"width: 100%; \">\n" +
                    "                <p class=\"ans\">&nbsp Ans: &nbsp &nbsp " + question[i].ans + "</p>\n" +
                    "            </div>\n" +
                    "\n" +
                    "        </div>");
            }
        },
        error: function (xhr, textStatus, errorThrown) {
            alert("查询失败，请稍后重试， \n" + errorThrown);
        }
    });
}
function que_simple() {
    //console.log("开始ajaxs");
    var sel = document.getElementById("course_id");
    var div = document.getElementById("ques_div");
    var index = sel.selectedIndex;
    $.ajax({
        // url:"${pageContext.request.ContextPath}/Man/Select}",
        url: "/Man/Simple",
        datatype: "json",
        data: {"course_id": sel.options[index].value},
        success: function (question) {
            //console.log(question);
            $("#ques_div").empty();
            for (var i = 0; i < question.length; ++i) {
                $("#ques_div").append("<div class=\"shadow graybgcolor\" style=\"border: 1px solid #004466;border-radius: 2%;;width: 90%;margin: 0 auto; margin-top: 20px; font-size: 1rem;\">\n" +
                    "\n" +
                    "            <!-- 先给题目的编号 -->\n" +
                    "            <div style=\"width: 100%; \">\n" +
                    "                <p class=\"ans\">&nbsp Ques_id: &nbsp &nbsp " + question[i].ques_id + "</p>\n" +
                    "            </div>\n" +
                    "            <hr class=\"line-ans\" />\n" +
                    "\n" +
                    "            <!-- 先写题干 -->\n" +
                    "            <div style=\"width: 100%; \">\n" +
                    "                <p class=\"ans\">&nbsp Ques: &nbsp &nbsp\n" +
                    "                       " + question[i].ques + "</p>\n" +
                    "            </div>\n" +
                    "            <hr class=\"line-ans\" />\n" +
                    "\n" +
                    "            <!-- 一个答案 -->\n" +
                    "            <div style=\"width: 100%; \">\n" +
                    "                <p class=\"ans\">&nbsp Ans: &nbsp &nbsp " + question[i].ans + "</p>\n" +
                    "            </div>\n" +
                    "\n" +
                    "        </div>");
            }
        },
        error: function (xhr, textStatus, errorThrown) {
            alert("查询失败，请稍后重试， \n" + errorThrown);
        }
    });
}
function query_ques() {
    //console.log("进入函数");
    var sel = document.getElementById("kindOfQues_q");
    var index = sel.selectedIndex;
    if (sel.options[index].value === "1") {
        //console.log("选择题js");
        que_select();
    }
    if (sel.options[index].value === "2") {
        //console.log("判断题js");
        que_judge();
    }
    if (sel.options[index].value === "3") {
        //console.log("简答题js");
        que_simple();
    }
}

//删除问题用的
function del_sel(ques_id) {
    var sel = document.getElementById("course_id");
    var index = sel.selectedIndex;

    //console.log(sel.options[index].value);
    //console.log(ques_id);
    $.ajax({
        // url:"${pageContext.request.ContextPath}/Man/Select}",
        url: "/Man/del_Select",
        datatype: "json",
        data: {"course_id": sel.options[index].value, "ques_id": ques_id},
        success: function (data) {
            //console.log(data);
            if (data.length > 0) {
                que_select();
                alert("删除成功");
            } else
                alert("删除失败，请重试");
        },
        error: function (xhr, textStatus, errorThrown) {
            alert("删除失败，请稍后重试\n" + errorThrown);
        }
    });
}
function del_sim (ques_id){
    var sel = document.getElementById("course_id");
    var index = sel.selectedIndex;

    //console.log(sel.options[index].value);
    //console.log(ques_id);
    $.ajax({
        // url:"${pageContext.request.ContextPath}/Man/Select}",
        url: "/Man/del_Simple",
        datatype: "json",
        data: {"course_id": sel.options[index].value, "ques_id": ques_id},
        success: function (data) {
            //console.log(data);
            if (data.length > 0) {
                que_simple();
                alert("删除成功");
            } else
                alert("删除失败，请重试");
        },
        error: function (xhr, textStatus, errorThrown) {
            alert("删除失败，请稍后重试\n" + errorThrown);
        }
    });
}
function del_jud (ques_id){
    var sel = document.getElementById("course_id");
    var index = sel.selectedIndex;

    //console.log(sel.options[index].value);
    //console.log(ques_id);
    $.ajax({
        // url:"${pageContext.request.ContextPath}/Man/Select}",
        url: "/Man/del_Judge",
        datatype: "json",
        data: {"course_id": sel.options[index].value, "ques_id": ques_id},
        success: function (data) {
            //console.log(data);
            if (data.length > 0) {
                que_judge();
                alert("删除成功");
            } else
                alert("删除失败，请重试");
        },
        error: function (xhr, textStatus, errorThrown) {
            alert("删除失败，请稍后重试\n" + errorThrown);
        }
    });
}
function del_ques() {
    var del_id = document.getElementById("del_id");
    var sel = document.getElementById("kindOfQues_q");
    var index = sel.selectedIndex;
    if (sel.options[index].value === "1") {
        //console.log("选择题js");
        del_sel(del_id.value);
    }
    if (sel.options[index].value === "2") {
        //console.log("判断题js");
        del_jud(del_id.value);
    }
    if (sel.options[index].value === "3") {
        //console.log("简答题js");
        del_sim(del_id.value);
    }
}


//跳转到编辑界面
function jump_edit(course_id, ques_id, kindOfQues) {
    var jump = document.getElementById("edit_sub");
    document.getElementById("edit_course_id").value = course_id;
    document.getElementById("edit_kind").value = kindOfQues;
    document.getElementById("edit_ques_id").value = ques_id;
    jump.target = "_blank";
    jump.action = "/Man/Edit";
    jump.submit();

}


//判断车程与题目是否相对应
function judge_sel(course_id,ques_id) {
    $.ajax({
        url:"/Man/judge_Select",
        datatype:"json",
        data:{"course_id":course_id,"ques_id":ques_id},
        success: function (data) {
            if(data.length <= 0){
                alert("编号与课程不符或编号输入错误");
            }
            else{
                jump_edit(course_id,ques_id,1);
            }
        },
        error: function (xhr, textStatus, errorThrown) {
            alert("失败，请稍后重试\n" + errorThrown);
        }
    });
}
function judge_sim(course_id,ques_id) {
    $.ajax({
        url:"/Man/judge_Simple",
        datatype:"json",
        data:{"course_id":course_id,"ques_id":ques_id},
        success: function (data) {
            if(data.length <= 0){
                alert("编号与课程不符或编号输入错误");
            }
            else{
                jump_edit(course_id,ques_id,3);
            }
        },
        error: function (xhr, textStatus, errorThrown) {
            alert("失败，请稍后重试\n" + errorThrown);
        }
    });
}
function judge_jud(course_id,ques_id) {
    $.ajax({
        url:"/Man/judge_Judge",
        datatype:"json",
        data:{"course_id":course_id,"ques_id":ques_id},
        success: function (data) {

            if(data.length <= 0){
                alert("编号与课程不符或编号输入错误");
            }
            else{
                jump_edit(course_id,ques_id,2);
            }
        },
        error: function (xhr, textStatus, errorThrown) {
            alert("失败，请稍后重试\n" + errorThrown);
        }
    });
}
function edit_ques() {
    var edit_id = document.getElementById("edit_id");
    var sel = document.getElementById("kindOfQues_q");
    var cour = document.getElementById("course_id");
    var index_cour = cour.selectedIndex;
    var index = sel.selectedIndex;

    console.log(sel.options[index].value);
    console.log(cour.options[index_cour].value+"d a"+edit_id.value);

    if (sel.options[index].value === "1") {
        console.log("选择题js");


        judge_sel(cour.options[index_cour].value,edit_id.value);
    }
    if (sel.options[index].value === "2") {
        console.log("判断题js");

        judge_jud(cour.options[index_cour].value,edit_id.value);
    }
    if (sel.options[index].value === "3") {
        console.log("简答题js");

        judge_sim(cour.options[index_cour].value,edit_id.value);
    }
}


//接下来的两个函数是导航页面用来做跳转的
function to_Man() {
    var jump = document.getElementById("pg_Guide_Jump");
    jump.target = "_blank";
    jump.action = "/Guide/man";
    jump.submit();
}

function to_Add() {
    var jump = document.getElementById("pg_Guide_Jump");
    jump.target = "_blank";
    jump.action = "/Guide/add";
    jump.submit();
}

//登陆时使用
function login() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("passwd").value;
    // console.log("login");
    $.ajax({
       url:"/Login/logincheck",
       datatype:"json",
       data:{"username":username,"password":password},
       success: function (data) {
           // console.log("loginajax");
           if (data.length<=0)
                alert("账号或者密码错误，请重试");
            else{
                alert("登陆成功");
                var form = document.getElementById("loginform");
                form.action="/Login/loginjump";
                form.submit();
            }
       },
        error: function (xhr, textStatus, errorThrown) {
            alert("登陆失败，请稍后重试\n" + errorThrown);
        }
    });
}
