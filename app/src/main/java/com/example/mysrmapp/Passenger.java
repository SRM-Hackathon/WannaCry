package com.example.mysrmapp;

public class Passenger {
    String id;
    String pnrno;
    String pname;
    public Passenger(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPnrno() {
        return pnrno;
    }

    public void setPnrno(String pnrno) {
        this.pnrno = pnrno;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Passenger(String id, String pnrno, String pname) {
        this.id = id;
        this.pnrno = pnrno;
        this.pname = pname;
    }
}
