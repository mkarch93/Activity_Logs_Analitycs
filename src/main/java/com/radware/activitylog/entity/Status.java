package com.radware.activitylog.entity;

import java.util.ArrayList;

public class Status {

    private String stName;
    private double stCount;
    private ArrayList<ActivityType> atList;
    private double stPercent;

    public ArrayList<ActivityType> getAtList() {
        return atList;
    }

    public void setAtList(ArrayList<ActivityType> atList) {
        this.atList = atList;
    }

    public Status(){}

    public Status(String stName, double stCount, ArrayList<ActivityType> atList) {
        this.stName = stName;
        this.stCount = stCount;
        this.atList = atList;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public double getStCount() {
        return stCount;
    }

    public void setStCount(double stCount) {
        this.stCount = stCount;
    }

    public double getStPercent() {
        return stPercent;
    }

    public void setStPercent(double stPercent) {
        this.stPercent = stPercent;
    }

    @Override
    public String toString() {
        return "Status{" +
                "st_name='" + stName + '\'' +
                ", st_count=" + stCount +
                ", at_list=" + atList +
                ", st_percent=" + stPercent +
                '}';
    }
}


