package org.smartapplication.services;

import org.smartapplication.dtos.request.CreateTicketRequest;
import org.smartapplication.dtos.response.CreateTicketResponse;
import org.smartapplication.model.Ticket;
import org.smartapplication.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
public class TicketServiceImpl implements TicketService{
    @Autowired
    private TicketRepository ticketRepository;
    @Override
    public CreateTicketResponse creatTicket(CreateTicketRequest createTicketrequest) {
        Ticket ticket = new Ticket();
        ticket.setName(createTicketrequest.getName());
        ticket.setReservationNumber(createTicketrequest.getReservationNumber());
        Ticket foundTicket = ticketRepository.save(ticket);
        CreateTicketResponse createTicketResponse = new CreateTicketResponse();
        createTicketResponse.setReservationNumber(foundTicket.getReservationNumber());
        return createTicketResponse;
    }

}
