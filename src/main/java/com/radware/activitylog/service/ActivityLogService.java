package com.radware.activitylog.service;

import com.radware.activitylog.dao.ActivityLogRepository;
import com.radware.activitylog.entity.ActivityType;
import com.radware.activitylog.entity.DataPrepared;
import com.radware.activitylog.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ActivityLogService {


    public ActivityLogService() {
    }

    private ActivityLogRepository activityLogRepository;

    @Autowired
    public ActivityLogService(ActivityLogRepository theActivityLogRepository) {
        activityLogRepository = theActivityLogRepository;
    }


    public List<Status> getListStatus(String statusesString, String activityTypesString) {
        String[] arrayStatuses = statusesString.split(", ");
        ArrayList<String> statuses = new ArrayList<>(Arrays.asList(arrayStatuses));

        String[] arrayActivities = activityTypesString.split(", ");
        ArrayList<String> activityTypes = new ArrayList<>(Arrays.asList(arrayActivities));

        List<DataPrepared> dataPreparedList = activityLogRepository.customPreparedWithParams(statuses, activityTypes);
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
        return resultList;

    }

    public void getListWithPercent(List<Status> statusList) {
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
    }
}