package com.radware.activitylog.controllers;


import com.radware.activitylog.entity.Status;
import com.radware.activitylog.service.ActivityLogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/data")
public class DataController {

    public static List<Status> statusList = new ArrayList<>();

    private ActivityLogService activityLogService;

    public DataController(ActivityLogService service) {
        this.activityLogService = service;
    }

    @GetMapping("/home")
    public String home() {

        System.out.println("home");

        return "home";

    }

    @GetMapping("/result")
    public String result(@RequestParam(value = "statuses", required = false) String statuses,
                         @RequestParam(value = "activity_types", required = false) String activity_types) {
        System.out.println("result statuses: " + statuses);
        System.out.println("result activity_types: " + activity_types);

        statusList = activityLogService.getListStatus(statuses, activity_types);
        return "pieChart";
    }







}
