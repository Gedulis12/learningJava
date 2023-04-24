<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>Calculator</title>
        <style>
            .error {color: red}
        </style>
    </head>
    <body>
        <h2>Internet calculator. Available operations: add, subtract, multiply, divide</h2>
        <h3>Calculator does not work with negative numbers</h3>
        <form:form method="POST" action="calculate" modelAttribute="number">
            First number: <form:input type="number" path="n1"/>
            <form:errors path="n1" cssClass="error"/><p>
            Second number: <form:input type="number" path="n2"/>
            <form:errors path="n2" cssClass="error"/><p>
            Operator symbol:
            <select name="operation">
                <option selected="selected" value="+">Add</option>
                <option value="-">Subtract</option>
                <option value="*">Multiply</option>
                <option value="/">Divide</option>
            </select><p>
            <input type="submit" value="calculate">
        </form:form>
    </body>
</html>