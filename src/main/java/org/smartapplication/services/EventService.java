package org.smartapplication.services;

import org.smartapplication.dtos.request.AddTicketRequest;
import org.smartapplication.dtos.request.EventRequest;
import org.smartapplication.dtos.response.AddEventResponse;
import org.smartapplication.dtos.response.EventResponse;
import org.smartapplication.model.Event;

public interface EventService {
    EventResponse createEvent(EventRequest eventRequest);

    AddEventResponse addTicketToEvent(AddTicketRequest request, Event event) throws Exception;

//    void viewTicket(ViewTicketRequest request);
//    void cancelTicket(CancelTicket request);
}
