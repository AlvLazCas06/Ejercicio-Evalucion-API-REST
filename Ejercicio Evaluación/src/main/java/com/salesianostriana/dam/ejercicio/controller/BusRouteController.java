package com.salesianostriana.dam.ejercicio.controller;

import com.salesianostriana.dam.ejercicio.dto.BusRouteResponse;
import com.salesianostriana.dam.ejercicio.dto.CreateBusRouteCmd;
import com.salesianostriana.dam.ejercicio.exception.BusRouteNotFoundException;
import com.salesianostriana.dam.ejercicio.exception.InvalidBusRouteDataException;
import com.salesianostriana.dam.ejercicio.service.BusRouteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus-route")
@RequiredArgsConstructor
@Tag(name = "Ruta Bus", description = "Comprueba las rutas de autobuses")
public class BusRouteController {

    private final BusRouteService service;

    @Operation(summary = "Observa todas las rutas de autobuses que hay presentes")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Se han mostrado correctamente todas las rutas",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = BusRouteResponse.class)),
                            examples = @ExampleObject("""
                                    [
                                        {
                                        
                                        }
                                    ]
                                    """)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "No hay rutas presentes",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = BusRouteNotFoundException.class),
                            examples = @ExampleObject("""
                                    [
                                        {
                                        
                                        }
                                    ]
                                    """)
                    )
            )
    })
    @GetMapping
    public List<BusRouteResponse> findAll() {
        return service.findAll()
                .stream()
                .map(BusRouteResponse::of)
                .toList();
    }

    @Operation(summary = "Guarda una ruta de autobús")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Se han guardado correctamente la ruta",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = BusRouteResponse.class),
                            examples = @ExampleObject("""
                                    [
                                        {
                                        
                                        }
                                    ]
                                    """)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "No existe esa ruta",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = InvalidBusRouteDataException.class),
                            examples = @ExampleObject("""
                                    
                                        {
                                        
                                        }
                                    
                                    """)
                    )
            )
    })
    @PostMapping
    public ResponseEntity<BusRouteResponse> save(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, description = "Cuerpo de la entidad",content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = CreateBusRouteCmd.class)
            ))
            @RequestBody CreateBusRouteCmd cmd
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(BusRouteResponse.of(service.save(cmd)));
    }

    @Operation(summary = "Observa una ruta de autobús")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Se han mostrado correctamente la ruta",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = BusRouteResponse.class),
                            examples = @ExampleObject("""
                                    [
                                        {
                                        
                                        }
                                    ]
                                    """)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "No existe esa ruta",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = BusRouteNotFoundException.class),
                            examples = @ExampleObject("""
                                    [
                                        {
                                        
                                        }
                                    ]
                                    """)
                    )
            )
    })
    @GetMapping("/{id:[0-9]+}")
    public BusRouteResponse findById(@PathVariable Long id) {
        return BusRouteResponse.of(service.findById(id));
    }

    @Operation(summary = "Edita una ruta de autobús")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Se han editado correctamente la ruta",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = BusRouteResponse.class),
                            examples = @ExampleObject("""
                                    
                                        {
                                        
                                        }
                                    
                                    """)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "No existe esa ruta",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = InvalidBusRouteDataException.class),
                            examples = @ExampleObject("""
                                    [
                                        {
                                        
                                        }
                                    ]
                                    """)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "No existe esa ruta",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = BusRouteNotFoundException.class),
                            examples = @ExampleObject("""
                                    [
                                        {
                                        
                                        }
                                    ]
                                    """)
                    )
            )
    })
    @PutMapping("/{id:[0-9]+}")
    public ResponseEntity<BusRouteResponse> edit(
            @Parameter(name = "ID", description = "Id de la ruta", required = true)
            @PathVariable Long id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, description = "Cuerpo de la entidad",content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = CreateBusRouteCmd.class)
            ))
            @RequestBody CreateBusRouteCmd cmd) {
        return ResponseEntity.ok(BusRouteResponse.of(service.edit(id, cmd)));
    }

    @Operation(summary = "Eliminar una ruta de autobús")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "Se han eliminado correctamente la ruta",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = BusRouteResponse.class),
                            examples = @ExampleObject("""
                                    
                                        {
                                        
                                        }
                                    
                                    """)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "No existe esa ruta",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = BusRouteNotFoundException.class),
                            examples = @ExampleObject("""
                                    
                                        {
                                        
                                        }
                                    
                                    """)
                    )
            )
    })
    @DeleteMapping("/{id:[0-9]+}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
