package com.example.restaurantreservation.repository;

import com.example.restaurantreservation.model.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Long> {
    // Puedes definir métodos de consulta personalizados aquí si es necesario
}