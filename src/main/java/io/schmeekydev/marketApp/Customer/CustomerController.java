package io.schmeekydev.marketApp.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // GET all customers
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(){
        ArrayList<Customer> customers = new ArrayList<Customer>();
        customers = (ArrayList<Customer>) this.customerService.getAllCustomers();
        if (customers == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.of(Optional.of(customers));
    }

    // GET customer by id
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") int id){
        Customer customer = this.customerService.getCustomerById(id);
        if(customer == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.of(Optional.of(customer));
    }

    // GET customer by email
    @GetMapping("/email/{email}")
    public ResponseEntity<Customer> getCustomerByEmail(@PathVariable("email") String email){
        Customer customer = this.customerService.getCustomerByEmail(email);
        if(customer == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.of(Optional.of(customer));
    }

    // POST customer
    @PostMapping("/post")
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer){
        this.customerService.addCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // PUT customer
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer){
        this.customerService.updateCustomerById(customer, id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    // PUT customer
    @PutMapping("/email/{email}")
    public ResponseEntity<String> updateCustomerByEmail(@PathVariable("email") String email, @RequestBody Customer customer){
        this.customerService.updateCustomerByEmail(customer, email);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // DELETE customer
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") int id){
        this.customerService.deleteCustomerById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // DELETE customer
    @DeleteMapping("/email/{email}")
    public ResponseEntity<String> deleteCustomerByEmail(@PathVariable("email") String email){
        this.customerService.deleteCustomerByEmail(email);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
