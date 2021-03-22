package com.radware.activitylog.dao;

import com.radware.activitylog.entity.DataPrepared;
import com.radware.activitylog.entity.UserActivityLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface ActivityLogRepository extends JpaRepository<UserActivityLogEntity, UUID> {

    List<UserActivityLogEntity> findByStatus(String status);

    UserActivityLogEntity findByUserActivityId(UUID uuid);

    List<UserActivityLogEntity> findByActivityType(String type);

    @Query("SELECT new com.radware.activitylog.entity.DataPrepared(d.status, d.activityType, COUNT(*)) " +
            "FROM UserActivityLogEntity d WHERE d.status IN (:status) AND  d.activityType IN (:activityType) " +
            "AND d.startDate BETWEEN (:startDateTime) AND (:finishDateTime) group by 1,2")
    List<DataPrepared> customPreparedWithParams(@Param("status") List<String> statuses,
                                                @Param("activityType") List<String> activityTypes,
                                                @Param("startDateTime") LocalDateTime startDateTime,
                                                @Param("finishDateTime") LocalDateTime finishDateTime);

    @Query("SELECT new com.radware.activitylog.entity.DataPrepared(d.status, d.activityType, COUNT(*)) " +
            "FROM UserActivityLogEntity d WHERE d.status IN (:status) " +
            "AND d.startDate BETWEEN (:startDateTime) AND (:finishDateTime) group by 1,2")
    List<DataPrepared> customPreparedWithStatuses(@Param("status") List<String> statuses,
                                                  @Param("startDateTime") LocalDateTime startDateTime,
                                                  @Param("finishDateTime") LocalDateTime finishDateTime);

    @Query("SELECT new com.radware.activitylog.entity.DataPrepared(d.status, d.activityType, COUNT(*)) " +
            "FROM UserActivityLogEntity d WHERE d.activityType IN (:activityType) " +
            "AND d.startDate BETWEEN (:startDateTime) AND (:finishDateTime) group by 1,2")
    List<DataPrepared> customPreparedWithActivityTypes(@Param("activityType") List<String> activityTypes,
                                                       @Param("startDateTime") LocalDateTime startDateTime,
                                                       @Param("finishDateTime") LocalDateTime finishDateTime);

    @Query("SELECT new com.radware.activitylog.entity.DataPrepared(d.status, d.activityType, COUNT(*)) " +
            "FROM UserActivityLogEntity d WHERE  d.startDate BETWEEN (:startDateTime) AND (:finishDateTime) group by 1,2")
    List<DataPrepared> customPreparedWithoutParams(@Param("startDateTime") LocalDateTime startDateTime,
                                                   @Param("finishDateTime") LocalDateTime finishDateTime);

    @Query("SELECT d.status FROM UserActivityLogEntity d group by 1")
    ArrayList<String> statusesRequest();

    @Query("SELECT d.activityType FROM UserActivityLogEntity d  group by 1")
    ArrayList<String> activityTypesRequest();

}
