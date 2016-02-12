package com.bus.detector.bus.controller;

import com.bus.detector.bus.domain.BusInfo;
import com.bus.detector.bus.service.impl.BusInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * by Mr Skip on 10.02.2016.
 */

@RestController
@RequestMapping("/bus")
public class BusController {

    @Autowired
    private BusInfoService service;

    @RequestMapping(
            value = "/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getAllBusName(){
        return service.getAllBusNumber();
    }

    @RequestMapping(value = "/get-bus", method = RequestMethod.GET)
    List<BusInfo> getRouteByBusNumber(@RequestParam("name") String name){
        return service.getBusByBusNumber(name);
    }
}
