package com.salesianostriana.dam.ejercicio.errors;

import com.salesianostriana.dam.ejercicio.exception.BusRouteNotFoundException;
import com.salesianostriana.dam.ejercicio.exception.InvalidBusRouteDataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(BusRouteNotFoundException.class)
    public ProblemDetail handleBusRouteNotFoundException(BusRouteNotFoundException ex) {
        ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        pd.setTitle("Ruta no encontrada");
        pd.setType(URI.create("https://dam.salesianos-triana.com/bus-route-not-found"));
        return pd;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidBusRouteDataException.class)
    public ProblemDetail handleInvalidBusRouteDataException(InvalidBusRouteDataException ex) {
        ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
        pd.setTitle("Parámetros Inválidos");
        pd.setType(URI.create("https://dam.salesianos-triana.com/bus-route-not-found"));
        return pd;
    }

}
