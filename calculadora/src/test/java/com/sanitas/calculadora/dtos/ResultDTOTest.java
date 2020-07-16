package com.sanitas.calculadora.dtos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultDTOTest {
    @Test
    public void toStringOK() {


        ResultDTO resultDto = new ResultDTO("10", true);
        String dtoAsString = resultDto.toString();
        assertFalse(dtoAsString.contains("Error"));
        assertTrue(dtoAsString.contains("10"));
        assertEquals(dtoAsString.toString(),
                "ResultDTO(result=10, success=true)");
    }

    @Test
    public void equalsOK() {

        ResultDTO expected = new ResultDTO("10", true);
        ResultDTO result = new ResultDTO("10", true);

        assertEquals(expected, result);
    }
}
