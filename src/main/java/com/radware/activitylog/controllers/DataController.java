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

    private static final Logger LOGGER = LoggerFactory.getLogger(DataController.class);

    private ActivityLogService activityLogService;

    public DataController(ActivityLogService service) {
        this.activityLogService = service;
    }

    @GetMapping("/home")
    public String home(HttpServletRequest request, Model model) {
        LOGGER.info(request.getMethod() + " " + request.getRequestURI() + " FROM IP: " + request.getRemoteAddr());
        LOGGER.debug("Requesting page parameters from DB");

        model.addAttribute("activityTypesArrayList", activityLogService.getListRequestParamsActivityTypes());
        model.addAttribute("statusesArrayList", activityLogService.getListRequestParamsStatuses());

        LOGGER.debug("Requesting page parameters completed");

        return "home3";

    }


    @PostMapping("/result")
    public String result(HttpServletRequest request,
                         Model model) {

        LOGGER.info(request.getMethod() + " " + request.getRequestURI() + " FROM IP: " + request.getRemoteAddr());
        LOGGER.info("Request statuses: " + request.getParameter("statuses"));
        LOGGER.info("Request activity types: " + request.getParameter("activityTypes"));
        LOGGER.info("Request startDateTime: " + request.getParameter("startDateTime"));
        LOGGER.info("Request finishDateTime: " + request.getParameter("finishDateTime"));
        LOGGER.debug("Starting method getListStatus");


        model.addAttribute("results", activityLogService.getListStatus(
                request.getParameter("statuses"),
                request.getParameter("activityTypes"),
                request.getParameter("startDateTime"),
                request.getParameter("finishDateTime")));

        LOGGER.debug("Method getListStatus completed");

        return "result";

    }

}
