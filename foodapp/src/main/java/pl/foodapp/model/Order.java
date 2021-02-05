package pl.foodapp.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import pl.foodapp.CustomerStatus;

import java.util.ArrayList;

@Component
@SessionScope
public class Order {
    private Customer customer;


    public void addDish(Dish dish){
        customer.getDishes().add(dish);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Order() {
        createCustomer();
    }

    private void createCustomer() {
       customer = new Customer();
       customer.setDishes(new ArrayList<>());
    }
    public void removeOrder() {
        customer = new Customer();
        customer.setDishes(new ArrayList<>());
    }
    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                '}';
    }
}
