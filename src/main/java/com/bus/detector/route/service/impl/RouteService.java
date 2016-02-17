package com.bus.detector.route.service.impl;

import com.bus.detector.bus.domain.BusInfo;
import com.bus.detector.bus.repository.BusInfoRepo;
import com.bus.detector.route.domain.StopStations;
import com.bus.detector.route.repository.StopStationsRepo;
import com.bus.detector.route.service.RouteLogic;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * by Mr Skip on 17.02.2016.
 */
@Service
public class RouteService implements RouteLogic{
    private final static Logger LOGGER = org.slf4j.LoggerFactory.getLogger(RouteService.class);
    @Autowired
    private BusInfoRepo busInfoRepo;

    @Autowired
    private StopStationsRepo stopStationsRepo;

    @Override
    public List<BusInfo> getRouteByTwoPoint(double xPointA, double yPointA, double xPointB, double yPointB) {
        List<BusInfo> list = new ArrayList<>();

        List<Integer> listBegin = render(xPointA, yPointA);
        List<Integer> listEnd = render(xPointB, yPointA);

        int n = 0;
        int countOfBus = 0;

        while (n != listBegin.size() && countOfBus < 3){
            if (n < 2) {
                int position = listBegin.get(n);
                for (int i = 0; i < 2; i++) {
                    int busId;
                    if ((busId = routeExist(position, listEnd.get(i))) != -1 && countOfBus < 3 && !busExist(list, busId)) {
                        list.add(getBusRouteFromStations(busId, position, listEnd.get(i)));
                        countOfBus++;
                    }
                }
                n++;
                continue;
            }
            int position = listBegin.get(n);
            for (int i = 0; i <= n; i++) {
                int busId;
                if ((busId = routeExist(position, listEnd.get(i))) != -1 && countOfBus < 3 && !busExist(list, busId)) {
                    list.add(getBusRouteFromStations(busId, position, listEnd.get(i)));
                    countOfBus++;
                }
            }
            position = listEnd.get(n);
            for (int i = 0; i < n; i++) {
                int busId;
                if ((busId = routeExist(listBegin.get(i), position)) != -1
                        && countOfBus < 3 && !busExist(list, busId)) {
                    list.add(getBusRouteFromStations(busId, listBegin.get(i), position));
                    countOfBus++;
                }
            }
            n++;
        }
        return list;
    }

    @Override
    public List<BusInfo> getRouteByBusNumber(String busNumber) {
        List<BusInfo> list;
        if ((list = busInfoRepo.getBusByBusNumber(busNumber)).isEmpty()){
            LOGGER.warn("Cant find any Route in class: " + getClass().getName()
                    + ". In method: getRouteByBusNumber(String busNumber)");
        }
        return list;
    }
    private boolean busExist(List<BusInfo> busInfo, int id){
        for (BusInfo info : busInfo) {
            if (info.getId() == id)
                return true;
        }
        return false;
    }

    private int routeExist(int beginStopStationId, int endStopStationId){
        for (BusInfo busInfo : busInfoRepo.findAll()) {
            if (busHasStopStations(busInfo, beginStopStationId) && busHasStopStations(busInfo, endStopStationId))
                return busInfo.getId();
        }
        return -1;
    }

    private boolean busHasStopStations(BusInfo busInfo, int stopId){
        for (StopStations stations : busInfo.getStopStationsList()) {
            if (stations.getId() == stopId) return true;
        }
        return false;
    }

    private BusInfo getBusRouteFromStations(int busId, int beginSsId, int endSSid){
        BusInfo info = busInfoRepo.findOne(busId);
        BusInfo busInfo = new BusInfo(info);

        List<StopStations> stopStations = new ArrayList<>();
        List<StopStations> currentSs = info.getStopStationsList();

        for (int i = 0; i < currentSs.size(); i++) {
            if (currentSs.get(i).getId() == beginSsId)
                beginSsId = i;
            if (currentSs.get(i).getId() == endSSid)
                endSSid = i;
        }

        if (beginSsId > endSSid){
            for (int i = endSSid + 1; i < currentSs.size(); i++) {
                stopStations.add(currentSs.get(i));
            }
            for (int i = 0; i < beginSsId; i++) {
                stopStations.add(currentSs.get(i));
            }
        }
        else {
            for (int i = beginSsId; i <= endSSid; i++) {
                stopStations.add(currentSs.get(i));
            }
        }
        busInfo.setStopStationsList(stopStations);
        return busInfo;
    }

    private List<Integer> render(double x, double y){
        Map<Integer, Double> map = new HashMap<>();
        try {
            for (StopStations stations : stopStationsRepo.findAll()) {
                map.put(stations.getId(), Math.hypot(x - stations.getCoordinateX(), y - stations.getCoordinateY()));
            }
        }catch (Exception e){
            LOGGER.warn("Something wrong in class: " + getClass().getName() + ". Exception :\n " + e);
            return new ArrayList<>();
        }
        return new ArrayList<>(map.entrySet().stream().sorted(Comparator.comparingDouble(Map.Entry :: getValue))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (aDouble, aDouble2) -> aDouble, LinkedHashMap :: new)).keySet());
    }
}
