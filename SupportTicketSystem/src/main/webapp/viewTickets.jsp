<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.support.model.Ticket" %>

<!DOCTYPE html>
<html>
<head>
<title>Support Ticket System</title>

<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f4f6f9;
    margin: 0;
    padding: 20px;
}

.container {
    background: white;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0,0,0,0.1);
}

h2 {
    text-align: center;
    color: #333;
}

table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
}

th {
    background-color: #007bff;
    color: white;
    padding: 10px;
}

td {
    padding: 8px;
    text-align: center;
}

tr:nth-child(even) {
    background-color: #f2f2f2;
}

a {
    text-decoration: none;
    padding: 5px 10px;
    border-radius: 4px;
}

.edit {
    background-color: #28a745;
    color: white;
}

.delete {
    background-color: #dc3545;
    color: white;
}

.search-box {
    margin-bottom: 15px;
}
button {
    padding: 6px 12px;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}
</style>
</head>

<body>

<div class="container">

<h2>Support Ticket Dashboard</h2>

<div class="search-box">
<form action="searchTicket" method="get">
    Username:
    <input type="text" name="username">

    Status:
    <select name="status">
        <option value="">All</option>
        <option value="Open">Open</option>
        <option value="In Progress">In Progress</option>
        <option value="Closed">Closed</option>
    </select>

    <button type="submit">Search</button>
</form>
</div>

<table>
<tr>
    <th>ID</th>
    <th>User</th>
    <th>Description</th>
    <th>Priority</th>
    <th>Status</th>
    <th>Action</th>
</tr>

<%
    List<Ticket> list = (List<Ticket>) request.getAttribute("ticketList");

    if(list != null){
        for(Ticket t : list){
%>

<tr>
    <td><%= t.getTicketid() %></td>
    <td><%= t.getUsername() %></td>
    <td><%= t.getIssuedescription() %></td>
    <td><%= t.getPriority() %></td>
    <td><%= t.getStatus() %></td>
    <td>
        <a class="edit" href="updateTicket?id=<%= t.getTicketid() %>">Edit</a>
        <a class="delete" href="deleteTicket?id=<%= t.getTicketid() %>"
           onclick="return confirm('Are you sure?');">Delete</a>
    </td>
</tr>

<%
        }
    }
%>

</table>

<br>
<button onclick="window.location.href='addTicket.jsp'">Add New Ticket</button>

</div>

</body>
</html>