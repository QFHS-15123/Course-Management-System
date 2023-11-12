package com.example.schoolwebsite_spring.bean;

public class Tea_stu {
    private String stu_id;
    private String tea_id;
    private String tea_stu_id;

    public Tea_stu(String stu_id, String tea_id, String tea_stu_id){
        this.stu_id = stu_id;
        this.tea_id = tea_id;
        this.tea_stu_id = tea_stu_id;
    }

    public Tea_stu(){}

    public String getStu_id(){ return stu_id; }
    public String getTea_id(){ return tea_id; }
    public String getTea_stu_id(){ return tea_stu_id; }

    public void setStu_id( String stu_id ){ this.stu_id = stu_id; }
    public void setTea_id( String tea_id ){ this.tea_id = tea_id; }
    public void setTea_stu_id( String tea_stu_id ){ this.tea_stu_id = tea_stu_id; }

    @Override
    public String toString(){
        return "Tea_stu{" +
                "stu_id=" + stu_id +
                ",tea_id=" + tea_id +
                ",tea_stu_id=" + tea_stu_id +
                "}";
    }
}
