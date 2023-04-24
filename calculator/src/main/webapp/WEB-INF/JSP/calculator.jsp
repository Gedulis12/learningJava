<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Calculator</title>
    </head>
    <body>
        <h2>Internet calculator. Available operations: add, subtract, multiply, divide</h2>
        <form method="POST" action="calculate">
            First number: <input type="number" name="n1"><p>
            Second number: <input type="number" name="n2"><p>
            Operator symbol:
            <select name="operation">
                <option selected="selected" value="+">Add</option>
                <option value="-">Subtract</option>
                <option value="*">Multiply</option>
                <option value="/">Divide</option>
            </select><p>
            <input type="submit" value="calculate">
        </form>
    </body>
</html>