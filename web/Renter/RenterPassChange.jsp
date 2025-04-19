<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                overflow: hidden;
                background-image: url('./Image/etc/123.jpg');
                background-size: 100% 100%;
                background-position: center;
                font-family: Arial, sans-serif;
                background-color: #f5f5f5;
                padding: 20px;
                margin: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }


            h1 {
                color: #333;
            }

            #form-container {
                background-color: #fff;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
                width: 500px;
            }

            form {
                width: 100%;
            }

            input[type="password"], input[type="text"] {
                width: 95%;
                padding: 10px;
                margin-bottom: 10px;
                border: 1px solid #ccc;
                border-radius: 5px;
            }

            input[type="submit"], input[type="button"] {
                width: calc(50% - 5px); /* Adjusted width to fit two buttons side by side */
                padding: 10px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                transition: background-color 0.3s;
            }

            input[type="submit"] {
                background-color: #007bff;
                color: #fff;
                margin-right: 5px;
            }

            input[type="button"] {
                background-color: #6c757d;
                color: #fff;
            }

            input[type="submit"]:hover, input[type="button"]:hover {
                background-color: #0056b3;
            }

            h3 {
                color: red;
            }

            /* Additional style for username label */
            label[for="userMail"] {
                font-weight: bold;
                margin-bottom: 5px;
            }
        </style>
    </head>
    <body>
        <%
            String userMail = (String) request.getAttribute("userMail");
        %>
        <div id="form-container">
            <h1>Change password form</h1>
            <h3>${requestScope.ms}</h3>
            <form action="changepass" method="post">
                <input type="hidden" name="userMail" value="${param.userMail}">
                Old password: <input type="password" name="opass"/><br/>
                New password: <input type="password" name="pass"/><br/>
                Confirm password: <input type="password" name="rp"/><br/>
                <input type="button" value="BACK TO PROFILE" onclick="window.location.href = 'login.jsp'">
                <input type="submit" value="CHANGE">

            </form>
        </div>
    </body>
</html>
