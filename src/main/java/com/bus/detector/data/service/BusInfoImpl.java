package com.bus.detector.data.service;

import com.bus.detector.data.Entities.BusInfo;
import com.bus.detector.data.Entities.Route;

import java.util.List;

/**
 * by Mr Skip on 09.02.2016.
 */
public interface BusInfoImpl {
    List<BusInfo> getAll();
    BusInfo getByDriverName(String name);
    BusInfo getByDriverPhone(String phone);
    List<BusInfo> getBusInfoByStreetName(String streetName);
    List<Route> getRouteByBusNumber(String busNumber, String machine);
}
