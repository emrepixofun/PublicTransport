package com.emre.publicTransport.Exception;

public class StationNotFoundException extends NotFoundException
{
    public StationNotFoundException()
    {
        super("Station");
    }
    public StationNotFoundException(Long id)
    {
        super("Station", id);
    }
}
