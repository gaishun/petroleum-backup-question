package com.bysj.controller;


import com.bysj.DAO.JudgeImp;
import com.bysj.DAO.Other_DAO;
import com.bysj.DAO.SelectImp;
import com.bysj.DAO.SimpleImp;
import com.bysj.Entity.Judge;
import com.bysj.Entity.Select;
import com.bysj.Entity.Simple;
import com.mysql.cj.xdevapi.JsonArray;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Man")
public class Man_ques_controller {

    private ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
    private JdbcTemplate jtemp = ac.getBean(JdbcTemplate.class);
    private ModelAndView mv ;

//    @RequestMapping("/Man_init")
//    public ModelAndView Man_init (Model model){
//        mv = new ModelAndView("/Man_ques/Man_ques_init");
//        model.addAttribute("course",new Other_DAO().query_tea_course(jtemp,1));
//        return mv;
//    }

    @RequestMapping("/Select")
    @ResponseBody
    public List<Select> Man_select (int course_id){ return new SelectImp().query_question(jtemp,course_id); }
    @RequestMapping("/Judge")
    @ResponseBody
    public List<Judge> Man_judge (int course_id){
        return new JudgeImp().query_question(jtemp,course_id);
    }
    @RequestMapping("/Simple")
    @ResponseBody
    public List<Simple> Man_simple (int course_id){
        return new SimpleImp().query_question(jtemp,course_id);
    }

    //删除问题
    @RequestMapping("/del_Select")
    @ResponseBody
    public List<Select> del_Select (int course_id, int ques_id) {
        List<Select> sel = new SelectImp().query_question_ques_id(jtemp,course_id,ques_id);
        if(sel.size()==0) return null;
        if(new SelectImp().del_question(jtemp,sel.get(0).getQues_id())==0) return null;
        return sel;
    }
    @RequestMapping("/del_Simple")
    @ResponseBody
    public List<Simple> del_Simple (int course_id, int ques_id) {
        List<Simple> sim = new SimpleImp().query_question_ques_id(jtemp,course_id,ques_id);
        if(sim.size()==0) return null;
        if(new SimpleImp().del_question(jtemp,sim.get(0).getQues_id())==0) return null;
        return sim;
    }
    @RequestMapping("/del_Judge")
    @ResponseBody
    public List<Judge> del_Judge (int course_id, int ques_id) {
        List<Judge> jud = new JudgeImp().query_question_ques_id(jtemp,course_id,ques_id);
        if(jud.size()==0) return null;
        if(new JudgeImp().del_question(jtemp,jud.get(0).getQues_id())==0) return null;
        return jud;
    }

    //判断课程和题目是否对应，相应地也判断了教师和题目是否对应
    @RequestMapping("/judge_Select")
    @ResponseBody
    public List<Select> judge_Select (int course_id, int ques_id) {
        List<Select> sel = new SelectImp().query_question_ques_id(jtemp,course_id,ques_id);
        if(sel.size()==0) return null;
        System.out.println(course_id+"...."+ques_id+"...."+sel);
        return sel;
    }
    @RequestMapping("/judge_Simple")
    @ResponseBody
    public List<Simple> judge_Simple (int course_id, int ques_id) {
        List<Simple> sim = new SimpleImp().query_question_ques_id(jtemp,course_id,ques_id);
        System.out.println(course_id+"...."+ques_id+"...."+sim);
        if(sim.size()==0) return null;
        return sim;
    }
    @RequestMapping("/judge_Judge")
    @ResponseBody
    public List<Judge> judge_Judge (int course_id, int ques_id) {
        List<Judge> jud = new JudgeImp().query_question_ques_id(jtemp,course_id,ques_id);
        if(jud.size()==0) return null;
        System.out.println(course_id+"...."+ques_id+"...."+jud);
        return jud;
    }

    //生成编辑试题的界面
    @RequestMapping("/Edit")
    public String Edit (Model model,Integer edit_course_id, Integer edit_ques_id, Integer edit_kind){
//        System.out.println(edit_course_id+"\t"+edit_ques_id+"\t"+edit_kind);
        int course_id = edit_course_id;
        int ques_id = edit_ques_id;
        int kindOfQues = edit_kind;
        String ques ;
        if(kindOfQues==1){
            List<Select> sel = new SelectImp().query_question_id(jtemp,ques_id);
//            System.out.println(jud);
            ques = sel.get(0).getQues().trim()+'\n';
            ques += sel.get(0).getAns1().trim()+'\n';
            ques += sel.get(0).getAns2().trim()+'\n';
            ques += sel.get(0).getAns3().trim()+'\n';
            ques += sel.get(0).getAns4().trim()+'\n';
//            System.out.println(ques);
            model.addAttribute("ques_zongji",ques);
            model.addAttribute("kind",1);
        }
        else if (kindOfQues == 2){
            List<Judge> jud = new JudgeImp().query_question_id(jtemp,ques_id);
            ques = jud.get(0).getQues().trim()+'\n';
            ques += jud.get(0).getAns().trim()+'\n';
            model.addAttribute("ques_zongji",ques);
            model.addAttribute("kind",2);
        }
        else {
            List<Simple> sim = new SimpleImp().query_question_id(jtemp,ques_id);
            ques = sim.get(0).getQues().trim()+'\n';
            ques += sim.get(0).getAns().trim()+'\n';
            model.addAttribute("ques_zongji",ques);
            model.addAttribute("kind",3);
        }

        model.addAttribute("course_id",course_id);
        model.addAttribute("ques_id",ques_id);

        return "/Man_ques/Man_ques_edit";
    }

    //更新题目
    @RequestMapping("/Update")
    @ResponseBody
    public List<Judge> Update (int ques_id,int kind,String ques){
        String []str = ques.split("\n");
        List<Judge> jud = new ArrayList<>();
        Judge temp = new Judge();
        jud.add(temp);
        int i =-1;
        if(kind == 1){
            i=4;
            i = new SelectImp().update_question(jtemp,str[i-4],str[i-3],str[i-2],str[i-1],str[i],ques_id);
        }
        else if(kind ==2){
            i=1;
            i = new JudgeImp().update_question(jtemp,str[i-1],str[i],ques_id);
        }
        else{
            i=1;
            i = new SimpleImp().update_question(jtemp,str[i-1],str[i],ques_id);
        }
        System.out.println(i);
        if(i==1)
            return jud;
        else
            return null;
    }




}
