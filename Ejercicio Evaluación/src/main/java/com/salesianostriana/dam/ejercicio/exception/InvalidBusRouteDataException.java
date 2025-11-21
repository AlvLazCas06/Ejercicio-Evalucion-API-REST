package com.salesianostriana.dam.ejercicio.exception;

public class InvalidBusRouteDataException extends RuntimeException {
    public InvalidBusRouteDataException(String message) {
        super(message);
    }

    public InvalidBusRouteDataException() {
        super("El/los parámetro/s introducidos no son validos");
    }
}
