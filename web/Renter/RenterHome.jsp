<!doctype html>
<html lang="en">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                        <a href="#" class="logo m-0 float-start">Renter</a>
                        <jsp:include page="navbar.jsp"></jsp:include>
                        <a href="#" class="burger light me-auto float-end mt-1 site-menu-toggle js-menu-toggle d-inline-block d-lg-none" data-toggle="collapse" data-target="#main-navbar">
                            <span></span>
                        </a>
                    </div>
                </div>
            </div>
        </nav>

        <div class="hero">
            <div class="hero-slide">
                <div class="img overlay" style="background-image: url('images/hero_bg_3.jpg')"></div>
                <div class="img overlay" style="background-image: url('images/hero_bg_2.jpg')"></div>
                <div class="img overlay" style="background-image: url('images/hero_bg_1.jpg')"></div>
            </div>

            <div class="container">
                <div class="row justify-content-center align-items-center">
                    <div class="col-lg-9 text-center">
                        <h1 class="heading" data-aos="fade-up">Welcome to Hoa Lac Apartment</h1>
                    </div>
                </div>
            </div>
        </div>

        <section class="features-1">
            <div class="container">
                <div class="row">
                    <div class="col-6 col-lg-3" data-aos="fade-up" data-aos-delay="100">
                        <a href="#" class="feature-link">
                            <div class="box-feature">
                                <span class="flaticon-house"></span>
                                <h3 class="mb-3">News</h3>
                                <p>View News</p>
                            </div>
                        </a>
                    </div>
                    <div class="col-6 col-lg-3" data-aos="fade-up" data-aos-delay="200">
                        <a href="RenterRoomDetail?service=RenterRoomDetail" class="feature-link">
                            <div class="box-feature">
                                <span class="flaticon-building"></span>
                                <h3 class="mb-3">My Room</h3>
                                <p>Look at your room detail</p>
                            </div>
                        </a>
                    </div>

                    <div class="col-6 col-lg-3" data-aos="fade-up" data-aos-delay="100">
                        <a href="#" class="feature-link">
                            <div class="box-feature">
                                <span class="flaticon-house-1"></span>
                                <h3 class="mb-3">Make A Request</h3>
                                <p>Request</p>
                            </div>
                        </a>
                    </div>
                    <div class="col-6 col-lg-3" data-aos="fade-up" data-aos-delay="200">
                        <a href="renterguideline?service=guideandrule" class="feature-link">
                            <div class="box-feature">
                                <span class="flaticon-house-1"></span>
                                <h3 class="mb-3">GuideLine</h3>
                                <p>Guide for new visitor</p>
                            </div>
                        </a>
                    </div>
<!--                    <div class="col-6 col-lg-3" data-aos="fade-up" data-aos-delay="300">
                        <a href="#" class="feature-link">
                            <div class="box-feature">
                                <span class="flaticon-house-1"></span>
                                <h3 class="mb-3">Rule</h3>
                                <p>Rule for new visitor</p>
                            </div>
                        </a>
                    </div>-->
                    <div class="col-6 col-lg-3" data-aos="fade-up" data-aos-delay="600">
                        <a href="RenterRoomController?service=listRoom&index=1" class="feature-link">
                            <div class="box-feature">
                                <span class="flaticon-house-1"></span>
                                <h3 class="mb-3">List Room</h3>
                                <p>View list room</p>
                            </div>
                        </a>
                    </div>
                    <div class="col-6 col-lg-3" data-aos="fade-up" data-aos-delay="600">
                        <a href="#" class="feature-link">
                            <div class="box-feature">
                                <span class="flaticon-house-1"></span>
                                <h3 class="mb-3">About us</h3>
                                <p>Detail about Motel</p>
                            </div>
                        </a>
                    </div>
                </div>
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

                    </div>
                </div>
            </div> <!-- /.container -->
        </div> <!-- /.site-footer -->


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
