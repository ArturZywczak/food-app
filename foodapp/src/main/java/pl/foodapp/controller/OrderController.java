package pl.foodapp.controller;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.foodapp.model.Calc;
import pl.foodapp.model.Customer;
import pl.foodapp.model.Dish;
import pl.foodapp.model.Order;
import pl.foodapp.repository.CustomerRepository;
import pl.foodapp.repository.DishRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class OrderController {
    private DishRepository dishRepository;
    private CustomerRepository customerRepository;
    private Order order;

    @Autowired
    public OrderController(DishRepository dishRepository, CustomerRepository customerRepository, Order order) {
        this.dishRepository = dishRepository;
        this.order = order;
        this.customerRepository = customerRepository;
    }

    @GetMapping("/order")
    public String order(Model model){
        double price = Calc.addAll(order.getCustomer().getDishes());
        model.addAttribute("allDishes", order.getCustomer().getDishes());
        model.addAttribute("price", price);
        model.addAttribute("customer", new Customer());

        return "orderSummary";
    }


    @GetMapping("/order/add")
    public String orderAdd(@RequestParam(name = "dishId") Long dishId, Model model) {
        Optional<Dish> dishById = dishRepository.findById(dishId);
        Dish dish = dishById.get();
        if (dish == null) {
            return "orderError";
        } else {
            order.addDish(dish);
            System.out.println(order.toString());
            model.addAttribute("dish", dish);
            return "orderSuccess";
        }
    }

    @PostMapping("/order/realize")
    public String realize(@ModelAttribute Customer customer){
        List<Dish> dishes = order.getCustomer().getDishes();
        customer.setDishes(dishes);
        System.out.println(customer);
        customerRepository.save(customer);

        return "realize";
    }


}
