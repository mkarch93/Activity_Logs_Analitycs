package com.radware.activitylog.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/data")
public class DataController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataController.class);


    @GetMapping("/home")
    public String home() {

        return "index";

    }


}
