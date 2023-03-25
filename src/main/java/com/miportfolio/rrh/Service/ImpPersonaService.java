package com.miportfolio.rrh.Service;

import com.miportfolio.rrh.Entity.Persona;
import com.miportfolio.rrh.Interface.IPersonaService;
import com.miportfolio.rrh.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ImpPersonaService implements IPersonaService{
    @Autowired IPersonaRepository IPersonaRepository;
    
    @Override
    public List<Persona> getPersona() {
            List<Persona> persona =  IPersonaRepository.findAll();
                    return persona;
    }

    @Override
    public void savePersona(Persona persona) {
            IPersonaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        IPersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = IPersonaRepository.findById(id).orElse(null);
        return persona;
        
    }
    
}
