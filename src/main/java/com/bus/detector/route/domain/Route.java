package com.bus.detector.route.domain;

import com.bus.detector.bus.domain.BusInfo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * by Mr Skip on 08.02.2016.
 */
@Entity
public class Route {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idBusInfo")
    private BusInfo busInfo;

    private String streetName;
    private String startCoordinate;
    private String endCoordinate;

    @ManyToMany
    @JoinTable(
            name = "route_stop_stations",
            joinColumns = {@JoinColumn(name = "route_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "stop_stations_id", referencedColumnName = "id")}
            )
    private Set<StopStations> stopStations = new HashSet<>();

    public Route() {}

    public Route(String streetName,
                 String startCoordinate, String endCoordinate){
        this.streetName = streetName;
        this.startCoordinate = startCoordinate;
        this.endCoordinate = endCoordinate;
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

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStartCoordinate() {
        return startCoordinate;
    }

    public void setStartCoordinate(String startCoordinate) {
        this.startCoordinate = startCoordinate;
    }

    public String getEndCoordinate() {
        return endCoordinate;
    }

    public void setEndCoordinate(String endCoordinate) {
        this.endCoordinate = endCoordinate;
    }

    public Set<StopStations> getStopStations() {
        return stopStations;
    }

    public void setStopStations(Set<StopStations> stopStations) {
        this.stopStations = stopStations;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", busNumber=" + busInfo.getBusNumber() +
                ", streetName='" + streetName + '\'' +
                ", startCoordinate='" + startCoordinate + '\'' +
                ", endCoordinate='" + endCoordinate + '\'' +
                '}';
    }
}
