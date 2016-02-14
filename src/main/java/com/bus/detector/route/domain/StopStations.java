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

    private String name;
    private double coordinateX;
    private double coordinateY;

    @ManyToMany
    @JoinTable(
            name = "bus_stop_stations",
            joinColumns = {@JoinColumn(name = "stop_stations_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "bus_id", referencedColumnName = "bus_id")}
    )
    @JsonIgnore
    private List<BusInfo> busInfoList;

    public StopStations(){}

    public StopStations(int id, String name, double coordinateX, double coordinateY){
        this.id = id;
        this.name = name;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
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

    public void setName(String name) {
        this.name = name;
    }

    public List<BusInfo> getBusInfoList() {
        return busInfoList;
    }

    public void setBusInfoList(List<BusInfo> busInfoList) {
        this.busInfoList = busInfoList;
    }

    public double getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(double coordinateX) {
        this.coordinateX = coordinateX;
    }

    public double getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(double coordinateY) {
        this.coordinateY = coordinateY;
    }

    @Override
    public String toString() {
        return "StopStations{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinateX=" + coordinateX +
                ", coordinateY=" + coordinateY +
                '}';
    }
}