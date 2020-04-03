package kg.iau.midtermproject.controller;

import kg.iau.midtermproject.entity.Customer;
import kg.iau.midtermproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public String sayHello(Model model) {
        model.addAttribute("date", new java.util.Date());
        return "index";
    }

    @GetMapping("/customers")
    public String getCustomers(Model model) {
        List<Customer> customerList = customerService.findAll();
        if (customerList != null) {
            model.addAttribute("customers", customerList);
        }
        return "customers";
    }

    @GetMapping("customers/add")
    public String showFormForAdd(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);

        return "addCustomerForm";
    }

    @PostMapping("/customers/save")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);

        return "redirect:/customers";
    }
}
