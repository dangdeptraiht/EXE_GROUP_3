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


        <title>HL_Motel</title>
        <link rel="icon" href="home-guest/favicon.png">
        <style>
            /*table*/

            .menu-bg-wrap{
                margin-left: 100px;
            }
            .btn {
                margin-top: 10px;
            }

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

        <div>
            <nav class="site-nav" style="width: 85%">
                <div class="container" >
                    <div class="menu-bg-wrap">
                        <div class="site-navigation">
                            <a href="renterprofile" class="logo m-0 float-start" style="text-decoration: none;">HL_Motel</a>

                            <jsp:include page="navbar.jsp"></jsp:include>

                                <a href="" class="burger light me-auto float-end mt-1 site-menu-toggle js-menu-toggle d-inline-block d-lg-none" data-toggle="collapse" data-target="#main-navbar">
                                    <span></span>
                                </a>

                            </div>
                        </div>
                    </div>
                </nav>
            </div>


            <div class="hero page-inner overlay" style="background-image: url('images/hero_bg_3.jpg');">

                <div class="container">
                    <div class="row justify-content-center align-items-center">
                        <div class="col-lg-9 text-center mt-5">
                            <h1 class="heading" data-aos="fade-up">Fee</h1>

                            <nav aria-label="breadcrumb" data-aos="fade-up" data-aos-delay="200">
                                <ol class="breadcrumb text-center justify-content-center">

                                </ol>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
            <section class="ftco-section">
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-md-6 text-center mb-5">
                            <h2 class="heading-section">Fee Form</h2>
                        </div>
                    </div>
                <c:set var="r" value="${requestScope.room}"></c:set>
                    <div class="row justify-content-center">
                        <div class="col-md-12">
                            <div class="wrapper">
                                <div class="row no-gutters">
                                    <div class="col-lg-8 col-md-7 order-md-last d-flex align-items-stretch">
                                        <div class="contact-wrap w-100 p-md-5 p-4">

                                            <h3>Electric and Water Price</h3>

                                            <table style="border-collapse: collapse; width: 100%;">
                                                <thead>
                                                    <tr style="background-color: #005555;color: #FFF">
                                                        <th style="padding: 8px; text-align: center;">Electric Price</th>
                                                        <th style="padding: 8px; text-align: center;">Water Price</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td style="padding: 8px; text-align: center;">${eprice}(VND/Kmw)</td>
                                                    <td style="padding: 8px; text-align: center;">${wprice}(VND/m3)</td>
                                                </tr>
                                            </tbody>
                                        </table>


                                        <h3 class="mb-4">Get a fee</h3>
                                        <form method="POST" action="addroomfee">
                                            <div class="row">
                                                <div class="col-md-6"> 
                                                    <div class="form-group">
                                                        <input type="hidden"  id="roomID" name="roomID" value="<%= request.getParameter("id") %>">
                                                        <label class="label" for="subject">Room Fee: </label>
                                                        <input type="number" class="form-control positive-number" name="roomFee" id="roomFee" value="${r.roomFee}" readonly>
                                                    </div>
                                                </div>
                                                <div class="col-md-6"> 
                                                    <div class="form-group">
                                                        <label class="label" for="subject">Service: </label>
                                                        <input type="number" class="form-control positive-number" name="service" id="service" placeholder="Enter Money" required>

                                                    </div>
                                                </div>
                                                <div class="col-md-6"> 
                                                    <div class="form-group">
                                                        <label class="label" for="subject">Electric Number Usage: </label>
                                                        <input type="number" class="form-control positive-number" name="electric" id="electric" placeholder="Enter Number" required>

                                                    </div>
                                                </div>
                                                <div class="col-md-6"> 
                                                    <div class="form-group">
                                                        <label class="label" for="subject">Water Block Usage: </label>
                                                        <input type="number" class="form-control" name="water" id="water" placeholder="Enter Number" required>
                                                    </div>
                                                </div>
                                                <div class="col-md-6"> 
                                                    <div class="form-group">
                                                        <label class="label" for="subject">Other: </label>
                                                        <input type="number" class="form-control positive-number" name="other" id="other" placeholder="Enter Money" required>
                                                    </div>
                                                </div>
                                                <div class="col-md-6"> 
                                                    <div class="form-group">
                                                        <label class="label" for="subject">Penalty Money: </label>
                                                        <input type="number" class="form-control positive-number" name="penMoney" id="penMoney" placeholder="Enter Money" required>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="form-group d-flex justify-content-between">
                                                        <button type="submit" class="btn btn-primary"><i class="fa-solid fa-envelope-open-text"></i>&nbsp;Add Now</button>
                                                        <a href="roomfee?roomID=${sessionScope.roomID}" style="color:#FFF" class="btn btn-info"><i class="fa-regular fa-rectangle-list"></i>&nbsp;Change my mind</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-5 d-flex align-items-stretch">
                                    <div class="info-wrap w-100 p-md-5 p-4" style="background-color :#005555; color: #FFF" >
                                        <h3 style="color: #FFF">Contact HL_Motel Owner</h3>
                                        <p class="mb-4">If it is an emergency, please contact the information below!</p>
                                        <div class="dbox w-100 d-flex align-items-start">
                                            <div class="icon d-flex align-items-center justify-content-center">
                                                <span class="fa fa-map-marker"></span>
                                            </div>
                                            <div class="text pl-3">
                                                <p><span>Address:</span> 198 Pho Vong, Thanh Xuan, Ha Noi</p>
                                            </div>
                                        </div>
                                        <div class="dbox w-100 d-flex align-items-center">
                                            <div class="icon d-flex align-items-center justify-content-center">
                                                <span class="fa fa-phone"></span>
                                            </div>
                                            <div class="text pl-3">
                                                <p><span>Phone:</span> <a href="tel://1234567920">+ 1235 2355 98</a></p>
                                            </div>
                                        </div>
                                        <div class="dbox w-100 d-flex align-items-center">
                                            <div class="icon d-flex align-items-center justify-content-center">
                                                <span class="fa fa-paper-plane"></span>
                                            </div>
                                            <div class="text pl-3">
                                                <p><span>Email:</span> <a href="mailto:info@yoursite.com">maituboss@gmail.com</a></p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
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
        <script>
            // Function to validate input fields
            function validateInput(event) {
                // Get the input element
                const input = event.target;

                // Get the input value
                let value = input.value;

                // Check if the value is a positive integer greater than 0
                if (!/^[0-9]\d*$/.test(value)) {
                    // If not a positive integer greater than 0, reset the value to empty
                    input.value = '';
                }
            }

            // Add event listeners to all input fields
            window.addEventListener('DOMContentLoaded', () => {
                const inputs = document.querySelectorAll('input[type="number"]');
                inputs.forEach(input => {
                    input.addEventListener('input', validateInput);
                });
            });
        </script>
    </body>

</html>