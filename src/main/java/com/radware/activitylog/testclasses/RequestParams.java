package com.radware.activitylog.testclasses;

public class RequestParams {
    private String requestStatuses;
    private String requestActivityTypes;

    public RequestParams() {
    }

    public RequestParams(String requestStatuses, String requestActivityTypes) {
        this.requestStatuses = requestStatuses;
        this.requestActivityTypes = requestActivityTypes;
    }

    public String getRequestStatuses() {
        return requestStatuses;
    }

    public void setRequestStatuses(String requestStatuses) {
        this.requestStatuses = requestStatuses;
    }

    public String getRequestActivityTypes() {
        return requestActivityTypes;
    }

    public void setRequestActivityTypes(String requestActivityTypes) {
        this.requestActivityTypes = requestActivityTypes;
    }
}
