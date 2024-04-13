package org.smartapplication.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRegistrationRequest {
    private Long id;
    private String name;
    private String email;
    private String password;
}
