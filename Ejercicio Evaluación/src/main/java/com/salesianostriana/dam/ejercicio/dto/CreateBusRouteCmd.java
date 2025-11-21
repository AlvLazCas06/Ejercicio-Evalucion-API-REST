package com.salesianostriana.dam.ejercicio.dto;

import com.salesianostriana.dam.ejercicio.model.BusRoute;

public record CreateBusRouteCmd(
        String code,
        String origin,
        String target,
        int distance,
        int frecuency
) {

    public static BusRoute toEntity(CreateBusRouteCmd cmd) {
        return BusRoute.builder()
                .code(cmd.code)
                .origin(cmd.origin)
                .target(cmd.target)
                .distance(cmd.distance)
                .frecuency(cmd.frecuency)
                .build();
    }

}
