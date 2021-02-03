package pl.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.foodapp.model.Dish;
@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
}
