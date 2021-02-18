//package com.radware.demo.models;
//
//import javax.persistence.*;
//import java.util.UUID;
//
//@Entity
//@Table(name = "user_activity_log", schema = "public", catalog = "reporter")
//public class Data {
//
//    private UUID userActivityId;
//    private String status;
//    private String activityType;
//
//    @Id
//    @Column(name = "user_activity_id")
//    public UUID getUserActivityId() {
//        return userActivityId;
//    }
//    public void setUserActivityId(UUID userActivityId) {
//        this.userActivityId = userActivityId;
//    }
//
//
//    @Basic
//    @Column(name = "status")
//    public String getStatus() {
//        return status;
//    }
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    @Column(name = "activity_type")
//    public String getActivityType() {
//        return activityType;
//    }
//    public void setActivityType(String activityType) {
//        this.activityType = activityType;
//    }
//
//    @Override
//    public String toString() {
//        return "Data{" +
//                "userActivityId='" + userActivityId + '\'' +
//                ", status='" + status + '\'' +
//                ", activityType='" + activityType + '\'' +
//                '}';
//    }
//
//    public Data() {
//    }
//}
