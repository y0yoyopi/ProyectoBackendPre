package com.example.restaurantreservation.domain;


import com.example.restaurantreservation.controller.MesaController;
import com.example.restaurantreservation.dto.MesaCreateDTO;
import com.example.restaurantreservation.dto.MesaDTO;
import com.example.restaurantreservation.domain.MesaService;
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

public class MesaControllerTest {

    @Mock
    private MesaService mesaService;

    @InjectMocks
    private MesaController mesaController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(mesaController).build();
    }

    @Test
    public void testListarMesas() throws Exception {
        // Given
        MesaDTO mesa1 = new MesaDTO();
        mesa1.setId(1L);
        mesa1.setNumero(1);
        mesa1.setCapacidad(4);

        MesaDTO mesa2 = new MesaDTO();
        mesa2.setId(2L);
        mesa2.setNumero(2);
        mesa2.setCapacidad(6);

        List<MesaDTO> mesas = Arrays.asList(mesa1, mesa2);

        when(mesaService.listarMesas()).thenReturn(mesas);

        // When/Then
        mockMvc.perform(get("/mesas"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].numero").value(1))
                .andExpect(jsonPath("$[1].capacidad").value(6));

        verify(mesaService, times(1)).listarMesas();
        verifyNoMoreInteractions(mesaService);
    }

    @Test
    public void testCrearMesa() throws Exception {
        // Given
        MesaCreateDTO mesaCreateDTO = new MesaCreateDTO();
        mesaCreateDTO.setNumero(3);
        mesaCreateDTO.setCapacidad(8);

        MesaDTO mesaGuardada = new MesaDTO();
        mesaGuardada.setId(3L);
        mesaGuardada.setNumero(3);
        mesaGuardada.setCapacidad(8);

        when(mesaService.guardarMesa(any(MesaCreateDTO.class))).thenReturn(mesaGuardada);

        // When/Then
        mockMvc.perform(post("/mesas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"numero\": 3, \"capacidad\": 8}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.numero").value(3))
                .andExpect(jsonPath("$.capacidad").value(8));

        verify(mesaService, times(1)).guardarMesa(any(MesaCreateDTO.class));
        verifyNoMoreInteractions(mesaService);
    }
}