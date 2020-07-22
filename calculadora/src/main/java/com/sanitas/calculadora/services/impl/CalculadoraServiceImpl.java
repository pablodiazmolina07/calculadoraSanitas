package com.sanitas.calculadora.services.impl;

import com.sanitas.calculadora.dtos.ResultDTO;
import com.sanitas.calculadora.enums.OperacionesEnum;
import com.sanitas.calculadora.services.ICalculadoraService;
import com.sanitas.calculadora.utils.OperacionUtils;
import io.corp.calculator.TracerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculadoraServiceImpl implements ICalculadoraService {
    private static final Logger log = LoggerFactory.getLogger(CalculadoraServiceImpl.class);

    private TracerImpl tracer = new TracerImpl();

    @Override
    public ResultDTO realizarOperacion(BigDecimal numero1, BigDecimal numero2, String operacion) {
        log.info("realizarOperacion - INICIO");

        ResultDTO resultDTO = null;

        double resultado = 0;

        // Validamos si la operación es correcta
        if (!"".equalsIgnoreCase(operacion)){
            // Identificamos la operación y la realizamos.
            if (OperacionesEnum.ADDITION.getCodigo().equals(operacion.toUpperCase())){
                // Realizamos la operación suma.
                resultado = OperacionUtils.operacionSuma(numero1, numero2);

                // Guardamos el resultado de la operación.
                resultDTO = new ResultDTO(String.valueOf(resultado), true);
            }else if (OperacionesEnum.SUBTRACTION.getCodigo().equals(operacion.toUpperCase())){
                // Realizamos la operación resta.
                resultado = OperacionUtils.operacionResta(numero1, numero2);

                // Guardamos el resultado de la operación.
                resultDTO = new ResultDTO(String.valueOf(resultado), true);
            }
            else{
                // Si la operación no está implementada devolvemos un error.
                log.error("Operacion " + operacion + " no implementada");
                resultDTO = new ResultDTO("Operacion " + operacion + " no implementada", false);
            }
        }
        else{
            log.error("Operacion es nulo. Es imposible realizar la operación");
            resultDTO = new ResultDTO("Operacion es nulo. Es imposible realizar la operación", false);
        }

        log.info("realizarOperacion - FIN - resultado: " + resultado);

        // Guardamos la traza de la operación realizada.
        tracer.trace(resultDTO);

        // Devolvemos el resultado.
        return resultDTO;
    }
}
