package com.example.restaurantreservation.domain;

import com.example.restaurantreservation.dto.ReservaDTO;
import com.example.restaurantreservation.dto.ReservaCreateDTO;
import com.example.restaurantreservation.repository.ReservaRepository;
import com.example.restaurantreservation.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private MesaRepository mesaRepository;

    public List<ReservaDTO> listarReservas() {
        return reservaRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ReservaDTO guardarReserva(ReservaCreateDTO reservaCreateDTO) {
        Reserva reserva = new Reserva();
        reserva.setNombreCliente(reservaCreateDTO.getNombreCliente());
        reserva.setFechaHora(reservaCreateDTO.getFechaHora());
        Mesa mesa = mesaRepository.findById(reservaCreateDTO.getMesaId()).orElseThrow();
        reserva.setMesa(mesa);
        Reserva savedReserva = reservaRepository.save(reserva);
        return convertToDTO(savedReserva);
    }

    private ReservaDTO convertToDTO(Reserva reserva) {
        ReservaDTO reservaDTO = new ReservaDTO();
        reservaDTO.setId(reserva.getId());
        reservaDTO.setNombreCliente(reserva.getNombreCliente());
        reservaDTO.setFechaHora(reserva.getFechaHora());
        reservaDTO.setMesaId(reserva.getMesa().getId());
        return reservaDTO;
    }
}