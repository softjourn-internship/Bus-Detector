package com.bus.detector.bus.domain;

import com.bus.detector.route.domain.Point;
import com.bus.detector.route.domain.StopStations;
import com.bus.detector.route.domain.TimeTable;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * by Mr Skip on 10.02.2016.
 */

@Entity
public class BusInfo {
    @Id
    @GeneratedValue
    @Column(name = "bus_id")
    private int id;

    private String busNumber;
    @JsonIgnore
    private String driverName;
    @JsonIgnore
    private String phoneNumber;
    @JsonIgnore
    private String machine;

    @OneToMany(targetEntity = TimeTable.class)
    @JsonIgnore
    private Set<TimeTable> timeTables;

    @OneToMany(mappedBy = "busInfo", cascade = CascadeType.ALL)
    private List<Point> points;

    @ManyToMany(mappedBy = "busInfoList")
    private List<StopStations> stopStationsList;

    public BusInfo(){}

    public BusInfo(String busNumber, String driverName,
                   String phoneNumber, String machine){
        this.busNumber = busNumber;
        this.driverName = driverName;
        this.phoneNumber = phoneNumber;
        this.machine = machine;
    }

    public int getId() {
            return id;
        }

    public void setId(int id) {
            this.id = id;
        }

    public String getBusNumber() {
            return busNumber;
        }

    public void setBusNumber(String busNumber) {
            this.busNumber = busNumber;
        }

    public String getDriverName() {
            return driverName;
        }

    public void setDriverName(String driverName) {
            this.driverName = driverName;
        }

    public String getPhoneNumber() {
            return phoneNumber;
        }

    public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

    public String getMachine() {
            return machine;
        }

    public void setMachine(String machine) {
            this.machine = machine;
        }

    public Set<TimeTable> getTimeTables() {
            return timeTables;
        }

    public void setTimeTables(Set<TimeTable> timeTables) {
            this.timeTables = timeTables;
        }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public List<StopStations> getStopStationsList() {
        return stopStationsList;
    }

    public void setStopStationsList(List<StopStations> stopStationsList) {
        this.stopStationsList = stopStationsList;
    }

    @Override
    public String toString() {
        return "BusInfo{" +
                "id=" + id +
                ", busNumber='" + busNumber + '\'' +
                ", driverName='" + driverName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", machine='" + machine + '\'' +
                '}';
    }
}
