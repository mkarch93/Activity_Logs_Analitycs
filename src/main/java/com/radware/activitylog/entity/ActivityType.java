package com.radware.activitylog.entity;

public class ActivityType {

    private String atName;
    private double atCount;
    private double atPercent;

    public ActivityType(){}

    public ActivityType(String atName, double atCount) {
        this.atName = atName;
        this.atCount = atCount;
    }

    public String getAtName() {
        return atName;
    }

    public void setAtName(String atName) {
        this.atName = atName;
    }

    public double getAtCount() {
        return atCount;
    }

    public void setAtCount(double atCount) {
        this.atCount = atCount;
    }

    public double getAtPercent() {
        return atPercent;
    }

    public void setAtPercent(double atPercent) {
        this.atPercent = atPercent;
    }

    @Override
    public String toString() {
        return "ActivityType{" +
                "at_name='" + atName + '\'' +
                ", at_count=" + atCount +
                ", at_percent=" + atPercent +
                '}';
    }
}
