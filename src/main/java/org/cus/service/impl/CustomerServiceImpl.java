package org.cus.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.cus.dto.Customer;
import org.cus.entity.CustomerEntity;
import org.cus.repository.CustomerRepository;
import org.cus.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    final CustomerRepository repository;

    @Override
    public void addCustomer(Customer customer) {
        CustomerEntity customerEntity = new ObjectMapper().convertValue(customer, CustomerEntity.class);
        repository.save(customerEntity);

    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customerList = new ArrayList<>();
        List<CustomerEntity> allEntityList = repository.findAll();
        allEntityList.forEach(entity -> {
            customerList.add(new ObjectMapper().convertValue(entity, Customer.class));

        });
        return customerList;
    }

    @Override
    public void deleteCustomerById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }

    }

    @Override
    public void updateCustomer(Customer customer) {
        if (repository.findById(customer.getId()).isPresent()) {
            repository.save(new ObjectMapper().convertValue(customer, CustomerEntity.class));

        }
    }

    @Override
    public Customer findById(Long id) {
        if (repository.findById(id).isPresent()) {
            Optional<CustomerEntity> byId = repository.findById(id);
            return new ObjectMapper().convertValue(byId.get(), Customer.class);
        }
        return new Customer();
    }

    @Override
    public Customer findByFirstName(String firstName) {
        return new ObjectMapper().convertValue(repository.findByFirstName(firstName),Customer.class);
    }
}
