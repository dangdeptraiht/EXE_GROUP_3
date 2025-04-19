<%@page import="dao.RoomDAO,java.util.List"%>
<%@page import="model.Rooms" %>

<%
    List<Rooms> listRoom = (List<Rooms>) request.getAttribute("rooms");
    List<Rooms> listAllRoom = (List<Rooms>) request.getAttribute("allRooms");
    int totalPage = (int) request.getAttribute("totalPage");
    int index = (int) request.getAttribute("index");
    int isRenter = (int) request.getAttribute("isRenter");
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
        <script>

            function formatNumber(number) {
                return number.toString().replace(/\B(?=(\d{3})+(?!\d))/g, '.');
            }


            function formatAllPrices() {
                var priceElements = document.querySelectorAll('.price span');
                priceElements.forEach(function (element) {
                    var rawFee = element.getAttribute('data-fee');
                    var formattedFee = formatNumber(rawFee);
                    element.textContent = formattedFee + ' VND';
                });
            }


            document.addEventListener('DOMContentLoaded', formatAllPrices);
        </script>
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
                width: 250px;
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

            .building-input {
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

            .building-input:checked {
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

            .rented-room-message {
                background-color: #f8d7da;
                color: #721c24;
                border: 1px solid #f5c6cb;
                padding: 15px;
                margin-bottom: 20px;
                border-radius: 5px;
                text-align: center;
            }

            .search-filter {
                padding: 20px;
                border: 1px solid #ddd;
                border-radius: 5px;
                background-color: #f9f9f9;
            }

            .search-container {
                margin-bottom: 20px;
            }

            .form-control.search-input {
                width: 100%;
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 4px;
            }

            .price-range, .building-filters {
                margin-bottom: 20px;
            }

            .price-label, .building-label {
                font-weight: bold;
                margin-bottom: 10px;
                display: block;
            }

            .price-input, .building-input {
                margin-right: 5px;
            }

            .price-range label, .building-filters label {
                margin-right: 10px;
            }

            .price-range input[type="checkbox"], .building-filters input[type="checkbox"] {
                margin-right: 5px;
            }

            .price-range input[type="checkbox"]:checked + label,
            .building-filters input[type="checkbox"]:checked + label {
                font-weight: bold;
                color: #007bff;
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

        <!-- header -->
        <nav class="site-nav">
            <div class="container">
                <div class="menu-bg-wrap">
                    <div class="site-navigation">
                        <a href="rentercontroller?service=renterhome" class="logo m-0 float-start">Room</a>

                        <jsp:include page = "navbar.jsp"></jsp:include>

                            <a href="#" class="burger light me-auto float-end mt-1 site-menu-toggle js-menu-toggle d-inline-block d-lg-none" data-toggle="collapse" data-target="#main-navbar">
                                <span></span>
                            </a>

                        </div>
                    </div>
                </div>
            </nav>

            <!-- background img header -->            
            <div class="hero page-inner overlay" style="background-image: url('images/hero_bg_1.jpg');">

                <div class="container">
                    <div class="row justify-content-center align-items-center">
                        <div class="col-lg-9 text-center mt-5">
                            <h1 class="heading" data-aos="fade-up">Rooms</h1>

                            <nav aria-label="breadcrumb" data-aos="fade-up" data-aos-delay="200">
                                <ol class="breadcrumb text-center justify-content-center">
                                    <li class="breadcrumb-item "><a href="rentercontroller?service=renterhome">Home</a></li>
                                </ol>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>

            <!-- body -->
            <div class="section section-properties" style="padding-bottom: 30px">
                <div class="container main-container">
                    <div class="row">
                        <!-- Search and Filter -->
                        <div class="col-lg-3" style="margin-left: -80px;">
                            <div class="search-filter">
                                <div class="search-container">
                                    <input type="text" id="searchInput" class="form-control search-input" placeholder="Search by room number">
                                </div>

                                <div class="price-range">
                                    <label style="color: orange; font-size: 17px" class="price-label">Price Levels</label><br>
                                    <input type="checkbox" id="priceBelow1M" name="priceRange" value="below1M" class="price-input" onclick="filterRooms(this)">
                                    <label for="priceBelow1M" class="price-label">Under 1 million</label><br>
                                    <input type="checkbox" id="price1To2M" name="priceRange" value="1To2M" class="price-input" onclick="filterRooms(this)">
                                    <label for="price1To2M" class="price-label">1-2 million</label><br>
                                    <input type="checkbox" id="price2To3M" name="priceRange" value="2To3M" class="price-input" onclick="filterRooms(this)">
                                    <label for="price2To3M" class="price-label">2-3 million</label>
                                </div>
                            </div>
                        </div>
                        <!-- End Search and Filter -->

                        <div class="col-lg-9">
                        <% if (isRenter != 0) { %>
                        <!-- Rented Room Message -->
                        <div class="rented-room-message text-center">
                            <p>You have already rented a room</p>
                        </div>
                        <% } %>

                        <% if (isRenter == 0) { %>
                        <!-- Available Rooms -->
                        <div id="roomListContainer">
                            <div id="roomList" class="room-list-container row" >
                                <% for (Rooms room : listRoom) { 
                            if (room.getRoomStatus() == 1) { %>
                                <div class="col-xs-12 col-sm-6 col-md-6 col-lg-4" data-room-name="<%= room.getRoomNumber() %>" data-room-price="<%= room.getRoomFee().longValue() %>">
                                    <div class="property-item mb-30">
                                        <a href="OwnerController?service=roomDetail&roomID=<%= room.getRoomID() %>" class="img">
                                            <% String base64Image = room.getRoomImg(); %>
                                            <img src="data:image/jpg;base64,<%= base64Image %>" class="img-fluid" style="height: 350px; width: 100%;">
                                        </a>
                                        <div class="property-content">
                                            <div class="price mb-2"><span><%= room.getRoomFee().longValue() %>k VND</span></div>
                                            <div>
                                                <span class="d-block mb-2 text-black-50">Thon 3, Tan Xa, Thach That</span>
                                                <span class="city d-block mb-3">Room <%= room.getRoomNumber() %></span>
                                                <div class="specs d-flex mb-4">
                                                    <span class="d-block d-flex align-items-center me-3">
                                                        <span class="icon-bed me-2"></span>
                                                        <span class="caption"><%= room.getRoomSize() %> beds</span>
                                                    </span>
                                                    <span style="margin-right: 10px" class="d-block d-flex align-items-center">
                                                        <span class="icon-building me-2"></span>
                                                        <span class="caption"><%= room.getRoomFloor() %> Floor</span>
                                                    </span>
                                                    <span class="d-block d-flex align-items-center">
                                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-buildings-fill" viewBox="0 0 16 16">
                                                        <path d="M15 .5a.5.5 0 0 0-.724-.447l-8 4A.5.5 0 0 0 6 4.5v3.14L.342 9.526A.5.5 0 0 0 0 10v5.5a.5.5 0 0 0 .5.5h9a.5.5 0 0 0 .5-.5V14h1v1.5a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5zM2 11h1v1H2zm2 0h1v1H4zm-1 2v1H2v-1zm1 0h1v1H4zm9-10v1h-1V3zM8 5h1v1H8zm1 2v1H8V7zM8 9h1v1H8zm2 0h1v1h-1zm-1 2v1H8v-1zm1 0h1v1h-1zm3-2v1h-1V9zm-1 2h1v1h-1zm-2-4h1v1h-1zm3 0v1h-1V7zm-2-2v1h-1V5zm1 0h1v1h-1z"/>
                                                        </svg>
                                                        <span class="caption"> Building <%= room.getRoomDepartment() %> </span>
                                                    </span>
                                                </div>
                                                <a style="margin-right: 53px" href="RenterRoomController?service=roomDetail&roomID=<%= room.getRoomID() %>" class="btn btn-primary py-2 px-3">See details</a>
                                                <a style="background-color: #17a2b8;" href="RenterRoomController?service=rentRoom&roomID=<%= room.getRoomID() %>" class="btn btn-rent py-2 px-3">Rent</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <% } } %>
                            </div>
                        </div>
                        <!-- End Available Rooms -->

                        <!-- All Rooms -->
                        <div id="allRoomListContainer" style="display: none;">
                            <div id="allRoomList" class="room-list-container row">
                                <% for (Rooms room : listAllRoom) { 
                            if (room.getRoomStatus() == 1) { %>
                                <div class="col-xs-12 col-sm-6 col-md-6 col-lg-4" data-room-name="<%= room.getRoomNumber() %>" data-room-price="<%= room.getRoomFee().longValue() %>">
                                    <div class="property-item mb-30">
                                        <a href="OwnerController?service=roomDetail&roomID=<%= room.getRoomID() %>" class="img">
                                            <% String base64Image = room.getRoomImg(); %>
                                            <img src="data:image/jpg;base64,<%= base64Image %>" class="img-fluid" style="height: 350px; width: 100%;">
                                        </a>
                                        <div class="property-content">
                                            <div class="price mb-2"><span><%= room.getRoomFee().longValue() %>k VND</span></div>
                                            <div>
                                                <span class="d-block mb-2 text-black-50">Thon 3, Tan Xa, Thach That</span>
                                                <span class="city d-block mb-3">Room <%= room.getRoomNumber() %></span>
                                                <div class="specs d-flex mb-4">
                                                    <span class="d-block d-flex align-items-center me-3">
                                                        <span class="icon-bed me-2"></span>
                                                        <span class="caption"><%= room.getRoomSize() %> beds</span>
                                                    </span>
                                                    <span style="margin-right: 10px" class="d-block d-flex align-items-center">
                                                        <span class="icon-building me-2"></span>
                                                        <span class="caption"><%= room.getRoomFloor() %> Floor</span>
                                                    </span>
                                                    <span class="d-block d-flex align-items-center">
                                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-buildings-fill" viewBox="0 0 16 16">
                                                        <path d="M15 .5a.5.5 0 0 0-.724-.447l-8 4A.5.5 0 0 0 6 4.5v3.14L.342 9.526A.5.5 0 0 0 0 10v5.5a.5.5 0 0 0 .5.5h9a.5.5 0 0 0 .5-.5V14h1v1.5a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5zM2 11h1v1H2zm2 0h1v1H4zm-1 2v1H2v-1zm1 0h1v1H4zm9-10v1h-1V3zM8 5h1v1H8zm1 2v1H8V7zM8 9h1v1H8zm2 0h1v1h-1zm-1 2v1H8v-1zm1 0h1v1h-1zm3-2v1h-1V9zm-1 2h1v1h-1zm-2-4h1v1h-1zm3 0v1h-1V7zm-2-2v1h-1V5zm1 0h1v1h-1z"/>
                                                        </svg>
                                                        <span class="caption"> Building <%= room.getRoomDepartment() %> </span>
                                                    </span>
                                                </div>
                                                <a style="margin-right: 53px" href="RenterRoomController?service=roomDetail&roomID=<%= room.getRoomID() %>" class="btn btn-primary py-2 px-3">See details</a>
                                                <a style="background-color: #17a2b8;" href="RenterRoomController?service=rentRoom&roomID=<%= room.getRoomID() %>" class="btn btn-rent py-2 px-3">Rent</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <% } } %>
                            </div>
                        </div>
                        <!-- End All Rooms -->

                        <!-- Rooms in Department A -->
                        <div id="departmentAListContainer" style="display: none;">
                            <div id="allRoomList" class="room-list-container row">
                                <% for (Rooms room : listAllRoom) { 
                                       if (room.getRoomStatus() == 1 && room.getRoomDepartment().trim().equals("A")) { 
                                %>                                
                                <div class="col-xs-12 col-sm-6 col-md-6 col-lg-4" data-room-name="<%= room.getRoomNumber() %>" data-room-price="<%= room.getRoomFee().longValue() %>" data-room-department="<%= room.getRoomDepartment() %>" >
                                    <div class="property-item mb-30">
                                        <a href="OwnerController?service=roomDetail&roomID=<%= room.getRoomID() %>" class="img">
                                            <% String base64Image = room.getRoomImg(); %>
                                            <img src="data:image/jpg;base64,<%= base64Image %>" class="img-fluid" style="height: 350px; width: 100%;">
                                        </a>
                                        <div class="property-content">
                                            <div class="price mb-2"><span><%= room.getRoomFee().longValue() %>k VND</span></div>
                                            <div>
                                                <span class="d-block mb-2 text-black-50">Thon 3, Tan Xa, Thach That</span>
                                                <span class="city d-block mb-3">Room <%= room.getRoomNumber() %></span>
                                                <div class="specs d-flex mb-4">
                                                    <span class="d-block d-flex align-items-center me-3">
                                                        <span class="icon-bed me-2"></span>
                                                        <span class="caption"><%= room.getRoomSize() %> beds</span>
                                                    </span>
                                                    <span style="margin-right: 10px" class="d-block d-flex align-items-center">
                                                        <span class="icon-building me-2"></span>
                                                        <span class="caption"><%= room.getRoomFloor() %> Floor</span>
                                                    </span>
                                                    <span class="d-block d-flex align-items-center">
                                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-buildings-fill" viewBox="0 0 16 16">
                                                        <path d="M15 .5a.5.5 0 0 0-.724-.447l-8 4A.5.5 0 0 0 6 4.5v3.14L.342 9.526A.5.5 0 0 0 0 10v5.5a.5.5 0 0 0 .5.5h9a.5.5 0 0 0 .5-.5V14h1v1.5a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5zM2 11h1v1H2zm2 0h1v1H4zm-1 2v1H2v-1zm1 0h1v1H4zm9-10v1h-1V3zM8 5h1v1H8zm1 2v1H8V7zM8 9h1v1H8zm2 0h1v1h-1zm-1 2v1H8v-1zm1 0h1v1h-1zm3-2v1h-1V9zm-1 2h1v1h-1zm-2-4h1v1h-1zm3 0v1h-1V7zm-2-2v1h-1V5zm1 0h1v1h-1z"/>
                                                        </svg>
                                                        <span class="caption"> Building <%= room.getRoomDepartment() %> </span>
                                                    </span>
                                                </div>
                                                <a style="margin-right: 53px" href="RenterRoomController?service=roomDetail&roomID=<%= room.getRoomID() %>" class="btn btn-primary py-2 px-3">See details</a>
                                                <a style="background-color: #17a2b8;" href="RenterRoomController?service=rentRoom&roomID=<%= room.getRoomID() %>" class="btn btn-rent py-2 px-3">Rent</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <% } } %>
                            </div>
                        </div>
                        <!-- End Rooms in Department A -->

                        <!-- Rooms in Department B -->
                        <div id="departmentBListContainer" style="display: none;">
                            <div id="departmentBList" class="room-list-container row">
                                <% for (Rooms room : listAllRoom) { 
                                        if (room.getRoomStatus() == 1 && room.getRoomDepartment().trim().equals("B")) { %>
                                <div class="col-xs-12 col-sm-6 col-md-6 col-lg-4" data-room-name="<%= room.getRoomNumber() %>" data-room-price="<%= room.getRoomFee().longValue() %>">
                                    <div class="property-item mb-30">
                                        <a href="OwnerController?service=roomDetail&roomID=<%= room.getRoomID() %>" class="img">
                                            <% String base64Image = room.getRoomImg(); %>
                                            <img src="data:image/jpg;base64,<%= base64Image %>" class="img-fluid" style="height: 350px; width: 100%;">
                                        </a>
                                        <div class="property-content">
                                            <div class="price mb-2"><span><%= room.getRoomFee().longValue() %>k VND</span></div>
                                            <div>
                                                <span class="d-block mb-2 text-black-50">Thon 3, Tan Xa, Thach That</span>
                                                <span class="city d-block mb-3">Room <%= room.getRoomNumber() %></span>
                                                <div class="specs d-flex mb-4">
                                                    <span class="d-block d-flex align-items-center me-3">
                                                        <span class="icon-bed me-2"></span>
                                                        <span class="caption"><%= room.getRoomSize() %> beds</span>
                                                    </span>
                                                    <span style="margin-right: 10px" class="d-block d-flex align-items-center">
                                                        <span class="icon-building me-2"></span>
                                                        <span class="caption"><%= room.getRoomFloor() %> Floor</span>
                                                    </span>
                                                    <span class="d-block d-flex align-items-center">
                                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-buildings-fill" viewBox="0 0 16 16">
                                                        <path d="M15 .5a.5.5 0 0 0-.724-.447l-8 4A.5.5 0 0 0 6 4.5v3.14L.342 9.526A.5.5 0 0 0 0 10v5.5a.5.5 0 0 0 .5.5h9a.5.5 0 0 0 .5-.5V14h1v1.5a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5zM2 11h1v1H2zm2 0h1v1H4zm-1 2v1H2v-1zm1 0h1v1H4zm9-10v1h-1V3zM8 5h1v1H8zm1 2v1H8V7zM8 9h1v1H8zm2 0h1v1h-1zm-1 2v1H8v-1zm1 0h1v1h-1zm3-2v1h-1V9zm-1 2h1v1h-1zm-2-4h1v1h-1zm3 0v1h-1V7zm-2-2v1h-1V5zm1 0h1v1h-1z"/>
                                                        </svg>
                                                        <span class="caption"> Building <%= room.getRoomDepartment() %> </span>
                                                    </span>
                                                </div>
                                                <a style="margin-right: 53px" href="RenterRoomController?service=roomDetail&roomID=<%= room.getRoomID() %>" class="btn btn-primary py-2 px-3">See details</a>
                                                <a style="background-color: #17a2b8;" href="RenterRoomController?service=rentRoom&roomID=<%= room.getRoomID() %>" class="btn btn-rent py-2 px-3">Rent</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <% } } %>
                            </div>
                        </div>
                        <!-- End Rooms in Department B -->


                        <% } %>
                    </div>
                </div>
            </div>
        </div>


        <!-- paging -->
        <div class="pagination" style="margin: 0px; padding-bottom: 50px">
            <% for (int i = 0; i < totalPage; i++) { %>
            <a href="RenterRoomController?service=listRoom&index=<%=i+1%>" class="<%= (i + 1 == index) ? "active" : "" %>"><%= i + 1 %></a>
            <% } %>
        </div>  

        <!-- footer -->
        <div class="site-footer">
            <div class="container">

                <div class="row">
                    <div class="col-lg-4">
                        <div class="widget">
                            <h3>Contact</h3>
                            <address>FPT University, Thach That, Ha Noi</address>
                            <ul class="list-unstyled links">
                                <li><a href="tel://11234567890">+1(123)-456-789</a></li>
                                <li><a href="tel://11234567890">+1(123)-456-789</a></li>
                                <li><a href="mailto:info@mydomain.com">fptuniversity@fpt.edu.vn</a></li>
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
                                <li><a href="https://www.facebook.com/elfadkeachother"><span class="icon-facebook"></span></a></li>
                                <li><a href="#"><span class="icon-linkedin"></span></a></li>
                                <li><a href="#"><span class="icon-pinterest"></span></a></li>
                                <li><a href="#"><span class="icon-dribbble"></span></a></li>
                            </ul>
                        </div> <!-- /.widget -->
                    </div> 
                </div> 
            </div> 
        </div> <!-- /.site-footer -->


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

        <script>
                                            document.addEventListener('DOMContentLoaded', function () {
                                                var searchInput = document.getElementById('searchInput');
                                                var roomList = document.getElementById('roomList').children;

                                                searchInput.addEventListener('input', function () {
                                                    var filter = searchInput.value.toLowerCase();
                                                    Array.from(roomList).forEach(function (room) {
                                                        var roomName = room.getAttribute('data-room-name').toLowerCase();
                                                        if (roomName.indexOf(filter) > -1) {
                                                            room.style.display = '';
                                                        } else {
                                                            room.style.display = 'none';
                                                        }
                                                    });
                                                });
                                            });
        </script>

        <script>
            function filterRooms(clickedCheckbox) {
                var checkboxes = document.querySelectorAll('input[name="priceRange"]');
                checkboxes.forEach(function (checkbox) {
                    if (checkbox !== clickedCheckbox) {
                        checkbox.checked = false;
                    }
                });

                var selectedPriceRange = document.querySelector('input[name="priceRange"]:checked') ? document.querySelector('input[name="priceRange"]:checked').value : null;
                var roomListContainer = document.getElementById('roomListContainer');
                var allRoomListContainer = document.getElementById('allRoomListContainer');
                var allRoomList = document.getElementById('allRoomList').children;

                if (!selectedPriceRange) {
                    roomListContainer.style.display = 'block';
                    allRoomListContainer.style.display = 'none';
                    return;
                }

                roomListContainer.style.display = 'none';
                allRoomListContainer.style.display = 'block';

                Array.from(allRoomList).forEach(function (room) {
                    var price = room.getAttribute('data-room-price');

                    if (selectedPriceRange === "all") {
                        room.style.display = "block";
                    } else if (selectedPriceRange === "below1M" && price < 1000) {
                        room.style.display = "block";
                    } else if (selectedPriceRange === "1To2M" && price >= 1000 && price <= 2000) {
                        room.style.display = "block";
                    } else if (selectedPriceRange === "2To3M" && price > 2000 && price <= 3000) {
                        room.style.display = "block";
                    } else {
                        room.style.display = "none";
                    }
                });

            }
        </script>

        <script>
            function filterRoomsByDepartment() {

                var departmentAChecked = document.getElementById("departmentA").checked;
                var departmentBChecked = document.getElementById("departmentB").checked;


                var availableRoomsContainer = document.getElementById("roomListContainer");
                var departmentAContainer = document.getElementById("departmentAListContainer");
                var departmentBContainer = document.getElementById("departmentBListContainer");



                departmentAContainer.style.display = 'none';
                departmentBContainer.style.display = 'none';


                if (departmentAChecked) {
                    availableRoomsContainer.style.display = 'none';
                    departmentAContainer.style.display = 'block';

                }
                if (departmentBChecked) {
                    departmentBContainer.style.display = 'block';
                    availableRoomsContainer.style.display = 'none';
                }
                if (!departmentAChecked && !departmentBChecked) {
                    availableRoomsContainer.style.display = 'block';
                }
            }


            document.getElementById("departmentA").addEventListener("change", filterRoomsByDepartment);
            document.getElementById("departmentB").addEventListener("change", filterRoomsByDepartment);
        </script>



    </body>
</html>