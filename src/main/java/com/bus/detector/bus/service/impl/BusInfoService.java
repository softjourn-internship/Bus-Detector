package com.bus.detector.bus.service.impl;

import com.bus.detector.bus.domain.BusInfo;
import com.bus.detector.bus.repository.BusInfoRepo;
import com.bus.detector.bus.service.BusInfoLogic;
import com.bus.detector.route.repository.PointRepo;
import com.bus.detector.route.repository.StopStationsRepo;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * by Mr Skip on 09.02.2016.
 */

@Service
public class BusInfoService implements BusInfoLogic {
    private final static Logger LOGGER = org.slf4j.LoggerFactory.getLogger(BusInfoService.class);

    @Autowired
    private BusInfoRepo busInfoRepo;

    @Autowired
    private StopStationsRepo stopStationsRepo;

    @Autowired
    private PointRepo pointRepo;

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
    public List<BusInfo> getBusByBusNumber(String busNumber) {
        List<BusInfo> list;
        if ((list = busInfoRepo.getBusByBusNumber(busNumber)).isEmpty()){
            LOGGER.warn("Cant find any Route in class: " + getClass().getName()
                    + ". In method: getRouteByBusNumber(String busNumber)");
        }
        return list;
    }

    @Override
    public List<String> getAllBusNumber() {
        return busInfoRepo.getAllBusNumber();
    }
}