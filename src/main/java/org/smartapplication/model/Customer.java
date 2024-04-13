package org.smartapplication.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity

public class Customer {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    private String name;
    private String email;
    private String password;
    private boolean isLocked = true;
    @OneToOne(fetch = EAGER, cascade = {CascadeType.MERGE})
    private Ticket ticket;
}
