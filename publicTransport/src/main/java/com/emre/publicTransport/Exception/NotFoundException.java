package com.emre.publicTransport.Exception;

public abstract class NotFoundException extends RuntimeException
{
    public NotFoundException(String obj)
    {
        super(obj + " not found");
    }
    public NotFoundException(String obj, Long id)
    {
        super(obj + " " + id +" not found");
    }

}
