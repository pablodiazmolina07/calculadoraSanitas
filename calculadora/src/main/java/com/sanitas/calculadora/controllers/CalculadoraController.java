package com.sanitas.calculadora.controllers;

import com.sanitas.calculadora.services.ICalculadoraService;
import io.corp.calculator.TracerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CalculadoraController {
    @Autowired
    private ICalculadoraService calculadoraService;

    private TracerImpl tracer = new TracerImpl();

    /**
     * Método Get visible para llamar al microservicio
     * @param numero1 cadena con el primer número de la operación
     * @param numero2 cadena con el segundo número de la operación
     * @param operacion cadena con la operación a realizar
     * @return resultado de la operación
     */
    @GetMapping(value = "/realizarOperacion")
    public ResponseEntity<Double> realizarOperacion(@RequestParam(name = "numero1") String numero1,
                                                    @RequestParam(name = "numero2") String numero2,
                                                    @RequestParam(name = "operacion") String operacion) {

        double result = this.calculadoraService.realizarOperacion(numero1, numero2, operacion);

        tracer.trace(result);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
