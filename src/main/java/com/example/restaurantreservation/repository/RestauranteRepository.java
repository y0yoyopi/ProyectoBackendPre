package com.example.restaurantreservation.repository;

import com.example.restaurantreservation.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
    // Puedes definir métodos de consulta personalizados aquí si es necesario
}