package com.spa.userservice.UserService.Exceptions;

public class ResourceNotFoundException extends  RuntimeException{
    public  ResourceNotFoundException()
    {
        super("Resource not found for the given request!!");
    }
    public  ResourceNotFoundException(String Message)
    {
        super(Message);
    }
}
