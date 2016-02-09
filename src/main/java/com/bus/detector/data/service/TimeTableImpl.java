package com.bus.detector.data.service;

import com.bus.detector.data.Entities.TimeTable;

import java.util.List;

/**
 * by Mr Skip on 09.02.2016.
 */

public interface TimeTableImpl {
    List<TimeTable> getAll();
    List<TimeTable> getByBusNumber(String busNumber);
    TimeTable getByBusNumber(String BusNumber, String day);
}
