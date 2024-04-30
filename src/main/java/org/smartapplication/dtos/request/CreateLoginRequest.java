package org.smartapplication.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateLoginRequest {
    private Long Id;
    private String email;
    private String password;


}
