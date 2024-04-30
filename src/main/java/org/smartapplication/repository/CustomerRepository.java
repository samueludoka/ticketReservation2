package org.smartapplication.repository;

import org.smartapplication.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {



    Customer findByEmail(String email);

    boolean existsByEmail(String email);

}
