package com.example.restaurantreservation.domain;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
/*
    private String nombre;
    private String area;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    // Método para asociar un restaurante al manager
    public void asociarRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    // Método para desasociar un restaurante del manager
    public void desasociarRestaurante() {
        this.restaurante = null;
    }

    // Método para ver las reservas de su restaurante
    public List<Reserva> verReservas() {
        if (restaurante != null) {
            return restaurante.getReservas();
        } else {
            // Manejar el caso donde el manager no tiene restaurante asociado
            return null;
        }
    }*/
}