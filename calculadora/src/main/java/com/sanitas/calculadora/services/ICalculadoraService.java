package com.sanitas.calculadora.services;

import java.math.BigDecimal;

public interface ICalculadoraService {
    double realizarOperacion (BigDecimal numero1, BigDecimal numero2, String operacion);
}
