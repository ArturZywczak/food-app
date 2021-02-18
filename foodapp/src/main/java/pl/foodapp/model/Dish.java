package pl.foodapp.model;

import com.sun.istack.NotNull;
import pl.foodapp.model.Customer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "dish")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "ingredients", length = 400, nullable = false)
    private String ingredients;
    @Column(name = "price", nullable = false)
    private double price;
    @ManyToMany(mappedBy = "dishes")
    private List<Customer> customers;

    public Dish() {
    }

    public Dish(String description, double price, String name) {
        this.ingredients = description;
        this.price = price;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public void addCustomer(Customer customer) {
        if (customers == null) {
            customers = new ArrayList<>();
        } else {
            customers.add(customer);
        }
    }

    public String printDish(){
        return this.name;
    }
}
