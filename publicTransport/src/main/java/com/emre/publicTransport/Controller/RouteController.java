package com.emre.publicTransport.Controller;

import com.emre.publicTransport.Core.LogManager;
import com.emre.publicTransport.Model.Route;
import com.emre.publicTransport.Model.Station;
import com.emre.publicTransport.Service.RouteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/route")
public class RouteController
{
    private RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping("/Save")
    public ResponseEntity<Route> Save(@RequestBody Route request)
    {
        LogManager.getSingleton().Log("RouteController (Save) Called: " + request.toString());

        Route route = routeService.Save(request);

        LogManager.getSingleton().Log("RouteController (Save) Responded: " + route.toString());

        return new ResponseEntity<>(route, HttpStatus.OK);
    }
    @PostMapping("/SaveAll")
    public ResponseEntity<List<Route>> Save(@RequestBody List<Route> request)
    {
        StringBuilder requestTS = new StringBuilder();
        for(int i = 0 ; i < request.size() ; i++)
            requestTS.append(request.get(i).toString());

        LogManager.getSingleton().Log("RouteController (SaveAll) Called: " + requestTS.toString());

        List<Route> routes = routeService.SaveAll(request);

        StringBuilder responseTS = new StringBuilder();
        for(int i = 0 ; i < routes.size() ; i++)
            responseTS.append(routes.get(i).toString());
        LogManager.getSingleton().Log("RouteController (SaveAll) Responded: " + responseTS.toString());

        return new ResponseEntity<>(routes, HttpStatus.OK);
    }
    @DeleteMapping("/Delete")
    public ResponseEntity<Boolean> Delete(@RequestParam("routeId") Long routeId)
    {
        LogManager.getSingleton().Log("RouteController (Delete) Called: " + routeId);

        routeService.Delete(routeId);

        LogManager.getSingleton().Log("RouteController (Delete) Responded: " + true);

        return new ResponseEntity<>(true, HttpStatus.OK);
    }
    @GetMapping("/FindAll")
    public ResponseEntity<List<Route>> Get()
    {
        LogManager.getSingleton().Log("RouteController (FindAll) Called");

        ResponseEntity<List<Route>> response = new ResponseEntity(routeService.FindAll(), HttpStatus.OK);

        LogManager.getSingleton().Log("RouteController (FindAll) Responded: " + response.toString());

        return response;
    }
    @GetMapping("/FindById")
    public ResponseEntity<Route> Get(@RequestParam("routeId") Long routeId)
    {
        LogManager.getSingleton().Log("RouteController (FindById) Called: " + routeId);

        ResponseEntity<Route> response = new ResponseEntity(routeService.FindById(routeId), HttpStatus.OK);

        LogManager.getSingleton().Log("RouteController (FindById) Responded: " + response.toString());

        return response;
    }

}
