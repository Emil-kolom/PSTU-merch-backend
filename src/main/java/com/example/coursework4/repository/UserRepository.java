package com.example.coursework4.repository;

import com.example.coursework4.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}