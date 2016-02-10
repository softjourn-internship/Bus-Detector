package com.bus.detector.route.domain;

import com.bus.detector.bus.domain.BusInfo;

import javax.persistence.*;
import java.sql.Time;

/**
 * by Mr Skip on 08.02.2016.
 */

@Entity
public class TimeTable {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idBusInfo")
    private BusInfo busInfo;

    private String day;
    private Time beginWork;
    private Time endWork;

    public TimeTable(){}

    public TimeTable(String day,
                     Time beginWork, Time endWork){
        this.day = day;
        this.beginWork = beginWork;
        this.endWork = endWork;
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

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Time getBeginWork() {
        return beginWork;
    }

    public void setBeginWork(Time beginWork) {
        this.beginWork = beginWork;
    }

    public Time getEndWork() {
        return endWork;
    }

    public void setEndWork(Time endWork) {
        this.endWork = endWork;
    }

    @Override
    public String toString() {
        return "TimeTable{" +
                "id=" + id +
                ", idBusNumber=" + busInfo.getBusNumber() +
                ", day='" + day + '\'' +
                ", beginWork=" + beginWork +
                ", endWork=" + endWork +
                '}';
    }
}
