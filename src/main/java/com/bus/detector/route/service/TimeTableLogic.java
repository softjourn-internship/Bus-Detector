package com.bus.detector.route.service;

import com.bus.detector.route.domain.TimeTable;

import java.util.List;

/**
 * by Mr Skip on 09.02.2016.
 */

public interface TimeTableLogic {
    List<TimeTable> getAll();
    List<TimeTable> getByBusNumber(String busNumber);
    TimeTable getByBusNumber(String BusNumber, String day);
}
