package com.example.mysrmapp;

import java.util.List;

public class tteDutyDetail {
    String train_no;
    String dest_stn;
    String src_stn;
    String train_name;
    List<String> coach;

    public tteDutyDetail()
    {}

    public tteDutyDetail(String train_no, String dest_stn, String src_stn, String train_name, List<String> coach) {
        this.train_no = train_no;
        this.dest_stn = dest_stn;
        this.src_stn = src_stn;
        this.train_name = train_name;
        this.coach = coach;
    }

    public String getTrain_no() {
        return train_no;
    }

    public void setTrain_no(String train_no) {
        this.train_no = train_no;
    }

    public String getDest_stn() {
        return dest_stn;
    }

    public void setDest_stn(String dest_stn) {
        this.dest_stn = dest_stn;
    }

    public String getSrc_stn() {
        return src_stn;
    }

    public void setSrc_stn(String src_stn) {
        this.src_stn = src_stn;
    }

    public String getTrain_name() {
        return train_name;
    }

    public void setTrain_name(String train_name) {
        this.train_name = train_name;
    }

    public List<String> getCoach() {
        return coach;
    }

    public void setCoach(List<String> coach) {
        this.coach = coach;
    }
}
