package com.miportfolio.rrh.Controller;

import com.miportfolio.rrh.DTO.dtoJobs;
import com.miportfolio.rrh.Entity.Jobs;
import com.miportfolio.rrh.Security.Controller.Mensaje;
import com.miportfolio.rrh.Service.ServiceJobs;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
@CrossOrigin(origins = "http://localhost:4200/")

public class CJobs {

    @Autowired
    ServiceJobs serviceJobs;

    //Traer listado de experiencias (Jobs)
  //  @GetMapping("/lista")
  //  public ResponseEntity<List<Jobs>> list() {
  //      List<Jobs> list = serviceJobs.list();
  //      return new ResponseEntity(list, HttpStatus.OK);
  //  }

    @GetMapping("/lista")
    public ResponseEntity<List<Jobs>> list(){
        List<Jobs> list = serviceJobs.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    
    
    
    
    
    
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<List> getById(@PathVariable("id") int id){
        if(!serviceJobs.existsById(id))
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.NOT_FOUND);
        Jobs jobs = serviceJobs.getOne(id).get();
        return new ResponseEntity(jobs, HttpStatus.OK);
    }
    
    
    
    
    
    
    
    
    
    //Crear una nueva experiencia laboral (Jobs)
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoJobs dtoNewXP) {
        if (StringUtils.isBlank(dtoNewXP.getNombreExp())) {
            return new ResponseEntity(new Mensaje("Introducir nombre (obligatorio)"), HttpStatus.BAD_REQUEST);
        }
        if (serviceJobs.existsByNombreExp(dtoNewXP.getNombreExp())) {
            return new ResponseEntity(new Mensaje("Esta experiencia laboral ya estaba registrada (1)"), HttpStatus.BAD_REQUEST);
        }

        Jobs jobs = new Jobs(dtoNewXP.getNombreExp(), dtoNewXP.getDescripcionExp());
        serviceJobs.save(jobs);
        return new ResponseEntity(new Mensaje("Nueva experiencia guardada correctamente - JAVA"), HttpStatus.OK);
    }

    //Actualizar una experiencia laboral creada (Jobs)
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoJobs dtoNewXP) {
        // Comprueba si la experiencia ya existe, POR EL ID
        if (!serviceJobs.existsById(id)) 
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);
        
        // Aquí se busca si la experiencia ya existía, POR EL NOMBRE
        if (serviceJobs.existsByNombreExp(dtoNewXP.getNombreExp()) && serviceJobs.getByNombreExp(dtoNewXP.getNombreExp()).get().getId() != id) 
            return new ResponseEntity(new Mensaje("Esta experiencia laboral ya estaba registrada (2)"), HttpStatus.BAD_REQUEST);
        
        // Tira error si está vacío
        if (StringUtils.isBlank(dtoNewXP.getNombreExp()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        

        Jobs jobs = serviceJobs.getOne(id).get();
        jobs.setNombreExp(dtoNewXP.getNombreExp());
        jobs.setDescripcionExp(dtoNewXP.getDescripcionExp());

        serviceJobs.save(jobs);
        return new ResponseEntity(new Mensaje("Experiencia laboral actualizada correctamente"), HttpStatus.OK);
    }

    // Borrar una experiencia laboral ya cargada
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        // Comprueba si existe, POR EL ID
        if (!serviceJobs.existsById(id)) {
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);
        }

        serviceJobs.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia laboral eliminada"), HttpStatus.OK);
    }

}
