package com.bus.detector.route.service;

import com.bus.detector.bus.domain.BusInfo;

import java.util.List;

/**
 * by Mr Skip on 17.02.2016.
 */
public interface RouteLogic {
    public List<BusInfo> getRouteByTwoPoint(double xPointA, double yPointA,
                                            double xPointB, double yPointB);
    public List<BusInfo> getRouteByBusNumber(String busNumber);
}
