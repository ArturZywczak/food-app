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
    private int id;
    @Column(name = "description", length = 400, nullable = false)
    private String description;
    @NotNull
    @Column(name = "pricesss", nullable = false)
    private double price;
    @ManyToMany(mappedBy = "dishes")
    private List<Customer> customers;

    public Dish() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Dish(String description, double price) {
        this.description = description;
        this.price = price;
    }

    public void addCustomer(Customer customer) {
        if (customers == null) {
            customers = new ArrayList<>();
        } else {
            customers.add(customer);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return id == dish.id && Double.compare(dish.price, price) == 0 && Objects.equals(description, dish.description) && Objects.equals(customers, dish.customers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, price, customers);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", customers=" + customers +
                '}';
    }
}
