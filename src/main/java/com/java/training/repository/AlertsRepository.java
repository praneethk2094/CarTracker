package com.java.training.repository;

import com.java.training.entities.Alerts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by diksh on 6/26/2017.
 */
@Repository
public interface AlertsRepository extends JpaRepository<Alerts, String> {

}
