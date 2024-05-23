package com.emre.publicTransport.Controller;

import com.emre.publicTransport.Core.LogManager;
import com.emre.publicTransport.Model.Route;
import com.emre.publicTransport.Model.Station;
import com.emre.publicTransport.Model.Vehicle;
import com.emre.publicTransport.Service.StationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/station")
public class StationController
{
    private StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @PostMapping("/Save")
    public ResponseEntity<Station> Save(@RequestBody Station request)
    {
        LogManager.getSingleton().Log("StationController (Save) Called: " + request.toString());

        Station station = stationService.Save(request);

        LogManager.getSingleton().Log("StationController (Save) Responded: " + station.toString());

        return new ResponseEntity<>(station, HttpStatus.OK);
    }
    @PostMapping("/SaveAll")
    public ResponseEntity<List<Station>> Save(@RequestBody List<Station> request)
    {
        StringBuilder requestTS = new StringBuilder();
        for(int i = 0 ; i < request.size() ; i++)
            requestTS.append(request.get(i).toString());

        LogManager.getSingleton().Log("StationController (SaveAll) Called: " + requestTS.toString());

        List<Station> stations = stationService.SaveAll(request);

        StringBuilder responseTS = new StringBuilder();
        for(int i = 0 ; i < stations.size() ; i++)
            responseTS.append(stations.get(i).toString());
        LogManager.getSingleton().Log("StationController (SaveAll) Responded: " + responseTS.toString());

        return new ResponseEntity<>(stations, HttpStatus.OK);
    }
    @DeleteMapping("/Delete")
    public ResponseEntity<Boolean> Delete(@RequestParam("stationId") Long stationId)
    {
        LogManager.getSingleton().Log("StationController (Delete) Called: " + stationId);

        stationService.Delete(stationId);

        LogManager.getSingleton().Log("StationController (Delete) Responded: " + true);

        return new ResponseEntity<>(true, HttpStatus.OK);
    }
    @GetMapping("/FindAll")
    public ResponseEntity<List<Station>> Get()
    {
        LogManager.getSingleton().Log("StationController (FindAll) Called");

        ResponseEntity<List<Station>> response = new ResponseEntity(stationService.FindAll(), HttpStatus.OK);

        LogManager.getSingleton().Log("StationController (FindAll) Responded: " + response.toString());

        return response;
    }
    @GetMapping("/FindById")
    public ResponseEntity<Station> Get(@RequestParam("stationId") Long stationId)
    {
        LogManager.getSingleton().Log("StationController (FindById) Called: " + stationId);

        ResponseEntity<Station> response = new ResponseEntity(stationService.FindById(stationId), HttpStatus.OK);

        LogManager.getSingleton().Log("StationController (FindById) Responded: " + response.toString());

        return response;
    }

}
