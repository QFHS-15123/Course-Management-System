package com.example.schoolwebsite_spring.bean;

public class SeeTeaProj {
    private String cour_id;
    private String cour_name;
    private String stu_count;
    private String proj_name;

    public SeeTeaProj(String cour_id, String stu_count, String proj_name, String cour_name){
        this.cour_id = cour_id;
        this.cour_name = cour_name;
        this.stu_count = stu_count;
        this.proj_name = proj_name;
    }

    public SeeTeaProj(){}

    public String getCour_id(){ return cour_id; }
    public String getCour_name(){ return cour_name; }
    public String getStu_count(){ return stu_count; }
    public String getProj_name(){ return proj_name; }

    public void setCour_id( String cour_id ){ this.cour_id = cour_id; }
    public void setCour_name( String cour_name ){ this.cour_name = cour_name; }
    public void setStu_count( String stu_count ){ this.stu_count = stu_count; }
    public void setProj_name( String proj_name ){ this.proj_name = proj_name; }

    @Override
    public String toString(){
        return "SeeTeaProj{" +
                "cour_id=" + cour_id +
                "cour_name=" + cour_name +
                ",stu_count=" + stu_count +
                ",proj_name=" + proj_name +
                "}";
    }
}
