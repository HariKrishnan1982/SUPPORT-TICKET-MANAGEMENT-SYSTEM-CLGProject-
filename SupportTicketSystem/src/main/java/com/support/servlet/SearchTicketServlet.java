package com.support.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.support.dao.TicketDAO;
import com.support.model.Ticket;

@WebServlet("/searchTicket")
public class SearchTicketServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String status = request.getParameter("status");

        if (username == null) username = "";
        if (status == null) status = "";

        TicketDAO dao = new TicketDAO();
        List<Ticket> tickets = dao.searchTickets(username, status);

        request.setAttribute("ticketList", tickets);

        RequestDispatcher rd = request.getRequestDispatcher("viewTickets.jsp");
        rd.forward(request, response);
    }
}