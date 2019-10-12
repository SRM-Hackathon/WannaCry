package com.example.mysrmapp;

public class tteDetails {

    String tte_id;
    String password;
    String username;
    public  tteDetails(){

    }
    public tteDetails(String password,String tte_id,String username){
        this.password=password;
        this.tte_id=tte_id;
        this.username=username;
    }

    public String getTte_id() {
        return tte_id;
    }

    public void setTte_id(String tte_id) {
        this.tte_id = tte_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
