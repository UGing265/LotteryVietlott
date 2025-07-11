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
        <script src="https://cdn.tailwindcss.com"></script>
    </head>
    <body>
        <button type="submit" name="action" value="BuyTicket">Save Database</button>
        <button type="submit" name="action" value="BuyTicket">Check Result from Database</button>
        <button type="submit" name="action" value="BuyTicket">Start Random new Result</button>
        
        
        <p>${sessionScope.RANDOM}</p>
        
        <div class="flex flex-wrap gap-5">
    <c:forEach var="num" items="${RANDOM}">
        <span class="px-2 py-1 bg-gray-200 rounded">${num}</span>
    </c:forEach>
</div>
    </body>
</html>
