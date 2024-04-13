package org.smartapplication.repository;

import org.smartapplication.model.CustomerNotification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<CustomerNotification, Long> {

}
