package org.smartapplication.dtos.request;

import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;
import org.smartapplication.model.Category;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;


@Getter
@Setter
public class EventRequest {
    private String name;
    private String eventDescription;
    private int attendees;
    private Category category;

}
