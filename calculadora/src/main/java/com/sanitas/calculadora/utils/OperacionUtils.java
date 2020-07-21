package com.sanitas.calculadora.utils;

import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * Clase en la que implementaremos las operaciones a realizar.
 */
public class OperacionUtils {

    /**
     * Operación suma
     * @param bdNumero1 Primer elemento de la suma.
     * @param bdNumero2 Segundo elemento de la suma.
     * @return resultado de la suma
     */
    public static double operacionSuma (BigDecimal bdNumero1, BigDecimal bdNumero2){
        return bdNumero1.add(bdNumero2).doubleValue();
    }

    /**
     * Operación resta
     * @param bdNumero1 Primer elemento de la resta
     * @param bdNumero2 Segundo elemento de la resta
     * @return resultado de la resta
     */
    public static double operacionResta (BigDecimal bdNumero1, BigDecimal bdNumero2){
        return bdNumero1.subtract(bdNumero2).doubleValue();
    }
}
