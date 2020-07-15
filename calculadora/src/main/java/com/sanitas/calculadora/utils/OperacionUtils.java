package com.sanitas.calculadora.utils;

import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class OperacionUtils {

    private BigDecimal bdNumero1 = null;
    private BigDecimal bdNumero2 = null;

    /**
     * Constructor para inicializar los elementos de la operación
     */
    public OperacionUtils (BigDecimal pNumero1, BigDecimal pNumero2){
        bdNumero1 = pNumero1;
        bdNumero2 = pNumero2;
    }

    public double operacionSuma (){
        return bdNumero1.add(bdNumero2).doubleValue();
    }

    public double operacionResta (){
        return bdNumero1.subtract(bdNumero2).doubleValue();
    }

    /**
     * Devuelve el primer numero de la operación
     * @return BigDecimal
     */
    public BigDecimal getBdNumero1() {
        return bdNumero1;
    }

    /**
     * Establece el primer numero de la operación
     * @param bdNumero1
     */
    public void setBdNumero1(BigDecimal bdNumero1) {
        this.bdNumero1 = bdNumero1;
    }

    /**
     * Devuelve el segundo numero de la operación
     * @return BigDecimal
     */
    public BigDecimal getBdNumero2() {
        return bdNumero2;
    }

    /**
     * Establece el segundo numero de la operación
     * @param bdNumero2
     */
    public void setBdNumero2(BigDecimal bdNumero2) {
        this.bdNumero2 = bdNumero2;
    }
}
