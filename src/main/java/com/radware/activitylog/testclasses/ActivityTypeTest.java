package com.radware.activitylog.testclasses;

public class ActivityTypeTest {
    private String activityType;
    private Double activityTypePercent;

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public Double getActivityTypePercent() {
        return activityTypePercent;
    }

    public void setActivityTypePercent(Double activityTypePercent) {
        this.activityTypePercent = activityTypePercent;
    }

    public ActivityTypeTest(String activityType, double activityTypePercent) {
        this.activityType = activityType;
        this.activityTypePercent = activityTypePercent;
    }

    public ActivityTypeTest() {
    }

    @Override
    public String toString() {
        return "Activity type = '" + activityType +
                "', Percent = " + activityTypePercent + "%  |\n";
    }
}
