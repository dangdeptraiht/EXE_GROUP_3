<%-- 
    Document   : payment_qr.jsp
    Created on : May 30, 2025, 6:10:34 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    StringBuilder sb = new StringBuilder();
    java.util.Random random = new java.util.Random();
    for (int i = 0; i < 8; i++) {
        int index = random.nextInt(chars.length());
        sb.append(chars.charAt(index));
    }
    String randomCode = sb.toString();
%>
<!DOCTYPE html>

<html>
    <head>
         <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="author" content="Untree.co">
        <link rel="shortcut icon" href="favicon.png">

        <meta name="description" content="" />
        <meta name="keywords" content="bootstrap, bootstrap5" />

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Work+Sans:wght@400;500;600;700&display=swap" rel="stylesheet">
        <link href='https://api.mapbox.com/mapbox-gl-js/v2.6.1/mapbox-gl.css' rel='stylesheet' />

        <link rel="stylesheet" href="fonts/icomoon/style.css">
        <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

        <link rel="stylesheet" href="css/tiny-slider.css">
        <link rel="stylesheet" href="css/aos.css">
        <link rel="stylesheet" href="css/style.css">

        <title>HoLa Motel</title>

        <style>
            /* Ensure the links fill the entire item */
            .feature-link {
                display: block;
                text-decoration: none;
                color: inherit;
            }

            /* Hover effect for the items */
            .box-feature {
                transition: background-color 0.3s ease, box-shadow 0.3s ease;
            }

            .box-feature:hover {
                background-color: #f0f0f0;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            }
        </style>
    </head>
    <body style="text-align:center; font-family: 'Work Sans', sans-serif; padding: 40px 20px;">
    <h2>Thanh toán qua mã QR</h2>
    <p>Mã thanh toán của bạn là: <strong><%= request.getAttribute("roomNumber") %>_<%= randomCode %></strong></p>
   
    <div style="margin: 20px auto;">
        <img src="<%= request.getContextPath() %>/Image/payment.jpg" alt="QR Code" style="width: 300px; height: auto; border: 2px solid #ccc; border-radius: 8px;"/>
    </div>
    <a href="renterhome" style="display: inline-block; margin-top: 30px; padding: 10px 20px; background-color: #005555; color: white; text-decoration: none; border-radius: 6px; font-weight: 600; transition: background-color 0.3s;">
        ⬅ Quay về trang chủ
    </a>
   
</body>
</html>
