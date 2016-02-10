package com.bus.detector.route.service.impl;

import com.bus.detector.route.domain.TimeTable;
import com.bus.detector.route.repository.TimeTableRepo;
import com.bus.detector.route.service.TimeTableLogic;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * by Mr Skip on 09.02.2016.
 */

@Service
public class TimeTableService implements TimeTableLogic {
    private final static Logger LOGGER = org.slf4j.LoggerFactory.getLogger(TimeTableService.class);
    @Autowired
    private TimeTableRepo timeTableRepo;

    @Override
    public List<TimeTable> getAll() {
        List<TimeTable> list;
        if ((list = timeTableRepo.findAll()).isEmpty())
            LOGGER.warn("Not find any TimeTable in class: " + getClass().getName());
        return list;
    }

    @Override
    public List<TimeTable> getByBusNumber(String busNumber) {
        List<TimeTable> list;
        if ((list = timeTableRepo.getTimeTableByBusNumber(busNumber)).isEmpty())
            LOGGER.warn("Cant find any TimeTable in class: " + getClass().getName()
                    + ". In method (getByBusNumber(String busNumber))");
        return list;
    }

    @Override
    public TimeTable getByBusNumber(String busNumber, String day) {
        TimeTable timeTable;
        if ((timeTable = timeTableRepo.getTimeTableByBusNumber(busNumber, day)) == null) {
            LOGGER.warn("Cant find any TimeTable in class: " + getClass().getName()
                    + ". In method (getByBusNumber(String busNumber, String day))");
            timeTable = new TimeTable();
        }
        return timeTable;
    }
}