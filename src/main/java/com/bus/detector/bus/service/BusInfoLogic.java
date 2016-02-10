package com.bus.detector.bus.service;

import com.bus.detector.bus.domain.BusInfo;
import com.bus.detector.route.domain.Route;

import java.util.List;

/**
 * by Mr Skip on 09.02.2016.
 */
public interface BusInfoLogic {
    List<BusInfo> getAll();
    BusInfo getByDriverName(String name);
    BusInfo getByDriverPhone(String phone);
    List<BusInfo> getBusInfoByStreetName(String streetName);
    List<Route> getRouteByBusNumber(String busNumber, String machine);
}
