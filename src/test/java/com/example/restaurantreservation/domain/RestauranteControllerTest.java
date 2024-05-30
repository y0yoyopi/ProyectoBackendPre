package com.example.restaurantreservation.domain;

import com.example.restaurantreservation.controller.RestauranteController;
import com.example.restaurantreservation.dto.RestauranteCreateDTO;
import com.example.restaurantreservation.dto.RestauranteDTO;
import com.example.restaurantreservation.domain.RestauranteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class RestauranteControllerTest {

    @Mock
    private RestauranteService restauranteService;

    @InjectMocks
    private RestauranteController restauranteController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(restauranteController).build();
    }

    @Test
    public void testListarRestaurantes() throws Exception {
        // Given
        RestauranteDTO restaurante1 = new RestauranteDTO();
        restaurante1.setId(1L);
        restaurante1.setNombre("Restaurante 1");
        restaurante1.setDireccion("Dirección 1");

        RestauranteDTO restaurante2 = new RestauranteDTO();
        restaurante2.setId(2L);
        restaurante2.setNombre("Restaurante 2");
        restaurante2.setDireccion("Dirección 2");

        List<RestauranteDTO> restaurantes = Arrays.asList(restaurante1, restaurante2);

        when(restauranteService.listarRestaurantes()).thenReturn(restaurantes);

        // When/Then
        mockMvc.perform(get("/restaurantes"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].nombre").value("Restaurante 1"))
                .andExpect(jsonPath("$[1].direccion").value("Dirección 2"));

        verify(restauranteService, times(1)).listarRestaurantes();
        verifyNoMoreInteractions(restauranteService);
    }

    @Test
    public void testCrearRestaurante() throws Exception {
        // Given
        RestauranteCreateDTO restauranteCreateDTO = new RestauranteCreateDTO();
        restauranteCreateDTO.setNombre("Nuevo Restaurante");
        restauranteCreateDTO.setDireccion("Nueva Dirección");

        RestauranteDTO restauranteGuardado = new RestauranteDTO();
        restauranteGuardado.setId(1L);
        restauranteGuardado.setNombre("Nuevo Restaurante");
        restauranteGuardado.setDireccion("Nueva Dirección");

        when(restauranteService.guardarRestaurante(any(RestauranteCreateDTO.class))).thenReturn(restauranteGuardado);

        // When/Then
        mockMvc.perform(post("/restaurantes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nombre\": \"Nuevo Restaurante\", \"direccion\": \"Nueva Dirección\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nombre").value("Nuevo Restaurante"))
                .andExpect(jsonPath("$.direccion").value("Nueva Dirección"));

        verify(restauranteService, times(1)).guardarRestaurante(any(RestauranteCreateDTO.class));
        verifyNoMoreInteractions(restauranteService);
    }
}