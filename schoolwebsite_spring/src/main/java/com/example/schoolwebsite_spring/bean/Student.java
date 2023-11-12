package com.example.schoolwebsite_spring.bean;

//import jdk.jfr.DataAmount;

public class Student {
    private String stu_id;
    private String stu_name;
    private String stu_sex;
    private String stu_pw;

    public Student(String stu_id, String stu_name, String stu_sex, String stu_pw){
        this.stu_id = stu_id;
        this.stu_name = stu_name;
        this.stu_sex = stu_sex;
        this.stu_pw = stu_pw;
    }

    public Student(){}

    public String getStu_id(){ return stu_id; }
    public String getStu_name(){ return stu_name; }
    public String getStu_sex(){ return stu_sex; }
    public String getStu_pw(){ return stu_pw; }

    public void setStu_id( String stu_id ){ this.stu_id = stu_id; }
    public void setStu_name( String stu_name ){ this.stu_name = stu_name; }
    public void setStu_sex( String stu_sex ){ this.stu_sex = stu_sex; }
    public void setStu_pw( String stu_pw ){ this.stu_pw = stu_pw; }

    @Override
    public String toString(){
        return "Student{" +
                "stu_id=" + stu_id +
                ",stu_name=" + stu_name +
                ",stu_sex=" + stu_sex +
                ",stu_pw=" + stu_pw +
                "}";
    }
}
