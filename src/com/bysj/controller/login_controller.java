package com.bysj.controller;


import com.bysj.DAO.Other_DAO;
import com.bysj.Entity.Select;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Login")
public class login_controller {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
    private JdbcTemplate jtemp = ac.getBean(JdbcTemplate.class);
    private ModelAndView mv ;



    @RequestMapping("/logincheck")
    @ResponseBody
    public List<Select> logincheck (int username,String password){
        List<Select> sel = new ArrayList<>();
        sel.add(new Select());
        String temp = new Other_DAO().get_password(jtemp,username).get(0);
        System.out.println(temp);
        if(temp.equals(password)){
            return sel;
        }
        else{
            return null;
        }
    }

    @RequestMapping("/login")
    public String login (){
        return "Login";
    }

    @RequestMapping("/loginjump")
    public String logincheck (Model model, int username){
        model.addAttribute("user_id",username);
        return "Guide";
    }
}
