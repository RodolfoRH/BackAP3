package com.miportfolio.rrh.Interface;

//Traer un listado de personas

import com.miportfolio.rrh.Entity.Persona;
import java.util.List;

        public interface IPersonaService {

public List<Persona> getPersona();

//Guardar el objeto del tipo "persona"
public void savePersona(Persona persona);

//Borrar un objeto del tipo "persona"
public void deletePersona(Long id);

//Búsqueda de persona por Id
public Persona findPersona (Long id);


}
