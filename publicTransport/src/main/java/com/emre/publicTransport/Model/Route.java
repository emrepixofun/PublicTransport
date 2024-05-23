package com.emre.publicTransport.Model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Route implements Serializable
{
    @Id
    private Long routeId;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable (
            name="route_station",
            joinColumns={ @JoinColumn(name="route_id", referencedColumnName="routeId") },
            inverseJoinColumns={ @JoinColumn(name="station_id", referencedColumnName="stationId") }
    )
    private List<Station> stations;

    public Route() {}
    public Route(Long routeId, List<Station> stations) {
        this.routeId = routeId;
        this.stations = stations;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    @Override
    public String toString() {
        return "Route{" +
                "routeId=" + routeId +
                ", stations=" + stations +
                '}';
    }
}
