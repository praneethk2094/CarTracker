package com.java.training.mocking;

import com.java.training.Application;
import com.java.training.Service.VehicleService;
import com.java.training.entities.Vehicle;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class controllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private VehicleService vehicleService;

    @Before
    public void before() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void TestfindoneVehicle() throws Exception {


        given(this.vehicleService.findOneVehicle("123"))
                .willReturn(new Vehicle("123", "Honda", "Civic"));

        //Mocked Server and checked result.
        this.mockMvc.perform(get("/vehicles/find/123"))
                .andExpect(status().isOk())
                .andExpect(content().json("{vin:\"123\"}"));
    }

    @Test
    public void TestfindAllVehicles() throws Exception {
        List<Vehicle> vehicles = Collections.singletonList(new Vehicle("123", "Honda", "Tx123"));
        given(this.vehicleService.findAllVehicles())
                .willReturn(vehicles);

        //Mocked Server and checked result.
        mockMvc.perform(get("/vehicles/find"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(new MediaType(MediaType.APPLICATION_JSON.getType(),
                        MediaType.APPLICATION_JSON.getSubtype(),
                        Charset.forName("utf8"))))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].vin", Matchers.is("123")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].make", Matchers.is("Honda")));
    }
}

