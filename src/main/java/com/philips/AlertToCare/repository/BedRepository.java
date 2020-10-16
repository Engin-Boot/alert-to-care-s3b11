package com.philips.AlertToCare.repository;

import com.philips.AlertToCare.entities.Bed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BedRepository extends JpaRepository<Bed, String> {
    public List<Bed> findByClientId(String clientId);
}