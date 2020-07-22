package com.sanitas.calculadora.services;

import com.sanitas.calculadora.dtos.ResultDTO;

import java.math.BigDecimal;

/**
 * Interfaz del microservicio
 */
public interface ICalculadoraService {
    /**
     * Método encargado de la lógica de la operación
     * @param numero1 Primer número de la operación
     * @param numero2 Segundo número de la operación
     * @param operacion Operación a realizar. Suma o Resta
     * @return Resultado de la operación
     */
    ResultDTO realizarOperacion (BigDecimal numero1, BigDecimal numero2, String operacion);
}
