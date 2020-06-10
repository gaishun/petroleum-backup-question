package com.bysj.Entity;

public class Select extends Question  {
    String ans1;

    @Override
    public String toString() {
        return "Select{" +
                "ans1='" + ans1 + '\'' +
                ", ans2='" + ans2 + '\'' +
                ", ans3='" + ans3 + '\'' +
                ", ans4='" + ans4 + '\'' +
                ", ques_id=" + ques_id +
                ", ques='" + ques + '\'' +
                '}';
    }

    String ans2;

    public String getAns1() {
        return ans1;
    }

    public void setAns1(String ans1) {
        this.ans1 = ans1;
    }

    public String getAns2() {
        return ans2;
    }

    public void setAns2(String ans2) {
        this.ans2 = ans2;
    }

    public String getAns3() {
        return ans3;
    }

    public void setAns3(String ans3) {
        this.ans3 = ans3;
    }

    public String getAns4() {
        return ans4;
    }

    public void setAns4(String ans4) {
        this.ans4 = ans4;
    }

    String ans3;
    String ans4;

    public Select(){};

    public Select (String s1,String s2,String s3,String s4,String s5){
        ques = s1;
        ans1 = s2;
        ans2 = s3;
        ans3 = s4;
        ans4 = s5;
    }
}
