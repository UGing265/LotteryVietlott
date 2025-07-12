<%-- 
    Document   : lottery
    Created on : 11-Jul-2025, 19:27:51
    Author     : HP
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Buy Lottery Tickets</h2>
        <form action="MainController" method="POST">
            <label for="num_tickets">Number of Tickets auto (Max 50):</label>
            <input type="number" name="numTickets" max="9000" required><br>
            <button type="submit" name="action" value="BuyTicketAuto">Buy Tickets</button>
        </form><br><br><br>
        
        
        
        
        <form action="MainController" method="POST">
            <label for="num_tickets">Custom number (chose 1 to 99999): </label>
            <input type="number" id="num_tickets" name="num_tickets" max="9999" required><br>
            <button type="submit" name="action" value="BuyTicket">Buy Tickets</button>
        </form>
        <a href="MainController?action=LotteryResult">click to watch result</a>
        
        <br>
        <br>
        <c:forEach var="num" items="${sessionScope.TICKETS}">
            <span>${num}</span>
        </c:forEach>
    </body>
</html>
