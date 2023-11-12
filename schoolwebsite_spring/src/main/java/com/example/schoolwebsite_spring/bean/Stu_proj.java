package com.example.schoolwebsite_spring.bean;

public class Stu_proj {
    private String proj_id;
    private String stu_id;
    private String proj_cont;
    private String proj_subtime;
    private String proj_stat;

    public Stu_proj(String proj_id, String stu_id, String proj_cont, String proj_subtime, String proj_stat){
        this.proj_id = proj_id;
        this.stu_id = stu_id;
        this.proj_cont = proj_cont;
        this.proj_subtime = proj_subtime;
        this.proj_stat = proj_stat;
    }

    public Stu_proj(){}

    public String getProj_id(){ return proj_id; }
    public String getStu_id(){ return stu_id; }
    public String getProj_cont(){ return proj_cont; }
    public String getProj_subtime(){ return proj_subtime; }
    public String getProj_stat(){ return proj_stat; }

    public void setProj_id( String proj_id ){ this.proj_id = proj_id; }
    public void setStu_id( String stu_id ){ this.stu_id = stu_id; }
    public void setProj_cont( String proj_cont ){ this.proj_cont = proj_cont; }
    public void setProj_subtime( String proj_subtime ){ this.proj_subtime = proj_subtime; }
    public void setProj_stat( String proj_stat ){ this.proj_stat = proj_stat; }

    @Override
    public String toString(){
        return "Stu_proj{" +
                "proj_id=" + proj_id +
                ",proj_cont=" + proj_cont +
                ",proj_subtime=" + proj_subtime +
                ",stu_id=" + stu_id +
                ",proj_stat=" + proj_stat +
                "}";
    }
}
