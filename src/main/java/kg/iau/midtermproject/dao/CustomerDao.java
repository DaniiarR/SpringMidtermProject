package kg.iau.midtermproject.dao;

import kg.iau.midtermproject.entity.Customer;

import java.util.List;

public interface CustomerDao {

    List<Customer> findAll();

    void saveCustomer(Customer customer);

    Customer findById(int id);

    void deleteById(int id);
}
