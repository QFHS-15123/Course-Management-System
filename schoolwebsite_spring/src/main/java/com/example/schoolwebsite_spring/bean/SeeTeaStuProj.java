package com.example.schoolwebsite_spring.bean;

public class SeeTeaStuProj {
    private String stu_id;
    private String stu_name;
    private String proj_stat;
    private String proj_subtime;

    public SeeTeaStuProj(String stu_id, String stu_name, String proj_stat, String proj_subtime){
        this.stu_id = stu_id;
        this.stu_name = stu_name;
        this.proj_stat = proj_stat;
        this.proj_subtime = proj_subtime;
    }

    public SeeTeaStuProj(){}

    public String getStu_id(){ return stu_id; }
    public String getStu_name(){ return stu_name; }
    public String getProj_stat(){ return proj_stat; }
    public String getProj_subtime(){ return proj_subtime; }

    public void setStu_id( String stu_id ){ this.stu_id = stu_id; }
    public void setStu_name( String stu_name ){ this.stu_name = stu_name; }
    public void setProj_stat( String proj_stat ){ this.proj_stat = proj_stat; }
    public void setProj_subtime( String proj_subtime ){ this.proj_subtime = proj_subtime; }

    @Override
    public String toString(){
        return "SeeTeaStuProj{" +
                "stu_id=" + stu_id +
                ",stu_name=" + stu_name +
                ",proj_stat=" + proj_stat +
                ",proj_subtime=" + proj_subtime +
                "}";
    }
}
