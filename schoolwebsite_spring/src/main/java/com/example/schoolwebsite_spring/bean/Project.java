package com.example.schoolwebsite_spring.bean;

public class Project {
    private String proj_id;
    private String tea_id;
    private String proj_name;
    private String proj_intro;
    private String cour_id;
    private String proj_uptime;
    private String proj_ddl;

    public Project(String proj_id, String tea_id, String proj_name, 
                   String proj_intro, String cour_id, String proj_uptime, String proj_ddl){
        this.proj_id = proj_id;
        this.tea_id = tea_id;
        this.proj_name = proj_name;
        this.proj_intro = proj_intro;
        this.cour_id = cour_id;
        this.proj_uptime = proj_uptime;
        this.proj_ddl = proj_ddl;
    }

    public Project(){}

    public String getProj_id(){ return proj_id; }
    public String getTea_id(){ return tea_id; }
    public String getProj_name(){ return proj_name; }
    public String getProj_intro(){ return proj_intro; }
    public String getCour_id(){ return cour_id; }
    public String getProj_uptime(){ return proj_uptime; }
    public String getProj_ddl(){ return proj_ddl; }

    public void setProj_id( String proj_id ){ this.proj_id = proj_id; }
    public void setTea_id( String tea_id ){ this.tea_id = tea_id; }
    public void setProj_name( String proj_name ){ this.proj_name = proj_name; }
    public void setProj_intro( String proj_intro ){ this.proj_intro = proj_intro; }
    public void setCour_id( String cour_id ){ this.cour_id = cour_id; }
    public void setProj_uptime( String proj_uptime ){ this.proj_uptime = proj_uptime; }
    public void setProj_ddl( String proj_ddl ){ this.proj_ddl = proj_ddl; }

    @Override
    public String toString(){
        return "Project{" +
                "proj_id=" + proj_id +
                ",proj_name=" + proj_name +
                ",proj_intro=" + proj_intro +
                ",tea_id=" + tea_id +
                ",cour_id=" + cour_id +
                ",proj_uptime=" + proj_uptime +
                ",proj_ddl=" + proj_ddl +
                "}";
    }
}
