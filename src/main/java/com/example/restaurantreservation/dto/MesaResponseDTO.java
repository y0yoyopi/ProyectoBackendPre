package com.example.restaurantreservation.dto;

public class MesaResponseDTO {
    private Long id;
    private int numero;
    private int capacidad;
    private RestauranteResponseDTO restaurante;

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public RestauranteResponseDTO getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(RestauranteResponseDTO restaurante) {
        this.restaurante = restaurante;
    }
}