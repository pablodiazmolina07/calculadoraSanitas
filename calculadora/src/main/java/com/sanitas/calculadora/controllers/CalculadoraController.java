package com.sanitas.calculadora.controllers;

import com.sanitas.calculadora.dtos.ResultDTO;
import com.sanitas.calculadora.services.ICalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculadora")
public class CalculadoraController {
    @Autowired
    private ICalculadoraService calculadoraService;

    /**
     * Método Get visible para llamar al microservicio
     * @param numero1 cadena con el primer número de la operación
     * @param numero2 cadena con el segundo número de la operación
     * @param operacion cadena con la operación a realizar
     * @return resultado de la operación
     */
    @GetMapping(value = "/realizarOperacion")
    public ResponseEntity<ResultDTO> realizarOperacion(@RequestParam(name = "numero1", required=true) String numero1,
                                                    @RequestParam(name = "numero2", required=true) String numero2,
                                                    @RequestParam(name = "operacion", required=true) String operacion) {

        final ResultDTO result = this.calculadoraService.realizarOperacion(numero1, numero2, operacion);

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
