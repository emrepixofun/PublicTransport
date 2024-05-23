package com.emre.publicTransport.Exception;

public class RouteNotFoundException extends NotFoundException
{
    public RouteNotFoundException()
    {
        super("Route");
    }
    public RouteNotFoundException(Long id)
    {
        super("Route", id);
    }

}
