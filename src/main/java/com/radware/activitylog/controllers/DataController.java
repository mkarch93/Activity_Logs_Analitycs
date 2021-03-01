package com.radware.activitylog.controllers;


import com.radware.activitylog.service.ActivityLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/data")
public class DataController {

    private static Logger LOGGER  = LoggerFactory.getLogger(DataController.class);

    private ActivityLogService activityLogService;

    public DataController(ActivityLogService service) {
        this.activityLogService = service;
    }

    @GetMapping("/home")
    public String home(HttpServletRequest request, Model model) {
        LOGGER.info(request.getMethod() + " " + request.getRequestURI() + " FROM IP: " + request.getRemoteAddr());
        LOGGER.info("Requesting page parameters from DB");

        model.addAttribute("activityTypesArrayList", activityLogService.getListRequestParamsActivityTypes());
        model.addAttribute("statusesArrayList", activityLogService.getListRequestParamsStatuses());

        LOGGER.info("Requesting page parameters completed");

        return "home";

    }



    @PostMapping("/result")
    public String result(HttpServletRequest request,
                         Model model) {

        LOGGER.info(request.getMethod() + " " + request.getRequestURI() + " FROM IP: " + request.getRemoteAddr());
        LOGGER.info("Request statuses: " + request.getParameter("statuses"));
        LOGGER.info("Request activity types: " + request.getParameter("activityTypes"));
        LOGGER.info("Starting method getListStatus");


        model.addAttribute("results", activityLogService.getListStatus(request.getParameter("statuses"),
                request.getParameter("activityTypes")));

        LOGGER.info("Method getListStatus completed");

        return "result";

    }

}
