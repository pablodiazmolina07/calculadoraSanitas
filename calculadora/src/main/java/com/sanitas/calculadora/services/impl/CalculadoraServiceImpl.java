package com.sanitas.calculadora.services.impl;

import com.sanitas.calculadora.constants.Constantes;
import com.sanitas.calculadora.dtos.ResultDTO;
import com.sanitas.calculadora.services.ICalculadoraService;
import com.sanitas.calculadora.utils.OperacionUtils;
//import io.corp.calculator.TracerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculadoraServiceImpl implements ICalculadoraService {
    private static final Logger log = LoggerFactory.getLogger(CalculadoraServiceImpl.class);

    //private TracerImpl tracer = new TracerImpl();

    @Override
    public ResultDTO realizarOperacion(String numero1, String numero2, String operacion) {
        log.info("realizarOperacion - INICIO");

        ResultDTO resultDTO = null;

        double resultado = 0;

        // Validamos si la operación es correcta
        if (!"".equalsIgnoreCase(operacion)){
            try
            {
                //Transformamos las cadenas de entrada a numéricos
                BigDecimal bdNumero1 = new BigDecimal(numero1.replace(",", "."));
                BigDecimal bdNumero2 = new BigDecimal(numero2.replace(",", "."));

                // Identificamos la operación y la realizamos.
                if (Constantes.OPERACION_SUMA.equals(operacion.toUpperCase()) ||
                        Constantes.OPERACION_SUMAR.equals(operacion.toUpperCase())){
                    resultado = OperacionUtils.operacionSuma(bdNumero1, bdNumero2);
                    resultDTO = new ResultDTO(String.valueOf(resultado), true);
                }else if (Constantes.OPERACION_RESTA.equals(operacion.toUpperCase()) ||
                        Constantes.OPERACION_RESTAR.equals(operacion.toUpperCase())){
                    resultado = OperacionUtils.operacionResta(bdNumero1, bdNumero2);
                    resultDTO = new ResultDTO(String.valueOf(resultado), true);
                }
                else{
                    log.error("Operacion " + operacion + " no implementada");
                    resultDTO = new ResultDTO("Operacion " + operacion + " no implementada", false);
                }
            }
            catch (NumberFormatException ex){
                log.error("Formato de los números a operar incorrecto.");
                resultDTO = new ResultDTO("Formato de los números a operar incorrecto.", false);
            }
        }
        else{
            log.error("Operacion es nulo. Es imposible realizar la operación");
            resultDTO = new ResultDTO("Operacion es nulo. Es imposible realizar la operación", false);
        }

        log.info("realizarOperacion - FIN - resultado: " + resultado);

        //tracer.trace(resultDTO);

        return resultDTO;
    }
}
