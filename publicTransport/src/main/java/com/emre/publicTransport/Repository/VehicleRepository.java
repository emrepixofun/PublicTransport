package com.emre.publicTransport.Repository;

import com.emre.publicTransport.Model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>
{

}
