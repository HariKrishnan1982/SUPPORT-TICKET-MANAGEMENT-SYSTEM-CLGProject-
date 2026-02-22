package com.support.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.support.model.Ticket;
import com.support.util.DBConnection;

public class TicketDAO {

    // ==============================
    // INSERT TICKET
    // ==============================
    public boolean addTicket(Ticket ticket) {

        String sql = "INSERT INTO tickets (username, issuedescription, priority, status) VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, ticket.getUsername());
            ps.setString(2, ticket.getIssuedescription());
            ps.setString(3, ticket.getPriority());
            ps.setString(4, ticket.getStatus());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // ==============================
    // VIEW ALL TICKETS
    // ==============================
    public List<Ticket> getAllTickets() {

        List<Ticket> list = new ArrayList<>();
        String sql = "SELECT * FROM tickets";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Ticket t = new Ticket();
                t.setTicketid(rs.getInt("ticketid"));
                t.setUsername(rs.getString("username"));
                t.setIssuedescription(rs.getString("issuedescription"));
                t.setPriority(rs.getString("priority"));
                t.setStatus(rs.getString("status"));

                list.add(t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // ==============================
    // GET TICKET BY ID
    // ==============================
    public Ticket getTicketById(int id) {

        String sql = "SELECT * FROM tickets WHERE ticketid=?";
        Ticket ticket = null;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                ticket = new Ticket();
                ticket.setTicketid(rs.getInt("ticketid"));
                ticket.setUsername(rs.getString("username"));
                ticket.setIssuedescription(rs.getString("issuedescription"));
                ticket.setPriority(rs.getString("priority"));
                ticket.setStatus(rs.getString("status"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ticket;
    }

    // ==============================
    // UPDATE TICKET
    // ==============================
    public boolean updateTicket(Ticket ticket) {

        String sql = "UPDATE tickets SET username=?, issuedescription=?, priority=?, status=? WHERE ticketid=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, ticket.getUsername());
            ps.setString(2, ticket.getIssuedescription());
            ps.setString(3, ticket.getPriority());
            ps.setString(4, ticket.getStatus());
            ps.setInt(5, ticket.getTicketid());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    // ==============================
    // DELETE TICKET
    // ==============================
    public boolean deleteTicket(int id) {

        String sql = "DELETE FROM tickets WHERE ticketid=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    // ==============================
    // SEARCH TICKET
    // ==============================
    public List<Ticket> searchTickets(String username, String status) {

        List<Ticket> list = new ArrayList<>();

        String sql = "SELECT * FROM tickets WHERE username LIKE ? AND status LIKE ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + username + "%");
            ps.setString(2, "%" + status + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Ticket t = new Ticket();
                t.setTicketid(rs.getInt("ticketid"));
                t.setUsername(rs.getString("username"));
                t.setIssuedescription(rs.getString("issuedescription"));
                t.setPriority(rs.getString("priority"));
                t.setStatus(rs.getString("status"));

                list.add(t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}