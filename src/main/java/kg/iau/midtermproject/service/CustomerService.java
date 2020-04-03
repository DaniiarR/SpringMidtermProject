package kg.iau.midtermproject.service;

import kg.iau.midtermproject.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void deleteById(int id);
}
