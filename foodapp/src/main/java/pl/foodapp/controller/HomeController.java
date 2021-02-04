package pl.foodapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.foodapp.model.Dish;
import pl.foodapp.repository.DishRepository;

import java.util.List;

@Controller
public class HomeController {
    private DishRepository dishRepository;

    @Autowired
    public HomeController(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("welcome", "Witamy w naszej pizzerii!");
        List<Dish> allDishes = dishRepository.findAll();
        model.addAttribute("dishes", allDishes);
        return "index";
    }

}
