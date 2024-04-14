package org.smartapplication.services;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.smartapplication.dtos.request.AddTicketRequest;
import org.smartapplication.dtos.request.CreateTicketRequest;
import org.smartapplication.dtos.response.AddEventResponse;
import org.smartapplication.dtos.response.CreateTicketResponse;
import org.smartapplication.model.Event;
import org.smartapplication.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
@Slf4j
class TicketServiceImplTest {
    @Autowired
    private TicketService ticketService;

    @Autowired
    private EventService eventService;

    @Test
    public void testCreateTicket(){
        CreateTicketRequest createTicketrequest = new CreateTicketRequest();
        createTicketrequest.setName("Women getTogether conference 2024");
        createTicketrequest.setReservationNumber("0001");
        ticketService.creatTicket(createTicketrequest);
        CreateTicketResponse createTicketResponse = ticketService.creatTicket(createTicketrequest);
        assertNotNull(createTicketResponse);
        assertNotNull(createTicketResponse.getReservationNumber());

    }
    @Test
    public void addTicketToEvent() throws Exception {
        AddTicketRequest request = new AddTicketRequest();
        request.setId(100L);
        request.setReservationNumber("seat 001, row 001, column 050");
        request.setTicketQuantity("1");
        Event event = new Event();
        event.setEmail("email");

        AddEventResponse response = eventService.addTicketToEvent(request, event);
        log.info("ticket added :: {}", response);
        assertNotNull(response);

    }

}