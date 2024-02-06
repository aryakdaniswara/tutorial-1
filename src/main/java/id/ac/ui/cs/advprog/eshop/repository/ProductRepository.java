package id.ac.ui.cs.advprog.eshop.repository;

import  id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();
    private static int productCount = 0;

    public Product create(Product product) {
        product.setProductId(Integer.toString(productCount)); // make product id
        productCount++;
        productData.add(product);
        return product;
    }

    public  Iterator<Product> findAll() {
        return  productData.iterator();
    }

    public Product edit(Product product) {
        String productId = product.getProductId();
        for (int i = 0; i < productData.size(); i++) {
            if (productData.get(i).getProductId().equals(product.getProductId())) {
                productData.set(i, product);
                return product;
            }
        }
        throw new NoSuchElementException("Product not found with ID: " + productId);
    }
}