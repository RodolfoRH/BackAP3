package com.miportfolio.rrh.Repository;

import com.miportfolio.rrh.Entity.Jobs;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RepoJobs extends JpaRepository<Jobs, Integer>{
    public Optional<Jobs> findByNombreExp(String nombreExp);
    public boolean existsByNombreExp(String nombreExp);
}
