package pl.foodapp.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Calc {


   static public double addAll(List<Dish> dishList) {
        double price = 0;
        for (Dish dish : dishList) {
            price += dish.getPrice();
        }
        return price;
    }


}
