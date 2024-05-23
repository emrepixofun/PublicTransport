package com.emre.publicTransport.Service;

import com.emre.publicTransport.Exception.StationNotFoundException;
import com.emre.publicTransport.Model.Station;
import com.emre.publicTransport.Repository.StationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StationService
{
    private StationRepository stationRepository;

    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public Station FindById(Long stationId)
    {
        return stationRepository.findById(stationId).orElseThrow(() -> new StationNotFoundException(stationId));
    }
    public List<Station> FindAll()
    {
        return stationRepository.findAll();
    }
    public Station Save(Station station)
    {
        if(station == null)
            throw new NullPointerException("Station is null");

        return stationRepository.save(station);
    }
    public List<Station> SaveAll(List<Station> stations)
    {
        if(stations == null)
            throw new NullPointerException("Station is null");

        List<Station> stationsResult = new ArrayList<>();
        for (Station station : stations)
            stationsResult.add(Save(station));

        return stationsResult;
    }
    public void Delete(Long stationId)
    {
        Station station = stationRepository.findById(stationId).orElseThrow(() -> new StationNotFoundException(stationId));

        stationRepository.delete(station);
    }

}
