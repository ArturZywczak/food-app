package pl.foodapp.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.foodapp.model.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
