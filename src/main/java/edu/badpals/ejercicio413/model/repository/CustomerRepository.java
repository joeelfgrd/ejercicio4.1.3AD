package edu.badpals.ejercicio413.model.repository;

import java.util.List;

import edu.badpals.ejercicio413.model.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

  List<Customer> findByLastName(String lastName);

  Customer findById(long id);
}