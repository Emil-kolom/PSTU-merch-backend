package com.example.coursework4.repository;

import com.example.coursework4.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<Client> findByFirstNameAndPhoneNumber(String firstName, String phoneNumber);
}