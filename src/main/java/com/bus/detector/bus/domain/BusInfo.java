package com.bus.detector.bus.domain;

import com.bus.detector.route.domain.Route;
import com.bus.detector.route.domain.TimeTable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * by Mr Skip on 10.02.2016.
 */

@Entity
public class BusInfo {
    @Id
    @GeneratedValue
    private int id;

    private String busNumber;
    private String driverName;
    private String phoneNumber;
    private String machine;

    @OneToMany(targetEntity = TimeTable.class)
    private Set<TimeTable> timeTables = new HashSet<>();

    @OneToMany(targetEntity = Route.class)
    private Set<Route> routes = new HashSet<>();

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

    public Set<Route> getRoutes() {
            return routes;
        }

    public void setRoutes(Set<Route> routes) {
            this.routes = routes;
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
