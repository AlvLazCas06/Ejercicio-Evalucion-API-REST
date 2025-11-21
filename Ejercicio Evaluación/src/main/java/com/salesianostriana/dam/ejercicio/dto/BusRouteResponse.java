package com.salesianostriana.dam.ejercicio.dto;

import com.salesianostriana.dam.ejercicio.model.BusRoute;

public record BusRouteResponse(
        Long id,
        String code,
        String origin,
        String target,
        int distance,
        int frecuency
) {

    public static BusRouteResponse of(BusRoute route) {
        return new BusRouteResponse(
                route.getId(),
                route.getCode(),
                route.getOrigin(),
                route.getTarget(),
                route.getDistance(),
                route.getFrecuency()
        );
    }

}
