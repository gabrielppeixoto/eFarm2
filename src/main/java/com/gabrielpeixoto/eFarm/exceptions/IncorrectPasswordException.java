package com.gabrielpeixoto.eFarm.exceptions;

public class IncorrectPasswordException extends RuntimeException{
    public IncorrectPasswordException()
    {
        super("Senha incorreta!");
    }
}
