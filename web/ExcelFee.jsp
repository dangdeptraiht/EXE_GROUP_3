
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Hoa Lac Apartment</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Free HTML5 Template by FREEHTML5.CO" />
        <meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
        <meta name="author" content="FREEHTML5.CO" />
        <link rel="shortcut icon" href="favicon.png">
        <!-- Facebook and Twitter integration -->
        <meta property="og:title" content=""/>
        <meta property="og:image" content=""/>
        <meta property="og:url" content=""/>
        <meta property="og:site_name" content=""/>
        <meta property="og:description" content=""/>
        <meta name="twitter:title" content="" />
        <meta name="twitter:image" content="" />
        <meta name="twitter:url" content="" />
        <meta name="twitter:card" content="" />

        <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->


        <!-- Google Webfonts -->
        <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,100,500' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Work+Sans:wght@400;500;600;700&display=swap" rel="stylesheet">


        <link rel="stylesheet" href="fonts/icomoon/style.css">
        <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">
        <link href="RenterCSS/css/tooplate-little-fashion.css" rel="stylesheet">
        <link rel="stylesheet" href="css/tiny-slider.css">
        <link rel="stylesheet" href="css/aos.css">
        <link rel="stylesheet" href="css/style.css">

        <style>
            .product-image {
                width: 50px; /* Adjust the width as needed */
                height: auto; /* Maintain aspect ratio */
            }


            .section-padding {
                padding: 60px 0;
            }

            .product-thumb {
                position: relative;
                border: 1px solid #ddd;
                padding: 15px;
                transition: transform 0.3s, box-shadow 0.3s;
            }

            .product-thumb:hover {
                transform: translateY(-10px);
                box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
            }

            .product-thumb img {
                width: 25%;
                height: auto;
                border-radius: 8px;
            }

            .product-top {
                position: absolute;
                top: 15px;
                left: 15px;
                right: 15px;
            }

            .product-alert {
                background-color: #ff4757;
                color: #fff;
                padding: 5px 10px;
                border-radius: 3px;
                font-size: 14px;
                font-weight: bold;
            }

            .product-icon {
                font-size: 20px;
                color: #ff4757;
            }

            .product-info {
                text-align: left;
                margin-top: 15px;
            }

            .product-title {
                font-size: 18px;
                font-weight: bold;
                margin: 0;
            }

            .product-title-link {
                color: #333;
                text-decoration: none;
                transition: color 0.3s


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
                                <a href="index.html" class="logo m-0 float-start">Property</a>

                                <ul class="js-clone-nav d-none d-lg-inline-block text-start site-menu float-end">
                                    <li><a href="index.html">Home</a></li>
                                    <li class="has-children">
                                        <a href="properties.html">Properties</a>
                                        <ul class="dropdown">
                                            <li><a href="#">Buy Property</a></li>
                                            <li><a href="#">Sell Property</a></li>
                                            <li class="has-children">
                                                <a href="#">Dropdown</a>
                                                <ul class="dropdown">
                                                    <li><a href="#">Sub Menu One</a></li>
                                                    <li><a href="#">Sub Menu Two</a></li>
                                                    <li><a href="#">Sub Menu Three</a></li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </li>
                                    <li><a href="services.html">Services</a></li>
                                    <li><a href="about.html">About</a></li>
                                    <li class="active"><a href="contact.html">Contact Us</a></li>
                                </ul>

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
                            <h1 class="heading" >Excel Fee</h1>

                            <nav aria-label="breadcrumb"  data-aos-delay="200">

                            </nav>
                        </div>
                    </div>
                </div>
            </div>
            <section class="featured-product section-padding">
                <div class="container">
                    <div class="row">
                        <!-- Export Button -->
                        <div class="col-lg-4 col-12 mb-3">
                            <form action="exportRenters" method="get" onsubmit="return confirmAction('Export')">
                                <div class="product-thumb">
                                    <button type="submit" class="btn btn-light" style="border: none;
                                            background: none;
                                            padding: 0;">
                                        <img src="images/import.png"  class="img-fluid product-image" alt="Export Data">
                                    </button>
                                    <div class="product-top d-flex justify-content-between align-items-center">
                                        <span class="product-alert">Export</span>
                                    </div>
                                    <div class="product-info mt-3">
                                        <h5 class="product-title mb-0">
                                            <span class="product-title-link">Export Data of Renter</span>
                                        </h5>
                                        <div class="form-group mt-2">
                                            <label for="file" class="d-block">The data will download as Excel File</label>
                                            <label for="file" class="d-block">Note: You can't change the data that already exist</label>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <!-- Import Button -->
                        <div class="col-lg-4 col-12 mb-3">
                            <form action="importRenter" method="post" enctype="multipart/form-data" onsubmit="return confirmAction('Import')">
                                <div class="product-thumb">
                                    <button type="submit" class="btn btn-light" style="border: none;
                                            background: none;
                                            padding: 0;">
                                        <img src="images/export.png" style="width:28%" class="img-fluid product-image" alt="Import Data">

                                        </button>
                                        <div class="product-top d-flex justify-content-between align-items-center">
                                            <span class="product-alert">Import</span>
                                        </div>
                                        <div class="product-info mt-3">
                                            <h5 class="product-title mb-0">
                                                <span class="product-title-link">Import Data</span>
                                            </h5>
                                        </div>
                                        <div class="form-group mt-2">
                                            <label for="file" class="d-block">Choose Excel file:</label>
                                            <input type="file" name="file" id="file" class="form-control-file" required>
                                        </div>
                                    </div>
                                </form>


                            </div>

                            <div class="col-lg-4 col-12 mb-3">
                                <div class="product-thumb">
                                    <a href="product-detail.html">

                                    </a>
                                    <div class="product-top d-flex justify-content-between align-items-center">

                                        <a href="#" class="bi-heart-fill product-icon"></a>
                                    </div>
                                    <div class="product-info mt-3">
                                        <h5 class="product-title mb-0">
                                            <a href="product-detail.html" class="product-title-link">Back</a>
                                        </h5>
                                        <p class="product-p">Return To Renter Management</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <c:if test="${not empty messages}">

                    <section class="contact section-padding">
                        <div class="container">
                            <div class="row">


                                <div class="col-lg-6 col-12">
                                    <h2 class="mb-4">Message <span>Log</span></h2>
                                    <form class="contact-form me-lg-5 pe-lg-3" role="form">
                                        <div class="form-floating mb-4">
                                            <c:forEach var="message" items="${messages}">
                                                <text id="message" name="message" class="form-control" placeholder="Leave a comment here" readonly="true">
                                                <c:out value="${message}" />
                                                </text>
                                            </c:forEach>
                                        </div>
                                    </form>
                                </div>




                                <div class="col-lg-6 col-12 mt-5 ms-auto">


                                    <div class="col-6 border-top contact-info">
                                        <h5 class="mb-3">If you cannot add the excel</h5>

                                        <ul class="social-icon">
                                            <li><h7>Your Input must be number</h7></li>
                                            <li><h7>Don't leave it blank</h7></li>
                                            <li><h7>Don't try to change the value that already have in excel</h7></li>
                                        </ul>

                                    </div>
                                </div>

                            </div>
                        </div>
                    </section>

                </c:if>

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

                        <div class="row mt-5">
                            <div class="col-12 text-center">
                                <!-- 
        **==========
        NOTE: 
        Please don't remove this copyright link unless you buy the license here https://untree.co/license/  
        **==========
                                -->

                                <p>Copyright &copy;<script>document.write(new Date().getFullYear());</script>. All Rights Reserved. &mdash; Designed with love by <a href="https://untree.co">Untree.co</a> <!-- License information: https://untree.co/license/ -->
                                </p>
                                <script >
                                    document.querySelector('.export-link').addEventListener('click', function (e) {
                                        e.preventDefault();
                                        if (confirm('Do you want to export the renter data?')) {
                                            window.location.href = this.href; // Redirect to the export endpoint
                                        }
                                    });

                                </script>
                                <script>
                                    function confirmAction(action) {
                                        return confirm('Are you sure you want to ' + action + '?');
                                    }
                                </script>

                            </div>
                        </div>
                    </div> <!-- /.container -->
                </div> <!-- /.site-footer -->






            </body>
        </html>
