package org.smartapplication.dtos.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerResponse {
    private long id;
    private String name;
    private String email;
    private String password;
    private List<NotificationResponse> notification;
}
