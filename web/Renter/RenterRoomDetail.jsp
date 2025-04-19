<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.RentDetail" %>
<%@ page import="model.Bill" %>

<% 
    List<RentDetail> rentDetails = (List<RentDetail>) request.getAttribute("rentDetails");
    String message = (String) request.getAttribute("message");  
    Bill bill = (Bill) request.getAttribute("bill"); 
%>
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
        <link rel="stylesheet" href="css/tiny-slider.css">
        <link rel="stylesheet" href="css/aos.css">
        <link rel="stylesheet" href="css/style.css">
        <title>Room Detail</title>
        <style>
            .pay-button {
                display: inline-block;
                padding: 10px 20px;
                font-size: 16px;
                font-weight: bold;
                color: #fff;
                background-color: #000;
                border: none;
                border-radius: 5px;
                text-align: center;
                text-decoration: none;
                transition: background-color 0.3s, box-shadow 0.3s;
            }

            .pay-button:hover {
                background-color: #666;
                color: #fff;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            }
            .img-property-slide img {
                width: 700px;
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
                        <a href="rentercontroller?service=renterhome" class="logo m-0 float-start">My Room</a>

                        <jsp:include page = "navbar.jsp"></jsp:include>

                            <a href="#" class="burger light me-auto float-end mt-1 site-menu-toggle js-menu-toggle d-inline-block d-lg-none" data-toggle="collapse" data-target="#main-navbar">
                                <span></span>
                            </a>
                        </div>
                    </div>
                </div>
            </nav>

            <div class="hero page-inner overlay" style="background-image: url('images/hero_bg_3.jpg');">
                <div class="container">
                    <div class="row justify-content-center align-items-center">
                        <div class="col-lg-9 text-center mt-5">
                            <h1 class="heading" >My Room</h1>

                            <nav aria-label="breadcrumb" >
                                <ol class="breadcrumb text-center justify-content-center">
                                    <li class="breadcrumb-item "><a href="rentercontroller?service=renterhome">Home</a></li>

                                </ol>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>

        <% 
            if (rentDetails != null && !rentDetails.isEmpty()) {
                String billFormatted = "0";
                if (bill != null) {
                    billFormatted = String.format("%.0f", bill.getTotal());
                }
                for (RentDetail detail : rentDetails) {
                    String roomFeeFormatted = String.format("%.0f", detail.getRoomFee());
                    String roomSizeFormatted = String.format("%.0f", detail.getRoomSize());
                    String roomBalanceFormatted = String.format("%.0f", detail.getBalance());
        %>

        <% if (message != null) { %>
        <p style="margin: 0px; text-align: center; color: red; margin: 10px 0px; background: beige"><%= message %></p>
        <%}%>
        <div class="section">
            <div class="container">
                <div class="row justify-content-between">
                    <div class="col-lg-7">
                        <div class="img-property-slide-wrap">
                            <div class="img-property-slide">
                                <img src="data:image/jpg;base64,<%= detail.getRoomImg() %>" alt="Room Image" class="img-fluid">
                            </div>
                        </div>
                    </div>
                    <% if (message != null) { %>
                    alert("<%= message %>");
                    <%}%>

                    <%
                        Boolean paymentSuccess = (Boolean) request.getAttribute("paymentSuccess");
                        if (paymentSuccess != null) {
                    %>
                    <script>
                        alert("Payment was successful!");
                    </script>
                    <%
                        }
                    %>
                    <div class="col-lg-4">
                        <h4 class="text-center">Room Details</h4>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Room Floor</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                <%= detail.getRoomFloor() %>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Room Number</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                <%= detail.getRoomNumber() %>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Room Size</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                <%= roomSizeFormatted %> 
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Room Fee</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                <%= roomFeeFormatted %> 000 VND / month
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Balance</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                <%= roomBalanceFormatted %> VND
                            </div>

                        </div>
                        <hr>
                        <div class="row">
                            <div  class="col-sm-3">
                                <h6 class="mb-0">Living expenses</h6>
                            </div>
                            <div class="col-sm-6 text-secondary" id="livingExpensesValue">
                                <%= billFormatted %> VND
                            </div>
                            <div class="col-sm-3 text-secondary">
                                <a href="RenterBillDetailController?roomID=<%= detail.getRoomID() %>" class="pay-button">Pay</a>
                            </div>
                        </div>
                        <div style="margin-top: 50px" class="text-center">
                            <form id="cancelForm" action="CancleRoom" method="get">
                                <input type="hidden" name="roomId" value="<%= detail.getRoomID() %>" />
                                <button type="button" class="btn btn-danger" onclick="confirmCancellation()">Cancel Room</button>
                            </form>
                        </div>
                        <% 
                    } // End for loop
                } // End if
                        %>
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
                            <address>fpt university</address>
                            <ul class="list-unstyled links">
                                <li><a href="tel://11234567890">+1(123)-456-7890</a></li>
                                <li><a href="tel://11234567890">+1(123)-456-7890</a></li>
                                <li><a href="mailto:info@mydomain.com">HolaMotel@gmail.com</a></li>
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

        <script src="js/jquery-3.6.0.min.js"></script>
        <script src="js/bootstrap.bundle.min.js"></script>
        <script src="js/tiny-slider.js"></script>
        <script src="js/aos.js"></script>
        <script src="js/main.js"></script>
        <script>
                                    function confirmCancellation() {
                                        var livingExpensesText = document.getElementById("livingExpensesValue").innerText;
                                        var livingExpenses = parseFloat(livingExpensesText.replace(/[^0-9.-]/g, '')); // Chuyển đổi giá trị sang số

                                        if (livingExpenses > 0) {
                                            alert("You need to pay living expenses before checking out");
                                        } else {
                                            var confirmation = confirm("Are you sure you want to cancel this room?");
                                            if (confirmation) {
                                                document.getElementById("cancelForm").submit();
                                            }
                                        }
                                    }
        </script>
    </body>

</html>
