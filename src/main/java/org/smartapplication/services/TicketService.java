package org.smartapplication.services;

import org.smartapplication.dtos.request.CreateTicketRequest;
import org.smartapplication.dtos.response.CreateTicketResponse;

public interface TicketService {
    CreateTicketResponse creatTicket(CreateTicketRequest createTicketrequest);


}
