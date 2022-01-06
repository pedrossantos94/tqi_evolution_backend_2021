package com.TQI.tqi_evolution_backend_2021.repository;

import com.TQI.tqi_evolution_backend_2021.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByUsername(String username);

}
