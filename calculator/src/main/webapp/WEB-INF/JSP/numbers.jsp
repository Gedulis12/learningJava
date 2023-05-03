<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Numbers</title>
    <jsp:include page="header.jsp"/>
</head>
<body class="container">
    <div class="table-responsive">
        <table class="table table-striped">
            <tr>
                <th>Pirmas skaičius</th>
                <th>Ženklas</th>
                <th>Antras skaičius</th>
                <th>Rezultatas</th>
                <th>Veiksmas</th>
            </tr>

            <!-- iteruoja per visą skaičių sarašą -->
            <c:forEach var="number" items="${numbers}">

                <!-- konstruoja įrašo atnaujinimo adresą su skaičiaus id -->
                <c:url var="update" value="/update">
                    <c:param name="id" value="${number.id}"/>
                </c:url>

                <!-- konstruoja įrašo trynimo adresą su skaičiaus id -->
                <c:url var="delete" value="/delete">
                    <c:param name="id" value="${number.id}"/>
                </c:url>

                <!-- konstruoja įrašo peržiūros adresą su skaičiaus id -->
                <c:url var="show" value="/show">
                    <c:param name="id" value="${number.id}"/>
                </c:url>

                <tr>
                    <td>${number.n1}</td>
                    <td>${number.operation}</td>
                    <td>${number.n2}</td>
                    <td>${number.result}</td>

                    <td>
                        <!-- atvaizduoti atnaujinimo adresą --> <a href="${update}">Keisti</a>
                        | <a href="${delete}"
                             onclick="if (!(confirm('Ar tikrai norite ištrinti šį įrašą?'))) return false">Trinti</a>
                        | <!-- atvaizduoti rodymo adresą --> <a href="${show}">Rodyti</a>
                    </td>

                </tr>

            </c:forEach>

        </table>
    </div>
</body>
</html>
