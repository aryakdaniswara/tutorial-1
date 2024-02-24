package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.service.CarServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class CarControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private CarController controller;

    @Mock
    private CarServiceImpl carService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testCreateCarPage() throws Exception {
        mockMvc.perform(get("/car/createCar"))
                .andExpect(status().isOk())
                .andExpect(view().name("CreateCar"));
    }

    @Test
    public void testCreateCarPost() throws Exception {
        mockMvc.perform(post("/car/createCar")
                        .flashAttr("car", new Car()))  // add temporary attributes, model "car"
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("listCar"));
    }

    @Test
    public void testCarListPage() throws Exception {
        List<Car> allCars = Arrays.asList(new Car(), new Car());
        when(carService.findAll()).thenReturn(allCars);

        mockMvc.perform(get("/car/listCar"))
                .andExpect(status().isOk())
                .andExpect(view().name("CarList"))
                .andExpect(model().attributeExists("cars"));
    }

    @Test
    public void testEditCarPage() throws Exception {
        String carId = "1";
        when(carService.findById(carId)).thenReturn(new Car());

        mockMvc.perform(get("/car/editCar/{carId}", carId))
                .andExpect(status().isOk())
                .andExpect(view().name("EditCar"))
                .andExpect(model().attributeExists("car"));
    }

    @Test
    public void testEditCarPost() throws Exception {
        mockMvc.perform(post("/car/editCar")
                        .flashAttr("car", new Car()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("listCar"));
    }

    @Test
    public void testDeleteCar() throws Exception {
        String carId = "1";
        when(carService.findById(carId)).thenReturn(new Car());

        mockMvc.perform(post("/car/deleteCar")
                        .param("id", "1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("listCar"));
    }
}
