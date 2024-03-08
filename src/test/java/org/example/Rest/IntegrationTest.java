package org.example.Rest;

import org.aspectj.lang.annotation.Before;
import org.example.Repoitory.GarageRepository;
import org.example.entities.Garage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    GarageRepository garageRepository;

    @BeforeEach
    public void setUp() {
        Garage garage = new Garage();
        garage.setName("Garage1");
        garageRepository.save(garage);
    }

    @Test
    public void addGarageShouldReturnStatusCodeOK() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/garages/"))
                .andDo(print())
                .andExpect(jsonPath("$[0].name").value("Garage1"))
                .andExpect(status().isOk());
    }
}
