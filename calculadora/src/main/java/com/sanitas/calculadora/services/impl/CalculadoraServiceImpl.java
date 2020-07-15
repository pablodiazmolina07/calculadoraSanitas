package com.sanitas.calculadora.services.impl;

import com.sanitas.calculadora.services.ICalculadoraService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculadoraServiceImpl implements ICalculadoraService {
    @Override
    public double realizarOperacion(BigDecimal numero1, BigDecimal numero2, String operacion) {
        return 0;
    }
}
