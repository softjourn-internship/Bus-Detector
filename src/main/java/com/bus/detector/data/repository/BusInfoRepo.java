package com.bus.detector.data.repository;

import com.bus.detector.data.Entities.BusInfo;
import com.bus.detector.data.Entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * by Mr Skip on 09.02.2016.
 */

public interface BusInfoRepo extends JpaRepository<BusInfo, Integer>{
    @Query("select busNumber, driverName, phoneNumber, machine from BusInfo where driverName = :name")
    BusInfo getBusByDriverName(@Param("name") String name);

    @Query("select busNumber, driverName, phoneNumber, machine from BusInfo where phoneNumber = :phoneNumber")
    BusInfo getBusByDriverPhone(@Param("phoneNumber") String phoneNumber);

    @Query("select b.busNumber, b.driverName, b.phoneNumber, b.machine from BusInfo b, Route r " +
            "where b.id = r.busInfo and r.streetName = :streetName")
    List<BusInfo> getBusInfoByStreetName(@Param("streetName") String streetName);

    @Query("select r.streetName, r.startCoordinate, r.endCoordinate from BusInfo b, Route r " +
            "where b.id = r.busInfo " +
            "and b.busNumber = :busNumber " +
            "and b.machine = :machine")
    List<Route> getRouteByBusNumber(@Param("busNumber") String busNumber,
                                    @Param("machine") String machine);


}
