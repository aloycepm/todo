/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.service;

import hello.domain.Customer;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ecyola
 */
@Service
@Profile("jpadao")
public class CustomerService implements CRUDService<Customer> {

    private CustomerRepository customerRepository;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> listAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getById(Integer id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer;
    }

    @Override
    public Customer saveOrUpdate(Customer customer) {
        if (customer != null) {
            customerRepository.save(customer);
        }
        throw new RuntimeException("Customer Can't be null.");
    }

    @Override
    public void delete(Integer id) {
        
    }

}
