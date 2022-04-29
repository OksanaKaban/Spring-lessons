package com.springdemo.rest;

import com.springdemo.entity.Customer;
import com.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
    // autowire customer service
    @Autowired
    private CustomerService customerService;

    // add mapping for get /customers
    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    // add mapping for get /customers/{customerId}
    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {

        Customer customer = customerService.getCustomer(customerId);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer Id not found - " + customerId);
        }
        return customer;
    }

    // add mapping for post /customers - add new customer
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer){

        // just in case, if client will pass Id in JSON, set Id to 0
        // this will force to save new item instead of update
        customer.setId(0);
        customerService.saveCustomer(customer);
        return customer;
    }

    // add mapping for put/customers - update existing customer
    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
        return customer;
    }

    // add mapping for DELETE/customers/customerId - delete existing customer

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {

        // check if such customer exist
        Customer customer = customerService.getCustomer(customerId);
        // throw exception if null
        if(customer == null) {
            throw new CustomerNotFoundException("customer Id not found " + customerId);
        }

        // if exists -> return message that delete successful
        customerService.deleteCustomer(customerId);
        return "Deleted customer Id - " + customerId;
    }

}

