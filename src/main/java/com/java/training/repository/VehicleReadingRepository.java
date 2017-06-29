package com.java.training.repository;

import com.java.training.entities.VehicleReading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleReadingRepository extends JpaRepository<VehicleReading, String> {
    List<VehicleReading> findAllByVin(String vin);

    void deleteAllByVin(String vin);
}
