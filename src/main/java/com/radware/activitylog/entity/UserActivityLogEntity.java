package com.radware.activitylog.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "user_activity_log", schema = "public", catalog = "reporter")
public class UserActivityLogEntity {

    public UserActivityLogEntity(){}


    private UUID userActivityId;
    private String trackingId;
    private String accountId;
    private Timestamp startDate;
    private String userEmail;
    private String processTypeText;
    private String status;
    private String referenceId;
    private String activityType;
    private String userIp;
    private String userAgent;
    private String userCountry;
    @Basic
    @Column(columnDefinition = "TEXT[]")
    @Type(type = "string-array")
    private String [] labels;



    @Id
    @Column(name = "user_activity_id")
    public UUID getUserActivityId() {
        return userActivityId;
    }

    public void setUserActivityId(UUID userActivityId) {
        this.userActivityId = userActivityId;
    }

    @Basic
    @Column(name = "tracking_id")
    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    @Basic
    @Column(name = "account_id")
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "start_date")
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "user_email")
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "process_type_text")
    public String getProcessTypeText() {
        return processTypeText;
    }

    public void setProcessTypeText(String processTypeText) {
        this.processTypeText = processTypeText;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "reference_id")
    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    @Basic
    @Column(name = "activity_type")
    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    @Basic
    @Column(name = "user_ip")
    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    @Basic
    @Column(name = "user_agent")
    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    @Basic
    @Column(name = "user_country")
    public String getUserCountry() {
        return userCountry;
    }

    public void setUserCountry(String userCountry) {
        this.userCountry = userCountry;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserActivityLogEntity that = (UserActivityLogEntity) o;
        return Objects.equals(userActivityId, that.userActivityId) && Objects.equals(trackingId, that.trackingId) && Objects.equals(accountId, that.accountId) && Objects.equals(startDate, that.startDate) && Objects.equals(userEmail, that.userEmail) && Objects.equals(processTypeText, that.processTypeText) && Objects.equals(status, that.status) && Objects.equals(referenceId, that.referenceId) && Objects.equals(activityType, that.activityType) && Objects.equals(userIp, that.userIp) && Objects.equals(userAgent, that.userAgent) && Objects.equals(userCountry, that.userCountry) && Objects.equals(labels, that.labels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userActivityId, trackingId, accountId, startDate, userEmail, processTypeText, status, referenceId, activityType, userIp, userAgent, userCountry, labels);
    }
}
