package com.bysj.Entity;

public class Course {
    @Override
    public String toString() {
        return "Course{" +
                "cour_id=" + cour_id +
                ", cour_name='" + cour_name + '\'' +
                ", tea_id=" + tea_id +
                '}';
    }

    private int cour_id;
    private String cour_name;



    private int tea_id;

    public int getCour_id() {
        return cour_id;
    }

    public void setCour_id(int cour_id) {
        this.cour_id = cour_id;
    }

    public String getCour_name() {
        return cour_name;
    }

    public void setCour_name(String cour_name) {
        this.cour_name = cour_name;
    }

    public int getTea_id() {
        return tea_id;
    }

    public void setTea_id(int tea_id) {
        this.tea_id = tea_id;
    }



}
