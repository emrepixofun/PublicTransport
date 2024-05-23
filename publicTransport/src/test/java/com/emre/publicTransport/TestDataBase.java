package com.emre.publicTransport;

import com.emre.publicTransport.Model.Route;
import com.emre.publicTransport.Model.Station;
import com.emre.publicTransport.Model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class TestDataBase
{
    protected List<Station> getMockStation1()
    {
        List<Station> stations = new ArrayList<>();
        Station station1 = new Station(1L, "Kızılay");
        Station station2 = new Station(2L, "Milli Kütüphane");
        Station station3 = new Station(3L, "ODTÜ");
        stations.add(station1);
        stations.add(station2);
        stations.add(station3);

        return stations;
    }
    protected List<Station> getMockStation2()
    {
        List<Station> stations = new ArrayList<>();
        Station station1 = new Station(4L, "AŞTİ");
        Station station2 = new Station(5L, "Maltepe");
        Station station3 = new Station(6L, "Demirtepe");
        stations.add(station1);
        stations.add(station2);
        stations.add(station3);

        return stations;
    }
    protected List<Station> getMockStations()
    {
        List<Station> stations = new ArrayList<>();
        stations.addAll(getMockStation1());
        stations.addAll(getMockStation2());

        return stations;
    }

    protected Route getMockRoute1()
    {
        return new Route(1L, getMockStation1());
    }
    protected Route getMockRoute2()
    {
        return new Route(2L, getMockStation2());
    }
    protected List<Route> getMockRoutes()
    {
        List<Route> routes = new ArrayList<>();
        Route route1 = getMockRoute1();
        Route route2 = getMockRoute2();
        routes.add(route1);
        routes.add(route2);

        return routes;
    }

    protected Vehicle getMockVehicle1()
    {
        return new Vehicle(1L, "06J001", "Mercedes", "1995", getMockRoute1());
    }
    protected Vehicle getMockVehicle2()
    {
        return new Vehicle(2L, "06J002", "Mercedes", "1993", getMockRoute2());
    }
    protected List<Vehicle> getMockVehicles()
    {
        List<Vehicle> vehicles = new ArrayList<>();
        Vehicle vehicle1 = getMockVehicle1();
        Vehicle vehicle2 = getMockVehicle2();
        vehicles.add(vehicle1);
        vehicles.add(vehicle2);

        return vehicles;
    }
}
