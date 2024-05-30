package com.example.restaurantreservation.domain;


import com.example.restaurantreservation.controller.ReservaController;
import com.example.restaurantreservation.dto.ReservaCreateDTO;
import com.example.restaurantreservation.dto.ReservaDTO;
import com.example.restaurantreservation.domain.ReservaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ReservaControllerTest {

    @Mock
    private ReservaService reservaService;

    @InjectMocks
    private ReservaController reservaController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(reservaController).build();
    }

    @Test
    public void testListarReservas() throws Exception {
        // Given
        ReservaDTO reserva1 = new ReservaDTO();
        reserva1.setId(1L);
        reserva1.setNombreCliente("Cliente 1");
        reserva1.setFechaHora(LocalDateTime.now());

        ReservaDTO reserva2 = new ReservaDTO();
        reserva2.setId(2L);
        reserva2.setNombreCliente("Cliente 2");
        reserva2.setFechaHora(LocalDateTime.now());

        List<ReservaDTO> reservas = Arrays.asList(reserva1, reserva2);

        when(reservaService.listarReservas()).thenReturn(reservas);

        // When/Then
        mockMvc.perform(get("/reservas"))
                .andExpect
                        (status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].nombreCliente").value("Cliente 1"))
                .andExpect(jsonPath("$[1].nombreCliente").value("Cliente 2"));

        verify(reservaService, times(1)).listarReservas();
        verifyNoMoreInteractions(reservaService);
    }

    @Test
    public void testCrearReserva() throws Exception {
        // Given
        ReservaCreateDTO reservaCreateDTO = new ReservaCreateDTO();
        reservaCreateDTO.setNombreCliente("Nuevo Cliente");
        reservaCreateDTO.setFechaHora(LocalDateTime.now());

        ReservaDTO reservaGuardada = new ReservaDTO();
        reservaGuardada.setId(3L);
        reservaGuardada.setNombreCliente("Nuevo Cliente");
        reservaGuardada.setFechaHora(LocalDateTime.now());

        when(reservaService.guardarReserva(any(ReservaCreateDTO.class))).thenReturn(reservaGuardada);

        // When/Then
        mockMvc.perform(post("/reservas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nombreCliente\": \"Nuevo Cliente\", \"fechaHora\": \"2024-06-01T12:00:00\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nombreCliente").value("Nuevo Cliente"));

        verify(reservaService, times(1)).guardarReserva(any(ReservaCreateDTO.class));
        verifyNoMoreInteractions(reservaService);
    }
}