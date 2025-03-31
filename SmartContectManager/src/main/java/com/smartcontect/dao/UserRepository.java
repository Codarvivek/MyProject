package com.smartcontect.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smartcontect.entites.Users;  // Ensure the correct path for your Users entity class

public interface UserRepository extends JpaRepository<Users, Integer> {
}
