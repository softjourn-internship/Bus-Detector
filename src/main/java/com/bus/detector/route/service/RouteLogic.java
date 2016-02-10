package com.bus.detector.route.service;

import com.bus.detector.bus.domain.BusInfo;
import com.bus.detector.route.domain.Route;

import java.util.List;

/**
 * by Mr Skip on 09.02.2016.
 */
public interface RouteLogic {
    List<Route> getAll();
    List<BusInfo> getBusInfoByStreetName(String street);
    List<Route> getRouteByBusNumber(String busNumber);
}
