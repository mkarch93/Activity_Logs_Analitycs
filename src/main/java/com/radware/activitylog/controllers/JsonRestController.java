package com.radware.activitylog.controllers;


import com.radware.activitylog.entity.Status;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class JsonRestController {


    private List<Status> statusList = new ArrayList<>();


    @GetMapping("/json")
    public List<Status> getStatuses()
    {
       // return DataController.statusList;
        return statusList;
    }


    public void setStatusList(List<Status> statusList) {
        this.statusList = statusList;
    }
}
