package com.java.training.mocking;

import com.java.training.entities.Vehicle;
import com.java.training.repository.VehicleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by prane on 6/30/2017.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class JPATests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private VehicleRepository repository;

    @Test
    public void testVehicleRepository() throws Exception {
        this.entityManager.persist(new Vehicle("123", "bmw", "1234"));
        Vehicle vehicle = this.repository.findOne("123");
        assertThat(vehicle.getMake()).isEqualTo("bmw");
        assertThat(vehicle.getVin()).isEqualTo("123");
    }
}
