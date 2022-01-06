package com.TQI.tqi_evolution_backend_2021.repository;

import com.TQI.tqi_evolution_backend_2021.model.Solicitacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {

    @Query ("select p from Solicitacao p join p.user u where u.username = :username")
    List<Solicitacao> findAllByUsuario(@Param("username")String usuario);

}
