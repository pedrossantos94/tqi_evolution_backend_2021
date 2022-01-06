package com.TQI.tqi_evolution_backend_2021.repository;

import com.TQI.tqi_evolution_backend_2021.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, String> {

}
