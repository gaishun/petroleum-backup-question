package com.bysj.controller;


import com.bysj.DAO.Other_DAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Guide")
public class Guide {
    private ModelAndView mv ;
    private ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
    private JdbcTemplate jtemp = ac.getBean(JdbcTemplate.class);

    @RequestMapping("/init")
    public ModelAndView Guide_init (Model model){
        mv = new ModelAndView("Guide");
        return mv;
    }

    @RequestMapping("/add")
    public ModelAndView add (Model model,int user_id){
        mv = new ModelAndView("Add_ques/Add_ques");
        model.addAttribute("course",new Other_DAO().query_tea_course(jtemp,user_id));
        model.addAttribute("user_id",user_id);
        return mv;
    }

    @RequestMapping("/man")
    public ModelAndView man (Model model,int user_id){
        mv = new ModelAndView("Man_ques/Man_ques_init");
        model.addAttribute("course",new Other_DAO().query_tea_course(jtemp,user_id));
        model.addAttribute("user_id",user_id);
        return mv;
    }
}
