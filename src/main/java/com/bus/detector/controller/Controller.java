package com.bus.detector.controller;

import com.bus.detector.data.Entities.BusInfo;
import com.bus.detector.data.service.impl.BusInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * by Mr Skip on 09.02.2016.
 */

@RequestMapping("/bus-detector")
@RestController
public class Controller {
    @Autowired
    private BusInfoService busInfoService;

    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String index() {
        return "index";
    }

//        @ResponseBody
//        @Transactional(readOnly = true)
    @RequestMapping(value = "/api",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BusInfo> getAll(){
        return busInfoService.getAll();
    }
}
