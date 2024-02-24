package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.google.common.collect.Iterators;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CarRepositoryTest {

    @InjectMocks
    CarRepository carRepository;

    @BeforeEach
    void setUp() {
    }
    @Test
    void testCreateAndFind() {
        Car car = new Car();
        car.setCarName("Innova");
        car.setCarColor("Biru");
        car.setCarQuantity(100);
        carRepository.create(car);

        Iterator<Car> carIterator = carRepository.findAll();
        assertTrue(carIterator.hasNext());
        Car savedCar = carIterator.next();
        assertEquals(car.getCarName(), savedCar.getCarName());
        assertEquals(car.getCarQuantity(), savedCar.getCarQuantity());
    }

    @Test
    void testEdit() {
        Car car = new Car();
        car.setCarId("0");
        car.setCarName("Avanza");
        car.setCarColor("Biru");
        car.setCarQuantity(100);
        carRepository.create(car);

        Car carEdit = new Car();
        carEdit.setCarId("0");
        carEdit.setCarName("Ferrari");
        carEdit.setCarColor("Merah");
        carEdit.setCarQuantity(69);
        Car editedCar = carRepository.update("0", carEdit);

        assertNotNull(editedCar);
        assertEquals("Ferrari", editedCar.getCarName());
        assertEquals("Merah", editedCar.getCarColor());
        assertEquals(69, editedCar.getCarQuantity());
    }

    @Test
    void testEditIfEmpty() {
        Car car = new Car();
        car.setCarId("0");
        car.setCarName("Ferrari");
        car.setCarColor("Merah");
        car.setCarQuantity(100);
        carRepository.create(car);


        // Expect the edit to fail
        Car updatedCar= carRepository.update("1", car);

        // Check if car list is empty
        assertNotEquals(car, updatedCar);
    }

    @Test
    void testDelete() {
        Car car = new Car();
        car.setCarId("0");
        car.setCarName("Botol");
        car.setCarQuantity(100);
        carRepository.create(car);
        carRepository.delete("0");

        // Check if car list is empty
        Iterator<Car> carIterator = carRepository.findAll();
        int size = Iterators.size(carIterator);
        assertEquals(0, size);
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<Car> carIterator = carRepository.findAll();
        assertFalse(carIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneCar() {
        Car car1 = new Car();
        car1.setCarId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        car1.setCarName("Innova");
        car1.setCarQuantity(100);
        carRepository.create(car1);

        Car car2 = new Car();
        car2.setCarId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        car2.setCarName("Sampo Cap Usep");
        car2.setCarQuantity(50);
        carRepository.create(car2);

        Iterator <Car> carIterator = carRepository.findAll();
        assertTrue(carIterator.hasNext());
        Car savedCar = carIterator.next();
        assertEquals(car1.getCarId(), savedCar.getCarId());
        savedCar = carIterator.next();
        assertEquals(car2.getCarId(), savedCar.getCarId());
        assertFalse(carIterator.hasNext());
    }

    @Test
    void testFindById() {
        Car car = new Car();
        car.setCarId("0");
        car.setCarName("Honda");
        car.setCarColor("Hijau");
        car.setCarQuantity(96);
        carRepository.create(car);


        Car searchedCar = carRepository.findById("0");

        assertNotNull(searchedCar);
        assertEquals(car, searchedCar);
    }

    @Test
    void testFindByIdIfEmpty() {
        Car car = new Car();
        car.setCarId("0");
        car.setCarName("Honda");
        car.setCarColor("Hijau");
        car.setCarQuantity(96);
        carRepository.create(car);

        // expect search to fail
        assertNull(carRepository.findById("1"));
    }

}
