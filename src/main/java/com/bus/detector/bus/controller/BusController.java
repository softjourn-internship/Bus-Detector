package com.bus.detector.bus.controller;

import com.bus.detector.bus.domain.BusInfo;
import com.bus.detector.bus.service.impl.BusInfoService;
import com.bus.detector.route.domain.StopStations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public Map<Integer, String> getAllBusName(){
        return service.getAllBusNumber();
    }

    @RequestMapping(value = "/bus-number", method = RequestMethod.GET)
    List<BusInfo> getRouteByBusNumber(@RequestParam("name") String name){
        return service.getBusByBusNumber(name);
    }

    @RequestMapping(value = "/route/by-point", method = RequestMethod.GET)
    List<BusInfo> getRouteByTwoPoint(@RequestParam("x1") double x1, @RequestParam("y1") double y1,
                                     @RequestParam("x2") double x2, @RequestParam("y2") double y2){
        return service.getRoutesFromTwoPoint(x1, y1, x2, y2);
    }
}
