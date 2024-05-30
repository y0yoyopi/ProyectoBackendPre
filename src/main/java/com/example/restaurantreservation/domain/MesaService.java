package com.example.restaurantreservation.domain;

import com.example.restaurantreservation.dto.MesaDTO;
import com.example.restaurantreservation.dto.MesaCreateDTO;
import com.example.restaurantreservation.repository.MesaRepository;
import com.example.restaurantreservation.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MesaService {
    @Autowired
    private MesaRepository mesaRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    public List<MesaDTO> listarMesas() {
        return mesaRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public MesaDTO guardarMesa(MesaCreateDTO mesaCreateDTO) {
        Mesa mesa = new Mesa();
        mesa.setNumero(mesaCreateDTO.getNumero());
        mesa.setCapacidad(mesaCreateDTO.getCapacidad());
        Restaurante restaurante = restauranteRepository.findById(mesaCreateDTO.getRestauranteId()).orElseThrow();
        mesa.setRestaurante(restaurante);
        Mesa savedMesa = mesaRepository.save(mesa);
        return convertToDTO(savedMesa);
    }

    private MesaDTO convertToDTO(Mesa mesa) {
        MesaDTO mesaDTO = new MesaDTO();
        mesaDTO.setId(mesa.getId());
        mesaDTO.setNumero(mesa.getNumero());
        mesaDTO.setCapacidad(mesa.getCapacidad());
        mesaDTO.setRestauranteId(mesa.getRestaurante().getId());
        return mesaDTO;
    }
}