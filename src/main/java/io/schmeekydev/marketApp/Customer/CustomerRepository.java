package io.schmeekydev.marketApp.Customer;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{
    public Optional<Customer> findById(int id);
    public Optional<Customer> findByEmail(String email);
    public void deleteByEmail(String email);
}
