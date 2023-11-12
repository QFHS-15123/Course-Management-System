package com.example.schoolwebsite_spring.bean;

public class Course {
    private String cour_id;
    private String cour_name;
    private int cour_credit;
    private String cour_intro;

    public Course(String cour_id, String cour_name, int cour_credit, String cour_intro){
        this.cour_id = cour_id;
        this.cour_name = cour_name;
        this.cour_credit = cour_credit;
        this.cour_intro = cour_intro;
    }

    public Course(){}

    public String getCour_id(){ return cour_id; }
    public String getCour_name(){ return cour_name; }
    public int getCour_credit(){ return cour_credit; }
    public String getCour_intro(){ return cour_intro; }

    public void setCour_id( String cour_id ){ this.cour_id = cour_id; }
    public void setCour_name( String cour_name ){ this.cour_name = cour_name; }
    public void setCour_credit( int cour_credit ){ this.cour_credit = cour_credit; }
    public void setCour_intro( String cour_intro ){ this.cour_intro = cour_intro; }

    @Override
    public String toString(){
        return "Course{" +
                "cour_id=" + cour_id +
                ",cour_name=" + cour_name +
                ",cour_credit=" + cour_credit +
                ",cour_intro=" + cour_intro +
                "}";
    }
}
