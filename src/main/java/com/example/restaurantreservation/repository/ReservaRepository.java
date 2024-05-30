package com.example.restaurantreservation.repository;

import com.example.restaurantreservation.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    // Puedes definir métodos de consulta personalizados aquí si es necesario
}