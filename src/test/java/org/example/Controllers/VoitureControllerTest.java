package org.example.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Main;
import org.example.Services.GarageService;
import org.example.Services.VoitureService;
import org.example.entities.Voiture;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@WebMvcTest(VoitureController.class)
@Import(Main.class)
class VoitureControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VoitureService voitureService;

    @MockBean
    private GarageService garageService;


    @Test
    void addVoitureShouldReturnStatusCodeOK() throws Exception {
        Voiture voiture = new Voiture();
        voiture.setMarque("Peugeot");
        voiture.setPuissance(100);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/voitures/addVoiture")
                .content(asJsonString(voiture))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
