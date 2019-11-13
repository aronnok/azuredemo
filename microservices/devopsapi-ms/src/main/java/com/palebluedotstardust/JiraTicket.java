package com.palebluedotstardust;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="jiratickets")
public class JiraTicket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ticket_number")
    private String ticketNumber;

    @Column(name = "description")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){

        return String.format("Jira=[id=%d, ticketnum=%s, desc=%s]",id,ticketNumber,description);
    }
}
