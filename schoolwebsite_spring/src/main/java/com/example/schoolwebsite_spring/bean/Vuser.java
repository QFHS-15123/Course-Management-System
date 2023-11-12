package com.example.schoolwebsite_spring.bean;

public class Vuser {
    private String account;
    private String password;
    private String state;
    private String name;

    public Vuser(String account, String password, String state, String name){
        this.account = account;
        this.password = password;
        this.state = state;
        this.name = name;
    }

    public Vuser(){}

    public String getAccount(){ return account; }
    public String getPassword(){ return password; }
    public String getState(){ return state; }
    public String getName(){ return name; }

    public void setAccount( String account ){ this.account = account; }
    public void setPassword( String password ){ this.password = password; }
    public void setState( String state ){ this.state = state; }
    public void setName( String name ){ this.name = name; }

    @Override
    public String toString(){
        return "Tea_cour{" +
                "account=" + account +
                ",password=" + password +
                ",state=" + state +
                ",name=" + name +
                "}";
    }
}
