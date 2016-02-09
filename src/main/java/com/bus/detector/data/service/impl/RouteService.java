package com.bus.detector.data.service.impl;

import com.bus.detector.data.Entities.BusInfo;
import com.bus.detector.data.Entities.Route;
import com.bus.detector.data.repository.RouteRepo;
import com.bus.detector.data.service.RouteImpl;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * by Mr Skip on 09.02.2016.
 */

@Service
public class RouteService implements RouteImpl {
    private final static Logger LOGGER = org.slf4j.LoggerFactory.getLogger(RouteService.class);

    @Autowired
    private RouteRepo routeRepo;

    @Override
    public List<Route> getAll() {
        List<Route> list;
        if ((list = routeRepo.findAll()).isEmpty()){
            LOGGER.warn("Cant find any Route in class: " + getClass().getName()
                    + ". In method: getAll()");
        }
        return list;
    }

    @Override
    public List<BusInfo> getBusInfoByStreetName(String street) {
        List<BusInfo> list;
        if ((list = routeRepo.getBusInfoByStreetName(street)).isEmpty()){
            LOGGER.warn("Cant find any Bus in class: " + getClass().getName()
                    + ". In method: getBusInfoByStreetName(String street)");
        }
        return list;
    }

    @Override
    public List<Route> getRouteByBusNumber(String busNumber) {
        List<Route> list;
        if ((list = routeRepo.getRouteByBusNumber(busNumber)).isEmpty()){
            LOGGER.warn("Cant find any Route in class: " + getClass().getName()
                    + ". In method: getRouteByBusNumber(String busNumber)");
        }
        return list;
    }
}
