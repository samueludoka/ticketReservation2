package org.smartapplication.services;

import org.smartapplication.dtos.request.*;
import org.smartapplication.dtos.response.*;
import org.smartapplication.exception.InvalidDetailsException;

public interface CustomerService {
    CustomerRegistrationResponse createUserAccount(CreateRegistrationRequest request);

    void login(CreateLoginRequest request) throws InvalidDetailsException;

    BookTicketResponse bookTicket(BookTicketRequest bookTicketRequest, AddTicketRequest ticketRequest) throws Exception;
}
