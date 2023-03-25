package com.miportfolio.rrh.Service;

import com.miportfolio.rrh.Entity.Education;
import com.miportfolio.rrh.Repository.RepoEducation;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ServiceEducation {
    @Autowired
    RepoEducation repoEducation;
    
    public List<Education> list(){
        return repoEducation.findAll();
    }
    public Optional<Education> getOne(int id){
        return repoEducation.findById(id);
    }
    public Optional<Education>getByNombreEdu(String nombreEdu){
        return repoEducation.findByNombreEdu(nombreEdu);
    }
    public void save(Education education){
        repoEducation.save(education);
    }
    public void delete(int id){
        repoEducation.deleteById(id);
    }
    public boolean existsById(int id){
        return repoEducation.existsById(id);
    }
    public boolean existisByNombreEdu(String nombreEdu){
        return repoEducation.existsByNombreEdu(nombreEdu);
    }

}
