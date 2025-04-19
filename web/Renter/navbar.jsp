<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="author" content="Untree.co">
        <link rel="shortcut icon" href="./images/favicon.png">

        <meta name="description" content="Your description here" />
        <meta name="keywords" content="bootstrap, bootstrap5" />

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Work+Sans:wght@400;500;600;700&display=swap" rel="stylesheet">


        <link rel="stylesheet" href="../fonts/icomoon/style.css">
        <link rel="stylesheet" href="../fonts/flaticon/font/flaticon.css">

        <link rel="stylesheet" href="../css/tiny-slider.css">
        <link rel="stylesheet" href="../css/aos.css">
        <link rel="stylesheet" href="../css/style.css">

        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link rel="stylesheet" href="https://cdn.datatables.net/2.0.8/css/dataTables.dataTables.css" />

        <script src="https://cdn.datatables.net/2.0.8/js/dataTables.js"></script>

        <title>HoLa Motel</title>
    </head>
    <body>        
        <ul class="js-clone-nav d-none d-lg-inline-block text-start site-menu float-end">
            <li class="${param.service == null || param.service == 'renterhome' ? 'active' : ''}">
                <a href="rentercontroller?service=renterhome">Home</a>
            </li>
            <li class="has-children ${(param.service == 'listRoom') ||  (param.service == 'guideandrule') || (param.service == 'RenterRoomDetail') ? 'active' : ''}">
                <a href="#">View</a>
                <ul class="dropdown">
                    <li><a href="RenterRoomController?service=listRoom&index=1">List Of Rooms</a></li>
                    <li><a href="renterguideline?service=guideandrule">Guide and Rule</a></li>
                    <li><a href="RenterRoomDetail?service=RenterRoomDetail">My Room</a></li>
                    <li><a href="rentercontroller?service=news">News</a></li>
                    <li><a href="renpen">Penalty</a></li>
                </ul>
            </li>               
            <li class="${param.service == "paymentList" ? "active" : ''}"><a href="WalletController">Wallet</a></li>
            <li><a href="rentercontroller?service=request">Contact Us</a></li>
            <li><a href="listrequest1?service=request">List Request</a></li>
            <li><a href="logout">Logout</a></li>
            <li>
                <a href="rentercontroller?service=renterprofile">
                    <img src="data:image/jpg;base64,${imgAvata}" alt="Profile Image" width="30px" height="30px" style="border-radius: 10px;">
                </a>
            </li>
        </ul>

        <script src="../js/bootstrap.bundle.min.js"></script>
        <script src="../js/tiny-slider.js"></script>
        <script src="../js/aos.js"></script>
        <script src="../js/navbar.js"></script>
        <script src="../js/counter.js"></script>
        <script src="../js/custom.js"></script>
    </body>
</html>
