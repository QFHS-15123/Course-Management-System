package com.example.schoolwebsite_spring.bean;

public class SeeTeaCour {
    private String cour_id;
    private String cour_name;
    private String tea_id;

    public SeeTeaCour(String cour_id, String cour_name, String tea_id){
        this.cour_id = cour_id;
        this.cour_name = cour_name;
        this.tea_id = tea_id;
    }

    public SeeTeaCour(){}

    public String getCour_id(){ return cour_id; }
    public String getCour_name(){ return cour_name; }
    public String gettea_id(){ return tea_id; }

    public void setCour_id( String cour_id ){ this.cour_id = cour_id; }
    public void setCour_name( String cour_name ){ this.cour_name = cour_name; }
    public void settea_id( String tea_id ){ this.tea_id = tea_id; }

    @Override
    public String toString(){
        return "SeeTeaCour{" +
                "cour_id=" + cour_id +
                ",cour_name=" + cour_name +
                ",tea_id=" + tea_id +
                "}";
    }
}
