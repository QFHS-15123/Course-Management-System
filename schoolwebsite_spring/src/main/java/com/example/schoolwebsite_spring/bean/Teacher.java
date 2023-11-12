package com.example.schoolwebsite_spring.bean;

public class Teacher {
    private String tea_id;
    private String tea_name;
    private String tea_pw;

    public Teacher(String tea_id, String tea_name, String tea_pw){
        this.tea_id = tea_id;
        this.tea_name = tea_name;
        this.tea_pw = tea_pw;
    }

    public Teacher(){}

    public String getTea_id(){ return tea_id; }
    public String getTea_name(){ return tea_name; }
    public String getTea_pw(){ return tea_pw; }

    public void setTea_id( String tea_id ){ this.tea_id = tea_id; }
    public void setTea_name( String tea_name ){ this.tea_name = tea_name; }
    public void setTea_pw( String tea_pw ){ this.tea_pw = tea_pw; }

    @Override
    public String toString(){
        return "Teacher{" +
                "tea_id=" + tea_id +
                ",tea_name=" + tea_name +
                ",tea_pw=" + tea_pw +
                "}";
    }
}
