package com.radware.activitylog.controllers;

import com.radware.activitylog.entity.Input;
import com.radware.activitylog.entity.Status;
import com.radware.activitylog.service.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class JsonRestController {


    private ActivityLogService activityLogService;

    @Autowired
    public JsonRestController(ActivityLogService theActivityLogService) {
        activityLogService = theActivityLogService;
    }


    @PostMapping("/json")
    public List<Status> getStatusesTest(@RequestBody Input input)
    {
        System.out.println(input.getActivityTypes());
        System.out.println(input.getStatuses());
        String time1 = input.getDateTime().get(0).substring(0, input.getDateTime().get(0).length()-8);
        String time2 = input.getDateTime().get(1).substring(0, input.getDateTime().get(1).length()-8);
        System.out.println(time1);
        System.out.println(time2);
        return activityLogService.getListStatus(input.getStatuses(),input.getActivityTypes(),time1,time2);

    }

}
