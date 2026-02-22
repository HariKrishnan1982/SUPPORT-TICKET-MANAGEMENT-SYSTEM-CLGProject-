package com.support.model;

public class Ticket {

    private int ticketid;
    private String username;
    private String issuedescription;
    private String priority;
    private String status;

    public int getTicketid() {
        return ticketid;
    }

    public void setTicketid(int ticketid) {
        this.ticketid = ticketid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIssuedescription() {
        return issuedescription;
    }

    public void setIssuedescription(String issuedescription) {
        this.issuedescription = issuedescription;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}