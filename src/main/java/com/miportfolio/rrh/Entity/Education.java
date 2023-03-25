package com.miportfolio.rrh.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreEdu;
    private String descripcionEdu;

   
    //Constructores vacío y lleno
    public Education() {
    }
    public Education(String nombreEdu, String descripcionEdu) {
        this.nombreEdu = nombreEdu;
        this.descripcionEdu = descripcionEdu;
    }

    //Getters y Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
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
