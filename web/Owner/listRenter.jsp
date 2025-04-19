<%-- 
    Document   : listRenter
    Created on : 4 thg 7, 2024, 23:21:05
    Author     : quocp
--%>

<%@page import="dao.RoomDAO,java.util.List"%>
<%@page import="model.Rooms, model.RenterList" %>

<%
    List<RenterList> listRenter = (List<RenterList>) request.getAttribute("listRenters");
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

        <title>Hola Motel</title>
        <style>
            .pagination {
                display: flex;
                justify-content: center;
                align-items: center;
                margin-top: 20px;
            }

            .pagination a {
                color: #007bff;
                padding: 8px 16px;
                text-decoration: none;
                border: 1px solid #ddd;
                margin: 0 5px;
                border-radius: 5px;
                transition: background-color 0.3s ease;
            }

            .pagination a:hover {
                background-color: #007bff;
                color: white;
            }

            .pagination a.active {
                background-color: #007bff;
                color: white;
                border-color: #007bff;
            }

            .search-container {
                text-align: left;
                margin-bottom: 20px;
                margin-right: 10px;
            }

            .search-input {
                width: 100%;
                padding: 10px;
                font-size: 16px;
                border: 1px solid #ccc;
                border-radius: 5px;
                transition: width 0.4s ease-in-out;
            }

            .search-input:focus {
                width: 270px;
                outline: none;
                border-color: #4CAF50;
            }

            .search-filter {
                background-color: #f8f9fa;
                border: 1px solid #ddd;
                border-radius: 5px;
                padding: 20px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            }

            .search-container {
                margin-bottom: 20px;
            }

            .search-input {
                width: 100%;
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 5px;
                box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.1);
                font-size: 16px;
            }

            .price-range {
                margin-top: 20px;
            }

            .price-label {
                display: inline-block;
                margin-right: 10px;
                cursor: pointer;
            }

            .price-input {
                appearance: none;
                -webkit-appearance: none;
                -moz-appearance: none;
                width: 20px;
                height: 20px;
                border: 2px solid #ccc;
                border-radius: 4px;
                vertical-align: middle;
                margin-right: 5px;
                cursor: pointer;
            }

            .price-input:checked {
                background-color: #17a2b8;
                border-color: #17a2b8;
            }

            .search-filter label {
                display: block;
                cursor: pointer;
                margin-bottom: 10px;
                padding: 5px 0;
                font-size: 14px;
                color: #555;
            }

            .search-filter input[type="radio"] {
                display: none;
            }

            .search-filter input[type="radio"] + label {
                position: relative;
                padding-left: 30px;
                cursor: pointer;
            }

            .search-filter input[type="radio"] + label:before {
                content: '';
                display: inline-block;
                width: 20px;
                height: 20px;
                border: 2px solid #007bff;
                border-radius: 50%;
                background: #fff;
                position: absolute;
                left: 0;
                top: 50%;
                transform: translateY(-50%);
            }

            .search-filter input[type="radio"]:checked + label:after {
                content: '';
                display: inline-block;
                width: 12px;
                height: 12px;
                border-radius: 50%;
                background: #007bff;
                position: absolute;
                left: 4px;
                top: 50%;
                transform: translateY(-50%);
            }

            .search-filter input[type="radio"]:checked + label:before {
                border-color: #007bff;
            }

            .property-content {
                position: relative;
            }

            .occupancy {
                position: absolute;
                top: 0;
                right: 0;
                margin-bottom: 10px;
                display: flex;
                align-items: center;
                margin-top: 38px;
                margin-right: 10px;
                background-color: #ffcccc;
            }


            .occupancy .icon-person {
                font-size: 16px;
                color: #ff8080;
            }

            .occupancy .caption {
                font-size: 14px;
                margin-left: 5px;
                color: #555;
            }

            .table-container {
                overflow-x: auto;
                margin-bottom: 20px;
                min-height: 300px;
                display: flex;
                align-items: stretch;
            }

            table {
                width: 100%;
                border-collapse: collapse;
                table-layout: fixed;
            }

            th, td {
                padding: 12px;
                border: 1px solid #ddd;
                text-align: left;
                word-wrap: break-word;
            }

            th {
                background-color: #f8f9fa;
            }

            td {
                background-color: #fff;
            }

            .hidden {
                display: none;
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
                        <a href="#" class="logo m-0 float-start">Room</a>

                        <jsp:include page = "navbar.jsp"></jsp:include>

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
                            <h1 class="heading" data-aos="fade-up">List of Renter</h1>

                            <nav aria-label="breadcrumb" data-aos="fade-up" data-aos-delay="200">
                                <ol class="breadcrumb text-center justify-content-center">
                                    <li class="breadcrumb-item "><a href="OwnerController?service=OwnerHome">Home</a></li>
                                </ol>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>                        

            <div class="section section-properties" style="padding-bottom: 30px">
                <div class="container main-container">
                    <div class="row">
                        <!-- search -->
                        <div class="col-lg-3" style="margin-left: -80px;">
                            <div class="search-filter">
                                <div class="search-container">
                                    <input type="text" id="searchInput" class="form-control search-input" placeholder="Search by room number" oninput="filterRoomsByNumber()">
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-9">
                            <div class="row" id="roomContainer">
                                <div class="table-container">
                                    <table id="renterTable">
                                        <thead>
                                            <tr>
                                                <th>Renter Name</th>
                                                <th>Room Number</th>
                                                <th>Room Floor</th>
                                                <th>Balance</th>
                                                <th>Room Fee</th>                                               
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <% for (RenterList renters : listRenter) { %>
                                        <tr class="property-content">
                                            <td><a href="ViewRenterProfileController?renterID=<%= renters.getUserID() %>"><%= renters.getUserName() %></a></td>
                                            <td><%= renters.getRoomNumber() %></td>
                                            <td><%= renters.getRoomFloor() %></td>
                                            <td><%= renters.getBalance() %></td>
                                            <td>
                                                <a href="roomfee?roomID=<%= renters.getRoomID() %>">See Detail</a>
                                            </td>
                                        </tr>
                                        <% } %>
                                    </tbody>
                                </table>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script>
            function filterRoomsByNumber() {
                var input, filter, table, tr, td, i, txtValue;
                input = document.getElementById("searchInput");
                filter = input.value.toUpperCase();
                table = document.getElementById("renterTable");
                tr = table.getElementsByTagName("tr");
                for (i = 1; i < tr.length; i++) {
                    td = tr[i].getElementsByTagName("td")[1];
                    if (td) {
                        txtValue = td.textContent || td.innerText;
                        if (txtValue.toUpperCase().indexOf(filter) > -1) {
                            tr[i].classList.remove("hidden");
                        } else {
                            tr[i].classList.add("hidden");
                        }
                    }
                }
            }

        </script>
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
