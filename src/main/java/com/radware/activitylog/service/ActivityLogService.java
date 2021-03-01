package com.radware.activitylog.service;

import com.radware.activitylog.controllers.DataController;
import com.radware.activitylog.dao.ActivityLogRepository;
import com.radware.activitylog.entity.ActivityType;
import com.radware.activitylog.entity.DataPrepared;
import com.radware.activitylog.entity.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ActivityLogService {

    private static Logger LOGGER  = LoggerFactory.getLogger(ActivityLogService.class);



    public ActivityLogService() {
    }

    private ActivityLogRepository activityLogRepository;

    @Autowired
    public ActivityLogService(ActivityLogRepository theActivityLogRepository) {
        activityLogRepository = theActivityLogRepository;
    }


    public List<Status> getListStatus(String statusesString, String activityTypesString) {

        String[] arrayStatuses = statusesString.split(",");
        ArrayList<String> statuses = new ArrayList<>(Arrays.asList(arrayStatuses));

        String[] arrayActivities = activityTypesString.split(",");
        ArrayList<String> activityTypes = new ArrayList<>(Arrays.asList(arrayActivities));



        List<DataPrepared> dataPreparedList;
        if (statusesString.isEmpty() && activityTypesString.isEmpty()) {
            LOGGER.info("Requesting data without searching parameters");
            dataPreparedList = activityLogRepository.customPreparedWithoutParams();
            statuses = activityLogRepository.statusesRequest();
            LOGGER.info("Requesting data without searching parameters. Success");
        } else if (statusesString.isEmpty()) {
            LOGGER.info("Requesting data with searching parameters: activity types");
            dataPreparedList = activityLogRepository.customPreparedWithActivityTypes(activityTypes);
            statuses = activityLogRepository.statusesRequest();
            LOGGER.info("Requesting data with searching parameters: activity types. Success");

        } else if (activityTypesString.isEmpty()) {
            LOGGER.info("Requesting data with searching parameters: statuses");
            dataPreparedList = activityLogRepository.customPreparedWithStatuses(statuses);
            LOGGER.info("Requesting data with searching parameters: statuses. Success");

        } else {
            LOGGER.info("Requesting data with searching parameters: activity types, statuses");
            dataPreparedList = activityLogRepository.customPreparedWithParams(statuses, activityTypes);
            LOGGER.info("Requesting data with searching parameters: activity types, statuses. Success");

        }

        LOGGER.info("Start data preparing");
        List<Status> resultList = new ArrayList<>();
        for (String s : statuses) {
            double tempCount = 0;
            ArrayList<ActivityType> tempList = new ArrayList<>();
            for (DataPrepared dataPrepared : dataPreparedList) {
                if (dataPrepared.getStatus().equals(s)) {
                    tempCount += dataPrepared.getCount();
                    tempList.add(new ActivityType(dataPrepared.getActivityType(), dataPrepared.getCount()));
                }

            }
            resultList.add(new Status(s, tempCount, tempList));
        }
        getListWithPercent(resultList);
        LOGGER.info("Finish data preparing");
        return resultList;

    }

    public void getListWithPercent(List<Status> statusList) {
        LOGGER.info("Start calculation of percents for statuses and activity types");

        double countAllStatus = 0;
        for (Status status : statusList) {
            countAllStatus += status.getSt_count();
        }

        for (Status status : statusList) {
            status.setSt_percent(status.getSt_count() / countAllStatus * 100);
            for (ActivityType activityType : status.getAt_list()) {
                activityType.setAt_percent(activityType.getAt_count() / status.getSt_count() * 100);
            }
        }
        LOGGER.info("Finish calculation of percents");


    }

    public ArrayList<String> getListRequestParamsStatuses() {
        LOGGER.info("Start statuses request");
        return activityLogRepository.statusesRequest();

    }

    public ArrayList<String> getListRequestParamsActivityTypes() {
        LOGGER.info("Start activity types request");
        return activityLogRepository.activityTypesRequest();
    }

}