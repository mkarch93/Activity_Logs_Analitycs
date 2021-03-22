package com.radware.activitylog.controllers;

import com.radware.activitylog.entity.Input;
import com.radware.activitylog.entity.Status;
import com.radware.activitylog.service.ActivityLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;


@RestController
@RequestMapping("/api")
public class JsonRestController {


    private static final Logger LOGGER = LoggerFactory.getLogger(DataController.class);

    private ActivityLogService activityLogService;

    @Autowired
    public JsonRestController(ActivityLogService theActivityLogService) {
        activityLogService = theActivityLogService;
    }


    @PostMapping("/chart")
    public List<Status> getStatusesTest(@RequestBody Input input)
    {

        LOGGER.info("Statuses: " + input.getStatuses());
        LOGGER.info("Activity Types: " + input.getActivityTypes());
        LOGGER.info("Start Date Time: " + input.getStartDateTime());
        LOGGER.info("End Date Time: " + input.getFinishDateTime());

        return activityLogService.getListStatus(input);

    }

}
