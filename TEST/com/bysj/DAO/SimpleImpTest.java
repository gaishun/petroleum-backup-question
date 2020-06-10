package com.bysj.DAO;

import com.bysj.Entity.Question;
import com.bysj.Entity.Select;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.chrono.JapaneseDate;
import java.util.Date;
import java.util.List;

class SimpleImpTest {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
    private  JdbcTemplate jtemp = ac.getBean(JdbcTemplate.class);
    @org.junit.jupiter.api.Test
    void add_question() {
        Select sel = ac.getBean(Select.class);
        sel.setAns1("0");
        sel.setAns2("0");
        sel.setAns3("0");
        sel.setAns4("0");
        sel.setQues("asdf");

        Question question = sel;
        System.out.println(((Select) question).getAns1()+((Select) question).getAns2()+question.getQues());
    }

    @Test
    void insert_test (){
        SimpleImp sim = ac.getBean(SimpleImp.class);
        JdbcTemplate jtemp = ac.getBean(JdbcTemplate.class);
        sim.add_question(jtemp, 0, "1+2=?", "3");
        System.out.println("succes");
    }

    @Test
    void query_course (){
        String str = "<div class=\"shadow graybgcolor\" style=\"border: 1px solid #004466;border-radius: 2%;;width: 90%;margin: 0 auto; margin-top: 20px; font-size: 1rem;\">\n" +
                "\n" +
                "            <!-- 先给题目的编号 -->\n" +
                "            <div style=\"width: 100%; \">\n" +
                "                <p class=\"ans\">&nbsp Ques_id: &nbsp &nbsp ${ques.ques_id}</p>\n" +
                "            </div>\n" +
                "            <hr class=\"line-ans\" />\n" +
                "\n" +
                "            <!-- 先写题干 -->\n" +
                "            <div style=\"width: 100%; \">\n" +
                "                <p class=\"ans\">&nbsp Ques: &nbsp &nbsp\n" +
                "                        ${ques.ques}</p>\n" +
                "            </div>\n" +
                "            <hr class=\"line-ans\" />\n" +
                "\n" +
                "            <!-- 一个答案 -->\n" +
                "            <div style=\"width: 100%; \">\n" +
                "                <p class=\"ans\">&nbsp Ans: &nbsp &nbsp ${ques.ans}</p>\n" +
                "            </div>\n" +
                "\n" +
                "        </div>";
        System.out.println(str);
    }



}