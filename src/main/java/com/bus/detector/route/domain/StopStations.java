package com.bus.detector.route.domain;

import com.bus.detector.bus.domain.BusInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * by Mr Skip on 11.02.2016.
 */

@Entity
public class StopStations {
    @Id
    private int id;
    private String coordinate;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "bus_stop_stations",
            joinColumns = {@JoinColumn(name = "stop_stations_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "bus_id", referencedColumnName = "bus_id")}
    )
    @JsonIgnore
    private List<BusInfo> busInfoList;

    public StopStations(){}

    public StopStations(int id, String name, String coordinate){
        this.id = id;
        this.coordinate = coordinate;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BusInfo> getBusInfoList() {
        return busInfoList;
    }

    public void setBusInfoList(List<BusInfo> busInfoList) {
        this.busInfoList = busInfoList;
    }

    @Override
    public String toString() {
        return "StopStations{" +
                "id=" + id +
                ", coordinate='" + coordinate + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}