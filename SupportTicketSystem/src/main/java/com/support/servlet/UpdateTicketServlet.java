package com.support.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.support.dao.TicketDAO;
import com.support.model.Ticket;

@WebServlet("/updateTicket")
public class UpdateTicketServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        TicketDAO dao = new TicketDAO();
        Ticket ticket = dao.getTicketById(id);

        request.setAttribute("ticket", ticket);
        request.getRequestDispatcher("updateTicket.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("ticketid"));
        String username = request.getParameter("username");
        String issue = request.getParameter("issue");
        String priority = request.getParameter("priority");
        String status = request.getParameter("status");

        Ticket ticket = new Ticket();
        ticket.setTicketid(id);
        ticket.setUsername(username);
        ticket.setIssuedescription(issue);
        ticket.setPriority(priority);
        ticket.setStatus(status);

        TicketDAO dao = new TicketDAO();
        dao.updateTicket(ticket);

        response.sendRedirect("viewTickets");
    }
}	