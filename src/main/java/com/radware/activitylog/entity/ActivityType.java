package com.radware.activitylog.entity;

public class ActivityType {

    private String at_name;
    private double at_count;
    private double at_percent;

    public ActivityType(){}

    public ActivityType(String at_name, double at_count) {
        this.at_name = at_name;
        this.at_count = at_count;
    }

    public String getAt_name() {
        return at_name;
    }

    public void setAt_name(String at_name) {
        this.at_name = at_name;
    }

    public double getAt_count() {
        return at_count;
    }

    public void setAt_count(double at_count) {
        this.at_count = at_count;
    }

    public double getAt_percent() {
        return at_percent;
    }

    public void setAt_percent(double at_percent) {
        this.at_percent = at_percent;
    }

    @Override
    public String toString() {
        return "ActivityType{" +
                "at_name='" + at_name + '\'' +
                ", at_count=" + at_count +
                ", at_percent=" + at_percent +
                '}';
    }
}
