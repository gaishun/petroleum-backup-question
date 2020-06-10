package com.bysj.Entity;

public class Question {
    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }


    public int getQues_id() {
        return ques_id;
    }

    public void setQues_id(int ques_id) {
        this.ques_id = ques_id;
    }

    @Override
    public String toString() {
        return "Question{" +
                "ques_id=" + ques_id +
                ", ques='" + ques + '\'' +
                '}';
    }

    int ques_id;
    String ques;
}
