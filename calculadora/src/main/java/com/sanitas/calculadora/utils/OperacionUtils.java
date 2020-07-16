package com.sanitas.calculadora.utils;

import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class OperacionUtils {

    public static double operacionSuma (BigDecimal bdNumero1, BigDecimal bdNumero2){
        return bdNumero1.add(bdNumero2).doubleValue();
    }

    public static double operacionResta (BigDecimal bdNumero1, BigDecimal bdNumero2){
        return bdNumero1.subtract(bdNumero2).doubleValue();
    }
}
