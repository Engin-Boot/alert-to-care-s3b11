package com.philips.AlertToCare.repository;

import com.philips.AlertToCare.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<Device, String> {
    public List<Device> findByBedId(String bedId);
}