<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="model.Guideline" %>
<% ArrayList<Guideline> guideLines = (ArrayList<Guideline>) request.getAttribute("guidelines"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Guildlines List</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" rel="stylesheet">

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

        <style>
            body {
                background: #f5f5f5;
                margin-top: 20px;
            }

            .ui-w-80 {
                width : 80px !important;
                height: auto;
            }

            .btn-default {
                border-color: rgba(24, 28, 33, 0.1);
                background  : rgba(0, 0, 0, 0);
                color       : #4E5155;
            }

            label.btn {
                margin-bottom: 0;
            }

            .btn-outline-primary {
                border-color: #26B4FF;
                background  : transparent;
                color       : #26B4FF;
            }

            .btn {
                cursor: pointer;
            }
            .text-light {
                color: #babbbc !important;
            }

            .btn-facebook {
                border-color: rgba(0, 0, 0, 0);
                background  : #3B5998;
                color       : #fff;
            }

            .btn-instagram {
                border-color: rgba(0, 0, 0, 0);
                background  : #000;
                color       : #fff;
            }

            .card {
                background-clip: padding-box;
                box-shadow     : 0 1px 4px rgba(24, 28, 33, 0.012);
            }

            .row-bordered {
                overflow: hidden;
            }

            .account-settings-fileinput {
                position  : absolute;
                visibility: hidden;
                width     : 1px;
                height    : 1px;
                opacity   : 0;
            }

            .account-settings-links .list-group-item.active {
                font-weight: bold !important;
            }

            html:not(.dark-style) .account-settings-links .list-group-item.active {
                background: transparent !important;
            }

            .account-settings-multiselect~.select2-container {
                width: 100% !important;
            }

            .light-style .account-settings-links .list-group-item {
                padding     : 0.85rem 1.5rem;
                border-color: rgba(24, 28, 33, 0.03) !important;
            }

            .light-style .account-settings-links .list-group-item.active {
                color: #4e5155 !important;
            }

            .material-style .account-settings-links .list-group-item {
                padding     : 0.85rem 1.5rem;
                border-color: rgba(24, 28, 33, 0.03) !important;
            }

            .material-style .account-settings-links .list-group-item.active {
                color: #4e5155 !important;
            }

            .dark-style .account-settings-links .list-group-item {
                padding     : 0.85rem 1.5rem;
                border-color: rgba(255, 255, 255, 0.03) !important;
            }

            .dark-style .account-settings-links .list-group-item.active {
                color: #fff !important;
            }

            .light-style .account-settings-links .list-group-item.active {
                color: #4E5155 !important;
            }

            .light-style .account-settings-links .list-group-item {
                padding     : 0.85rem 1.5rem;
                border-color: rgba(24, 28, 33, 0.03) !important;
            }

            .scrollable-list {
                max-height: 400px;
                overflow-y: auto;
            }
        </style>
    </head>
    <body>

        <nav style="margin-top: -20px" class="site-nav">
            <div class="container">
                <div class="menu-bg-wrap">
                    <div class="site-navigation">
                        <a href="renterguideline" class="logo m-0 float-start">GuideLine</a>
                        <jsp:include page = "navbar.jsp"></jsp:include>

                            <a href="#" class="burger light me-auto float-end mt-1 site-menu-toggle js-menu-toggle d-inline-block d-lg-none" data-toggle="collapse" data-target="#main-navbar">
                                <span></span>
                            </a>

                        </div>
                    </div>
                </div>
            </nav>


            <div  class="container light-style flex-grow-1 container-p-y">
                <h4 class="font-weight-bold py-3 mb-4">

                </h4>

                <div class="card overflow-hidden">
                    <div class="row no-gutters row-bordered row-border-light">

                        <div class="col-md-3 pt-0">
                            <div class="list-group list-group-flush account-settings-links scrollable-list">
                            <% for (int i = 0; i < guideLines.size(); i++) { %>
                            <a class="list-group-item list-group-item-action <%= i == 0 ? "active" : "" %>" data-toggle="tab" href="#account-<%=i%>"><%= guideLines.get(i).getGuideName() %></a>
                            <%}%>
                        </div>
                    </div>


                    <div class="col-md-9">
                        <div class="tab-content">
                            <% for (int i = 0; i < guideLines.size(); i++) { %>
                            <div class="tab-pane fade <%= i == 0 ? "active show" : "" %>" id="account-<%=i%>">
                                <div class="card-body">                                    
                                    <% String base64Image = guideLines.get(i).getImg(); %>
                                    <img src="<%= base64Image %>" class="img-fluid" style="height: 500px; width: 100%;">
                                </div>
                            </div>
                            <% } %>
                        </div>
                    </div>                                                                        
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
        <script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>
        <script type="text/javascript"></script>
    </body>

</html>
