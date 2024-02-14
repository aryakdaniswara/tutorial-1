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
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testEdit() {
        Product product = new Product();
        product.setProductId("0");
        product.setProductName("Sampo Kuda");
        product.setProductQuantity(100);
        productRepository.create(product);

        Product productEdit = new Product();
        productEdit.setProductId("0");
        productEdit.setProductName("Sampo Sapi");
        productEdit.setProductQuantity(69);
        Product editedProduct = productRepository.edit(productEdit);

        assertNotNull(editedProduct);
        assertEquals("Sampo Sapi", editedProduct.getProductName());
        assertEquals(69, editedProduct.getProductQuantity());
    }

    @Test
    void testEditIfEmpty() {
        Product product = new Product();
        product.setProductId("0");
        product.setProductName("Botol");
        product.setProductQuantity(100);
        
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
        product.setProductId("0");
        product.setProductName("Botol");
        product.setProductQuantity(100);
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
        product.setProductId("0");
        product.setProductName("Botol");
        product.setProductQuantity(100);
        
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
        product.setProductId("0");
        product.setProductName("Sampo Babi");
        product.setProductQuantity(96);
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
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Iterator <Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());
        savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());
        assertFalse(productIterator.hasNext());
    }
    
}
