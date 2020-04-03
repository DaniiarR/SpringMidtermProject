package kg.iau.midtermproject.controller;

import kg.iau.midtermproject.entity.Customer;
import kg.iau.midtermproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerRestController {

    @Autowired
    CustomerService customerService;

    @DeleteMapping("/customers/{customerId}")
    public String deleteEmployee(@PathVariable int customerId) {
        Customer customer = customerService.findById(customerId);
        if (customer == null) {
            throw new RuntimeException("Employee with the given id does not exist: " + customerId);
        }
        customerService.deleteById(customerId);
        return "Successfully deleted a customer with id: " + customerId;
    }

    @PutMapping("/customers")
    public String updateCustomer(@RequestBody Customer customer) {
        customerService.save(customer);
        return "Customer successfully updated: customerId = " + customer.getId();
    }

}
