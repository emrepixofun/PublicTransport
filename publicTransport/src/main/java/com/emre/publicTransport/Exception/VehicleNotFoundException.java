package com.emre.publicTransport.Exception;

public class VehicleNotFoundException extends NotFoundException
{
    public VehicleNotFoundException()
    {
        super("Vehicle");
    }
    public VehicleNotFoundException(Long id)
    {
        super("Vehicle", id);
    }

}
