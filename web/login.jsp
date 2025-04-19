<% String error = (String) request.getAttribute("error"); %>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="UTF-8">
        <title>Login</title>

        <link rel="shortcut icon" href="images/favicon.png">
        <link rel="stylesheet" href="css/login.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    </head>
    <body>
        <div class="container1">
            <div class="title">Login</div>
            <% if (error != null) { %>
            <h3 style="color: #FF0E0E; margin-top: 20px;"><%= error %></h3>
            <% } %>
            <h3 style="color: #FF0E0E; margin-top: 20px;">${message}</h3>
            <div class="content">
                <form id="loginForm" action="login" method="post">
                    <div class="user-details1">
                        <div class="input-box">
                            <span class="details">Email</span>
                            <input type="email" name="email" placeholder="Enter your Email" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Password</span>
                            <input type="password" name="password" placeholder="Enter your Password" required>
                        </div>
                        <br/>
                        <span class="details">
                            Don't have an account?
                            <a href="register.jsp" style="text-decoration: none; font-weight: 600;">Register now</a>
                        </span>
                    </div>
                    <div class="button">
                        <input type="submit" value="Login" style="width: 400px; height: 45px">
                    </div>
                    <input type="radio" name="yea" value="" />
                </form>

                <div class="form1">
                    <div class="button">
                        <a href="forgotPassword.jsp"><input type="button" value="Forgot password"></a>
                    </div>
                </div>
                <div class="form1">
                    <div class="button">
                        <a href="GuestController"><input type="button" value="Back to Home"></a>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
