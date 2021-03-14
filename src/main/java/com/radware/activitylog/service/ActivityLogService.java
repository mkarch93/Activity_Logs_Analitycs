package com.radware.activitylog.service;

import com.radware.activitylog.dao.ActivityLogRepository;
import com.radware.activitylog.entity.ActivityType;
import com.radware.activitylog.entity.DataPrepared;
import com.radware.activitylog.entity.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ActivityLogService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityLogService.class);

    public ActivityLogService() {
    }

    private ActivityLogRepository activityLogRepository;

    @Autowired
    public ActivityLogService(ActivityLogRepository theActivityLogRepository) {
        activityLogRepository = theActivityLogRepository;
    }


/*    public List<Status> getListStatus(String statusesString, String activityTypesString,
                                      String startDateTime, String finishDateTime) {

        Timestamp timeStart = Timestamp.valueOf(LocalDateTime.parse(startDateTime));
        Timestamp timeFinish = Timestamp.valueOf(LocalDateTime.parse(finishDateTime));

        String[] arrayStatuses = statusesString.split(",");
        ArrayList<String> statuses = new ArrayList<>(Arrays.asList(arrayStatuses));

        String[] arrayActivities = activityTypesString.split(",");
        ArrayList<String> activityTypes = new ArrayList<>(Arrays.asList(arrayActivities));


        List<DataPrepared> dataPreparedList;
        if (statusesString.isEmpty() && activityTypesString.isEmpty()) {
            LOGGER.debug("Requesting data without searching parameters");
            dataPreparedList = activityLogRepository.customPreparedWithoutParams(timeStart, timeFinish);
            statuses = activityLogRepository.statusesRequest();
            LOGGER.debug("Requesting data without searching parameters. Success");
        } else if (statusesString.isEmpty()) {
            LOGGER.debug("Requesting data with searching parameters: activity types");
            dataPreparedList = activityLogRepository.customPreparedWithActivityTypes(activityTypes, timeStart, timeFinish);
            statuses = activityLogRepository.statusesRequest();
            LOGGER.debug("Requesting data with searching parameters: activity types. Success");

        } else if (activityTypesString.isEmpty()) {
            LOGGER.debug("Requesting data with searching parameters: statuses");
            dataPreparedList = activityLogRepository.customPreparedWithStatuses(statuses, timeStart, timeFinish);
            LOGGER.debug("Requesting data with searching parameters: statuses. Success");

        } else {
            LOGGER.debug("Requesting data with searching parameters: activity types, statuses");
            dataPreparedList = activityLogRepository.customPreparedWithParams(statuses, activityTypes, timeStart, timeFinish);
            LOGGER.debug("Requesting data with searching parameters: activity types, statuses. Success");

        }

        LOGGER.debug("Start data preparing");
        List<Status> resultList = new ArrayList<>();

        //part of code with for-loops
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

            //part of code with lambda
            *//*statuses.stream().forEach(s->{
                AtomicInteger tempCount = new AtomicInteger(0);
                ArrayList<ActivityType> tempList = new ArrayList<>();
                dataPreparedList.forEach(dataPrepared -> {
                    if(dataPrepared.getStatus().equals(s)){
                        tempCount.addAndGet((int)dataPrepared.getCount());
                        tempList.add(new ActivityType(dataPrepared.getActivityType(), dataPrepared.getCount()));
                    }
                });
            resultList.add(new Status(s, tempCount.doubleValue(), tempList));
        });*//*


        getListWithPercent(resultList);
        LOGGER.debug("Finish data preparing");
        return resultList;
    }*/


    public List<Status> getListStatus(ArrayList<String> statuses, ArrayList<String> activityTypes,
                                      String startDateTime, String finishDateTime) {

        Timestamp timeStart = Timestamp.valueOf(LocalDateTime.parse(startDateTime));
        Timestamp timeFinish = Timestamp.valueOf(LocalDateTime.parse(finishDateTime));


        List<DataPrepared> dataPreparedList;
        if (statuses.isEmpty() && activityTypes.isEmpty()) {
            LOGGER.debug("Requesting data without searching parameters");
            dataPreparedList = activityLogRepository.customPreparedWithoutParams(timeStart, timeFinish);
            statuses = activityLogRepository.statusesRequest();
            LOGGER.debug("Requesting data without searching parameters. Success");
        } else if (statuses.isEmpty()) {
            LOGGER.debug("Requesting data with searching parameters: activity types");
            dataPreparedList = activityLogRepository.customPreparedWithActivityTypes(activityTypes, timeStart, timeFinish);
            statuses = activityLogRepository.statusesRequest();
            LOGGER.debug("Requesting data with searching parameters: activity types. Success");

        } else if (activityTypes.isEmpty()) {
            LOGGER.debug("Requesting data with searching parameters: statuses");
            dataPreparedList = activityLogRepository.customPreparedWithStatuses(statuses, timeStart, timeFinish);
            LOGGER.debug("Requesting data with searching parameters: statuses. Success");

        } else {
            LOGGER.debug("Requesting data with searching parameters: activity types, statuses");
            dataPreparedList = activityLogRepository.customPreparedWithParams(statuses, activityTypes, timeStart, timeFinish);
            LOGGER.debug("Requesting data with searching parameters: activity types, statuses. Success");

        }

        LOGGER.debug("Start data preparing");
        List<Status> resultList = new ArrayList<>();

        //part of code with for-loops
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
        LOGGER.debug("Finish data preparing");
        return resultList;
    }
















    public void getListWithPercent(List<Status> statusList) {
        LOGGER.debug("Start calculation of percents for statuses and activity types");

        double countAllStatus = 0;
        for (Status status : statusList) {
            countAllStatus += status.getStCount();
        }

        for (Status status : statusList) {
            status.setStPercent(status.getStCount() / countAllStatus * 100);
            for (ActivityType activityType : status.getAtList()) {
                activityType.setAtPercent(activityType.getAtCount() / status.getStCount() * 100);
            }
        }
        LOGGER.debug("Finish calculation of percents");

    }

    public ArrayList<String> getListRequestParamsStatuses() {
        LOGGER.debug("Start statuses request");
        return activityLogRepository.statusesRequest();

    }

    public ArrayList<String> getListRequestParamsActivityTypes() {
        LOGGER.debug("Start activity types request");
        return activityLogRepository.activityTypesRequest();
    }

}