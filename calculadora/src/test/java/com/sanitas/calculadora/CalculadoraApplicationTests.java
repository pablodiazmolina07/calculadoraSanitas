package com.sanitas.calculadora;

import com.sanitas.calculadora.services.ICalculadoraService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import java.net.URI;
import java.net.URISyntaxException;

@SpringBootTest
class CalculadoraApplicationTests {

    @Test
    void contextLoads() {
    }

    /**
     * Invoca una llamada al método GET del microservicio con los parametros de entrada
     * @param numero1
     * @param numero2
     * @param operacion
     * @return
     * @throws URISyntaxException
     */
    private ResponseEntity<Double> realizarOperacion(String numero1, String numero2, String operacion) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:8080" + "/api/realizarOperacion?numero1=" + numero1 +
                "&numero2=" + numero1 + "&operacion=" + operacion;
        URI uri = new URI(baseUrl);

        ResponseEntity<Double> resultado = restTemplate.getForEntity(uri, Double.class);
        return resultado;
    }

    @Test
    public void testSumaConExito() throws URISyntaxException {

        ResponseEntity<Double> resultado = realizarOperacion("10", "5", "suma");

        //Comprueba el resultado
        Assertions.assertEquals(200, resultado.getStatusCodeValue());
        Assertions.assertEquals(15.0d, resultado.getBody().doubleValue(), 0.001d);
    }

    @Test
    public void testSumaConPuntoConExito() throws URISyntaxException {

        ResponseEntity<Double> resultado = realizarOperacion("10.5", "5", "suma");

        //Comprueba el resultado
        Assertions.assertEquals(200, resultado.getStatusCodeValue());
        Assertions.assertEquals(15.5d, resultado.getBody().doubleValue(), 0.001d);
    }

    @Test
    public void testSumaConComaConExito() throws URISyntaxException {

        ResponseEntity<Double> resultado = realizarOperacion("10", "5,5", "suma");

        //Comprueba el resultado
        Assertions.assertEquals(200, resultado.getStatusCodeValue());
        Assertions.assertEquals(15.5d, resultado.getBody().doubleValue(), 0.001d);
    }

    @Test
    public void testSumarConExito() throws URISyntaxException {

        ResponseEntity<Double> resultado = realizarOperacion("10", "5", "sumar");

        //Comprueba el resultado
        Assertions.assertEquals(200, resultado.getStatusCodeValue());
        Assertions.assertEquals(15.0d, resultado.getBody().doubleValue(), 0.001d);
    }

    @Test
    public void testSumarConPuntoConExito() throws URISyntaxException {

        ResponseEntity<Double> resultado = realizarOperacion("10.5", "5", "sumar");

        //Comprueba el resultado
        Assertions.assertEquals(200, resultado.getStatusCodeValue());
        Assertions.assertEquals(15.5d, resultado.getBody().doubleValue(), 0.001d);
    }

    @Test
    public void testSumarConComaConExito() throws URISyntaxException {

        ResponseEntity<Double> resultado = realizarOperacion("10", "5,5", "sumar");

        //Comprueba el resultado
        Assertions.assertEquals(200, resultado.getStatusCodeValue());
        Assertions.assertEquals(15.5d, resultado.getBody().doubleValue(), 0.001d);
    }

    @Test
    public void testRestaConExito() throws URISyntaxException {

        ResponseEntity<Double> resultado = realizarOperacion("10", "5", "resta");

        //Comprueba el resultado
        Assertions.assertEquals(200, resultado.getStatusCodeValue());
        Assertions.assertEquals(5.0d, resultado.getBody().doubleValue(), 0.001d);
    }

    @Test
    public void testRestaConPuntoConExito() throws URISyntaxException {

        ResponseEntity<Double> resultado = realizarOperacion("10.5", "5", "resta");

        //Comprueba el resultado
        Assertions.assertEquals(200, resultado.getStatusCodeValue());
        Assertions.assertEquals(4.5d, resultado.getBody().doubleValue(), 0.001d);
    }

    @Test
    public void testRestaConComaConExito() throws URISyntaxException {

        ResponseEntity<Double> resultado = realizarOperacion("10", "5,5", "resta");

        //Comprueba el resultado
        Assertions.assertEquals(200, resultado.getStatusCodeValue());
        Assertions.assertEquals(4.5d, resultado.getBody().doubleValue(), 0.001d);
    }

    @Test
    public void testRestarConExito() throws URISyntaxException {

        ResponseEntity<Double> resultado = realizarOperacion("5", "10", "restar");

        //Comprueba el resultado
        Assertions.assertEquals(200, resultado.getStatusCodeValue());
        Assertions.assertEquals(-5.0d, resultado.getBody().doubleValue(), 0.001d);
    }

    @Test
    public void testRestarConPuntoConExito() throws URISyntaxException {

        ResponseEntity<Double> resultado = realizarOperacion("5", "10.5", "restar");

        //Comprueba el resultado
        Assertions.assertEquals(200, resultado.getStatusCodeValue());
        Assertions.assertEquals(-4.5d, resultado.getBody().doubleValue(), 0.001d);
    }

    @Test
    public void testRestarConComaConExito() throws URISyntaxException {

        ResponseEntity<Double> resultado = realizarOperacion("5,5", "10", "restar");

        //Comprueba el resultado
        Assertions.assertEquals(200, resultado.getStatusCodeValue());
        Assertions.assertEquals(-4.5d, resultado.getBody().doubleValue(), 0.001d);
    }
}
