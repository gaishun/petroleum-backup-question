package com.bysj.DAO;

import com.bysj.Entity.Judge;
import com.bysj.Entity.Simple;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JudgeImp {
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    }


    /**
     * 增加一个新的判断题
     * @param jtemp
     * @param course_id
     * @param ques
     */
    public int  add_question(JdbcTemplate jtemp,int course_id,String ques ,String ans){
        String sql = "insert into jud_ques (course_id,ques,ans) values (?,?,?)";
        return jtemp.update(sql,course_id,ques,ans);
    }

    /**
     *
     * @param jtemp
     * @param ques_id
     * @return
     */
    public List<Judge> query_question_id (JdbcTemplate jtemp, int ques_id){
        String sql = " SELECT ques_id,ques,ans from jud_ques where ques_id = ?";
        return jtemp.query(sql, new RowMapper<Judge>() {
            @Override
            public Judge mapRow(ResultSet rs, int rownum) throws SQLException {
                Judge jud  = new Judge();
                jud.setQues_id(rs.getInt(1));
                jud.setQues(rs.getString(2));
                jud.setAns(rs.getString(3));
                return jud;
            }
        }, ques_id);
    }

    /**
     * 根据ques——id删除一个问题
     * @param jtemp
     * @param ques_id
     * @return
     */
    public int del_question(JdbcTemplate jtemp,int ques_id){
        String sql = "delete from jud_ques where ques_id = ?";
        return jtemp.update(sql,ques_id);
    }

    /**
     * 根据ques_id修改一个问题
     * @param jtemp
     * @param ques
     * @param ques_id
     * @return
     */
    public int update_question(JdbcTemplate jtemp,String ques,String ans ,int ques_id){
        String sql = "update jud_ques set ques = ? , ans = ? where ques_id = ?";
        return jtemp.update(sql,ques,ques_id);
    }
    /**
     * 根据课程号和题目编号查询是否有结果，有结果的话证明操作合法，否则不予操作
     * @param jtemp
     * @param cour_id
     * @param ques_id
     * @return
     */
    public List< Judge> query_question_ques_id (JdbcTemplate jtemp, int cour_id, int ques_id){
        String sql = " select ques_id from  jud_ques where course_id = ? and ques_id = ?";
        return jtemp.query(sql, new RowMapper< Judge>() {
            @Override
            public  Judge mapRow(ResultSet rs, int rownum) throws SQLException {
                 Judge jud  = new  Judge();
                jud.setQues_id(rs.getInt(1));
                return jud;
            }
        }, cour_id,ques_id);
    }

    /**
     * 根据课程的ID查找该课程的判断题
     * @param jtemp
     * @param cour_id
     * @return
     */
    public List<Judge> query_question (JdbcTemplate jtemp, int cour_id){
        String sql = " SELECT ques_id,ques,ans from jud_ques where course_id = ?";
        return jtemp.query(sql, new RowMapper<Judge>() {
            @Override
            public Judge mapRow(ResultSet rs, int rownum) throws SQLException {
                Judge jud  = new Judge();
                jud.setQues_id(rs.getInt(1));
                jud.setQues(rs.getString(2));
                jud.setAns(rs.getString(3));
                return jud;
            }
        }, cour_id);
    }
}
