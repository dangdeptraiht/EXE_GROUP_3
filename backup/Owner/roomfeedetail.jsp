<%-- 
    Document   : SeNews
    Created on : Jan 18, 2024, 2:59:38 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


        <title>GreenRoom</title>
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
                        <a href="Homepage.html" class="logo m-0 float-start">GreenRoom</a>

                        <ul class="js-clone-nav d-none d-lg-inline-block text-start site-menu float-end">
                            <li><a href="Homepage.html">Home</a></li>
                            <li class="active"><a href="manageroom">Room</a></li>
                            <li><a href="Payment.html">Payment</a></li>
                            <li><a href="request">Send Request</a></li>
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


        <div class="hero page-inner overlay" style="background-image: url('images/hero_bg_3.jpg');">

            <div class="container">
                <div class="row justify-content-center align-items-center">
                    <div class="col-lg-9 text-center mt-5">
                        <h1 class="heading" data-aos="fade-up">Room Fee</h1>

                        <nav aria-label="breadcrumb" data-aos="fade-up" data-aos-delay="200">
                            <ol class="breadcrumb text-center justify-content-center">

                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
        </div>

        <c:set var="bl" value="${billDetail}"></c:set>
       	<div class="container rounded bg-white">
            <div class="row d-flex justify-content-center pb-5">
                <div class="col-sm-3 col-md-4 offset-md-1 mobile">
                    <div class="py-4 d-flex justify-content-end">
                        <h6><a href="#"> Return to List</a></h6>
                    </div>
                    <div class="bg-light rounded d-flex flex-column">
                        <div class="p-2 ml-3"><h4>Bill Recap</h4></div>
                        <div class="p-2 d-flex">
                            <div class="col-8">Room Fee</div>
                            <div class="ml-auto">${bl.roomFee} VND</div>
                        </div>
                        <div class="p-2 d-flex">
                            <div class="col-8">Electric Bill</div>
                            <div class="ml-auto">${bl.electric} VND</div>
                        </div>
                        <div class="p-2 d-flex">
                            <div class="col-8">Water Bill</div>
                            <div class="ml-auto">${bl.water} VND</div>
                        </div>
                        <div class="p-2 d-flex">
                            <div class="col-8">Service</div>
                            <div class="ml-auto">${bl.service} VND</div>
                        </div>
                        <div class="border-top px-4 mx-3">
                        </div>
                        <div class="p-2 d-flex pt-3">
                            <div class="col-8">Penalty Money</div>
                            <div class="ml-auto">${bl.penMoney} VND</div>
                        </div>
                        <div class="p-2 d-flex">
                            <div class="col-8">Other Pay</div>
                            <div class="ml-auto">${bl.other} VND</div>
                        </div>
                        <div class="border-top px-4 mx-3"></div>
                        <div class="p-2 d-flex pt-3">
                            <div class="col-8"><b>Total</b></div>
                            <div class="ml-auto"><b class="green">${bl.roomFee + bl.electric + bl.water + bl.service + bl.penMoney + bl.other} VND</b></div>
                        </div>
                    </div>
                </div>    
                <div class="col-sm-5 col-md-5 ml-1">
                    <div class="py-4 d-flex flex-row">
                        <h5><span style="color: #005555" class="fa fa-check-square-o"></span><b style="color: #005555">GREENROOM</b> | </h5><span class="pl-2">Pay</span>
                    </div>
                    <h4 class="green">$85.00</h4>
                    <h4>Diabetes Pump & Supplies</h4>
                    <div class="d-flex pt-2">
                        <div><p><b>Insurance Responsibility.</b><span class="green">$71.76</span></p></div>
                        <div class="ml-auto"><p class="text-primary"><i class="fa fa-plus-circle text-primary"></i>Add insurance card</p></div>
                    </div>
                    <p>Insurance claims and all necessary dependencies will be submitted to your insurer for the coverred portion of this order</p>
                    <div class="rounded bg-light d-flex">
                        <div class="p-2">Aetna-Open Access</div>
                        <div class="ml-auto p-2">OAP</div>
                    </div>
                    <hr>
                    <div class="pt-2">
                        <div class="d-flex">
                            <div><p><b>Patient Balance.</b><span class="green">$13.24</span></p></div>
                            <div class="ml-auto p-2"><p class="text-primary"><i class="fa fa-plus-circle text-primary"></i>Add payment card</p></div>
                        </div>
                    </div>
                </div>    
            </div>
        </div>
        <!--        <script>
        <c:set var="succ" value="${requestScope.success}"></c:set>
        <c:set var="err" value="${requestScope.error}"></c:set>
        var successMessage = "${succ}";
        var errorMessage = "${err}";
        if (successMessage !== "") {
            alert(successMessage);
        }
        if (errorMessage !== "") {
            alert(errorMessage);
        }
    </script>-->


        <script src="js/bootstrap.bundle.min.js"></script>
        <script src="js/tiny-slider.js"></script>
        <script src="js/aos.js"></script>
        <script src="js/navbar.js"></script>
        <script src="js/counter.js"></script>
        <script src="js/custom.js"></script>
    </body>

</html>