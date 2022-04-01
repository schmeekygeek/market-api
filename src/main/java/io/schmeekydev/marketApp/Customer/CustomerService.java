package io.schmeekydev.marketApp.Customer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private static final String USER_NOT_FOUND_MSG_ID = "The user with the id %s cannot be found";
    private static final String USER_NOT_FOUND_MSG_EMAIL = "The user with the email %s cannot be found";
    @Autowired
    private CustomerRepository customerRepository;

    // GET all Customers
    public List<Customer> getAllCustomers(){
        return (ArrayList<Customer>) customerRepository.findAll();
    }

    // GET Customer by id
    public Customer getCustomerById(int id){
        return customerRepository.findById(id).orElse(null);
    }

    // GET customer by email
    public Customer getCustomerByEmail(String email){
        return customerRepository.findByEmail(email).orElse(null);
    }

    // POST Customer
    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }

    // PUT Customer by ID
    public void updateCustomerById(Customer updatedCustomer, int id) {
        Customer customer = customerRepository.findById(id).orElse(null);

        if(customer == null){
            throw new NullPointerException(String.format(USER_NOT_FOUND_MSG_ID, id));
        }

        customer.setAddress(updatedCustomer.getAddress());
        customer.setAge(updatedCustomer.getAge());
        customer.setAvatarURL(updatedCustomer.getAvatarURL());
        customer.setEmail(updatedCustomer.getEmail());
        customer.setName(updatedCustomer.getName());
        customer.setPhoneNumber(updatedCustomer.getPhoneNumber());
        customerRepository.save(customer);
    }

    // PUT Customer By Email
    public void updateCustomerByEmail(Customer updatedCustomer, String email) {
        Customer customer = customerRepository.findByEmail(email).orElse(null);

        if(customer == null){
            throw new NullPointerException(String.format(USER_NOT_FOUND_MSG_EMAIL, email));
        }

        customer.setAddress(updatedCustomer.getAddress());
        customer.setAge(updatedCustomer.getAge());
        customer.setAvatarURL(updatedCustomer.getAvatarURL());
        customer.setEmail(updatedCustomer.getEmail());
        customer.setName(updatedCustomer.getName());
        customer.setPhoneNumber(updatedCustomer.getPhoneNumber());
        customerRepository.save(customer);
    }

    // DELETE customer by ID
    public void deleteCustomerById(int id){
        customerRepository.deleteById(id);
    }

    // DELETE Customer by Email
    public void deleteCustomerByEmail(String email){
        customerRepository.deleteByEmail(email);
    }

}
