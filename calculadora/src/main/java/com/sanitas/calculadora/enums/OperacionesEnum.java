package com.sanitas.calculadora.enums;

public enum OperacionesEnum {
    ADDITION("A"),
    SUBTRACTION("S");

    private final String codigo;

    private OperacionesEnum(String codigo) {
        this.codigo = codigo;
    }

    public final String getCodigo() {
        return codigo;
    }
}
