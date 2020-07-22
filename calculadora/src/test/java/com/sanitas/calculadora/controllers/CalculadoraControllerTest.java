package com.sanitas.calculadora.controllers;

import com.sanitas.calculadora.dtos.ResultDTO;
import com.sanitas.calculadora.services.ICalculadoraService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CalculadoraControllerTest {
    private MockMvc mvc;

    @Mock
    ICalculadoraService calculadoraService;

    @InjectMocks
    private CalculadoraController calculadoraController;

    private static final String URI_BASE = "/api/calculadora/";
    private static final String CALCULATE = "realizarOperacion";
    private static final String SUMA_URI = URI_BASE.concat(CALCULATE);
    private static final String RESTA_URI = URI_BASE.concat(CALCULATE);
    private static final String FIRST_PARAM_NAME = "numero1";
    private static final String SECOND_PARAM_NAME = "numero2";
    private static final String THIRD_PARAM_NAME = "operacion";


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(calculadoraController).build();
    }

    @Test
    public void noRequiredParams() throws Exception {
        mvc.perform(post(RESTA_URI)).andExpect(status().isBadRequest());
    }

    @Test
    public void noRequiredFirstParam() throws Exception {
        String url = RESTA_URI.concat("?").concat(SECOND_PARAM_NAME).concat("=").concat("10").concat("&").concat(THIRD_PARAM_NAME).concat("A");
        mvc.perform(post(url)).andExpect(status().isBadRequest());
    }

    @Test
    public void noRequiredSecondParam() throws Exception {
        String url = RESTA_URI.concat("?").concat(FIRST_PARAM_NAME).concat("=").concat("10").concat("&").concat(THIRD_PARAM_NAME).concat("A");
        mvc.perform(post(url)).andExpect(status().isBadRequest());
    }

    @Test
    public void noRequiredThirdParam() throws Exception {
        String url = RESTA_URI.concat("?").concat(FIRST_PARAM_NAME).concat("=").concat("10").concat("&").concat(SECOND_PARAM_NAME).concat("5");
        mvc.perform(post(url)).andExpect(status().isBadRequest());
    }

    @Test
    public void operacionNoPermitida() throws Exception {
        ResultDTO resultOperation = new ResultDTO("15.0" ,true);
        when(calculadoraService.realizarOperacion(new BigDecimal("10"), new BigDecimal("5"),"A")).thenReturn(resultOperation);

        String url = SUMA_URI.concat("?").concat(FIRST_PARAM_NAME).concat("=").concat("10")
                .concat("&").concat(SECOND_PARAM_NAME).concat("=").concat("5")
                .concat("&").concat(THIRD_PARAM_NAME).concat("=").concat("P");

        ResultActions result = mvc.perform(post(url));

        result.andExpect(status().isOk()).andExpect(content().json("{\"result\": \"Operacion P no implementada\", \"success\": false}"));
    }

    @Test
    public void formatoOperadoresNoValido() throws Exception {
        ResultDTO resultOperation = new ResultDTO("15.0", true);
        when(calculadoraService.realizarOperacion(new BigDecimal("10"), new BigDecimal(""),"A")).thenReturn(resultOperation);

        String url = SUMA_URI.concat("?").concat(FIRST_PARAM_NAME).concat("=").concat("10")
                .concat("&").concat(SECOND_PARAM_NAME).concat("=").concat("")
                .concat("&").concat(THIRD_PARAM_NAME).concat("=").concat("A");

        mvc.perform(post(url)).andExpect(status().isBadRequest());
    }

    @Test
    public void operacionSuma_responseOK() throws Exception {
        ResultDTO resultOperation = new ResultDTO("15.0", true);
        when(calculadoraService.realizarOperacion(new BigDecimal("10"), new BigDecimal("5"),"suma")).thenReturn(resultOperation);

        String url = SUMA_URI.concat("?").concat(FIRST_PARAM_NAME).concat("=").concat("10")
                .concat("&").concat(SECOND_PARAM_NAME).concat("=").concat("5")
                .concat("&").concat(THIRD_PARAM_NAME).concat("=").concat("A");
        ResultActions result = mvc.perform(post(url));

        result.andExpect(status().isOk()).andExpect(content().json("{\"result\": \"15.0\", \"success\": true}"));
    }

    @Test
    public void operacionResta_responseOK() throws Exception {
        ResultDTO resultOperation = new ResultDTO("5.0", true);

        when(calculadoraService.realizarOperacion(new BigDecimal("10"), new BigDecimal("5"),"resta")).thenReturn(resultOperation);

        ResultActions result = mvc.perform(
                post(SUMA_URI.concat("?").concat(FIRST_PARAM_NAME).concat("=").concat("10")
                        .concat("&").concat(SECOND_PARAM_NAME).concat("=").concat("5")
                        .concat("&").concat(THIRD_PARAM_NAME).concat("=").concat("S")));

        result.andExpect(status().isOk()).andExpect(content().json("{\"result\": \"5.0\", \"success\": true}"));
    }
}
