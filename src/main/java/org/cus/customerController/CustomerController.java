package org.cus.customerController;

import lombok.RequiredArgsConstructor;
import org.cus.dto.Customer;
import org.cus.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cus-controller")
@CrossOrigin
//http://localhost:8080/cus-controller/add-customer
@RequiredArgsConstructor
public class CustomerController {
    final CustomerService service;
    @PostMapping("add-customer")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomer(@RequestBody Customer customer) { service.addCustomer(customer); }

    @GetMapping("get-all")
    public List<Customer> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/delete-cus/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteCustomer(@PathVariable Long id){
        service.deleteCustomerById(id);
        return "Deleted";

    }
    @PutMapping("/update-customer")
    public void updateCustomer(@RequestBody Customer customer){
        service.updateCustomer(customer);
    }
    @GetMapping("/find-by-id/{id}")
    public Customer findById(@PathVariable Long id){
        return service.findById(id);
    }
    @GetMapping("/find-by-firstName/{firstName}")
    public Customer findByFirstName(@PathVariable String firstName){
        return service.findByFirstName(firstName);

    }
}