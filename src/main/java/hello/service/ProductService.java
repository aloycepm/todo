/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.service;

import hello.domain.Product;
import java.util.List;

/**
 *
 * @author Ecyola
 */
public interface ProductService {

    public List<Product> listAllProduct();

    public Product getProductById(Integer id);

    public Product saveOrUpdate(Product product);
}
