package org.smartapplication.services;

import org.smartapplication.dtos.request.NotificationRequest;
import org.smartapplication.dtos.response.NotificationResponse;

public interface NotificationService {
    NotificationResponse notifyCustomer(NotificationRequest notificationRequest);
}
