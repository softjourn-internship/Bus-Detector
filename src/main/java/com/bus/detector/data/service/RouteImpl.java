package com.bus.detector.data.service;

import com.bus.detector.data.Entities.BusInfo;
import com.bus.detector.data.Entities.Route;

import java.util.List;

/**
 * by Mr Skip on 09.02.2016.
 */
public interface RouteImpl {
    List<Route> getAll();
    List<BusInfo> getBusInfoByStreetName(String street);
    List<Route> getRouteByBusNumber(String busNumber);
}
