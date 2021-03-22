package com.radware.activitylog.entity;

import java.time.LocalDateTime;
import java.util.List;

public class Input {

    private List<String> activityTypes;
    private List<String> statuses;
    private LocalDateTime startDateTime;
    private LocalDateTime finishDateTime;

    public Input(List<String> activityTypes, List<String> statuses, LocalDateTime startDateTime, LocalDateTime finishDateTime) {
        this.activityTypes = activityTypes;
        this.statuses = statuses;
        this.startDateTime = startDateTime;
        this.finishDateTime = finishDateTime;
    }

    public List<String> getActivityTypes() {
        return activityTypes;
    }

    public void setActivityTypes(List<String> activityTypes) {
        this.activityTypes = activityTypes;
    }

    public List<String> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<String> statuses) {
        this.statuses = statuses;
    }


    public void setDateTime (List<String> dateTime) {
        setStartDateTime(dateTime);
        setFinishDateTime(dateTime);
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(List<String> dateTime) {
        this.startDateTime = LocalDateTime.parse(dateTime.get(0).substring(0, dateTime.get(0).length() - 1));
    }

    public LocalDateTime getFinishDateTime() {
        return finishDateTime;
    }

    public void setFinishDateTime(List<String> dateTime) {
        this.finishDateTime = LocalDateTime.parse(dateTime.get(1).substring(0,dateTime.get(1).length() - 1));
    }
}