package org.smartapplication.services;

import org.junit.jupiter.api.Test;
import org.smartapplication.dtos.request.EventRequest;
import org.smartapplication.dtos.response.EventResponse;
import org.smartapplication.model.Category;
import org.smartapplication.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EventServiceImplTest {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventService eventService;

    @Test
    public void testCreateEvent(){
        EventRequest eventRequest = new EventRequest();
        eventRequest.setName("Women getTogether");
        eventRequest.setAttendees(1000);
        eventRequest.setCategory(Category.CONFERENCE);
        eventRequest.setEventDescription("that gender 'FEMALE'");
        EventResponse eventResponse = eventService.createEvent(eventRequest);
        assertNotNull(eventResponse);
        assertNotNull(eventResponse.getName());
    }

}