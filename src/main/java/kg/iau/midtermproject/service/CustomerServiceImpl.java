package kg.iau.midtermproject.service;

import kg.iau.midtermproject.dao.CustomerRepository;
import kg.iau.midtermproject.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

   @Autowired
   private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id).orElseThrow(null);
    }

    @Override
    public void deleteById(int id) {
        customerRepository.deleteById(id);
    }
}
