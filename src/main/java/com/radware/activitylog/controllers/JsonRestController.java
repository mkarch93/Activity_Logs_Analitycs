package com.radware.activitylog.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.radware.activitylog.entity.Input;
import com.radware.activitylog.entity.Status;
import com.radware.activitylog.service.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class JsonRestController {


    private List<Status> statusList = new ArrayList<>();

    @Autowired
    private ActivityLogService activityLogService;

    @GetMapping("/json")
    public List<Status> getStatuses()
    {
       // return DataController.statusList;
        return statusList;
    }

    @PostMapping("/test")
    public List<Status> getStatusesTest(@RequestBody Input input) throws JsonProcessingException
    {

        return activityLogService.getListStatus(input.getStInputList(),input.getAtInputList(),input.getDateTime().get(0),input.getDateTime().get(1));
        //ObjectMapper mapper = new ObjectMapper();
        //String jsonString = mapper.writeValueAsString(input);

    }


    public void setStatusList(List<Status> statusList) {
        this.statusList = statusList;
    }
}
