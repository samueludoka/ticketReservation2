package org.smartapplication.repository;

import org.smartapplication.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Customer, Long> {

}
