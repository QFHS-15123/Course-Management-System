package com.example.schoolwebsite_spring.bean;

public class SeeNews {
    private String news_name;
    private String news_info;
    private String news_uptime;
    private String tea_name;
    private String tea_id;
    private String cour_name;
    private String cour_id;

    public SeeNews(String news_name, String tea_name, String tea_id,
                   String news_info, String news_uptime, String cour_name, String cour_id){
        this.news_name = news_name;
        this.tea_name = tea_name;
        this.tea_id = tea_id;
        this.news_info = news_info;
        this.news_uptime = news_uptime;
        this.cour_name = cour_name;
        this.cour_id = cour_id;
    }

    public SeeNews(){}

    public String getNews_name(){ return news_name; }
    public String getTea_name(){ return tea_name; }
    public String getTea_id(){ return tea_id; }
    public String getNews_info(){ return news_info; }
    public String getNews_uptime(){ return news_uptime; }
    public String getCour_name(){ return cour_name; }
    public String getCour_id(){ return cour_id; }

    public void setNews_name( String news_name ){ this.news_name = news_name; }
    public void setTea_name( String tea_name ){ this.tea_name = tea_name; }
    public void setTea_id( String tea_id ){ this.tea_id = tea_id; }
    public void setNews_info( String news_info ){ this.news_info = news_info; }
    public void setNews_uptime( String news_uptime ){ this.news_uptime = news_uptime; }
    public void setCour_name( String cour_name ){ this.cour_name = cour_name; }
    public void setCour_id( String cour_id ){ this.cour_id = cour_id; }

    @Override
    public String toString(){
        return "SeeNews{" +
                "news_name=" + news_name +
                ",tea_name=" + tea_name +
                ",tea_id=" + tea_id +
                ",news_info=" + news_info +
                ",news_uptime=" + news_uptime +
                ",cour_name=" + cour_name +
                ",cour_name=" + cour_name +
                "}";
    }
}
