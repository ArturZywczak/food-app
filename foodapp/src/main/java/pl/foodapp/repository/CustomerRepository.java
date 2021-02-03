package pl.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.foodapp.model.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {



}
