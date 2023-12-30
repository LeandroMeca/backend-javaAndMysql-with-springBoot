package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.api.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

}
