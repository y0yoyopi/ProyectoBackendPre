package com.example.restaurantreservation.controller;

import com.example.restaurantreservation.dto.MesaDTO;
import com.example.restaurantreservation.dto.MesaCreateDTO;
import com.example.restaurantreservation.domain.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesas")
public class MesaController {
    @Autowired
    private MesaService mesaService;

    @GetMapping
    public List<MesaDTO> listarMesas() {
        return mesaService.listarMesas();
    }

    @PostMapping
    public MesaDTO crearMesa(@RequestBody MesaCreateDTO mesaCreateDTO) {
        return mesaService.guardarMesa(mesaCreateDTO);
    }
}