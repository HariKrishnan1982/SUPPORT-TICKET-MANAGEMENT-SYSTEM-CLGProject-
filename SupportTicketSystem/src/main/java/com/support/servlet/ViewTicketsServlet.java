package com.support.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.support.dao.TicketDAO;
import com.support.model.Ticket;

@WebServlet("/viewTickets")
public class ViewTicketsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        TicketDAO dao = new TicketDAO();
        List<Ticket> tickets = dao.getAllTickets();

        request.setAttribute("ticketList", tickets);
        RequestDispatcher rd = request.getRequestDispatcher("viewTickets.jsp");
        rd.forward(request, response);
    }
}