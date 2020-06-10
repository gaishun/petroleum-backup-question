package com.bysj.Entity;

public class Simple extends Question  {
    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    @Override
    public String toString() {
        return "Simple{" +
                "ans='" + ans + '\'' +
                ", ques_id=" + ques_id +
                ", ques='" + ques + '\'' +
                '}';
    }

    String ans;
    public Simple(){};
    public Simple (String s1,String s2){
        ques = s1;
        ans = s2;
    }
}
