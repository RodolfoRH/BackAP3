package com.miportfolio.rrh.Service;

import com.miportfolio.rrh.Entity.Jobs;
import com.miportfolio.rrh.Repository.RepoJobs;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServiceJobs {

    @Autowired
    RepoJobs repoJobs;

    public List<Jobs> list() {
        return repoJobs.findAll();
    }

    public Optional<Jobs> getOne(int id) {
        return repoJobs.findById(id);
    }

    public Optional<Jobs> getByNombreExp(String nombreExp) {
        return repoJobs.findByNombreExp(nombreExp);
    }

    public void save(Jobs varExp) {
        repoJobs.save(varExp);
    }

    public void delete(int id) {
        repoJobs.deleteById(id);
    }

    public boolean existsById(int id) {
        return repoJobs.existsById(id);
    }

    public boolean existsByNombreExp(String nombreExp) {
        return repoJobs.existsByNombreExp(nombreExp);
    }

}
