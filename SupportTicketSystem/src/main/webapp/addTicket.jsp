<!DOCTYPE html>
<html>
<head>
<title>Add Ticket</title>

<style>
body {
    font-family: Arial;
    background-color: #f4f6f9;
    padding: 30px;
}

.form-box {
    width: 400px;
    margin: auto;
    background: white;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0,0,0,0.1);
}

input, select {
    width: 100%;
    padding: 8px;
    margin: 6px 0;
}

button {
    width: 100%;
    padding: 10px;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}
</style>
</head>

<body>

<div class="form-box">
<h2>Create Support Ticket</h2>

<form action="addTicket" method="post">
    Username:
    <input type="text" name="username" required>

    Issue:
    <input type="text" name="issue" required>

    Priority:
    <select name="priority">
        <option>Low</option>
        <option>Medium</option>
        <option>High</option>
    </select>

    Status:
    <select name="status">
        <option>Open</option>
        <option>In Progress</option>
        <option>Closed</option>
    </select>

    <button type="submit">Submit Ticket</button>
</form>

<br>
<button onclick="window.location.href='viewTickets'">View Tickets</button>

</div>

</body>
</html>