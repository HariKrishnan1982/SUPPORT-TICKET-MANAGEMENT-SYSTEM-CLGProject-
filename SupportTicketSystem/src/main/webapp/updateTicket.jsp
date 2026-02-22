<%@ page import="com.support.model.Ticket" %>
<%
    Ticket t = (Ticket) request.getAttribute("ticket");
%>

<h2>Update Ticket</h2>

<form action="updateTicket" method="post">

    <input type="hidden" name="ticketid" value="<%= t.getTicketid() %>">

    Username:
    <input type="text" name="username" value="<%= t.getUsername() %>" required><br><br>

    Issue:
    <input type="text" name="issue" value="<%= t.getIssuedescription() %>" required><br><br>

    Priority:
    <select name="priority">
        <option <%= t.getPriority().equals("Low") ? "selected" : "" %>>Low</option>
        <option <%= t.getPriority().equals("Medium") ? "selected" : "" %>>Medium</option>
        <option <%= t.getPriority().equals("High") ? "selected" : "" %>>High</option>
    </select><br><br>

    Status:
    <select name="status">
        <option <%= t.getStatus().equals("Open") ? "selected" : "" %>>Open</option>
        <option <%= t.getStatus().equals("In Progress") ? "selected" : "" %>>In Progress</option>
        <option <%= t.getStatus().equals("Closed") ? "selected" : "" %>>Closed</option>
    </select><br><br>

    <input type="submit" value="Update Ticket">

</form>