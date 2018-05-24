/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.service;

import hello.domain.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ecyola
 */
@Service
public class ProductServiceImpl implements ProductService {

    private Map<Integer, Product> products;

    public ProductServiceImpl() {
        loadProducts();
    }

    @Override
    public List<Product> listAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product getById(Integer id) {
        return products.get(id);
    }

    @Override
    public Product saveOrUpdate(Product product) {
        if (product != null) {
            if (product.getId() == null) {
                product.setId(getMaxKey());
            }

            products.put(product.getId(), product);

            return product;
        } else {
            throw new RuntimeException("product can't be null");
        }
    }

    @Override
    public void delete(Integer id) {
        products.remove(id);
    }

    
    
    private Integer getMaxKey() {
        return Collections.max(products.keySet()) + 1;
    }

    private void loadProducts() {
        products = new HashMap<>();

        Product product1 = new Product();
        product1.setId(1);
        product1.setDescription("Product 1");
        product1.setPrice(new BigDecimal("100.5"));
        product1.setImageUrl("http://example.com/product1");

        products.put(1, product1);

        Product product2 = new Product();
        product2.setId(2);
        product2.setDescription("Product 2");
        product2.setPrice(new BigDecimal("199.99"));
        product2.setImageUrl("http://example.com/product2");

        products.put(2, product2);
    }

}
