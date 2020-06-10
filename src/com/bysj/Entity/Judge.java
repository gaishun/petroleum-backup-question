package com.bysj.Entity;

public class Judge extends Question {
    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    String ans;
    public Judge(){};

    @Override
    public String toString() {
        return "Judge{" +
                "ans='" + ans + '\'' +
                ", ques_id=" + ques_id +
                ", ques='" + ques + '\'' +
                '}';
    }

    public Judge (String s1, String s2){
        ques = s1;
        ans = s2;
    }
}
