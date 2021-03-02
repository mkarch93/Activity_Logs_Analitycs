package com.radware.activitylog.dao;

import com.radware.activitylog.entity.DataPrepared;
import com.radware.activitylog.entity.UserActivityLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface ActivityLogRepository extends JpaRepository<UserActivityLogEntity, UUID> {
     List<UserActivityLogEntity> findByStatus(String status);

     UserActivityLogEntity findByUserActivityId(UUID uuid);

     List<UserActivityLogEntity> findByActivityType(String type);


     @Query("SELECT new com.radware.activitylog.entity.DataPrepared(d.status, d.activityType, COUNT(*))  FROM UserActivityLogEntity d WHERE d.status IN ('FAIL','SUCCESS') AND  d.activityType IN ('UPDATE_ANTIBOT_CONFIGURATION_STATUS', 'USER_CREATED') group by 1,2")
     List<DataPrepared> customCandy();

     @Query("SELECT new com.radware.activitylog.entity.DataPrepared(d.status, d.activityType, COUNT(*))  FROM UserActivityLogEntity d WHERE d.status IN (:status) AND  d.activityType IN (:activityType) group by 1,2")
     List<DataPrepared> customPreparedWithParams(@Param("status") ArrayList<String> statuses, @Param("activityType") ArrayList<String> activityTypes);


}
