package org.smartapplication.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.GenerationType.IDENTITY;
import static java.time.LocalDateTime.now;
import static org.hibernate.annotations.CascadeType.MERGE;
import static org.hibernate.annotations.CascadeType.PERSIST;

@Getter
@Setter
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    private String name;
    private String eventDescription;
    private Integer attendees;
    private String email;
    private LocalDateTime createdAt;
    private Category category;
    @OneToMany(fetch = EAGER)
    @Cascade({PERSIST, MERGE})
    private List<Ticket> ticket;

    @PrePersist
    public void setCreatedAt() {
        this.createdAt = now();
    }
}
