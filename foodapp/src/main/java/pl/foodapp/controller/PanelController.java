package pl.foodapp.controller;

import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.foodapp.CustomerStatus;
import pl.foodapp.model.Calc;
import pl.foodapp.model.Customer;
import pl.foodapp.model.Dish;
import pl.foodapp.repository.CustomerRepository;

import java.util.List;
import java.util.stream.Stream;

@Controller
public class PanelController {
    CustomerRepository customerRepository;
    private Long customerId;
    private Customer customer;
    @Autowired
    public PanelController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/panel")
     public String panel(Model model){
        List<Customer> allCustomers = customerRepository.findAll();
        model.addAttribute("orders", allCustomers);
         return "/panel/panel";
     }
    @GetMapping("/panel/client/{customerId}")
    public String clientManager(@PathVariable("customerId") Long customerId, Model model){
        customer = customerRepository.getOne(customerId);
        CustomerStatus customerStatus = customer.getCustomerStatus();
        double price = Calc.addAll(customer.getDishes());
        model.addAttribute("customer", customer);
        model.addAttribute("dishesPrice", price);
        return "/panel/client";
    }

    @GetMapping("/panel/serviced")
    public String serviceCustomer(Model model){
        customerRepository.delete(customer);
      return "/panel/clientServiced";
    }





}
