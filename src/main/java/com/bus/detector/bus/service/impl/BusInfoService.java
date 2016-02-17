package com.bus.detector.bus.service.impl;

import com.bus.detector.bus.domain.BusInfo;
import com.bus.detector.bus.repository.BusInfoRepo;
import com.bus.detector.bus.service.BusInfoLogic;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * by Mr Skip on 09.02.2016.
 */

@Service
public class BusInfoService implements BusInfoLogic {
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
    public Map<Integer, String> getAllBusNumber() {
        Map<Integer, String> list = new HashMap<>();
        for (String s : busInfoRepo.getAllBusNumber()) {
            list.put(list.size() + 1, s);
        }
        return list;
    }
}