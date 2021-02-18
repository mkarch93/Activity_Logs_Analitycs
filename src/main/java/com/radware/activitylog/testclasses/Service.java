package com.radware.activitylog.testclasses;

import com.radware.activitylog.dao.ActivityLogRepository;
import com.radware.activitylog.entity.DataPrepared;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


@org.springframework.stereotype.Service
public class Service {



    private ActivityLogRepository activityLogRepository;

    private long allCount;
    private long statusCount;

    private ArrayList<StatusTest> statusesPercent = new ArrayList<StatusTest>();
    ArrayList<ActivityTypeTest> activityTypeTestList = new ArrayList<ActivityTypeTest>();


    @Autowired
    public Service(ActivityLogRepository activityLogRepository) {
        this.activityLogRepository = activityLogRepository;
    }

    public Service() {
    }

//    public String method() {
//
//        UUID uuid = UUID.fromString("00066f32-c7e5-4b72-9615-d747870b8809");
//        List<UserActivityLogEntity> data1 = dataRepository.findByStatus("FAIL");
//        UserActivityLogEntity data2 = dataRepository.findByUserActivityId(uuid);
//        List<UserActivityLogEntity> data3 = dataRepository.findByActivityType("REFINE");
//
//        Long count =  dataRepository.count();
//
//        System.out.println(count);
//
//
//        System.out.println("----------------------");
//        System.out.println("----------------------");
//
//
//
//
//        System.out.println(data1.get(0).toString());
//        System.out.println(data1.toArray().length);
//        System.out.println("----------------------");
//
//        System.out.println(data2.toString());
//
//        System.out.println("----------------------");
//
//        System.out.println(data3.get(0).toString());
//        System.out.println(data3.toArray().length);
//        System.out.println("----------------------");
//
//
//
//        List<DataPrepared> dataPreparedList = dataRepository.customCandy();
//
//        System.out.println("----------------------");
//        System.out.println("----------------------");
//        System.out.println(dataPreparedList.toArray().length);
//        System.out.println(dataPreparedList.get(0).toString());
//        System.out.println(dataPreparedList.get(1).toString());
//        System.out.println(dataPreparedList.get(2).toString());
//        System.out.println("----------------------");
//        System.out.println("----------------------");
//
//        ArrayList<String> statuses = new ArrayList<String>();
//        statuses.add("FAIL");
//        statuses.add("SUCCESS");
//
//        System.out.println("++++++++++++++++++++++++");
//        System.out.println(statuses);
//        System.out.println("++++++++++++++++++++++++");
//
//
//        ArrayList<String> activityTypes = new ArrayList<String>();
//        activityTypes.add("UPDATE_ANTIBOT_CONFIGURATION_STATUS");
//        activityTypes.add("USER_CREATED");
//
//        System.out.println("++++++++++++++++++++++++");
//        System.out.println(activityTypes);
//        System.out.println("++++++++++++++++++++++++");
//
//
//        List<DataPrepared> dataPreparedList1 = dataRepository.customPreparedWithParams(statuses, activityTypes);
//
//        System.out.println("----------------------");
//        System.out.println("----------------------");
//        System.out.println(dataPreparedList1.toArray().length);
//        System.out.println(dataPreparedList1.get(0).toString());
//        System.out.println(dataPreparedList1.get(1).toString());
//        System.out.println(dataPreparedList1.get(2).toString());
//        System.out.println("----------------------");
//        System.out.println("----------------------");
//
//        return data2.getUserActivityId().toString();
//    }

    public ArrayList<StatusTest> statusesPercent(ArrayList<String> statuses, ArrayList<String> activityTypes) {


        List<DataPrepared> freshData = activityLogRepository.customPreparedWithParams(statuses, activityTypes);

        allCount = 0;
        for (DataPrepared data : freshData ) {
            allCount =  allCount + data.getCount();
        }

        System.out.println("All count = " + allCount);



        statusesPercent.clear();
        for (String tmp : statuses) {

            statusCount = 0;
            for (DataPrepared data : freshData ) {
                if (tmp.equals(data.getStatus())) {
                    statusCount = statusCount + data.getCount();
                }
            }
            Double tmpDouble = new Double((double) statusCount/allCount);

            String zazaa = tmp;
            System.out.println(zazaa);

            activityTypeTestList.clear();
            for (int i = 1; i < 4; i++) {
                activityTypeTestList.add(new ActivityTypeTest(zazaa  + " ActivityType" + i, new Double(22.4) ));

            }


            statusesPercent.add(new StatusTest(tmp, tmpDouble, activityTypeTestList));

        }
        return statusesPercent;
    }

    }

