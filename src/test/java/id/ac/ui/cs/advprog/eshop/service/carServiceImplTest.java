package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.google.common.collect.Iterators;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class carServiceImplTest {

    @InjectMocks
    CarServiceImpl carService;

    @Mock
    private CarRepository carRepository;

    @BeforeEach
    void setUp() {
    }
    @Test
    void testCreateAndFind() {
        Car car = new Car();
        car.setId("123");
        car.setName("Honda");
        car.setColor("Hijau");
        car.setQuantity(100);
        carService.create(car);

        when(carRepository.create(car)).thenReturn(car);

        Car savedCar = carService.create(car);
        assertEquals(car.getId(), savedCar.getId());
        assertEquals(car.getName(), savedCar.getName());
        assertEquals(car.getColor(), savedCar.getColor());
        assertEquals(car.getQuantity(), savedCar.getQuantity());
    }

    @Test
    void testEdit() {
        Car car = new Car();
        car.setId("0");
        car.setName("Suzuki");
        car.setColor("Biru");
        car.setQuantity(100);
        carService.create(car);

        Car carEdit = new Car();
        carEdit.setId("0");
        carEdit.setName("Honda");
        car.setColor("Hijau");
        carEdit.setQuantity(69);

        when(carRepository.update("0", carEdit)).thenReturn(carEdit);
        carService.update("0", carEdit);
        Car editedCar = carRepository.update("0", carEdit);

        assertNotNull(editedCar);
        assertEquals("Honda", editedCar.getName());
        assertEquals(69, editedCar.getQuantity());
    }

    @Test
    void testDelete() {
        Car car = new Car();
        car.setId("0");
        car.setName("Honda");
        car.setColor("Hijau");
        car.setQuantity(100);
        carService.create(car);
        carService.deleteById("0");

        when(carRepository.findAll()).thenReturn(List.of(car).iterator());
        Iterator <Car> iterator = carService.findAll().iterator();

        // Check if car list is empty
        Iterator<Car> carIterator = carRepository.findAll();
        int size = Iterators.size(carIterator);
        assertEquals(0, size);
    }

    @Test
    void testFindAll() {
        Car car = new Car();
        car.setId("0");
        car.setName("Suzuki");
        car.setQuantity(96);
        carService.create(car);

        when(carRepository.findAll()).thenReturn(List.of(car).iterator());
        Iterator <Car> iterator = carService.findAll().iterator();

        assertTrue(iterator.hasNext());
        Car savedCar = iterator.next();
        assertEquals(car.getId(), savedCar.getId());
        assertEquals(car.getName(), savedCar.getName());
        assertEquals(car.getQuantity(), savedCar.getQuantity());
    }

    @Test
    void testFindById() {
        Car car = new Car();
        car.setId("0");
        car.setName("Kijang");
        car.setColor("Biru");
        car.setQuantity(96);
        carService.create(car);

        when(carRepository.findById("0")).thenReturn(car);

        Car searchedCar = carService.findById("0");

        assertNotNull(searchedCar);
        assertEquals(car, searchedCar);
    }


}
