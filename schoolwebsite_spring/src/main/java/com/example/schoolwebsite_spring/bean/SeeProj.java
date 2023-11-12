package com.example.schoolwebsite_spring.bean;

public class SeeProj {
    private String proj_name;
    private String proj_subtime;
    private String proj_intro;
    private String proj_uptime;
    private String proj_ddl;
    private String proj_stat;
    private String proj_content;
    private String cour_name;
    private String cour_id;
    private String stu_id;

    public SeeProj(String proj_name, String proj_subtime, String proj_intro, 
                   String proj_uptime, String proj_ddl, String proj_stat, 
                   String proj_content, String cour_name, String cour_id, String stu_id){
        this.proj_name = proj_name;
        this.proj_subtime = proj_subtime;
        this.proj_intro = proj_intro;
        this.proj_ddl = proj_ddl;
        this.proj_stat = proj_stat;
        this.proj_content = proj_content;
        this.proj_uptime = proj_uptime;
        this.cour_name = cour_name;
        this.cour_id = cour_id;
        this.stu_id = stu_id;
    }

    public SeeProj(){}

    public String getProj_name(){ return proj_name; }
    public String getProj_subtime(){ return proj_subtime; }
    public String getProj_intro(){ return proj_intro; }
    public String getProj_stat(){ return proj_stat; }
    public String getProj_uptime(){ return proj_uptime; }
    public String getProj_content(){ return proj_content; }
    public String getProj_ddl(){ return proj_ddl; }
    public String getCour_name(){ return cour_name; }
    public String getCour_id(){ return cour_id; }
    public String getStu_id(){ return stu_id; }

    public void setProj_name( String proj_name ){ this.proj_name = proj_name; }
    public void setProj_subtime( String proj_subtime ){ this.proj_subtime = proj_subtime; }
    public void setProj_intro( String proj_intro ){ this.proj_intro = proj_intro; }
    public void setProj_uptime( String proj_uptime ){ this.proj_uptime = proj_uptime; }
    public void setProj_ddl( String proj_ddl ){ this.proj_ddl = proj_ddl; }
    public void setProj_content( String proj_content ){ this.proj_content = proj_content; }
    public void setProj_stat( String proj_stat ){ this.proj_stat = proj_stat; }
    public void setCour_name( String cour_name ){ this.cour_name = cour_name; }
    public void setCour_id( String cour_id ){ this.cour_id = cour_id; }
    public void setStu_id( String stu_id ){ this.stu_id = stu_id; }

    @Override
    public String toString(){
        return "SeeNews{" +
                "proj_name=" + proj_name +
                ",proj_subtime=" + proj_subtime +
                ",proj_intro=" + proj_intro +
                ",proj_uptime=" + proj_uptime +
                ",proj_stat=" + proj_stat +
                ",proj_content=" + proj_content +
                ",proj_ddl=" + proj_ddl +
                ",cour_name=" + cour_name +
                ",cour_id=" + cour_id +
                ",stu_id=" + stu_id +
                "}";
    }
}
