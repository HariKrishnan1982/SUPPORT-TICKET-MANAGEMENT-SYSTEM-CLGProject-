package com.support.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.support.dao.TicketDAO;
import com.support.model.Ticket;

@WebServlet("/addTicket")
public class AddTicketServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String issue = request.getParameter("issue");
        String priority = request.getParameter("priority");
        String status = request.getParameter("status");

        Ticket ticket = new Ticket();
        ticket.setUsername(username);
        ticket.setIssuedescription(issue);
        ticket.setPriority(priority);
        ticket.setStatus(status);

        TicketDAO dao = new TicketDAO();
        dao.addTicket(ticket);

        response.getWriter().println("Ticket Added Successfully!");
        response.sendRedirect("viewTickets");
    }
}