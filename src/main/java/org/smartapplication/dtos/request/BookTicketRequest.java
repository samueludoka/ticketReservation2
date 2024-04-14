package org.smartapplication.dtos.request;

import lombok.Getter;
import lombok.Setter;
import org.smartapplication.model.Category;

import java.time.LocalDateTime;

@Getter
@Setter
public class BookTicketRequest {
    private Long id;
    private Category name;
    private String reservationNumber;
    private String ticketQuantity;
    private LocalDateTime reservationDate;

}
