/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.repository;

import org.springframework.data.repository.CrudRepository;
import hello.domain.*;
/**
 *
 * @author Ecyola
 */
public interface ProductRepository extends CrudRepository<Product, Integer>{
    
}
