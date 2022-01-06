package com.TQI.tqi_evolution_backend_2021.repository;

import com.TQI.tqi_evolution_backend_2021.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CadastroUsuarioRepository extends JpaRepository<Cliente, Long> {

    @Query("select p from Cliente p where p.email = :email")
    Cliente findByEmail(@Param("email")String email);

}
