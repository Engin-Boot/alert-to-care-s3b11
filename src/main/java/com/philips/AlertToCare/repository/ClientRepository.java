package com.philips.AlertToCare.repository;

import com.philips.AlertToCare.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
    List<Client> findAll();
}