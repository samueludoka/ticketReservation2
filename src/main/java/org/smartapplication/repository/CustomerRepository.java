package org.smartapplication.repository;

import org.smartapplication.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {



    Customer findByEmail(String email);

    boolean existsByEmail(String email);
}
