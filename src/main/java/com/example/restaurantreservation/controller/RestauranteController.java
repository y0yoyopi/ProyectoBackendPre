package com.example.restaurantreservation.controller;

import com.example.restaurantreservation.dto.RestauranteDTO;
import com.example.restaurantreservation.dto.RestauranteCreateDTO;
import com.example.restaurantreservation.domain.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {
    @Autowired
    private RestauranteService restauranteService;

    @GetMapping
    public List<RestauranteDTO> listarRestaurantes() {
        return restauranteService.listarRestaurantes();
    }

    @PostMapping
    public RestauranteDTO crearRestaurante(@RequestBody RestauranteCreateDTO restauranteCreateDTO) {
        return restauranteService.guardarRestaurante(restauranteCreateDTO);
    }
}