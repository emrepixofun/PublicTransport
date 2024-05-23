package com.emre.publicTransport.Repository;

import com.emre.publicTransport.Model.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, Long>
{

}