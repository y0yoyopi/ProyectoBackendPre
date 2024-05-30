package com.example.restaurantreservation.controller;

import com.example.restaurantreservation.dto.ReservaDTO;
import com.example.restaurantreservation.dto.ReservaCreateDTO;
import com.example.restaurantreservation.domain.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public List<ReservaDTO> listarReservas() {
        return reservaService.listarReservas();
    }

    @PostMapping
    public ReservaDTO crearReserva(@RequestBody ReservaCreateDTO reservaCreateDTO) {
        return reservaService.guardarReserva(reservaCreateDTO);
    }
}