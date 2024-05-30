package com.example.restaurantreservation.dto;

import java.time.LocalDateTime;

public class ReservaResponseDTO {
    private Long id;
    private String nombreCliente;
    private LocalDateTime fechaHora;
    private MesaResponseDTO mesa;

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public MesaResponseDTO getMesa() {
        return mesa;
    }

    public void setMesa(MesaResponseDTO mesa) {
        this.mesa = mesa;
    }
}