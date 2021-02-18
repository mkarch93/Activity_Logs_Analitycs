package com.radware.activitylog.entity;

public class DataPrepared {

    private String status;
    private String activityType;
    private long count;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }


    public DataPrepared() {
    }

    public DataPrepared(String status, String activityType, long count) {
        this.setStatus(status);
        this.setActivityType(activityType);
        this.setCount(count);
    }

    @Override
    public String toString() {
        return "DataPrepared{" +
                "status='" + status + '\'' +
                ", activityType='" + activityType + '\'' +
                ", count=" + count +
                '}';
    }
}
