package com.bus.detector.data.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * by Mr Skip on 08.02.2016.
 */
@Entity
public class StopStations {
    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String coordinate;

    @ManyToMany
    private Set<Route> routes = new HashSet<>();

    public StopStations() {}

    public StopStations(int id, String name, String coordinate) {
        this.id = id;
        this.name = name;
        this.coordinate = coordinate;
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

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public String toString() {
        return "StopStations{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinate='" + coordinate + '\'' +
                '}';
    }
}
