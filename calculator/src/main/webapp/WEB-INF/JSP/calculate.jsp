<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>calculate</title>
        <jsp:include page="header.jsp"/>
    </head>
    <body>
        <h4> ${n1} ${operation} ${n2} = ${result} </h4>
                <form>
                 <input type="button" value="Go back!" onclick="history.back()">
                </form>
    </body>
</html>