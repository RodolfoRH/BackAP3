package com.miportfolio.rrh.DTO;

import javax.validation.constraints.NotBlank;

public class dtoEducation {
    @NotBlank
    private String nombreEdu;
    @NotBlank
    private String descripcionEdu;
    
        //Constructores vacío y completo
    public dtoEducation() {
    }
    public dtoEducation(String nombreEdu, String descripcionEdu) {
        this.nombreEdu = nombreEdu;
        this.descripcionEdu = descripcionEdu;
    }

        //Getters y Setters
    public String getNombreEdu() {
        return nombreEdu;
    }
    public void setNombreEdu(String nombreEdu) {
        this.nombreEdu = nombreEdu;
    }
    public String getDescripcionEdu() {
        return descripcionEdu;
    }
    public void setDescripcionEdu(String descripcionEdu) {
        this.descripcionEdu = descripcionEdu;
    }
    
}
