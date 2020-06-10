package com.bysj.DAO;

import com.bysj.Entity.Simple;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Queue;


/**
 * 对sim_ques表的内容进行增删改查
 */
public class SimpleImp {


    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    }

    /**
     * 增加一个新的填空题
     * @param jtemp
     * @param course_id
     * @param ques
     * @param ans
     */
    public int  add_question(JdbcTemplate jtemp,int course_id,String ques, String ans ){
        String sql = "insert into sim_ques (course_id,ques,ans) values (?,?,?)";
        return jtemp.update(sql,course_id,ques,ans);
    }

    /**
     * 根据ques——id删除一个问题
     * @param jtemp
     * @param ques_id
     * @return
     */
    public int del_question(JdbcTemplate jtemp,int ques_id){
        String sql = "delete from sim_ques where ques_id = ?";
        return jtemp.update(sql,ques_id);
    }

    /**
     * 根据ques_id修改一个问题
     * @param jtemp
     * @param ques
     * @param ans
     * @param ques_id
     * @return
     */
    public int update_question(JdbcTemplate jtemp,String ques, String ans,int ques_id){
        String sql = "update sim_ques set ques = ? , ans = ? where ques_id = ?";
        return jtemp.update(sql,ques,ans,ques_id);
    }


    /**
     * 根据课程的ID查找该课程的简答题
     * @param jtemp
     * @param cour_id
     * @return
     */
    public List<Simple> query_question (JdbcTemplate jtemp,int cour_id){
        String sql = "select ques_id,ques,ans from sim_ques where course_id = ?";
        return jtemp.query(sql, new RowMapper<Simple>() {
            @Override
            public Simple mapRow(ResultSet rs, int rownum) throws SQLException {
                Simple sim  = new Simple();
                sim.setQues_id(rs.getInt(1));
                sim.setQues(rs.getString(2));
                sim.setAns(rs.getString(3));
                return sim;
            }
        }, cour_id);
    }

    /**
     *
     * @param jtemp
     * @param ques_id
     * @return
     */
    public List<Simple> query_question_id (JdbcTemplate jtemp,int ques_id){
        String sql = "select ques_id,ques,ans from sim_ques where ques_id = ?";
        return jtemp.query(sql, new RowMapper<Simple>() {
            @Override
            public Simple mapRow(ResultSet rs, int rownum) throws SQLException {
                Simple sim  = new Simple();
                sim.setQues_id(rs.getInt(1));
                sim.setQues(rs.getString(2));
                sim.setAns(rs.getString(3));
                return sim;
            }
        }, ques_id);
    }

    /**
     * 根据课程号和题目编号查询是否有结果，有结果的话证明操作合法，否则不予操作
     * @param jtemp
     * @param cour_id
     * @param ques_id
     * @return
     */
    public List< Simple> query_question_ques_id (JdbcTemplate jtemp, int cour_id, int ques_id){
        String sql = " select ques_id from  sim_ques where course_id = ? and ques_id = ?";
        return jtemp.query(sql, new RowMapper< Simple>() {
            @Override
            public  Simple mapRow(ResultSet rs, int rownum) throws SQLException {
                Simple jud  = new  Simple();
                jud.setQues_id(rs.getInt(1));
                return jud;
            }
        }, cour_id,ques_id);
    }

}
