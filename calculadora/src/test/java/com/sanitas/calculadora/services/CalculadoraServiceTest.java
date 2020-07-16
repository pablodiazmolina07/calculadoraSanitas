package com.sanitas.calculadora.services;

import com.sanitas.calculadora.dtos.ResultDTO;
import com.sanitas.calculadora.services.impl.CalculadoraServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraServiceTest {
    @InjectMocks
    private CalculadoraServiceImpl calculadoraService;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void calculateNullValues() {
        ResultDTO expected = new ResultDTO("Formato de los números a operar incorrecto.", false);

        ResultDTO result = calculadoraService.realizarOperacion("10", "5", "suma");
        assertEquals(expected, result);
    }
    @Test
    public void calculateAddition() {
        ResultDTO expected = new ResultDTO("15", true);

        ResultDTO result = calculadoraService.realizarOperacion("10","5", "suma");
        assertEquals(expected, result);
    }

    @Test
    public void calculateSubtraction() {
        ResultDTO expected = new ResultDTO("5", true);

        ResultDTO result = calculadoraService.realizarOperacion("10","5", "resta");
        assertEquals(expected, result);
    }
    @Test
    public void operationNotImplemented() {
        ResultDTO expected = new ResultDTO("5", true);

        ResultDTO result = calculadoraService.realizarOperacion("10","5", "producto");
        assertEquals(expected, result);
    }
}
