package org.smartapplication.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.smartapplication.dtos.request.CreateLoginRequest;
import org.smartapplication.dtos.request.CreateRegistrationRequest;
import org.smartapplication.dtos.response.CustomerLoginResponse;
import org.smartapplication.dtos.response.CustomerRegistrationResponse;
import org.smartapplication.exception.InvalidDetailsException;
import org.smartapplication.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerServiceImplTest {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerService customerService;



    @Test
    public void testThatCustomersCanBeRegistered(){
        CreateRegistrationRequest request = new CreateRegistrationRequest();
        request.setId(1L);
        request.setName("firstCustomer");
        request.setEmail("firstcustomer@gmail.com");
        request.setPassword("password");
        customerService.createUserAccount(request);
        CustomerRegistrationResponse customerRegistrationResponse = customerService.createUserAccount(request);
        assertNotNull(customerRegistrationResponse);
        assertNotNull(customerRegistrationResponse.getId());
    }
    @Test
    public void testThatCustomerCannotLoginWithWrongDetailsAfterRegistering(){
        CreateRegistrationRequest request = new CreateRegistrationRequest();
        request.setId(1L);
        request.setName("firstCustomer");
        request.setEmail("firstcustomer@gmail.com");
        request.setPassword("password");
        customerService.createUserAccount(request);
        CreateLoginRequest createLoginRequest = new CreateLoginRequest();
        createLoginRequest.setEmail("firstcustomer@gmail.com");
        createLoginRequest.setPassword("password");
        customerService.login(createLoginRequest);
        assertEquals(1,customerRepository.count());
    }

}