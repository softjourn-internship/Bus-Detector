package com.bus.detector.route.domain;

import com.bus.detector.bus.domain.BusInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * by Mr Skip on 11.02.2016.
 */

@Entity
public class Point {
    @Id
    @Column(name = "point_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "bus_id")
    @JsonIgnore
    private BusInfo busInfo;

    private String coordinate;

    public Point(){}

    public Point(int id, String coordinate){
        this.id = id;
        this.coordinate = coordinate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BusInfo getBusInfo() {
        return busInfo;
    }

    public void setBusInfo(BusInfo busInfo) {
        this.busInfo = busInfo;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public String toString() {
        return "Point{" +
                "id=" + id +
                ", coordinate='" + coordinate + '\'' +
                '}';
    }
}
