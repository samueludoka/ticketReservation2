package org.smartapplication.services;

import org.smartapplication.dtos.request.NotificationRequest;
import org.smartapplication.dtos.response.NotificationResponse;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService{
    @Override
    public NotificationResponse notifyCustomer(NotificationRequest notificationRequest) {

        return null;
    }
}
