package com.emre.publicTransport.Model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Vehicle implements Serializable
{
    @Id
    private Long vehicleId;
    private String plate;
    private String brand;
    private String model;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (
            name="route",
            referencedColumnName = "routeId"
    )
    private Route route;

    public Vehicle() {}
    public Vehicle(Long vehicleId, String plate, String brand, String model, Route route) {
        this.vehicleId = vehicleId;
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.route = route;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", plate='" + plate + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", route=" + route +
                '}';
    }

}
