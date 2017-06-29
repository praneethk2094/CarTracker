package com.java.training.repository;

import com.java.training.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by prane on 6/26/2017.
 */
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {
}
