package pl.foodapp.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderInfo {
       private List<String> orderInformation = List.of("Zamówienie złozone!", "Zamówienie w trakcie przygotowania", "Dostawca wyjechał z zamóieniem");



    public OrderInfo() {
    }

    public List<String> getOrderInformation() {
        return orderInformation;
    }

    public void setOrderInformation(List<String> orderInformation) {
        this.orderInformation = orderInformation;
    }
}
