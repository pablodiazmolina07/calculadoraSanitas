package com.sanitas.calculadora.services.impl;

import com.sanitas.calculadora.constants.Constantes;
import com.sanitas.calculadora.services.ICalculadoraService;
import com.sanitas.calculadora.utils.OperacionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalculadoraServiceImpl implements ICalculadoraService {
    private static final Logger log = LoggerFactory.getLogger(CalculadoraServiceImpl.class);

    @Override
    public double realizarOperacion(String numero1, String numero2, String operacion) {
        log.info("realizarOperacion - INICIO");

        double resultado = 0;

        // Validamos si la operación es correcta
        if (!"".equalsIgnoreCase(operacion)){
            try
            {
                //Transformamos las cadenas de entrada a numéricos
                BigDecimal bdNumero1 = new BigDecimal(numero1.replace(",", "."));
                BigDecimal bdNumero2 = new BigDecimal(numero2.replace(",", "."));

                OperacionUtils operacionUtils = new OperacionUtils(bdNumero1, bdNumero2);

                // Identificamos la operación y la realizamos.
                if (Constantes.OPERACION_SUMA.equals(operacion.toUpperCase()) ||
                        Constantes.OPERACION_SUMAR.equals(operacion.toUpperCase())){
                    resultado = operacionUtils.operacionSuma();
                }else if (Constantes.OPERACION_RESTA.equals(operacion.toUpperCase()) ||
                        Constantes.OPERACION_RESTAR.equals(operacion.toUpperCase())){
                    resultado = operacionUtils.operacionResta();
                }
                else{
                    log.error("Operacion " + operacion + " no identificada");
                    throw new RuntimeException("Operacion " + operacion + " no identificada");
                }
            }
            catch (NumberFormatException ex){
                log.error("Formato de los números a operar incorrecto. Numero1: " + numero1 + " Numero2: " + numero2);
                throw new RuntimeException("Formato de los números a operar incorrecto. Numero1: " + numero1 + " Numero2: " + numero2);
            }
        }
        else{
            log.error("Operacion es nulo. Es imposible realizar la operación");
            throw new RuntimeException("Operacion es nulo. Es imposible realizar la operación");
        }

        log.info("realizarOperacion - FIN - resultado: " + resultado);

        return resultado;
    }
}
