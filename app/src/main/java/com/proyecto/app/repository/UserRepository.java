package com.proyecto.app.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.app.models.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}