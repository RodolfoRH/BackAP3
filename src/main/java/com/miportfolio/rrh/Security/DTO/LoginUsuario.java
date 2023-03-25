package com.miportfolio.rrh.Security.DTO;

import javax.validation.constraints.NotBlank;





public class LoginUsuario {
    
    //Usuario y contraseña - NO pueden estar en blanco
    @NotBlank
    private String nombreUsuario;
    @NotBlank
    private String password;

    //Getters y Setters

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    


}
