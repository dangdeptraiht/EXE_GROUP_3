
<% String error = (String) request.getAttribute("error"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Designined by CodingLab - youtube.com/codinglabyt -->
<html lang="en" dir="ltr">

    <head>
        <meta charset="UTF-8">
        <title> Register </title>
        <link rel="shortcut icon" href="images/favicon.png">
        <link rel="stylesheet" href="css/register.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            .password-input {
                position: relative;
            }

            .password-input::after {
                content: attr(data-placeholder);
                position: absolute;
                top: 50%;
                left: 10px;
                transform: translateY(-50%);
                pointer-events: none;
                color: gray;
            }
        </style>
    </head>

    <body>
        <div class="container">
            <div class="title">Register</div>
            <div class="content">
                <% if (error != null) { %>
                <h3 id="message" style="color: #FF0E0E; margin-top: 20px;"><%= error %></h3>
                <% } %>
                <h3 id="message" style="color: #FF0E0E; margin-top: 20px;">${message}</h3>
                
                <form id="registerForm" action="emailSender" method="post">
                    <div class="user-details">
                        <div class="input-box">
                            <span class="details">Username</span>
                            <input type="text" placeholder="Enter your username" name="username" required maxlength="30">
                        </div>
                        <div class="input-box">
                            <span class="details">Gender</span>
                            <select name="gender" style="width: 300px;height: 44px;border-radius: 5px; padding-left: 15px;font-size: 16px; ">
                                <option value="Male" selected="selected">Male</option>
                                <option value="Female">Female</option>
                                <option value="Other">Other</option>
                            </select>
                        </div>
                        <div class="input-box">
                            <span class="details">Email</span>
                            <input type="email" placeholder="Enter your email" name="email" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Phone Number</span>
                            <input type="text" placeholder="Enter your number" name="phone" required maxlength="10">
                        </div>
                        <div class="input-box">
                            <span class="details">Birth Day</span>
                            <input type="date" name="dob" id="dob">
                        </div>
                        <div class="input-box">
                            <span class="details">Password</span>
                            <input type="password" placeholder="Enter your password" name="password" required>
                        </div>

                        <div class="input-box">
                            <span class="details">Address</span>
                            <input type="text" placeholder="Enter your Address" name="address" required maxlength="50">
                            <span id="addressMessage" class="error-message"></span>
                        </div>
                        <div class="input-box">
                            <span class="details">Confirm Password</span>
                            <input type="password" placeholder="Confirm your password" name="repassword" required>
                        </div>
                    </div>

                    <div class="button">
                        <input type="submit" value="Register" style="width: 650px;">
                    </div>
                    ${message}
                </form>

                <div class="form1">
                    <div class="button">
                        <a href="login.jsp"><input type="submit" value="Back to Login" style="width: 650px;"></a>
                    </div>
                </div>
            </div>
        </div>
    </body>

    <script>
        document.addEventListener("DOMContentLoaded", function () {
            var passwordInput = document.querySelector('input[name="password"]');
            var repasswordInput = document.querySelector('input[name="repassword"]');
            var messageElement = document.querySelector('#message');
            var addressInput = document.querySelector('input[name="address"]');
            var addressMessageElement = document.querySelector('#addressMessage');
            var form = document.getElementById('registerForm');
            var timeoutId;

            passwordInput.addEventListener("input", function () {
                clearTimeout(timeoutId);
                timeoutId = setTimeout(validatePasswords, 1000);
            });

            repasswordInput.addEventListener("input", function () {
                clearTimeout(timeoutId);
                timeoutId = setTimeout(validatePasswords, 1000);
            });

            addressInput.addEventListener("input", function () {
                clearTimeout(timeoutId);
                timeoutId = setTimeout(validateAddress, 1000);
            });

            form.addEventListener('submit', function (event) {
                if (!isPasswordValid(passwordInput.value) || passwordInput.value !== repasswordInput.value || !isAddressValid(addressInput.value)) {
                    event.preventDefault();
                    validatePasswords();
                    validateAddress();
                }
            });

            function validatePasswords() {
                var password = passwordInput.value;
                var repassword = repasswordInput.value;

                if (repassword !== "" && password !== repassword) {
                    messageElement.textContent = "Password and Confirm-Password do not match.";
                    messageElement.style.color = "#FF0E0E";
                } else if (!isPasswordValid(password)) {
                    messageElement.textContent = "Password must be at least 8 characters long and include at least one uppercase letter and one special character.";
                    messageElement.style.color = "#FF0E0E";
                } else {
                    messageElement.textContent = "";
                }
            }

            function validateAddress() {
                var address = addressInput.value;

                if (!isAddressValid(address)) {
                    addressMessageElement.textContent = "Address must contain only words.";
                    addressMessageElement.style.color = "#FF0E0E";
                } else {
                    addressMessageElement.textContent = "";
                }
            }

            function isPasswordValid(password) {
                var regex = /^(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,}$/;
                return regex.test(password);
            }

            function isAddressValid(address) {
                // Check if the address contains only letters and spaces
                var regex = /^[A-Za-z\s]+$/;
                return regex.test(address);
            }

            document.getElementById('dob').max = new Date().toISOString().split("T")[0];
        });
    </script>

</html>
