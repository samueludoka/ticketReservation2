package org.smartapplication.services;

import org.junit.jupiter.api.Test;
import org.smartapplication.dtos.request.NotificationRequest;
import org.smartapplication.dtos.request.UpdateCustomerRequest;
import org.smartapplication.dtos.response.NotificationResponse;
import org.smartapplication.exception.CustomerNotFoundException;
import org.smartapplication.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class NotificationServiceImplTest {
    @Autowired
    private NotificationService notificationService;

    @Autowired
    private CustomerService customerService;

    @Test
    @Sql({"scripts/insert.sql"})
    public void sendNotificationToCustomer() throws CustomerNotFoundException {
        var notificationCount = customerService.getCustomerBy(1L).getNotification().size();
        UpdateCustomerRequest updateCustomerRequest = new UpdateCustomerRequest();
        updateCustomerRequest.setEmail("secondCustomer@gmail.com");
        customerService.updateCustomer(1L, updateCustomerRequest);
        var currentNotificationCount = customerService.getCustomerBy(1L).getNotification().size();
        assertThat(currentNotificationCount).isGreaterThan(notificationCount);
    }

}