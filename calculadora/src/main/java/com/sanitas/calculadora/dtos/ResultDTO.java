package com.sanitas.calculadora.dtos;

import java.io.Serializable;

/**
 * DTO para tratar el resultado de la operación
 */
public class ResultDTO implements Serializable  {
    /**
     *
     */
    private static final long serialVersionUID = 4513741196180970122L;

    /**
     * Resultado de la operación
     */
    private String result;

    /**
     * Finalización correcta de la petición
     */
    private  boolean success;

    /**
     * Constructor por defecto
     */
    public ResultDTO (){

    }

    /**
     * Constructor para inicializar el DTO
     */
    public ResultDTO (String pResult, boolean pSucces){
        this.result = pResult;
        this.success = pSucces;
    }

    /**
     * Para obtener la variable result
     * @return String
     */
    public String getResult() {
        return result;
    }

    /**
     * Para establecer la variable result
     * @param result
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * Para obtener la variable succes
     * @return boolean
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Para establecer la variable success
     * @param success
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }
}
