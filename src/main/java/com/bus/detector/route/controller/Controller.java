package com.bus.detector.route.controller;

import com.bus.detector.bus.domain.BusInfo;
import com.bus.detector.route.service.impl.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * by Mr Skip on 09.02.2016.
 */

@RequestMapping("/route")
@RestController
public class Controller {
    @Autowired
    private RouteService service;

    @RequestMapping(value = "/bus/{busNumber}", method = RequestMethod.GET)
    List<BusInfo> getRouteByBusNumber(@PathVariable("busNumber") String busNumber){
        return service.getRouteByBusNumber(busNumber);
    }

    @RequestMapping(value = "/route/find", method = RequestMethod.GET)
    List<BusInfo> getRouteByTwoPoint(@RequestParam("xPointA") double xPointA, @RequestParam("yPointA") double yPointA,
                                     @RequestParam("xPointB") double xPointB, @RequestParam("yPointB") double yPointB){
        return service.getRouteByTwoPoint(xPointA, yPointA, xPointB, yPointB);
    }
}
