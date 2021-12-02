package com.rest.dogs.web;


import com.rest.dogs.config.TestConfig;
import com.rest.dogs.security.CryptEncoder;
import com.rest.dogs.security.SecurityConfig;
import com.rest.dogs.service.DogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(DogController.class)
@Import(TestConfig.class)
public class DogControllerUnitTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DogService dogService;


    @Test
    public void getAllDogs() throws Exception {
        this.mockMvc.perform(
                get("/dogs")
                        .with(user("admin").password("password"))
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"dogs\": []}"))
                .andExpect(jsonPath("$.dogs").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.dogs[*].id").isEmpty());

        verify(dogService, times(1)).retrieveDogs();
    }

    @Test
    public void getAllBreeds() throws Exception {
        this.mockMvc.perform(get("/dogs/breed")
                        .with(user("admin").password("password")))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));

        verify(dogService, times(1)).retrieveDogBreed();
    }

    @Test
    public void getBreedById() throws Exception {
        this.mockMvc.perform(get("/dogs/1/breed")
                        .with(user("admin").password("password")))
                .andExpect(status().isOk());

        verify(dogService, times(1)).retrieveDogBreedById(1L);

    }
}
