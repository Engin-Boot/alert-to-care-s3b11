package com.philips.AlertToCare.repository;

import com.philips.AlertToCare.entities.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AlertRepository extends JpaRepository<Alert, String> {
}