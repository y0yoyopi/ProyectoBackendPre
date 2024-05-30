package com.example.restaurantreservation.domain;

import com.example.restaurantreservation.dto.RestauranteDTO;
import com.example.restaurantreservation.dto.RestauranteCreateDTO;
import com.example.restaurantreservation.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestauranteService {
    @Autowired
    private RestauranteRepository restauranteRepository;

    public List<RestauranteDTO> listarRestaurantes() {
        return restauranteRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public RestauranteDTO guardarRestaurante(RestauranteCreateDTO restauranteCreateDTO) {
        Restaurante restaurante = new Restaurante();
        restaurante.setNombre(restauranteCreateDTO.getNombre());
        restaurante.setDireccion(restauranteCreateDTO.getDireccion());
        Restaurante savedRestaurante = restauranteRepository.save(restaurante);
        return convertToDTO(savedRestaurante);
    }

    private RestauranteDTO convertToDTO(Restaurante restaurante) {
        RestauranteDTO restauranteDTO = new RestauranteDTO();
        restauranteDTO.setId(restaurante.getId());
        restauranteDTO.setNombre(restaurante.getNombre());
        restauranteDTO.setDireccion(restaurante.getDireccion());
        return restauranteDTO;
    }
}
