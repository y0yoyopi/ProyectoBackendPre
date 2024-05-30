package com.example.restaurantreservation.domain;

import com.example.restaurantreservation.domain.RestauranteService;
import com.example.restaurantreservation.dto.RestauranteDTO;
import com.example.restaurantreservation.dto.RestauranteCreateDTO;
import com.example.restaurantreservation.domain.Restaurante;
import com.example.restaurantreservation.repository.RestauranteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RestauranteServiceTest {

    @Mock
    private RestauranteRepository restauranteRepository;

    @InjectMocks
    private RestauranteService restauranteService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testListarRestaurantes() {
        // Given
        Restaurante restaurante1 = new Restaurante();
        restaurante1.setId(1L);
        restaurante1.setNombre("Restaurante 1");
        restaurante1.setDireccion("Dirección 1");

        Restaurante restaurante2 = new Restaurante();
        restaurante2.setId(2L);
        restaurante2.setNombre("Restaurante 2");
        restaurante2.setDireccion("Dirección 2");

        when(restauranteRepository.findAll()).thenReturn(Arrays.asList(restaurante1, restaurante2));

        // When
        List<RestauranteDTO> restaurantes = restauranteService.listarRestaurantes();

        // Then
        assertEquals(2, restaurantes.size());
        assertEquals("Restaurante 1", restaurantes.get(0).getNombre());
        assertEquals("Dirección 2", restaurantes.get(1).getDireccion());
    }

    @Test
    public void testGuardarRestaurante() {
        // Given
        RestauranteCreateDTO restauranteCreateDTO = new RestauranteCreateDTO();
        restauranteCreateDTO.setNombre("Nuevo Restaurante");
        restauranteCreateDTO.setDireccion("Nueva Dirección");

        Restaurante restaurante = new Restaurante();
        restaurante.setId(1L);
        restaurante.setNombre("Nuevo Restaurante");
        restaurante.setDireccion("Nueva Dirección");

        when(restauranteRepository.save(any(Restaurante.class))).thenReturn(restaurante);

        // When
        RestauranteDTO restauranteGuardado = restauranteService.guardarRestaurante(restauranteCreateDTO);

        // Then
        assertEquals("Nuevo Restaurante", restauranteGuardado.getNombre());
        assertEquals("Nueva Dirección", restauranteGuardado.getDireccion());
    }
}