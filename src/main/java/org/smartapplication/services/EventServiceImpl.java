package org.smartapplication.services;

import org.modelmapper.ModelMapper;
import org.smartapplication.dtos.request.AddTicketRequest;
import org.smartapplication.dtos.request.EventRequest;
import org.smartapplication.dtos.response.AddEventResponse;
import org.smartapplication.dtos.response.EventResponse;
import org.smartapplication.model.Category;
import org.smartapplication.model.Event;
import org.smartapplication.model.Ticket;
import org.smartapplication.repository.EventRepository;
import org.smartapplication.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService{
    @Autowired
    EventRepository eventRepository;
    @Autowired
    TicketRepository ticketRepository;

    @Override
    public EventResponse createEvent(EventRequest eventRequest) {
        Event event = new Event();
        event.setName(eventRequest.getName());
        event.setCategory(eventRequest.getCategory());
        event.setAttendees(eventRequest.getAttendees());
        event.setEventDescription(eventRequest.getEventDescription());
        Event savedEvent = eventRepository.save(event);
        EventResponse eventResponse = new EventResponse();
        eventResponse.setName(savedEvent.getName());

        return eventResponse;
    }

    @Override
    public AddEventResponse addTicketToEvent(AddTicketRequest request, Event event) throws Exception {
        Category particularCategory = checkCategory(request.getCategory());
        ModelMapper mapper = new ModelMapper();
        Ticket ticket = mapper.map(request, Ticket.class);
        Ticket savedTicket = ticketRepository.save(ticket);
        return mapper.map(savedTicket, AddEventResponse.class);
    }

    private Category checkCategory(String category) throws Exception {
        for(Category event : Category.values()){
            if(event.name().equalsIgnoreCase(category)){
                return event;
            }
        }
        return null;
//        throw new Exception("Category not found");
    }
}
