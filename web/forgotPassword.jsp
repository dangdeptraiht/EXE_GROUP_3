<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" href="home-guest/favicon.png">
        <title>Forgot Password</title>
        <link href="forgotpassword/rspassword.css" rel="stylesheet" type="text/css">
        <style>
            body {
                background: linear-gradient(135deg, #30BD36, #5A84E6);
                font-family: sans-serif;
                height: 100vh;
            }
            .container {
                max-width: 700px;
                max-height: 300px;
                margin: 10% auto 0;
                padding: 20px;
                background-color: white;
                border-radius: 5px;
                border-color: white;
                box-shadow: 0 5px 10px rgba(0, 0, 0, 0.15);
            }

            .get-password {
                background-color: #5A84E6;
                color: white;
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                text-align: center;
                text-decoration: none; /* Remove underline for anchor tag */
                display: inline-block; /* To make anchor tag behave like a button */
                font-size: 16px; /* Adjust font size as needed */
                cursor: pointer;
                margin: 5px;
            }

            .get-password:hover {
                background-color: #4a6bbf; /* Darker shade for hover effect */
            }

            .back-login {
                display: inline-block; /* Ensure the link behaves like a button */
            }
        </style>
    </head>
    <body>
        <div class="container">
            <form action="forgotPassword" method="post">
                <div class="title-text">Forgot your password?</div>
                <p>Change your password in three easy steps. This will help you to secure your password!</p>

                <ol class="step-reset">
                    <li> Enter your email address below.</li>
                    <li> Our system will send you an OTP to your email.</li>
                    <li> Enter the OTP on the next page.</li>
                </ol>
            </form>

            <form action="forgotPassword" method="POST" style="margin-bottom: 100px; ">
                <label for="email">Enter your email address</label>
                <br>
                <br>
                <input class="enter-email" type="email" placeholder="Email" name="email" id="email" required>
                <br>
                <br>
                <small class="form-text">( Enter the email address you used during the registration. Then we'll email an OTP to this address. )</small>
                <br>
                <br>
                <hr>
                <div class="submit-password">
                    <button class="get-password" type="submit">
                        Get New Password
                    </button>
                    <a class="get-password back-login" href="login.jsp">
                        Back to Login
                    </a>
                    <h2 class="notice-message">${message}</h2>
                </div>
            </form>


        </div>
    </body>
</html>
