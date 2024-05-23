package com.emre.publicTransport.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Station implements Serializable
{
    @Id
    private Long stationId;
    private String name;

    public Station() {}
    public Station(Long stationId, String name) {
        this.stationId = stationId;
        this.name = name;
    }

    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Station{" +
                "stationId=" + stationId +
                ", name='" + name + '\'' +
                '}';
    }
}
