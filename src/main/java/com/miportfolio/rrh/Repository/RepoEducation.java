package com.miportfolio.rrh.Repository;

import com.miportfolio.rrh.Entity.Education;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoEducation extends JpaRepository<Education, Integer>{
public Optional<Education> findByNombreEdu(String nombreEdu);
public boolean existsByNombreEdu(String nombreEdu);
}
