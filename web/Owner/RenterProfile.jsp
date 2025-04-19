<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.RoomDAO, dao.RenterDAO, java.util.List,java.util.Vector"%>
<%@page import="model.Room, model.User, model.Account" %>

<% User renterProfile = (User) request.getAttribute("renterProfile"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HL_Motel</title>
        <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css'>

        <link rel="shortcut icon" href="images/favicon.png">
        <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css'>

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Work+Sans:wght@400;500;600;700&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="fonts/icomoon/style.css">
        <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

        <link rel="stylesheet" href="css/tiny-slider.css">
        <link rel="stylesheet" href="css/aos.css">
        <link rel="stylesheet" href="css/style.css">

        <style>
            body {
                background: gray;
                margin-top: 80px;
            }

            .form-control:focus {
                box-shadow: none;
                border-color: #BA68C8;
            }

            .profile-button {
                background: #BA68C8;
                box-shadow: none;
                border: none;
            }

            .profile-button:hover {
                background: #682773;
            }

            .profile-button:focus {
                background: #682773;
                box-shadow: none;
            }

            .profile-button:active {
                background: #682773;
                box-shadow: none;
            }

            .back:hover {
                color: #682773;
                cursor: pointer;
            }

            label {
                font-size: 0.9rem;
                font-weight: 500;
                margin-bottom: 5px;
                display: block;
            }

            .back a {
                color: #FFFFFF;
                background-color: #BA68C8;
                border: 2px solid #BA68C8;
                padding: 10px 20px;
                border-radius: 5px;
                font-weight: 600;
                text-decoration: none;
            }

            .back a:hover {
                background-color: #FFFFFF;
                color: #BA68C8;
                text-decoration: none;
                cursor: pointer;
            }
        </style>
    </head>
    <body>
        <nav style="margin-top: -20px" class="site-nav">
            <div class="container">
                <div class="menu-bg-wrap">
                    <div class="site-navigation">
                        <a href="OwnerHome.jsp" class="logo m-0 float-start">Room</a>

                        <jsp:include page = "navbar.jsp"></jsp:include>

                            <a href="#" class="burger light me-auto float-end mt-1 site-menu-toggle js-menu-toggle d-inline-block d-lg-none" data-toggle="collapse" data-target="#main-navbar">
                                <span></span>
                            </a>

                        </div>
                    </div>
                </div>
            </nav>
            <div class="container rounded bg-white mt-5">                                   
                <div class="row">
                    <div class="col-md-4 border-right">
                        <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                        <% String base64Image = renterProfile.getUserAvatar(); %>
                        <img class="rounded-circle mt-5" src="data:image/jpg;base64, <%= base64Image %>" width="150">
                        <span class="font-weight-bold" style="margin-top: 5px">Avatar</span>
                    </div>
                </div>
                <div class="col-md-8">
                    <div class="p-3 py-5">                           
                        <div class="row">
                            <div class="col-md-6">
                                <label>Full Name</label>
                                <input type="text" class="form-control" placeholder="Full Name" value="<%= renterProfile.getUserName() %>" readonly="">
                            </div>
                            <div class="col-md-6">
                                <label>Phone Number</label>
                                <input type="text" class="form-control" value="<%= renterProfile.getUserPhone() %>" placeholder="Phone number" readonly="">
                            </div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-md-6">
                                <label>Gender</label>
                                <input type="text" class="form-control" value="<%= renterProfile.getUserGender() %>" placeholder="Gender" readonly="">
                            </div>
                            <div class="col-md-6">
                                <label>BirthDay</label>
                                <input type="text" class="form-control" value="<%= renterProfile.getUserBirth() %>" placeholder="BirthDay" readonly="">
                            </div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-md-12">
                                <label>Address</label>
                                <input type="text" class="form-control" value="<%= renterProfile.getUserAddress() %>" placeholder="Address" readonly="">
                            </div>                            
                        </div>
                        <div class="mt-5 text-right"></div>
                        <div class="d-flex justify-content-between align-items-center mb-3">
                            <div class="d-flex flex-row align-items-center back">
                                <i class="fa fa-long-arrow-left mr-1 mb-1"></i>
                                <a href="ListRenterController">Back to list</a>
                            </div>               
                        </div>
                    </div>
                </div>                          
            </div>                            
        </div>
        
    </body>
    <script src='https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js'></script>
</html>
