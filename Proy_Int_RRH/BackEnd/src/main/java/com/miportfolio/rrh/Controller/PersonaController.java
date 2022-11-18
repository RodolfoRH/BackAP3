package com.miportfolio.rrh.Controller;

import com.miportfolio.rrh.Entity.Persona;
import com.miportfolio.rrh.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    @Autowired IPersonaService IPersonaService;
    @GetMapping("/personas/traer")
    public List<Persona> getPersona(){
        return IPersonaService.getPersona();
    }

    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        IPersonaService.savePersona(persona);
        return "El usuario se creó correctamente";
    }
    
    @DeleteMapping("/personas/borrar/(id)")
    public String deletePersona(@PathVariable Long id){
    IPersonaService.deletePersona(id);
    return "El usuario se eliminó correctamente";
}
 
    
    @PutMapping("/personas/editar/(id)")
    public Persona editPersona (@PathVariable Long id,
                                @RequestParam("nombre") String nuevoNombre,
                                @RequestParam("nombre") String nuevoApellido,
                                @RequestParam("nombre") String nuevoImg){
        
        Persona persona = IPersonaService.findPersona(id);
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
        
        IPersonaService.savePersona(persona);
               return persona;
    }
    
    @GetMapping("/personas/traer/perfil")
    public Persona findPersona(){
        return IPersonaService.findPersona((long)1);
    }
}