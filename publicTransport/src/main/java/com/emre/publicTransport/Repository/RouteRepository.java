package com.emre.publicTransport.Repository;

import com.emre.publicTransport.Model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long>
{

}