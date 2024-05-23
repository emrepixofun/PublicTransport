package com.emre.publicTransport.Controller;

import com.emre.publicTransport.Core.LogManager;
import com.emre.publicTransport.Model.Route;
import com.emre.publicTransport.Model.Vehicle;
import com.emre.publicTransport.Service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/vehicle")
public class VehicleController
{
    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/Save")
    public ResponseEntity<Vehicle> Save(@RequestBody Vehicle request)
    {
        LogManager.getSingleton().Log("VehicleController (Save) Called: " + request.toString());

        Vehicle vehicle = vehicleService.Save(request);

        LogManager.getSingleton().Log("VehicleController (Save) Responded: " + vehicle.toString());

        return new ResponseEntity<>(vehicle, HttpStatus.OK);
    }
    @PostMapping("/SaveAll")
    public ResponseEntity<List<Vehicle>> Save(@RequestBody List<Vehicle> request)
    {
        StringBuilder requestTS = new StringBuilder();
        for(int i = 0 ; i < request.size() ; i++)
            requestTS.append(request.get(i).toString());

        LogManager.getSingleton().Log("VehicleController (SaveAll) Called: " + requestTS.toString());

        List<Vehicle> vehicles = vehicleService.SaveAll(request);

        StringBuilder responseTS = new StringBuilder();
        for(int i = 0 ; i < vehicles.size() ; i++)
            responseTS.append(vehicles.get(i).toString());
        LogManager.getSingleton().Log("VehicleController (SaveAll) Responded: " + responseTS.toString());

        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }
    @DeleteMapping("/Delete")
    public ResponseEntity<Boolean> Delete(@RequestParam("vehicleId") Long vehicleId)
    {
        LogManager.getSingleton().Log("VehicleController (Delete) Called: " + vehicleId);

        vehicleService.Delete(vehicleId);

        LogManager.getSingleton().Log("VehicleController (Delete) Responded: " + true);

        return new ResponseEntity<>(true, HttpStatus.OK);
    }
    @GetMapping("/FindAll")
    public ResponseEntity<List<Vehicle>> Get()
    {
        LogManager.getSingleton().Log("VehicleController (FindAll) Called");

        ResponseEntity<List<Vehicle>> response = new ResponseEntity(vehicleService.FindAll(), HttpStatus.OK);

        LogManager.getSingleton().Log("VehicleController (FindAll) Responded: " + response.toString());

        return response;
    }
    @GetMapping("/FindById")
    public ResponseEntity<Vehicle> Get(@RequestParam("vehicleId") Long vehicleId)
    {
        LogManager.getSingleton().Log("VehicleController (FindById) Called: " + vehicleId);

        ResponseEntity<Vehicle> response = new ResponseEntity(vehicleService.FindById(vehicleId), HttpStatus.OK);

        LogManager.getSingleton().Log("VehicleController (FindById) Responded: " + response.toString());

        return response;
    }

}
