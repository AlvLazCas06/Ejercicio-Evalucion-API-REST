package com.salesianostriana.dam.ejercicio.service;

import com.salesianostriana.dam.ejercicio.dto.CreateBusRouteCmd;
import com.salesianostriana.dam.ejercicio.exception.BusRouteNotFoundException;
import com.salesianostriana.dam.ejercicio.exception.InvalidBusRouteDataException;
import com.salesianostriana.dam.ejercicio.model.BusRoute;
import com.salesianostriana.dam.ejercicio.repository.BusRouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BusRouteService {

    private final BusRouteRepository repository;

    public BusRoute save(CreateBusRouteCmd cmd) {
        BusRoute busRoute = CreateBusRouteCmd.toEntity(cmd);
        if (!StringUtils.hasText(busRoute.getCode())) {
            throw new InvalidBusRouteDataException();
        }
        return repository.save(busRoute);
    }

    public List<BusRoute> findAll() {
        List<BusRoute> results = repository.findAll();
        if (results.isEmpty()) {
            throw new BusRouteNotFoundException();
        }
        return results;
    }

    public BusRoute edit(Long id, CreateBusRouteCmd cmd) {
        BusRoute busRoute = CreateBusRouteCmd.toEntity(cmd);
        if (!StringUtils.hasText(busRoute.getCode())) {
            throw new InvalidBusRouteDataException();
        }
        if (repository.findById(id).isEmpty()) {
            throw new BusRouteNotFoundException(id);
        }
        busRoute.setId(id);
        return repository.save(busRoute);
    }

    public BusRoute findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new BusRouteNotFoundException(id));
    }

    public void delete(Long id) {
        BusRoute busRoute = repository.findById(id)
                .orElseThrow(() -> new BusRouteNotFoundException(id));
        repository.delete(busRoute);
    }

}
