<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="model.Guideline" %>
<!DOCTYPE html>
<html>
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
        <title>Payments</title>
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
            <div class="hero page-inner overlay" style="background-image: url('images/hero_bg_1.jpg');">

                <div class="container">
                    <div class="row justify-content-center align-items-center">
                        <div class="col-lg-9 text-center mt-5">
                            <h1 class="heading" data-aos="fade-up">Payments</h1>
                        </div>
                    </div>
                </div>
            </div>

             <div class="main">
                <div class="container" style="margin-top: 2em">
                    <div class="col-3"><a href="createPayment"><button type="button" class="btn btn-primary">Create Payment</button></div></a>
                    <table id="guildLineTable" class="display">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th><p class="text-center">Money</p></th>
                                <th><p class="text-center">Status</p></th>
                                <th>Created At</th>
                                <th>Updated At</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
            </div>
       
        </body>
        <script>
            $(document).ready(function () {
                var dataList = ${dataList};
                //var realData = JSON.parse(dataList);
                $('#guildLineTable').DataTable({
                    data: dataList,
                    columns: [
                        {title: "ID", data: "id"},
                        {title: "Money", data: "money"},
                        {
                            title: "Status",
                            data: "status",
                            render: function (data, type, row) {
                                if (data === 0) {
                                    return '<button type="button" class="btn btn-info">Pending</span>';
                                } else if (data === 1) {
                                    return '<button type="button" class="btn btn-success">Paid</span>';
                                } else if (data === 2) {
                                    return '<button type="button" class="btn btn-danger">Not Paid</span>';
                                }
                            }
                        },
                        {
                            title: "Created At",
                            data: "createdAt",
                            render: function (data, type, row) {
                                return '<p class="text-left">' + data + '</p>';
                            }
                        },
                        {
                            title: "Updated At",
                            data: "updatedAt",
                            render: function (data, type, row) {
                                return '<p class="text-left">' + data + '</p>';
                            }
                        },
                        {
                            title: "Action",
                            
                            render: function (data, type, row) {
                                return '\
            <a href="VNPay_PaymentController?id=' + row.id + '&flag=0&amount=' + row.money + '"><button type="button" class="btn btn-success">Pay</button></a>';
                            },
                            orderable: false
                        }
                    ]
                });
            });
            
    </script>
</html>
