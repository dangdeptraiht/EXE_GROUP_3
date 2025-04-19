
<%@page import="model.Rooms"%>
<%@page import="model.User"%>
<%@page import="java.util.List"%>
<% List<User> listUserAvailable = (List<User>) request.getAttribute("listUserAvailable"); 
   List<Rooms> listRoomAvailable = (List<Rooms>) request.getAttribute("listRoomAvailable"); 
   String message = (String) request.getAttribute("message");
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>HL_Motel</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Free HTML5 Template by FREEHTML5.CO" />
        <meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
        <meta name="author" content="FREEHTML5.CO" />
        <!-- Social media meta tags -->
        <meta property="og:title" content=""/>
        <meta property="og:image" content=""/>
        <meta property="og:url" content=""/>
        <meta property="og:site_name" content=""/>
        <meta property="og:description" content=""/>
        <meta name="twitter:title" content="" />
        <meta name="twitter:image" content="" />
        <meta name="twitter:url" content="" />
        <meta name="twitter:card" content="" />
        <link rel="shortcut icon" href="./images/favicon.png">
        <!-- Google Webfonts -->
        <link href='https://fonts.googleapis.com/css?family=Roboto:400,300,100,500' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Work+Sans:wght@400;500;600;700&display=swap" rel="stylesheet">
        <!-- Stylesheets -->
        <link rel="stylesheet" href="fonts/icomoon/style.css">
        <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">
        <link rel="stylesheet" href="css/tiny-slider.css">
        <link rel="stylesheet" href="css/aos.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="RenterCSS/css/animate.css">
        <link rel="stylesheet" href="RenterCSS/css/icomoon.css">
        <link rel="stylesheet" href="RenterCSS/css/magnific-popup.css">
        <link rel="stylesheet" href="RenterCSS/css/salvattore.css">
        <link rel="stylesheet" href="RenterCSS/css/style.css">
        <!-- Modernizr JS -->
        <script src="RenterCSS/js/modernizr-2.6.2.min.js"></script>
        <!-- FOR IE9 below -->
        <!--[if lt IE 9]>
        <script src="js/respond.min.js"></script>
        <![endif]-->
        <style>
            .cart-form-select {
                border-radius: 0;
                padding-top: 15px;
                padding-bottom: 15px;
            }
        </style>
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
                        <a href="rentercontroller?service=renterhome" class="logo m-0 float-start">Renter</a>
                        <jsp:include page="navbar.jsp"></jsp:include>
                            <a href="#" class="burger light me-auto float-end mt-1 site-menu-toggle js-menu-toggle d-inline-block d-lg-none" data-toggle="collapse" data-target="#main-navbar">
                                <span></span>
                            </a>
                        </div>
                    </div>
                </div>
            </nav>
            <div class="hero page-inner overlay" style="background-image: url('images/hero_bg_1.jpg');">
                <div class="container">
                    <div class="row justify-content-center align-items-center">
                        <div class="col-lg-9 text-center mt-5">
                            <h1 class="heading">Add Renter</h1>
                        </div>
                    </div>
                </div>
            </div>

        <% if (message != null) { %>
        <p style="color: red"> <%= message %> </p>
        <%}%>

        <section class="product-detail section-padding">
            <div class="container">
                <form id="addRenterForm" action="AddRenterController" method="post" style="margin-bottom: 100px">
                    <div class="row">
                        <div class="col-lg-6 col-12">
                            <div class="product-info d-flex"></div>
                            <div class="product-description">
                                <strong class="d-block mt-4 mb-2">Renter</strong>
                                <p class="lead mb-5">Pick User You Want To Add</p>
                            </div>
                            <div class="product-cart-thumb row">
                                <div class="col-lg-6 col-12">
                                    <select style="font-size: 15px" class="form-select cart-form-select" id="inputGroupSelect01" name="userID">
                                        <% for (User user : listUserAvailable) { %>
                                        <option selected="" hidden="" disabled=""></option>
                                        <option value="<%= user.getUserID() %>"><%= user.getUserName() %>- <%= user.getUserPhone()%></option>
                                        <%}%>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6 col-12">
                            <div class="product-info d-flex"></div>
                            <div class="product-description">
                                <strong class="d-block mt-4 mb-2">Rooms</strong>
                                <p class="lead mb-5">Pick Room</p>
                            </div>

                            <div class="product-cart-thumb row">
                                <div class="col-lg-6 col-12">
                                    <select style="font-size: 15px" class="form-select cart-form-select" id="inputGroupSelect01" name="roomID">
                                        <% for (Rooms rooms : listRoomAvailable) { %>
                                        <option selected="" hidden="" disabled=""></option>
                                        <option value="<%= rooms.getRoomID() %>"><%= rooms.getRoomNumber()%></option>
                                        <%}%>
                                    </select>
                                </div>
                                <div class="col-lg-6 col-12 mt-4 mt-lg-0">
                                    <button type="submit" class="btn custom-btn cart-btn" data-bs-toggle="modal" data-bs-target="#cart-modal">Add Renter</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
                <script type="text/javascript">
                    document.getElementById("addRenterForm").addEventListener("submit", function (event) {
                        alert("Add Success");
                        // Không c?n ph?i ch?n vi?c g?i form n?u b?n mu?n form ???c g?i ?i sau khi thông báo
                    });
                </script>
            </div>
        </section>

        <div class="site-footer">
            <div class="container">

                <div class="row">
                    <div class="col-lg-4">
                        <div class="widget">
                            <h3>Contact</h3>
                            <address>Thon 3 Thach Hoa Thach That Ha Noi</address>
                            <ul class="list-unstyled links">
                                <li><a href="tel://11234567890">+1(123)-456-7890</a></li>
                                <li><a href="tel://11234567890">+1(123)-456-7890</a></li>
                                <li><a href="mailto:info@mydomain.com">info@mydomain.com</a></li>
                            </ul>
                        </div> <!-- /.widget -->
                    </div> <!-- /.col-lg-4 -->
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
                        </div> <!-- /.widget -->
                    </div> <!-- /.col-lg-4 -->
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
                        </div> <!-- /.widget -->
                    </div> <!-- /.col-lg-4 -->
                </div> <!-- /.row -->
            </div> <!-- /.container -->
        </div>

        <!-- Scripts -->
        <script src="RenterCSS/js/jquery.min.js"></script>
        <script src="RenterCSS/js/jquery.easing.1.3.js"></script>
        <script src="RenterCSS/js/bootstrap.min.js"></script>
        <script src="RenterCSS/js/jquery.waypoints.min.js"></script>
        <script src="RenterCSS/js/jquery.countTo.js"></script>
        <script src="RenterCSS/js/jquery.magnific-popup.min.js"></script>
        <script src="RenterCSS/js/salvattore.min.js"></script>
        <script src="RenterCSS/js/main.js"></script>
    </body>
</html>