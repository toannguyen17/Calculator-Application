<%--
  Created by IntelliJ IDEA.
  User: toanv
  Date: 19/06/2020
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Calculator</title>
    </head>
    <body>
        <h3>Calculator</h3>
        <h4>Result:</h4>
        <%= request.getParameter("first") %>
        <%= request.getParameter("operand") %>
        <%= request.getParameter("second") %>
        =
        <%= request.getAttribute("result") %>
    </body>
</html>
