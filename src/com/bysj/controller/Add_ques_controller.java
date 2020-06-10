package com.bysj.controller;

//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import com.bysj.DAO.JudgeImp;
import com.bysj.DAO.Other_DAO;
import com.bysj.DAO.SelectImp;
import com.bysj.DAO.SimpleImp;
import com.bysj.Entity.Judge;
import com.bysj.Entity.Select;
import com.bysj.Entity.Simple;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/Add")
public class Add_ques_controller {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
    private JdbcTemplate jtemp = ac.getBean(JdbcTemplate.class);
    private ModelAndView mv ;

    ModelAndView get_mv (String m){
        return  new ModelAndView(m);
    }

//    @RequestMapping("/Add_init")
//    public ModelAndView Add_init (Model model){
//        model.addAttribute("course",new Other_DAO().query_tea_course(jtemp,1));
//        mv = get_mv("/Add_ques/Add_ques");
//
//        return mv;
//    }

    /**
     * 测试通过 4.6
     * @param model
     * @param kindOfQues
     * @param textarea
     * @return
     */
    @RequestMapping("/Preview")
    public ModelAndView Preview (Model model,String kindOfQues,String textarea){
        String []str = textarea.split("\n");
        System.out.println(str);
        List<Object> list= new LinkedList<Object>();
        mv = get_mv("/Add_ques/Preview_ques");
        if(kindOfQues.equals("1")){
            model.addAttribute("kind",1);
            for(int i=4;i<str.length;i+=5){
                list.add(new Select(str[i-4],str[i-3],str[i-2],str[i-1],str[i]));
                System.out.println(list);
            }
        }
        else if (kindOfQues.equals("2")){
            model.addAttribute("kind",2);
            for(int i=1;i<str.length;i+=2){
                list.add(new Judge(str[i-1],str[i]));
                System.out.println(list);

            }
        }
        else{
            model.addAttribute("kind",3);
            for(int i=1;i<str.length;i+=2){
                list.add(new Simple(str[i-1],str[i]));
                System.out.println(list);

            }
        }
        model.addAttribute("question",list);
        return mv;

    }
    /**
     *
     * @param model
     * @param course_id
     * @param kindOfQues
     * @param textarea
     * @return
     */
    @RequestMapping("/Addques")
    public ModelAndView Addques (Model model,int course_id,String kindOfQues,String textarea,int user_id){
        String []str = textarea.split("\n");

        if(kindOfQues.equals("1")){
            for(int i=4;i<str.length;i+=5){
                new SelectImp().add_question(jtemp,course_id,str[i-4],str[i-3],str[i-2],str[i-1],str[i]);
            }
        }
        else if (kindOfQues.equals("2")){
            for(int i=1;i<str.length;i+=2){
                new JudgeImp().add_question(jtemp,course_id,str[i-1],str[i]);
            }
        }
        else{
            for(int i=1;i<str.length;i+=2){
                new SimpleImp().add_question(jtemp,course_id,str[i-1],str[i]);
            }
        }

        model.addAttribute("course",new Other_DAO().query_tea_course(jtemp,user_id));
        mv = get_mv("/Add_ques/Add_ques");

        return mv;

    }
}
