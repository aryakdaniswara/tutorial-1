package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        this.car = new Car();
        this.car.setId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        this.car.setName("Avanza");
        this.car.setColor("Biru");
        this.car.setQuantity(100);
    }

    @Test
    void testGetCarId() {
        assertEquals("eb558e9f-1c39-460e-8860-71af6af63bd6", this.car.getId());
    }

    @Test
    void testGetCarName() {
        assertEquals("Avanza", this.car.getName());
    }

    @Test
    void testGetCarColor() {
        assertEquals("Biru", this.car.getColor());
    }

    @Test
    void testGetCarQuantity() {
        assertEquals(100, this.car.getQuantity());
    }
}