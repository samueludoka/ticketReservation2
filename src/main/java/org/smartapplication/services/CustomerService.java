package org.smartapplication.services;

import org.smartapplication.dtos.request.CreateLoginRequest;
import org.smartapplication.dtos.request.CreateRegistrationRequest;
import org.smartapplication.dtos.request.UpdateCustomerRequest;
import org.smartapplication.dtos.response.ApiResponse;
import org.smartapplication.dtos.response.CustomerRegistrationResponse;
import org.smartapplication.dtos.response.CustomerResponse;
import org.smartapplication.dtos.response.UpdateCustomerResponse;
import org.smartapplication.exception.CustomerNotFoundException;
import org.smartapplication.exception.InvalidDetailsException;

public interface CustomerService {
    CustomerRegistrationResponse createUserAccount(CreateRegistrationRequest request);

    void login(CreateLoginRequest request) throws InvalidDetailsException;

    CustomerResponse getCustomerBy(Long id) throws CustomerNotFoundException;

    ApiResponse<UpdateCustomerResponse> updateCustomer(Long id, UpdateCustomerRequest updateCustomerRequest);
}
