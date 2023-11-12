package com.example.schoolwebsite_spring.bean;

public class Stu_cour {
    private String stu_id;
    private String cour_id;
    private String stu_cour_id;

    public Stu_cour(String stu_id, String cour_id, String stu_cour_id){
        this.stu_id = stu_id;
        this.cour_id = cour_id;
    }

    public Stu_cour(){}

    public String getStu_id(){ return stu_id; }
    public String getCour_id(){ return cour_id; }

    public void setStu_id( String stu_id ){ this.stu_id = stu_id; }
    public void setCour_id( String cour_id ){ this.cour_id = cour_id; }

    @Override
    public String toString(){
        return "Stu_cour{" +
                ",stu_id=" + stu_id +
                ",cour_id=" + cour_id +
                "}";
    }
}
