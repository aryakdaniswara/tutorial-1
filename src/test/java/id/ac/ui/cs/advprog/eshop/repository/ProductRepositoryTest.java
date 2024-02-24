package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
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
public class ProductRepositoryTest {

    @InjectMocks
    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
    }
    @Test
    void testCreateAndFind() {
        Product product = new Product();
        product.setId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setName("Sampo Cap Bambang");
        product.setQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getId(), savedProduct.getId());
        assertEquals(product.getName(), savedProduct.getName());
        assertEquals(product.getQuantity(), savedProduct.getQuantity());
    }

    @Test
    void testEdit() {
        Product product = new Product();
        product.setId("0");
        product.setName("Sampo Kuda");
        product.setQuantity(100);
        productRepository.create(product);

        Product productEdit = new Product();
        productEdit.setId("0");
        productEdit.setName("Sampo Sapi");
        productEdit.setQuantity(69);
        Product editedProduct = productRepository.edit(productEdit);

        assertNotNull(editedProduct);
        assertEquals("Sampo Sapi", editedProduct.getName());
        assertEquals(69, editedProduct.getQuantity());
    }

    @Test
    void testEditIfEmpty() {
        Product product = new Product();
        product.setId("0");
        product.setName("Botol");
        product.setQuantity(100);
        
        // Expect the edit to fail
        assertThrows(NoSuchElementException.class, () ->  productRepository.edit(product));

        // Check if product list is empty
        Iterator<Product> productIterator = productRepository.findAll();
        int size = Iterators.size(productIterator);
        assertEquals(0, size);;
    }

    @Test
    void testDelete() {
        Product product = new Product();
        product.setId("0");
        product.setName("Botol");
        product.setQuantity(100);
        productRepository.create(product);
        productRepository.delete(product);

        // Check if product list is empty
        Iterator<Product> productIterator = productRepository.findAll();
        int size = Iterators.size(productIterator);
        assertEquals(0, size);
    }

    @Test
    void testDeleteIfEmpty() {
        Product product = new Product();
        product.setId("0");
        product.setName("Botol");
        product.setQuantity(100);
        
        // Expect the delete to fail
        assertThrows(NoSuchElementException.class, () -> productRepository.delete(product));

        // Check if product list is empty
        Iterator<Product> productIterator = productRepository.findAll();
        int size = Iterators.size(productIterator);
        assertEquals(0, size);;
    }

    @Test
    void testFindByIdIfEmpty() {
        Product product = new Product();
        product.setId("0");
        product.setName("Sampo Babi");
        product.setQuantity(96);
        productRepository.create(product);

        // expect search to fail
        assertThrows(NoSuchElementException.class, () -> productRepository.findById("1"));
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setName("Sampo Cap Bambang");
        product1.setQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setName("Sampo Cap Usep");
        product2.setQuantity(50);
        productRepository.create(product2);

        Iterator <Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getId(), savedProduct.getId());
        savedProduct = productIterator.next();
        assertEquals(product2.getId(), savedProduct.getId());
        assertFalse(productIterator.hasNext());
    }
    
}
