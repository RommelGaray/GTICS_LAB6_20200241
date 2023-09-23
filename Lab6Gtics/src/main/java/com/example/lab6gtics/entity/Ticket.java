package com.example.lab6gtics.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TicketID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SiteID")
    private Site siteID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TechnicianID")
    private Technician technicianID;

    @Column(name = "Status", length = 50)
    private String status;

    @Column(name = "OpenedDate")
    private Instant openedDate;

    @Column(name = "ClosedDate")
    private Instant closedDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Site getSiteID() {
        return siteID;
    }

    public void setSiteID(Site siteID) {
        this.siteID = siteID;
    }

    public Technician getTechnicianID() {
        return technicianID;
    }

    public void setTechnicianID(Technician technicianID) {
        this.technicianID = technicianID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Instant getOpenedDate() {
        return openedDate;
    }

    public void setOpenedDate(Instant openedDate) {
        this.openedDate = openedDate;
    }

    public Instant getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(Instant closedDate) {
        this.closedDate = closedDate;
    }

}