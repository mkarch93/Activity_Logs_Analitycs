package com.radware.activitylog.entity;

import java.util.ArrayList;

public class Status {

    private String st_name;
    private double st_count;
    private ArrayList<ActivityType> at_list;
    private double st_percent;

    public ArrayList<ActivityType> getAt_list() {
        return at_list;
    }

    public void setAt_list(ArrayList<ActivityType> at_list) {
        this.at_list = at_list;
    }

    public Status(){}

    public Status(String st_name, double st_count, ArrayList<ActivityType> at_list) {
        this.st_name = st_name;
        this.st_count = st_count;
        this.at_list = at_list;
    }

    public String getSt_name() {
        return st_name;
    }

    public void setSt_name(String st_name) {
        this.st_name = st_name;
    }

    public double getSt_count() {
        return st_count;
    }

    public void setSt_count(double st_count) {
        this.st_count = st_count;
    }

    public double getSt_percent() {
        return st_percent;
    }

    public void setSt_percent(double st_percent) {
        this.st_percent = st_percent;
    }

    @Override
    public String toString() {
        return "Status{" +
                "st_name='" + st_name + '\'' +
                ", st_count=" + st_count +
                ", at_list=" + at_list +
                ", st_percent=" + st_percent +
                '}';
    }
}


