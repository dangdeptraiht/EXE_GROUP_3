
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- /*
* Template Name: Property
* Template Author: Untree.co
* Template URI: https://untree.co/
* License: https://creativecommons.org/licenses/by/3.0/
*/ -->
<!-- /*
* Template Name: Property
* Template Author: Untree.co
* Template URI: https://untree.co/
* License: https://creativecommons.org/licenses/by/3.0/
*/ -->
<!doctype html>
<html lang="en">

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


        <link rel="stylesheet" href="fonts/icomoon/style.css">
        <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">
        <link rel="stylesheet" href="./vcss/tiny-slider.css">
        <link rel="stylesheet" href="./vcss/aos.css">
        <link rel="stylesheet" href="./vcss/style.css">

        <title>Property &mdash; Free Bootstrap 5 Website Template by Untree.co</title>
        <link rel="icon" href="home-guest/favicon.png">
        <style>
            /*table*/
            .tabular--wrapper{
                background: #fff;
                margin-top: 1rem;
                border-radius: 10px;
                padding: 2rem;
            }

            .table-container{
                width: 100%;
            }

            table{
                width: 100%;
                border-collapse: collapse;
            }

            /*Chinh mau chu o hang dau*/
            thead{
                background: rgb(138, 110, 60, 000);
                color: black;
            }

            th{
                padding: 15px;
                text-align: left;
            }

            tbody{
                background: #f2f2f2;
            }

            td{
                padding: 15px;
                font-size: 14px;
                color: #333;
            }

            tr:nth-child(even){
                background: white;
            }


            tfoot{
                background: rgba(113, 99, 186, 255);
                font-weight: bold;
                color: rgb(255, 255, 255);
            }

            tfoot td{
                padding: 15px;
            }

            .table-container button{
                color: green;
                background: none;
                cursor: pointer;

            }

            th{
                padding: 15px;
                background: none;
                cursor: pointer;
            }



            .user-info {
                display: flex;
                flex-direction: column;
                align-items: center; /* Center items horizontally */
                text-align: center;  /* Center text within the container */
                background-color: #f9f9f9; /* Background color */
                border-radius: 10px; /* Optional: Add rounded corners */
                box-shadow: 0 0 12px rgba(0, 0, 0, 0.1); /* Optional: Add box shadow */
                padding: 20px; /* Optional: Add padding */
                max-width: 600px; /* Optional: Set max-width */
                margin: 20px auto; /* Center the container */
            }
            .user-info p {
                font-size: 20px;  /* Increase paragraph font size */
                color: green;     /* Change color to green */
                margin-bottom: 12px;
            }

            @media (max-width: 768px) {
                .renter-info {
                    max-width: 100%;
                }
            }        </style>
    </head>

    <body>

        <div class="site-mobile-menu site-navbar-target">
            <div class="site-mobile-menu-header">
                <div class="site-mobile-menu-close">
                    <span class="icofont-close js-menu-toggle"></span>
                </div>
            </div>
            <div class="site-mobile-menu-body"></div>
        </div>

        <nav class="site-nav">
            <div class="container">
                <div class="menu-bg-wrap">
                    <div class="site-navigation">
                        <a href="Homepage.html" class="logo m-0 float-start">Property</a>

                        <ul class="js-clone-nav d-none d-lg-inline-block text-start site-menu float-end">
                            <li class="active"><a href="Homepage.html">Home</a></li>
                            <li class="active"><a href="RoomList.html">Room</a></li>
                            <li><a href="Payment.html">Payment</a></li>
                            <li><a href="CustomerList.html">Customer</a></li>
                            <li><a href="Guide.html">Guide</a></li>
                            <li><a href="News.html">News</a></li>
                        </ul>

                        <a href="#"
                           class="burger light me-auto float-end mt-1 site-menu-toggle js-menu-toggle d-inline-block d-lg-none"
                           data-toggle="collapse" data-target="#main-navbar">
                            <span></span>
                        </a>

                    </div>
                </div>
            </div>
        </nav>


        <div class="PaddingMenu" style="background-image: url(''); height: 100px; padding: 40px;">
            <!-- Content of PaddingMenu -->
        </div>
        <div class="personal-info">

            <div class="tabular--wrapper">
                <h3 class="main--title">Penalties</h3>
                <div class="table-container">
                    <table>
                        <thead>
                            <tr>
                                <th>Title</th>
                                <th>Description</th>
                                <th>Money</th>
                                <th>Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${ListP}" var="p">
                                <tr>
                                    <td>${p.title}</td>
                                    <td>${p.description}</td>
                                    <td>${p.penMoney}</td>
                            <th> 
                                <%-- Check for renter status and display accordingly --%>
                                <c:choose>
                                    <c:when test="${p.status == 0}">Need to pay!</c:when>
                                    <c:when test="${p.status == 1}">Paid</c:when>
                                    <c:otherwise>Unknown</c:otherwise>
                                </c:choose>
                                    </th>
                                </tr>
                            </c:forEach>
                            </tbody>
                    </table>
                </div>
            </div>

        </div>

        <div class="site-footer">
            <div class="container">

                <div class="row">
                    <div class="col-lg-4">
                        <div class="widget">
                            <h3>Contact</h3>
                            <address>43 Raymouth Rd. Baltemoer, London 3910</address>
                            <ul class="list-unstyled links">
                                <li><a href="tel://11234567890">+1(123)-456-7890</a></li>
                                <li><a href="tel://11234567890">+1(123)-456-7890</a></li>
                                <li><a href="mailto:info@mydomain.com">info@mydomain.com</a></li>
                            </ul>
                        </div>
                        <!-- /.widget -->
                    </div>
                    <!-- /.col-lg-4 -->
                    <div class="col-lg-4">
                        <div class="widget">
                            <h3>Sources</h3>
                            <ul class="list-unstyled float-start links">
                                <li><a href="#">About us</a></li>
                                <li><a href="#">Services</a></li>
                                <li><a href="#">Vision</a></li>
                                <li><a href="#">Mission</a></li>
                                <li><a href="#">Terms</a></li>
                                <li><a href="#">Privacy</a></li>
                            </ul>
                            <ul class="list-unstyled float-start links">
                                <li><a href="#">Partners</a></li>
                                <li><a href="#">Business</a></li>
                                <li><a href="#">Careers</a></li>
                                <li><a href="#">Blog</a></li>
                                <li><a href="#">FAQ</a></li>
                                <li><a href="#">Creative</a></li>
                            </ul>
                        </div>
                        <!-- /.widget -->
                    </div>
                    <!-- /.col-lg-4 -->
                    <div class="col-lg-4">
                        <div class="widget">
                            <h3>Links</h3>
                            <ul class="list-unstyled links">
                                <li><a href="#">Our Vision</a></li>
                                <li><a href="#">About us</a></li>
                                <li><a href="#">Contact us</a></li>
                            </ul>

                            <ul class="list-unstyled social">
                                <li><a href="#"><span class="icon-instagram"></span></a></li>
                                <li><a href="#"><span class="icon-twitter"></span></a></li>
                                <li><a href="#"><span class="icon-facebook"></span></a></li>
                                <li><a href="#"><span class="icon-linkedin"></span></a></li>
                                <li><a href="#"><span class="icon-pinterest"></span></a></li>
                                <li><a href="#"><span class="icon-dribbble"></span></a></li>
                            </ul>
                        </div>
                        <!-- /.widget -->
                    </div>
                    <!-- /.col-lg-4 -->
                </div>
                <!-- /.row -->


            </div>
            <!-- /.container -->
        </div>
        <!-- /.site-footer -->


        <!-- Preloader -->
        <div id="overlayer"></div>
        <div class="loader">
            <div class="spinner-border" role="status">
                <span class="visually-hidden">Loading...</span>
            </div>
        </div>


        <script src="js/bootstrap.bundle.min.js"></script>
        <script src="js/tiny-slider.js"></script>
        <script src="js/aos.js"></script>
        <script src="js/navbar.js"></script>
        <script src="js/counter.js"></script>
        <script src="js/custom.js"></script>
    </body>

</html>