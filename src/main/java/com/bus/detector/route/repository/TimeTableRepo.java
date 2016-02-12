package com.bus.detector.route.repository;

import com.bus.detector.route.domain.TimeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * by Mr Skip on 09.02.2016.
 */

public interface TimeTableRepo extends JpaRepository<TimeTable, Integer> {
    @Query("select t from TimeTable t, BusInfo b " +
            "where b.id = t.busInfo and b.busNumber = :busNumber")
    List<TimeTable> getTimeTableByBusNumber(@Param("busNumber") String busNumber);

    @Query("select t from TimeTable t, BusInfo b " +
            "where b.id = t.busInfo and b.busNumber = :busNumber and t.day = :day")
    TimeTable getTimeTableByBusNumber(@Param("busNumber") String busNumber,
                                      @Param("day") String day);
}
