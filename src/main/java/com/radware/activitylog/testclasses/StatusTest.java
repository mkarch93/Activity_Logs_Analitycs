package com.radware.activitylog.testclasses;

import java.util.List;

public class StatusTest {
    private String status;
    private Double statusPercents;
    private List<ActivityTypeTest> activityTypesListTest;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getStatusPercents() {
        return statusPercents;
    }

    public void setStatusPercents(Double statusPercents) {
        this.statusPercents = statusPercents;
    }


    public List<ActivityTypeTest> getActivityTypesList() {
        return activityTypesListTest;
    }

    public String getActivityTypesString() {
        String tmp = new String();
        for (ActivityTypeTest activityTypeTest : activityTypesListTest) {
           tmp = tmp.concat(activityTypeTest.toString());
        }
        return tmp;
    }

    public void setActivityTypesList(List<ActivityTypeTest> activityTypesListTest) {
        this.activityTypesListTest = activityTypesListTest;
    }

    public StatusTest(String status, Double statusPercents, List<ActivityTypeTest> activityTypesListTest) {
        this.status = status;
        this.statusPercents = statusPercents;
        this.activityTypesListTest = activityTypesListTest;
    }


    @Override
    public String toString() {
        return "Status{" +
                "status='" + status + '\'' +
                ", statusPercents=" + statusPercents +
                "\n activityTypesList=" + activityTypesListTest +
                '}';
    }
}
