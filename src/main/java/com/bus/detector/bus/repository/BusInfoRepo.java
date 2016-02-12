package com.bus.detector.bus.repository;

import com.bus.detector.bus.domain.BusInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * by Mr Skip on 09.02.2016.
 */

public interface BusInfoRepo extends JpaRepository<BusInfo, Integer>{
    @Query("select b from BusInfo b where driverName = :name")
    BusInfo getBusByDriverName(@Param("name") String name);

    @Query("select b from BusInfo b where phoneNumber = :phoneNumber")
    BusInfo getBusByDriverPhone(@Param("phoneNumber") String phoneNumber);

    @Query("select b.busNumber from BusInfo b")
    List<String> getAllBusNumber();

    @Query("select b from BusInfo b " +
            "where b.busNumber = :busNumber ")
    List<BusInfo> getBusByBusNumber(@Param("busNumber") String busNumber);
}
