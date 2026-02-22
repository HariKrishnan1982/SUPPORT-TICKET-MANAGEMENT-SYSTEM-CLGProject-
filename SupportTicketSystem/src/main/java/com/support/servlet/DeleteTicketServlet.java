package com.support.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.support.dao.TicketDAO;

@WebServlet("/deleteTicket")
public class DeleteTicketServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        TicketDAO dao = new TicketDAO();
        dao.deleteTicket(id);

        response.sendRedirect("viewTickets");
    }
}