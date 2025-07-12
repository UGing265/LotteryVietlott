<%-- 
    Document   : lotteryResult
    Created on : 11-Jul-2025, 22:08:52
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://cdn.dtailwindcss.com"></script>
    </head>
    <body>
        <form action="MainController" method="POST">
            <button name="action" value="startRound">Start Rounds</button><br>
            <button name="action" value="endRound">End Rounds</button><br>
            <button name="action" value="saveDB">Save Result Database</button><br>
            <button name="action" value="CheckResultTickets">Check Result from Database</button><br>
            <button name="action" value="LotteryResultGO">Start Random new Result</button><br>
        </form>



        <p>${sessionScope.RANDOM}</p>

        <c:forEach var="num" items="${RANDOM}">
            <span>${num}</span>
        </c:forEach>
            
            <p>${requestScope.SUCCESS}</p>
            <p>${requestScope.ERROR}</p>
            <p>rounds numbers is ${sessionScope.ROUND_NUMBER}</p>
    </div>
</body>
</html>
