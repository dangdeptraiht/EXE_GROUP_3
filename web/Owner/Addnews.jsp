<%-- 
    Document   : Addnews
    Created on : Jun 28, 2024, 9:28:01 AM
    Author     : pc
--%>

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





        <!-- Favicons -->
        <link rel="shortcut icon" href="images/favicon.png">
        <link href="img/apple-touch-icon.png" rel="apple-touch-icon">

        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet">

        <!-- Bootstrap CSS File -->
        <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Libraries CSS Files -->
        <link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <link href="lib/animate/animate.min.css" rel="stylesheet">
        <link href="lib/ionicons/css/ionicons.min.css" rel="stylesheet">
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

        <!-- Main Stylesheet File -->
        <link href="css/style_owner.css" rel="stylesheet">

        <title>HoLa Motel</title>
        <style>
            /* Override text color */
            body {
                color: #000; /* Black text */
            }

            /* Style labels to be black */
            label {
                color: #000; /* Black text */

            }
            .bg-image {
                
                height: 100px;
                width: 1920px; 
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
                        <a href="addnews" class="logo m-0 float-start">Owner</a>

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
                                        <h1 class="heading" data-aos="fade-up">Add News</h1>

                                    </div>
                                </div>
                            </div>
                        </div>
        <div class="container my-5">
            <h2>Add News</h2>
            <form action="addnews" method="post" enctype="multipart/form-data">
                <div class="mb-3">
                    <label for="title" class="form-label">Title</label>
                    <input type="text" class="form-control" id="title"  name="title" required>
                </div>
                <div class="mb-3">
                    <label for="description" class="form-label">Description</label>
                    <textarea class="form-control" id="description" name="description" rows="5" required></textarea>

                </div>
                <div class="mb-3">
                    <label for="image" class="form-label">Upload Image</label>
                    <input id="fileInput" type="file" class="form-control" name="image" accept="image/jpeg, image/png" required>
                    <span id="fileError" style="color: red;"></span>
                </div>
                <div class="mb-3">
                    <label for="createAt" class="form-label">Create at:</label>
                    <input type="date" class="form-control" id="createAt" name="createAt" required readonly="">
                </div>

                <button type="submit" class="btn btn-primary" onclick="return validateFile()">Submit</button>
                <a href="displayNews" class="btn btn-primary"> Back to list</a>
            </form>
            <script>

                const today = new Date().toISOString().split('T')[0];

                document.getElementById('createAt').value = today;
            </script>
               <script>
                    function validateFile() {
                        const fileInput = document.getElementById('fileInput');
                        const fileError = document.getElementById('fileError');
                        fileError.textContent = ''; // Clear previous errors

                        if (!fileInput.files || fileInput.files.length === 0) {
                            fileError.textContent = 'Please select a file.';
                            return false;
                        }

                        const file = fileInput.files[0];
                        const allowedTypes = ['image/jpeg', 'image/png'];
                        const maxSize = 1 * 1024 * 1024; // 1 MB

                        if (!allowedTypes.includes(file.type)) {
                            fileError.textContent = 'Only JPEG and PNG files are allowed.';
                            return false;
                        }

                        if (file.size > maxSize) {
                            fileError.textContent = 'File size must be less than 1 MB.';
                            return false;
                        }

                        return true;
                    }
                </script>
            
        </div>
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

        <a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>
        <div id="preloader"></div>


        <script src="js/bootstrap.bundle.min.js"></script>
        <script src="js/tiny-slider.js"></script>
        <script src="js/aos.js"></script>
        <script src="js/navbar.js"></script>
        <script src="js/counter.js"></script>
        <script src="js/custom.js"></script>


        <!-- JavaScript Libraries -->
        <script src="lib/jquery/jquery.min.js"></script>
        <script src="lib/jquery/jquery-migrate.min.js"></script>
        <script src="lib/popper/popper.min.js"></script>
        <script src="lib/bootstrap/js/bootstrap.min.js"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>
        <script src="lib/scrollreveal/scrollreveal.min.js"></script>


        <!-- Template Main Javascript File -->
        <script src="js/main_owner.js"></script>
    </body>
</html>
