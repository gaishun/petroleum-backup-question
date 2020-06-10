package com.bysj.DAO;

import com.bysj.Entity.Select;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SelectImp {
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    }

    /**
     * 增加一个新的
     * @param jtemp
     * @param course_id
     * @param ques
     * @param ans1
     * @param ans2
     * @param ans3
     * @param ans4
     * @return
     */
    public int  add_question(JdbcTemplate jtemp,int course_id,String ques, String ans1,String ans2,String ans3,String ans4 ){
        String sql = "insert into select_ques (course_id,ques,ans1,ans2,ans3,ans4) values (?,?,?,?,?,?)";
        return jtemp.update(sql,course_id,ques,ans1,ans2,ans3,ans4);
    }

    /**
     * 根据ques——id删除一个问题
     * @param jtemp
     * @param ques_id
     * @return
     */
    public int del_question(JdbcTemplate jtemp,int ques_id){
        String sql = "delete from select_ques where ques_id = ?";
        return jtemp.update(sql,ques_id);
    }

    /**
     * 根据ques_id修改一个问题
     * @param jtemp
     * @param ques
     * @param ans1
     * @param ans2
     * @param ans3
     * @param ans4
     * @param ques_id
     * @return
     */
    public int update_question(JdbcTemplate jtemp,String ques,String ans1,String ans2,String ans3,String ans4 ,int ques_id){
        String sql = "update select_ques set ques = ? , ans1 = ? , ans2 = ? , ans3 = ? , ans4 = ? where ques_id = ?";
        return jtemp.update(sql,ques,ans1,ans2,ans3,ans4,ques_id);
    }


    /**
     * 根据课程的ID查找该课程的选择题
     * @param jtemp
     * @param cour_id
     * @return
     */
    public List<Select> query_question (JdbcTemplate jtemp, int cour_id){
        String sql = "select ques_id,ques,ans1,ans2,ans3,ans4 from select_ques where course_id = ?";
        return jtemp.query(sql, new RowMapper<Select>() {
            @Override
            public Select mapRow(ResultSet rs, int rownum) throws SQLException {
                Select sel  = new Select();
                sel.setQues_id(rs.getInt(1));
                sel.setQues(rs.getString(2));
                sel.setAns1(rs.getString(3));
                sel.setAns2(rs.getString(4));
                sel.setAns3(rs.getString(5));
                sel.setAns4(rs.getString(6));
                return sel;
            }
        }, cour_id);
    }

    /**
     *
     * @param jtemp
     * @param ques_id
     * @return
     */
    public List<Select> query_question_id (JdbcTemplate jtemp, int ques_id){
        String sql = "select ques_id,ques,ans1,ans2,ans3,ans4 from select_ques where ques_id = ?";
        return jtemp.query(sql, new RowMapper<Select>() {
            @Override
            public Select mapRow(ResultSet rs, int rownum) throws SQLException {
                Select sel  = new Select();
                sel.setQues_id(rs.getInt(1));
                sel.setQues(rs.getString(2));
                sel.setAns1(rs.getString(3));
                sel.setAns2(rs.getString(4));
                sel.setAns3(rs.getString(5));
                sel.setAns4(rs.getString(6));
                return sel;
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
    public List<Select> query_question_ques_id (JdbcTemplate jtemp, int cour_id, int ques_id){
        String sql = "select ques_id from select_ques where course_id = ? and ques_id = ?";
        return jtemp.query(sql, new RowMapper<Select>() {
            @Override
            public Select mapRow(ResultSet rs, int rownum) throws SQLException {
                Select sel  = new Select();
                sel.setQues_id(rs.getInt(1));
                return sel;
            }
        }, cour_id,ques_id);
    }
}
