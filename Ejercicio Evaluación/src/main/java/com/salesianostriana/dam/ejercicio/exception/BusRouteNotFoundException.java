package com.salesianostriana.dam.ejercicio.exception;

public class BusRouteNotFoundException extends RuntimeException {
    public BusRouteNotFoundException(String message) {
        super(message);
    }

    public BusRouteNotFoundException() {
        super("No se ha encontrado ninguna ruta de autobuses");
    }

    public BusRouteNotFoundException(Long id) {
        super("La ruta de autobús con id: %d, no existe".formatted(id));
    }
}
