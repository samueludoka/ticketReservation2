package org.smartapplication.services;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.smartapplication.dtos.request.AddTicketRequest;
import org.smartapplication.dtos.request.BookTicketRequest;
import org.smartapplication.dtos.request.CreateLoginRequest;
import org.smartapplication.dtos.request.CreateRegistrationRequest;
import org.smartapplication.dtos.response.BookTicketResponse;
import org.smartapplication.dtos.response.CustomerLoginResponse;
import org.smartapplication.dtos.response.CustomerRegistrationResponse;
import org.smartapplication.exception.InvalidDetailsException;
import org.smartapplication.model.Category;
import org.smartapplication.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@AllArgsConstructor
@SpringBootTest
class CustomerServiceImplTest {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerService customerService;
    private final Category category;



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
    @Test
    public void testThatCustomerCanBookTicket() throws Exception {
        BookTicketRequest bookTicketRequest = new BookTicketRequest();
        AddTicketRequest ticketRequest = new AddTicketRequest();
        bookTicketRequest.setId(1L);
        bookTicketRequest.setName(category.CONCERT);
        bookTicketRequest.setReservationNumber("010");
        bookTicketRequest.setReservationDate(LocalDateTime.parse("30|04|2024"));
        BookTicketResponse bookTicketResponse = customerService.bookTicket(bookTicketRequest, ticketRequest);
        assertNotNull(bookTicketResponse);


    }

}