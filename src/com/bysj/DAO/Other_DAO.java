package com.bysj.DAO;

import com.bysj.Entity.Course;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Other_DAO {

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    }


    /**
     * 根据老师的id来获取老师当前有做过哪些课的题库
     * @param jtemp
     * @param tea_id
     * @return
     */
    public List<Course> query_tea_course (JdbcTemplate jtemp, int tea_id){
        String sql ="select cour_id,cour_name FROM Course where Course.tea_id=?";
        return jtemp.query(sql, new RowMapper<Course >() {
            @Override
            public Course mapRow(ResultSet rs, int i) throws SQLException {
                Course c = new Course();
                c.setCour_id(rs.getInt(1));
                c.setCour_name(rs.getString(2));
                return c;
            }
        }, tea_id);
    }

    /**
     * 添加一门课程，需要老师的id来添加
     * @param jtemp
     * @param tea_id
     * @param Course_name
     * @return
     */
    public int add_course (JdbcTemplate jtemp,int tea_id,String Course_name){
        String sql ="insert into Course (tea_id , cour_name) values (?,?)";
        return jtemp.update(sql,tea_id,Course_name);
    }


    /**
     * 根据tea_id 返回 查询到的密码，控制器再根据密码判断是否合法
     * @param jtemp
     * @param tea_id
     * @return
     */
    public List<String> get_password (JdbcTemplate jtemp, int tea_id){
        String sql = "select password from teacher_id where tea_id = ?";
        return jtemp.query(sql,new RowMapper<String >(){
            @Override
            public String mapRow(ResultSet rs,int i)throws SQLException{
                return rs.getString(1);
            }
        },tea_id);
    }

    /**
     * 根据选择的课程，可以删除该课程，同时触发器级联删除该课程对应的表中的各种问题。
     * @param Jtemp
     * @param Cour_id
     * @return
     */
    public int del_Course (JdbcTemplate Jtemp , int Cour_id){
        String sql = "delete from Course where cour_id = ?";
        return Jtemp.update(sql,Cour_id);
    }


    /**
     * 用来做注册用的一个方法
     * @param jtemp
     * @param nick_name
     * @param password
     * @return
     */
    public int add_tea (JdbcTemplate jtemp, String nick_name,String password){
        String sql = "insert into teacher_id (tea_name , password) values(?,?)";
        return jtemp.update(sql,nick_name,password);
    }


}
