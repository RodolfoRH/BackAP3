package com.miportfolio.rrh.Controller;

import com.miportfolio.rrh.DTO.dtoEducation;
import com.miportfolio.rrh.Entity.Education;
import com.miportfolio.rrh.Security.Controller.Mensaje;
import com.miportfolio.rrh.Service.ServiceEducation;
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
@RequestMapping("/education")
@CrossOrigin(origins = "http://localhost:4200")
public class CEducation {

    @Autowired
    ServiceEducation serviceEducation;

    //Ver listado de registros
    @GetMapping("/lista")
    public ResponseEntity<List<Education>> list(){
        List<Education> list = serviceEducation.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    //Detail
    @GetMapping("/detail/{id}")
    public ResponseEntity<Education> getById(@PathVariable("id") int id) {
        if (!serviceEducation.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }

        Education education = serviceEducation.getOne(id).get();
        return new ResponseEntity(education, HttpStatus.OK);
    }

    //Eliminar un registro existente, por el ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!serviceEducation.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        serviceEducation.delete(id);
        return new ResponseEntity(new Mensaje("Se eliminó el registro de educación"), HttpStatus.OK);
    }

    //Agregar nuevo registro
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducation dtoeducation) {
        if (StringUtils.isBlank(dtoeducation.getNombreEdu())) {
            return new ResponseEntity(new Mensaje("El nombre de la educación, es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (serviceEducation.existisByNombreEdu(dtoeducation.getNombreEdu())) {
            return new ResponseEntity(new Mensaje("Es nombre de la educación elegido, ya existe"), HttpStatus.BAD_REQUEST);
        }

        Education education = new Education(dtoeducation.getNombreEdu(), dtoeducation.getDescripcionEdu());
        serviceEducation.save(education);
        return new ResponseEntity(new Mensaje("Registro creado correctamente"), HttpStatus.OK);
    }

    //Editar un registro existente
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducation dtoeducation) {
        if (!serviceEducation.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.NOT_FOUND);
        }
        if (serviceEducation.existisByNombreEdu(dtoeducation.getNombreEdu()) && serviceEducation.getByNombreEdu(dtoeducation.getNombreEdu()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoeducation.getNombreEdu())) {
            return new ResponseEntity(new Mensaje("La descripción es obligatoria"), HttpStatus.BAD_REQUEST);
        }

        Education education = serviceEducation.getOne(id).get();

        education.setNombreEdu(dtoeducation.getNombreEdu());
        education.setDescripcionEdu(dtoeducation.getDescripcionEdu());

        serviceEducation.save(education);

        return new ResponseEntity(new Mensaje("Registro de educación actualizado correctamente"), HttpStatus.OK);
    }

}
