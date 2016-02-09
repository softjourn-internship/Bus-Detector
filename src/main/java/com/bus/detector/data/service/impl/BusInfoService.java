package com.bus.detector.data.service.impl;

import com.bus.detector.data.Entities.BusInfo;
import com.bus.detector.data.Entities.Route;
import com.bus.detector.data.repository.BusInfoRepo;
import com.bus.detector.data.service.BusInfoImpl;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * by Mr Skip on 09.02.2016.
 */

@Service
public class BusInfoService implements BusInfoImpl{
    private final static Logger LOGGER = org.slf4j.LoggerFactory.getLogger(BusInfoService.class);

    @Autowired
    private BusInfoRepo busInfoRepo;

    @Override
    public BusInfo getByDriverName(String name) {
        BusInfo busInfo;
        if ((busInfo = busInfoRepo.getBusByDriverName(name)) == null){
            LOGGER.warn("Not find any Bus for driver name:" + name + ". In class: " + getClass().getName());
            busInfo = new BusInfo();
        }
        return busInfo;
    }

    @Override
    public BusInfo getByDriverPhone(String phone) {
        BusInfo busInfo;
        if ((busInfo = busInfoRepo.getBusByDriverPhone(phone)) == null){
            LOGGER.warn("Not find any Bus for driver phone:" + phone + ". In class: " + getClass().getName());
            busInfo = new BusInfo();
        }
        return busInfo;
    }

    @Override
    public List<BusInfo> getAll(){
        List<BusInfo> list;
        if ((list = busInfoRepo.findAll()).isEmpty()){
            LOGGER.warn("Cant find any Bus in class: " + getClass().getName());
        }
        return list;
    }

    @Override
    public List<BusInfo> getBusInfoByStreetName(String streetName) {
        List<BusInfo> list;
        if ((list = busInfoRepo.getBusInfoByStreetName(streetName)).isEmpty()){
            LOGGER.warn("Cant find any Bus in class: " + getClass().getName()
            + ". In method: getBusInfoByStreetName(String streetName)");
        }
        return list;
    }

    @Override
    public List<Route> getRouteByBusNumber(String busNumber, String machine) {
        List<Route> list;
        if ((list = busInfoRepo.getRouteByBusNumber(busNumber, machine)).isEmpty()){
            LOGGER.warn("Cant find any Route in class: " + getClass().getName()
                    + ". In method: getRouteByBusNumber(String busNumber)");
        }
        return list;
    }
}