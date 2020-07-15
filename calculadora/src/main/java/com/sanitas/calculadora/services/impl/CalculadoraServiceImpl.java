package com.sanitas.calculadora.services.impl;

import com.sanitas.calculadora.constants.Constantes;
import com.sanitas.calculadora.services.ICalculadoraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculadoraServiceImpl implements ICalculadoraService {
    private static final Logger log = LoggerFactory.getLogger(CalculadoraServiceImpl.class);

    @Override
    public double realizarOperacion(BigDecimal numero1, BigDecimal numero2, String operacion) {
        log.info("realizarOperacion - INICIO");
        double resultado = 0;

        // Validamos si la operación es correcta
        if (!"".equalsIgnoreCase(operacion)){
            // Identificamos la operación y la realizamos.
            if (Constantes.OPERACION_SUMA.equals(operacion)){
                resultado = numero1.add(numero2).doubleValue();
            }else if (Constantes.OPERACION_RESTA.equals(operacion)){
                resultado = numero1.subtract(numero2).doubleValue();
            }
            else{
                log.error("Operacion " + operacion + " no identificada");
                throw new RuntimeException("Operacion " + operacion + " no identificada");
            }
        }
        else{
            log.error("Operacion es nulo. Es imposible realizar la operación");
            throw new RuntimeException("Operacion es nulo. Es imposible realizar la operación");
        }

        log.info("realizarOperacion - FIN - resultado: " + String.valueOf(resultado));

        return resultado;
    }
}
