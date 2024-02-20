package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ProductControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private ProductController controller;

    @Mock
    private ProductService service;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this); // initialize mockito
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testCreateProductPage() throws Exception {
        mockMvc.perform(get("/product/create"))
                .andExpect(status().isOk())
                .andExpect(view().name("CreateProduct"));
    }

    @Test
    public void testCreateProductPost() throws Exception {
        when(service.create(any(Product.class))).thenReturn(new Product()); // create and return new product
        mockMvc.perform(post("/product/create"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("list"));
    }

    @Test
    public void testProductListPage() throws Exception {
        List<Product> allProducts = Arrays.asList(new Product(), new Product());
        when(service.findAll()).thenReturn(allProducts);

        mockMvc.perform(get("/product/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("ProductList"))
                .andExpect(model().attributeExists("products"));
    }

    @Test
    public void testEditProductPage() throws Exception {
        when(service.findById(anyString())).thenReturn(new Product());

        mockMvc.perform(get("/product/edit/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("EditProduct"))
                .andExpect(model().attributeExists("product"));
    }

    @Test
    public void testEditProductPost() throws Exception {
        when(service.edit(any(Product.class))).thenReturn(new Product());

        mockMvc.perform(post("/product/edit"))
                .andExpect(status().is3xxRedirection()) // check for page change/redirection
                .andExpect(redirectedUrl("list"));
    }

    @Test
    public void testDeleteProduct() throws Exception {
        when(service.findById(anyString())).thenReturn(new Product());

        mockMvc.perform(get("/product/delete/1"))
                .andExpect(status().is3xxRedirection()) // check for page change/redirection
                .andExpect(redirectedUrl("../list"));
    }
}
