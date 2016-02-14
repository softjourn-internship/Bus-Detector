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

    private double coordinateX;
    private double coordinateY;

    public Point(){}

    public Point(int id, double coordinateX, double coordinateY){
        this.id = id;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
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

    public double getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(double coordinataX) {
        this.coordinateX = coordinataX;
    }

    public double getCoordinataY() {
        return coordinateY;
    }

    public void setCoordinateY(double coordinataY) {
        this.coordinateY = coordinataY;
    }
}
