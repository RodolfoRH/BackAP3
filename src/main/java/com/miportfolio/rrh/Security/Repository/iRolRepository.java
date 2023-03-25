package com.miportfolio.rrh.Security.Repository;

import com.miportfolio.rrh.Security.Entity.Rol;
import com.miportfolio.rrh.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rodolfo
 */
@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol>findByRolNombre(RolNombre rolNombre);
}
