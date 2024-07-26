package org.cus.service;

import org.cus.dto.Customer;

import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);
    List<Customer> getAll();

    void deleteCustomerById(Long id);

    void updateCustomer(Customer customer);

    Customer findById(Long id);

    Customer findByFirstName(String firstName);
}
