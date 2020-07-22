package com.sanitas.calculadora.controllers;

import com.sanitas.calculadora.dtos.ResultDTO;
import com.sanitas.calculadora.services.ICalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Controller de la api
 */
@RestController
@RequestMapping("/api/calculadora")
public class CalculadoraController {
    @Autowired
    private ICalculadoraService calculadoraService;

    /**
     * Método Get visible para llamar al microservicio
     * @param numero1 Primer número de la operación
     * @param numero2 Segundo número de la operación
     * @param operacion cadena con la operación a realizar
     * @return resultado de la operación
     */
    @GetMapping(value = "/realizarOperacion")
    public ResponseEntity<ResultDTO> realizarOperacion(@RequestParam(name = "numero1", required=true) BigDecimal numero1,
                                                    @RequestParam(name = "numero2", required=true) BigDecimal numero2,
                                                    @RequestParam(name = "operacion", required=true) String operacion) {

        // Realizamos la llamada el servicio encargado de realizar la operación.
        final ResultDTO result = this.calculadoraService.realizarOperacion(numero1, numero2, operacion);

        // Tratamos el resultado de la operación.
        if (result != null){
            if (result.isSuccess()){
                return ResponseEntity.ok(result);
            }
            else{
                return ResponseEntity.badRequest().body(result);
            }
        }

        return ResponseEntity.noContent().build();
    }
}
