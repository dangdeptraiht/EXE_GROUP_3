<%@page import="dao.RoomDAO,java.util.List"%>
<%@page import="model.RoomDetailSe"%>
<%@ page import="java.util.Base64" %>
<%@ page import="java.text.DecimalFormat" %>

<% RoomDetailSe roomDetail = (RoomDetailSe) request.getAttribute("roomDetail"); 
   List<String> listNameRenter = (List<String>) request.getAttribute("listNameRenter");
%>

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">        
        <link rel="shortcut icon" href="favicon.png">

        <meta name="description" content="" />
        <meta name="keywords" content="bootstrap, bootstrap5" />

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Work+Sans:wght@400;500;600;700&display=swap" rel="stylesheet">


        <link rel="stylesheet" href="fonts/icomoon/style.css">
        <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

        <link rel="stylesheet" href="css/tiny-slider.css">
        <link rel="stylesheet" href="css/aos.css">
        <link rel="stylesheet" href="css/style.css">

        <title>Room Detail</title>

        <style>
            .textDetail {
                position: relative;
                color: #2e2a2a;
                font-family: "Be Vietnam Pro", sans-serif, sans-serif;
                font-style: normal;
                font-weight: 300;
                font-size: 15px;
                line-height: 1.5;
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
                        <a href="#" class="logo m-0 float-start">Room Detail</a>

                        <jsp:include page = "navbar.jsp"></jsp:include>

                            <a href="#" class="burger light me-auto float-end mt-1 site-menu-toggle js-menu-toggle d-inline-block d-lg-none" data-toggle="collapse" data-target="#main-navbar">
                                <span></span>
                            </a>

                        </div>
                    </div>
                </div>
            </nav>


            <div class="hero page-inner overlay" style="background-image: url('images/slide-1.jpg');">

                <div class="container">
                    <div class="row justify-content-center align-items-center">
                        <div class="col-lg-9 text-center mt-5">
                            <h1 class="heading" data-aos="fade-up">Room Detail</h1>

                            <nav aria-label="breadcrumb" data-aos="fade-up" data-aos-delay="200">
                                <ol class="breadcrumb text-center justify-content-center">
                                    <li class="breadcrumb-item "><a href="OwnerController?service=OwnerHome">Home</a></li>                               
                                </ol>
                            </nav>


                        </div>
                    </div>


                </div>
            </div>


            <div class="section">
                <div class="container">
                    <div class="row justify-content-between">
                        <div class="col-lg-7">
                            <div class="img-property-slide-wrap">
                                <div class="img-property-slide">
                                <% String base64Image = roomDetail.getRoomImg(); %>

                                <img style="margin-top: 50px;" src="data:image/jpg;base64, <%= base64Image %>" alt="Image" class="img-fluid">

                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="d-block agent-box p-5">
                            <h2 class="heading text-primary" style="font-weight: 700"> Room <%= roomDetail.getRoomNumber()%></h2>
                            <%
                               DecimalFormat df = new DecimalFormat("#,###");
                               String formattedFee = df.format(roomDetail.getRoomFee() * 1000);
                            %>
                            <p class="meta" style="color: #c90927; font-size: 18px; font-weight: 600"><%= formattedFee %> VND/Month</p>
                            <label class="textDetail" style="font-size: 20px; font-weight: 500">Detailed description</label>
                            <p class="textDetail">Area: 22m²</p>
                            <p class="textDetail">Room Floor: <%= roomDetail.getRoomFloor()%></p>
                            <p class="textDetail">Room Size: <%= roomDetail.getRoomSize()%></p>
                            <p class="textDetail">Facilities: There is air conditioning, private toilet, comfortable living hours</p>
                            <p class="textDetail">In the room are available: </p>
                            <% 
                            String[] itemNames = roomDetail.getItemName(); 
                            int[] quantities = roomDetail.getQuantity(); 

                            if (itemNames != null && quantities != null && itemNames.length == quantities.length) {
                                for (int i = 0; i < itemNames.length; i++) {
                                    String itemName = itemNames[i];
                                    int quantity = quantities[i];
                            %>
                            <p class="textDetail"><%= quantity %> <%= itemName %></p>
                            <%
                                    }
                                }
                            %>
                            <p class="textDetail">Address: Thon 3, Tan Xa, Thach That, Ha Noi</p>
                            <p class="textDetail">Contact Info: 0123456789</p>                            
                            <% for (String renterName : listNameRenter) { %>
                            <p class="textDetail">Renter: 
                            <a style="color: blue;" href="#"> <%= renterName %> </a> 
                            </p> <br>
                            <%}%> 
                            <div class="row" style="margin-top: 20px">
                                <div class="col-sm-12">
                                    <a class="btn btn-info " href="OwnerController?service=editRoom&roomID=<%= roomDetail.getRoomID()%>">Edit Room</a>
                                </div>
                            </div>
                        </div>
                    </div>
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
        </div> <!-- /.site-footer -->


        <script src="js/bootstrap.bundle.min.js"></script>
        <script src="js/tiny-slider.js"></script>
        <script src="js/aos.js"></script>
        <script src="js/navbar.js"></script>
        <script src="js/counter.js"></script>
        <script src="js/custom.js"></script>
    </body>
</html>
