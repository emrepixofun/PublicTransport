package com.emre.publicTransport.Service;

import com.emre.publicTransport.Exception.RouteNotFoundException;
import com.emre.publicTransport.Model.Route;
import com.emre.publicTransport.Model.Station;
import com.emre.publicTransport.Repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RouteService
{
    private RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public Route FindById(Long routeId)
    {
        return routeRepository.findById(routeId).orElseThrow(() -> new RouteNotFoundException(routeId));
    }
    public List<Route> FindAll()
    {
        return routeRepository.findAll();
    }
    public Route Save(Route route)
    {
        if(route == null)
            throw new NullPointerException("Route is null");

        List<Station> stations = route.getStations();
        if(stations == null || stations.size() < 2)
            throw new RuntimeException("Route station size cannot be less than 2");

        Set<Long> stationIds = new HashSet<>();
        for (Station station : stations)
        {
            if (stationIds.contains(station.getStationId()))
                throw new RuntimeException("Looping stations are not permitted");

            stationIds.add(station.getStationId());
        }

        return routeRepository.save(route);
    }
    public List<Route> SaveAll(List<Route> routes)
    {
        if(routes == null)
            throw new NullPointerException("Route is null");

        List<Route> routesResult = new ArrayList<>();
        for (Route route : routes)
            routesResult.add(Save(route));

        return routesResult;
    }
    public void Delete(Long stationId)
    {
        Route route = routeRepository.findById(stationId).orElseThrow(() -> new RouteNotFoundException(stationId));

        routeRepository.delete(route);
    }

}
