package com.example.schoolwebsite_spring.bean;

public class SeeStuCour {
    private String cour_id;
    private String stu_id;
    private String cour_name;
    private String cour_credit;
    private String cour_intro;
    private String tea_name;

    public SeeStuCour(String cour_id, String cour_name, 
                      String tea_name, String stu_id, String cour_credit, String cour_intro){
        this.cour_id = cour_id;
        this.cour_name = cour_name;
        this.stu_id = stu_id;
        this.cour_credit = cour_credit;
        this.cour_intro = cour_intro;
        this.tea_name = tea_name;
    }

    public SeeStuCour(){}

    public String getCour_id(){ return cour_id; }
    public String getCour_name(){ return cour_name; }
    public String getStu_id(){ return stu_id; }
    public String getCour_credit(){ return cour_credit; }
    public String getCour_intro(){ return cour_intro; }
    public String gettea_name(){ return tea_name; }

    public void setCour_id( String cour_id ){ this.cour_id = cour_id; }
    public void setCour_name( String cour_name ){ this.cour_name = cour_name; }
    public void setStu_id( String stu_id ){ this.stu_id = stu_id; }
    public void setCour_credit( String cour_credit ){ this.cour_credit = cour_credit; }
    public void setCour_intro( String cour_intro ){ this.cour_intro = cour_intro; }
    public void settea_name( String tea_name ){ this.tea_name = tea_name; }

    @Override
    public String toString(){
        return "SeeStuCour{" +
                "cour_id=" + cour_id +
                ",cour_name=" + cour_name +
                ",stu_id=" + stu_id +
                ",cour_credit=" + cour_credit +
                ",cour_intro=" + cour_intro +
                ",tea_name=" + tea_name +
                "}";
    }
}
