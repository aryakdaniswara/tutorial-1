package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.google.common.collect.Iterators;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class productServiceImplTest {

    @InjectMocks
    ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
    }
    @Test
    void testCreateAndFind() {
        Product product = new Product();
        product.setProductId("123");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productService.create(product);

        when(productRepository.create(product)).thenReturn(product);

        Product savedProduct = productService.create(product);
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
        productService.create(product);

        Product productEdit = new Product();
        productEdit.setProductId("0");
        productEdit.setProductName("Sampo Sapi");
        productEdit.setProductQuantity(69);

        when(productRepository.edit(productEdit)).thenReturn(productEdit);
        Product editedProduct = productService.edit(productEdit);

        assertNotNull(editedProduct);
        assertEquals("Sampo Sapi", editedProduct.getProductName());
        assertEquals(69, editedProduct.getProductQuantity());
    }

    @Test
    void testDelete() {
        Product product = new Product();
        product.setProductId("0");
        product.setProductName("Botol");
        product.setProductQuantity(100);
        productService.create(product);
        productService.delete(product);

        when(productRepository.findAll()).thenReturn(List.of(product).iterator());
        Iterator <Product> iterator = productService.findAll().iterator();

        // Check if product list is empty
        Iterator<Product> productIterator = productRepository.findAll();
        int size = Iterators.size(productIterator);
        assertEquals(0, size);
    }

    @Test
    void testFindAll() {
        Product product = new Product();
        product.setProductId("0");
        product.setProductName("Sampo Babi");
        product.setProductQuantity(96);
        productService.create(product);

        when(productRepository.findAll()).thenReturn(List.of(product).iterator());
        Iterator <Product> iterator = productService.findAll().iterator();

        assertTrue(iterator.hasNext());
        Product savedProduct = iterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testFindById() {
        Product product = new Product();
        product.setProductId("0");
        product.setProductName("Sampo Babi");
        product.setProductQuantity(96);
        productService.create(product);

        when(productRepository.findAll()).thenReturn(List.of(product).iterator());
        Product searchedProduct = productService.findById("0");

        assertNotNull(searchedProduct);
        assertEquals(product.getProductId(), searchedProduct.getProductId());
        assertEquals(product.getProductName(), searchedProduct.getProductName());
        assertEquals(product.getProductQuantity(), searchedProduct.getProductQuantity());
        assertEquals(product, searchedProduct);
    }

    @Test
    void testFindByIdIfEmpty() {
        Product product = new Product();
        product.setProductId("0");
        product.setProductName("Sampo Babi");
        product.setProductQuantity(96);
        productService.create(product);

        when(productRepository.findAll()).thenReturn(List.of(product).iterator());

        // expect search to fail
        assertThrows(NoSuchElementException.class, () -> productService.findById("1"));
    }


}
