package pl.foodapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import pl.foodapp.CustomerStatus;
import pl.foodapp.logic.Calc;
import pl.foodapp.model.Customer;
import pl.foodapp.repository.CustomerRepository;

import java.util.List;

@Controller
public class PanelController {
    CustomerRepository customerRepository;
    private Customer customer;
    @Value("${newCustomer}")
    private String customerStatusNew;

    @Autowired
    public PanelController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/panel")
     public String panel(Model model){
        System.out.println(customerStatusNew);
        List<Customer> allCustomers = customerRepository.findAll();
        model.addAttribute("orders", allCustomers);
         return "/panel/panel";
     }
    @GetMapping("/panel/client/{customerId}")
    public String clientManager(@PathVariable("customerId") Long customerId, Model model){
        customer = customerRepository.getOne(customerId);
        double price = Calc.addAll(customer.getDishes());
        model.addAttribute("customer", customer);
        model.addAttribute("dishesPrice", price);
        model.addAttribute("customerStatus", CustomerStatus.values());
        return "/panel/client";
    }

    @GetMapping("/panel/serviced/{customerId}")
    public String serviceCustomer(@PathVariable("customerId") Long customerId, Model model, @ModelAttribute(name = "status") CustomerStatus customerStatus){
        customer.setCustomerStatus(customerStatus);
        customerRepository.save(customer);
        model.addAttribute("customer", customer);
        return "/panel/finishedOrder";
    }





}
