package com.emre.publicTransport.Service;

import com.emre.publicTransport.Exception.VehicleNotFoundException;
import com.emre.publicTransport.Model.Station;
import com.emre.publicTransport.Model.Vehicle;
import com.emre.publicTransport.Repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService
{
    private VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository)
    {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle FindById(Long vehicleId)
    {
        return vehicleRepository.findById(vehicleId).orElseThrow(() -> new VehicleNotFoundException(vehicleId));
    }
    public List<Vehicle> FindAll()
    {
        return vehicleRepository.findAll();
    }
    public Vehicle Save(Vehicle vehicle)
    {
        if(vehicle == null)
            throw new NullPointerException("Vehicle is null");
        if(vehicle.getBrand() == null || vehicle.getBrand().trim().isEmpty())
            throw new RuntimeException("Brand should not be empty");
        if(vehicle.getModel() == null || vehicle.getModel().trim().isEmpty())
            throw new RuntimeException("Model should not be empty");
        if(vehicle.getPlate() == null || vehicle.getPlate().trim().isEmpty())
            throw new RuntimeException("Plate should not be empty");

        return vehicleRepository.save(vehicle);
    }
    public List<Vehicle> SaveAll(List<Vehicle> vehicles)
    {
        if(vehicles == null)
            throw new NullPointerException("Vehicle is null");

        List<Vehicle> vehiclesResult = new ArrayList<>();
        for (Vehicle vehicle : vehicles)
            vehiclesResult.add(Save(vehicle));

        return vehiclesResult;
    }
    public void Delete(Long vehicleId)
    {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(() -> new VehicleNotFoundException(vehicleId));

        vehicleRepository.delete(vehicle);
    }

}
