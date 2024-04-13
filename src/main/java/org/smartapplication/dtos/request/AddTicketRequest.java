package org.smartapplication.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddTicketRequest {
    private String reservationNumber;
    private String ticketQuantity;
    private String category;
}
