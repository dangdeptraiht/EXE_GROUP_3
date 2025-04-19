<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.Bill, java.text.DecimalFormat" %>

<% Bill bill = (Bill) request.getAttribute("bill"); %>
<% double balanceRenter = (double) request.getAttribute("balanceRenter"); 
   int roomID = (int) request.getAttribute("roomID");
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
        <link rel="stylesheet" href="./vcss/tiny-slider.css">
        <link rel="stylesheet" href="./vcss/aos.css">
        <link rel="stylesheet" href="./vcss/style.css">
        <link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">	
        <link rel="stylesheet" href="./CSS/Renter.css"/>
        <link
            rel="stylesheet"
            type="text/css"
            href="./bootstrap-5.0.2-dist/css/bootstrap.min.css"
            />
        <script
            type="text/javascript"
            src="./bootstrap-5.0.2-dist/js/bootstrap.min.js"
        ></script>
        <link
            href="https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css"
            rel="stylesheet"
            />
        <link rel="stylesheet" href="./fontawesome-free-6.5.1-web/css/all.css">


        <title>HL_Motel</title>
        <link rel="icon" href="home-guest/favicon.png">
        <style>

            @media print {
                body * {
                    visibility: hidden;
                }
                #printableArea, #printableArea * {
                    visibility: visible;
                }
                #printableArea {
                    position: absolute;
                    left: 0;
                    top: 0;
                }
            }
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

            .notification {
                padding: 15px;
                margin: 20px 0;
                border: 1px solid #d4edda;
                border-radius: 5px;
                background-color: #d4edda;
                color: #155724;
                font-size: 16px;
                text-align: center;
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
                            <h1 class="heading" data-aos="fade-up">Fee Detail</h1>

                            <nav aria-label="breadcrumb" data-aos="fade-up" data-aos-delay="200">
                                <ol class="breadcrumb text-center justify-content-center">

                                </ol>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>


        <% 
            String message = "";
            if (bill == null) {
                message = "You have no charges yet!";
        %>
        <div class="notification">
            <%= message %>
        </div>

        <%
            }else if (bill != null) {                
                DecimalFormat decimalFormat = new DecimalFormat("#,###");
                String electricFormatted = decimalFormat.format(bill.getElectric() * 1000);
                String waterFormatted = decimalFormat.format(bill.getWater() * 1000);
                String serviceFormatted = decimalFormat.format(bill.getService() * 1000);
                String penaltyFormatted = decimalFormat.format(bill.getPenMoney() * 1000);
                String otherFormatted = decimalFormat.format(bill.getOther() * 1000);
                String totalFormatted = decimalFormat.format(bill.getTotal());
        %>
        <div class="container rounded bg-white" id="printableArea">
            <div class="row d-flex justify-content-center pb-5">
                <div class="col-sm-3 col-md-4 offset-md-1 mobile">
                    <div class="py-4 d-flex justify-content-end">
                        <h6><a href="RenterRoomDetail">Return to room</a></h6>
                    </div>
                    <div class="bg-light rounded d-flex flex-column">
                        <div class="p-2 d-flex">
                            <div class="col-8">Electric Bill</div>
                            <div class="ml-auto"><%= electricFormatted %> VND</div>
                        </div>
                        <div class="p-2 d-flex">
                            <div class="col-8">Water Bill</div>
                            <div class="ml-auto"><%= waterFormatted %> VND</div>
                        </div>
                        <div class="p-2 d-flex">
                            <div class="col-8">Service</div>
                            <div class="ml-auto"><%= serviceFormatted %> VND</div>
                        </div>
                        <div class="border-top px-4 mx-3">
                        </div>
                        <div class="p-2 d-flex pt-3">
                            <div class="col-8">Penalty Money</div>
                            <div class="ml-auto"><%= penaltyFormatted %> VND</div>
                        </div>
                        <div class="p-2 d-flex">
                            <div class="col-8">Other Pay</div>
                            <div class="ml-auto"><%= otherFormatted %> VND</div>
                        </div>
                        <div class="border-top px-4 mx-3"></div>
                        <div class="p-2 d-flex pt-3">
                            <div class="col-8"><b>Total</b></div>
                            <div class="ml-auto"><b id="totalAmount" class="green"><%= totalFormatted %> VND</b></div>
                        </div>
                    </div>
                </div>    
                <div class="col-sm-5 col-md-5 ml-1">
                    <div class="py-4 d-flex flex-row">
                        <h5><span style="color: #005555" class="fa fa-check-square-o"></span><b style="color: #005555">HL_Motel</b> | </h5><span class="pl-2">Pay</span>
                    </div>
                    <h4 class="green">Bill Recap</h4>
                    <div class="d-flex pt-2">
                        <div><p><b>This Bill Are From HL-Motel.</b><span class="green"></span></p></div>
                    </div>
                    <p>Hoa Lac</p>
                    <hr>
                    <div class="pt-2">
                        <% if (bill.getPayAt() == null) { %>
                        <div class="d-flex">
                            <div><p><b>Please notice and pay after: <%= bill.getDeadline() %> </b><span class="green"></span></p></div>
                        </div>
                        <%}%>
                    </div>
                </div>    
            </div>
        </div>
        <%}%>
        <div class="container rounded bg-white" id="printableArea">
            <!-- Your existing content here -->
        </div>
        <% if (bill != null) { %>
        <div class="p-2" style="display: grid; place-items: center;">
            <button class="btn btn-primary" data-toggle="modal" data-target="#paymentModal">Pay</button>
        </div>
        <%}%>
        <!-- Modal -->
        <div class="modal fade" id="paymentModal" tabindex="-1" role="dialog" aria-labelledby="paymentModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="paymentModalLabel">Payment Confirmation</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form id="paymentForm" action="PayBillController" method="post">
                        <div class="modal-body" style="text-align: center; font-size: 22px;">
                            <p><strong>Your Balance:</strong> <br>
                                
                                <span id="walletBalance"><%= balanceRenter %></span> VND</p>
                            <input type="hidden" name="balance" value="<%= balanceRenter %>">
                            <input type="hidden" name="totalAmountToPay" value="<%= bill.getTotal() %>">
                            <input type="hidden" name="roomID" value="<%= roomID %>">
                            
                        </div>
                        <div class="modal-footer">
                            <div class="d-flex justify-content-between w-100">
                                <button type="button" class="btn btn-primary" id="confirmPaymentBtn">Confirm Payment</button>
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>


        <script>
            document.addEventListener('DOMContentLoaded', function () {

                // get balance
                var walletBalanceText = document.getElementById('walletBalance').textContent;
                // loai bo dau hang nghin
                var walletBalance = parseFloat(walletBalanceText.replace(/,/g, ''));

                // get total to pay
                var totalAmountText = document.getElementById('totalAmount').textContent;
                var totalAmountToPay = parseFloat(totalAmountText.replace(/,/g, ''));

                // hien thi len man hinh
                document.getElementById('walletBalance').textContent = walletBalance.toLocaleString();


                document.getElementById('confirmPaymentBtn').addEventListener('click', function () {

                    if (totalAmountToPay === 0) {
                        alert('No payment amount specified.');
                    } else if (walletBalance >= totalAmountToPay) {
                        document.getElementById('paymentForm').submit();
                    } else {
                        alert('Insufficient balance. Please add more funds to your wallet.');
                    }
                });
            });
        </script>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

        <script src="js/bootstrap.bundle.min.js"></script>
        <script src="js/tiny-slider.js"></script>
        <script src="js/aos.js"></script>
        <script src="js/navbar.js"></script>
        <script src="js/counter.js"></script>
        <script src="js/custom.js"></script>
    </body>

</html>