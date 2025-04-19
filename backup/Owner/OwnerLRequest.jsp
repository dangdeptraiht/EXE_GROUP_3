<%-- 
    Document   : test
    Created on : 27 thg 5, 2024, 20:04:34
    Author     : quocp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.RoomDAO,java.util.List,java.util.Vector"%>
<%@page import="model.Room, model.User" %>

<% User ownerProfile = (User) request.getAttribute("ownerProfile"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="images/favicon.png">
        <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css'>
        <title>JSP Page</title>

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Work+Sans:wght@400;500;600;700&display=swap" rel="stylesheet">


        <link rel="stylesheet" href="fonts/icomoon/style.css">
        <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

        <link rel="stylesheet" href="css/tiny-slider.css">
        <link rel="stylesheet" href="css/aos.css">
        <link rel="stylesheet" href="css/style.css">
        <style>
            body{
                margin-top:20px;
                color: #1a202c;
                text-align: left;
                background-color: #e2e8f0;
            }
            .main-body {
                padding: 15px;
            }
            .card {
                box-shadow: 0 1px 3px 0 rgba(0,0,0,.1), 0 1px 2px 0 rgba(0,0,0,.06);
            }

            .card {
                position: relative;
                display: flex;
                flex-direction: column;
                min-width: 0;
                word-wrap: break-word;
                background-color: #fff;
                background-clip: border-box;
                border: 0 solid rgba(0,0,0,.125);
                border-radius: .25rem;
            }

            .card-body {
                flex: 1 1 auto;
                min-height: 1px;
                padding: 1rem;
            }

            .gutters-sm {
                margin-right: -8px;
                margin-left: -8px;
            }

            .gutters-sm>.col, .gutters-sm>[class*=col-] {
                padding-right: 8px;
                padding-left: 8px;
            }
            .mb-3, .my-3 {
                margin-bottom: 1rem!important;
            }

            .bg-gray-300 {
                background-color: #e2e8f0;
            }
            .h-100 {
                height: 100%!important;
            }
            .shadow-none {
                box-shadow: none!important;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="main-body">
                <div>
                    <nav class="site-nav" style="width: 85%">
                        <div class="container" >
                            <div class="menu-bg-wrap">
                                <div class="site-navigation">
                                    <a href="OwnerController?service=ownerProfile" class="logo m-0 float-start" style="text-decoration: none;">Profile</a>

                                    <jsp:include page="navbar.jsp"></jsp:include>

                                    <a href="#" class="burger light me-auto float-end mt-1 site-menu-toggle js-menu-toggle d-inline-block d-lg-none" data-toggle="collapse" data-target="#main-navbar">
                                        <span></span>
                                    </a>

                                </div>
                            </div>
                        </div>
                    </nav>
                </div>

                    

            </div>
            <script src='https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.bundle.min.js'></script>
            <script src="js/bootstrap.bundle.min.js"></script>
            <script src="js/tiny-slider.js"></script>
            <script src="js/aos.js"></script>
            <script src="js/navbar.js"></script>
            <script src="js/counter.js"></script>
            <script src="js/custom.js"></script>
    </body>
</html>
