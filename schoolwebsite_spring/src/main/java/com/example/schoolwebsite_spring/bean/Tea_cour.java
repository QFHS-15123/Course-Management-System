package com.example.schoolwebsite_spring.bean;

public class Tea_cour {
    private String tea_id;
    private String tea_cour_id;
    private String cour_id;

    public Tea_cour(String tea_id, String tea_cour_id, String cour_id){
        this.tea_id = tea_id;
        this.tea_cour_id = tea_cour_id;
        this.cour_id = cour_id;
    }

    public Tea_cour(){}

    public String getTea_id(){ return tea_id; }
    public String getTea_cour_id(){ return tea_cour_id; }
    public String getCour_id(){ return cour_id; }

    public void setTea_id( String tea_id ){ this.tea_id = tea_id; }
    public void setTea_cour_id( String tea_cour_id ){ this.tea_cour_id = tea_cour_id; }
    public void setCour_id( String cour_id ){ this.cour_id = cour_id; }

    @Override
    public String toString(){
        return "Tea_cour{" +
                "tea_id=" + tea_id +
                ",tea_cour_id=" + tea_cour_id +
                ",cour_id=" + cour_id +
                "}";
    }
}
