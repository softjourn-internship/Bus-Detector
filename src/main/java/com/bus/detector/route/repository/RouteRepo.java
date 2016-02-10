package com.bus.detector.route.repository;

import com.bus.detector.bus.domain.BusInfo;
import com.bus.detector.route.domain.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * by Mr Skip on 09.02.2016.
 */

public interface RouteRepo extends JpaRepository<Route, Integer> {
    @Query("select r.streetName, r.startCoordinate, r.endCoordinate from BusInfo b, Route r " +
            "where b.id = r.busInfo and b.busNumber = :busNumber")
    List<Route> getRouteByBusNumber(@Param("busNumber") String busNumber);

    @Query("select b.busNumber, b.driverName, b.phoneNumber, b.machine from BusInfo b, Route r " +
            "where b.id = r.busInfo and r.streetName = :streetName")
    List<BusInfo> getBusInfoByStreetName(@Param("streetName") String streetName);
}
