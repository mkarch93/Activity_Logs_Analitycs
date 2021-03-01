package com.radware.activitylog;

import com.radware.activitylog.dao.ActivityLogRepository;
import com.radware.activitylog.entity.ActivityType;
import com.radware.activitylog.entity.DataPrepared;
import com.radware.activitylog.entity.Status;
import com.radware.activitylog.entity.UserActivityLogEntity;
import com.radware.activitylog.service.ActivityLogService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootTest
class ActivityLogsAnalyticsApplicationTests {

    @Autowired
    private ActivityLogService activityLogService;

    @Autowired
    private ActivityLogRepository activityLogRepository;


    @Test
    void contextLoads() {
    }

    @Test
    public void checkStatusesQuery() {
        ArrayList<String> statuses = activityLogRepository.statusesRequest();
        Assertions.assertTrue(statuses.size() > 0);
    }

    @Test
    public void checkActivityTypesQuery() {
        ArrayList<String> activityTypes = activityLogRepository.activityTypesRequest();
        Assertions.assertTrue(activityTypes.size() > 0);
    }

    @Test
    public void checkPreparedWithParamsQuery() {
        Random random = new Random();
        // take actual statuses list
        ArrayList<String> statusesArrayList = activityLogRepository.statusesRequest();
        int a = statusesArrayList.size();

        // put random status in statuses list for query
        ArrayList<String> statuses = new ArrayList<>();
        statuses.add(statusesArrayList.get(random.nextInt(a)));

        // take list entities from DB with previously generated random status
        List<UserActivityLogEntity> userActivityLogEntityList  = activityLogRepository.findByStatus(statuses.get(0));
        int b = userActivityLogEntityList.size();

        // put random activity type in statuses list for query
        ArrayList<String> activityTypes = new ArrayList<>();
        activityTypes.add(userActivityLogEntityList.get(random.nextInt(b)).getActivityType());

        List<DataPrepared> dataPreparedList = activityLogRepository.customPreparedWithParams(statuses, activityTypes);
        Assertions.assertEquals(dataPreparedList.size(), 1);
        Assertions.assertTrue(dataPreparedList.get(0).getCount() > 0);
        Assertions.assertTrue(dataPreparedList.get(0).getStatus().equals(statuses.get(0)));
        Assertions.assertTrue(dataPreparedList.get(0).getActivityType().equals(activityTypes.get(0)));


    }

    @Test
    public void checkPreparedWithStatusesQuery() {
        Random random = new Random();
        // take actual statuses list
        ArrayList<String> statusesArrayList = activityLogRepository.statusesRequest();
        int a = statusesArrayList.size();

        // put random status in statuses list for query
        ArrayList<String> statuses = new ArrayList<>();
        statuses.add(statusesArrayList.get(random.nextInt(a)));

        List<DataPrepared> dataPreparedList = activityLogRepository.customPreparedWithStatuses(statuses);
        Assertions.assertTrue(dataPreparedList.size() > 0);
        Assertions.assertTrue(dataPreparedList.get(0).getCount() > 0);
        Assertions.assertTrue(dataPreparedList.get(0).getStatus().equals(statuses.get(0)));
        Assertions.assertTrue(dataPreparedList.get(dataPreparedList.size() - 1).getStatus().equals(statuses.get(0)));

    }

    @Test
    public void checkPreparedWithActivityTypesQuery() {
        Random random = new Random();
        // take actual activity types list
        ArrayList<String> activityTypesArrayList = activityLogRepository.activityTypesRequest();
        int a = activityTypesArrayList.size();

        // put random status in statuses list for query
        ArrayList<String> activityTypes = new ArrayList<>();
        activityTypes.add(activityTypesArrayList.get(random.nextInt(a)));

        List<DataPrepared> dataPreparedList = activityLogRepository.customPreparedWithActivityTypes(activityTypes);
        Assertions.assertTrue(dataPreparedList.size() > 0);
        Assertions.assertTrue(dataPreparedList.get(0).getCount() > 0);
        Assertions.assertTrue(dataPreparedList.get(0).getActivityType().equals(activityTypes.get(0)));
        Assertions.assertTrue(dataPreparedList.get(dataPreparedList.size() - 1).getActivityType().equals(activityTypes.get(0)));

    }

    @Test
    public void checkPreparedWithoutParamsQuery() {
        int coincidenceCounter = 0;

        ArrayList<String> statuses = activityLogRepository.statusesRequest();
        ArrayList<String> activityTypes = activityLogRepository.activityTypesRequest();

        List<DataPrepared> dataPreparedListStatuses = activityLogRepository.customPreparedWithStatuses(statuses);
        List<DataPrepared> dataPreparedListActivityTypes = activityLogRepository.customPreparedWithActivityTypes(activityTypes);
        List<DataPrepared> dataPreparedList = activityLogRepository.customPreparedWithoutParams();

        Assertions.assertEquals(dataPreparedList.size(), dataPreparedListStatuses.size());
        Assertions.assertEquals(dataPreparedList.size(), dataPreparedListActivityTypes.size());

        for (DataPrepared dataPrepared : dataPreparedListStatuses) {
            for (DataPrepared data :dataPreparedList) {
                if (data.toString().equals(dataPrepared.toString())){
                    coincidenceCounter++;
                    break;
                }
            }
        }
        Assertions.assertEquals(coincidenceCounter, dataPreparedListStatuses.size());

        coincidenceCounter = 0;
        for (DataPrepared dataPrepared : dataPreparedListStatuses) {
            for (DataPrepared data :dataPreparedList) {
                if (data.toString().equals(dataPrepared.toString())){
                    coincidenceCounter++;
                    break;
                }
            }
        }
        Assertions.assertEquals(coincidenceCounter, dataPreparedListActivityTypes.size());
    }

    @Test
    public void checkGetListStatusCalculations() {
        double countStatuses = 0;
        double countActivityTypes;

        List<Status> statusList = activityLogService.getListStatus("","");
        for (Status status : statusList) {
            countStatuses = countStatuses +  status.getSt_percent();
            countActivityTypes = 0;
            for (ActivityType activityType : status.getAt_list()){
                countActivityTypes = countActivityTypes + activityType.getAt_percent();
            }
            Assertions.assertEquals((int) Math.round(countActivityTypes), 100);
        }
        Assertions.assertEquals((int) Math.round(countStatuses), 100);


    }

}
