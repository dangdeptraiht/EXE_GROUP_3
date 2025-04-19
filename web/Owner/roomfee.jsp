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


        <title>HL_Hotel</title>
        <link rel="icon" href="home-guest/favicon.png">
        <style>
            /*table*/
            .menu-bg-wrap{
                margin-left: 100px;
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
                            <h1 class="heading" data-aos="fade-up">Room Fee</h1>

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
                        <div class="col-md-12">
                            <div class="wrapper">
                                <div class="row no-gutters">
                                    <div class="col-12 order-md-last d-flex align-items-stretch">
                                        <div class="contact-wrap w-100 p-md-5 p-4">
                                            <section class="ftco-section">
                                                <div class="container">
                                                    <div class="row justify-content-center">
                                                        <div class="col-md-12">
                                                            <div class="wrapper">
                                                                <div class="row no-gutters">
                                                                    <div class="col-12 order-md-last d-flex align-items-stretch">
                                                                        <div class="contact-wrap w-100" style="padding: 0px 48px">
                                                                            <div class="card2">
                                                                                <div class="card-body2">
                                                                                    <h4 class="card-title2">All Fee(s) history in this room</h4>
                                                                                    <h6 class="card-subtitle2">Latest Fee that created by user</h6>
                                                                                    <div class="row">
                                                                                        <!--                                                                                                <div class="col-lg-6 col-md-12">
                                                                                                                                                                                            <form method="post" action="searchrequest" class="w-100">
                                                                                                                                                                                                <div class="row h-100" style="margin-bottom: 30px">
                                                                                                                                                                                                <div class="col-12"> 
                                                                                                                                                                                                <h6 class="main--title" style="padding-bottom: 0px; margin-bottom: 0px">&nbsp;Search:</h6>
                                                                                        
                                                                                                                                                                                                <div class="d-flex" >
                                                                                                                                                                                                <button class="btn-search"><i class="fa-solid fa-magnifying-glass"></i></button>
                                                                                                                                                                                                <input type="text" class="form-control w-75" name="txtSearch" placeholder="Enter name or mail" value="${param.txtSearch}">
                                                                                                                                                                                                </div>
                                                                                                                                                                                                </div>
                                                                                                                                                                                                <div class="col-12">
                                                                                                                                                                                                <div class="row">
                                                                                                                                                                                                <div class="col-12 d-flex gap-3">
                                                                                                                                                                                                Result Found: ${searchCount}
                                                                                                                                                                                                </div>
                                                                                                                                                                                                </div>
                                                                                                                                                                                                </div>
                                                                                                                                                                                                </div>
                                                                                                                                                                                            </form>
                                                                                                                                                                                        </div>-->
                                                                                    <!--                                                                                                <div class="col-lg-6 col-md-12">
                                                                                                                                                                                        <form method="get" action="filterrequest" class="w-100">
                                                                                                                                                                                            <div class="row h-100" style="margin-bottom: 30px">
                                                                                                                                                                                            <div class="col-12"> 
                                                                                                                                                                                            <h6 class="main--title" style="padding-bottom: 0px; margin-bottom: 0px">&nbsp;Filter by status:</h6>
                                                                                                                                                                                            <div class="d-flex">
                                                                                                                                                                                            <button type="submit" class="btn btn-info" style="background: #666; color: #FFF" type="submit">Filter</button>
                                                                                                                                                                                            <select name="status" class="form-control w-75">
                                                                                                                                                                                            <option value="">All</option>
                                                                                    <c:forEach items="${allStatus}" var="st">
                                                                                        <option value="${st.resStatus}">${st.resStatus}</option>
                                                                                    </c:forEach>
                                                                                </select>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </form>
                                                            </div>-->
                                                                                </div>
                                                                                <small style="font-style: italic; color: #EF3159">(*) you can edit or delete fee only when renter not paid that fee</small>
                                                                            </div>
                                                                            <a class="btn btn-primary" style="text-decoration: none; color: #FFF" href="addroomfee?id=${requestScope.roomID}"><i class="fa-solid fa-plus"></i></a>                                                                                                             
                                                                            <c:set var="page" value="${requestScope.page}"></c:set>
                                                                                <div class="comment-widgets m-b-20">

                                                                                    <div class="table-container">
                                                                                        <table>
                                                                                            <thead>
                                                                                                <tr>
                                                                                                    <th>Id</th>
                                                                                                    <th>Create Time</th>
                                                                                                    <th>Paid Time</th>
                                                                                                    <th>Total</th>
                                                                                                    <th style="text-align: center">Action</th>
                                                                                                </tr>
                                                                                            </thead>
                                                                                            <tbody>
                                                                                            <c:forEach var="bl" items="${requestScope.billList}" varStatus="loop" >
                                                                                                <c:set var="id" value="${bl.billID}"/>
                                                                                                <tr>
                                                                                                    <td style="text-align: center">${loop.index + 1}</td>
                                                                                                    <td style="padding: 20px 0px ">${bl.createAt}</td>
                                                                                                    <td>
                                                                                                        <c:choose>
                                                                                                            <c:when test="${bl.payAt eq null}">
                                                                                                                <p style="color: #EF3159; padding-bottom: 0px; font-weight: bold">Not paid yet!</p>
                                                                                                            </c:when>
                                                                                                            <c:otherwise>
                                                                                                                ${bl.payAt}
                                                                                                            </c:otherwise>
                                                                                                        </c:choose></td>
                                                                                                    <td style="font-weight: bold">${bl.total}k VND</td> 
                                                                                                    <td class="d-flex justify-content-center gap-3">
                                                                                                        <a class="btn btn-info" style="text-decoration: none; color: #FFF" href="roomfeedetail?id=${id}"><i class="fa-solid fa-circle-info"></i></a>
                                                                                                        <c:choose>
                                                                                                            <c:when test="${bl.payAt eq null}">
                                                                                                                <a class="btn btn-success" style="text-decoration: none" href="EditRoomFeeController?id=${id}"><i class="fa-regular fa-pen-to-square"></i></a>
                                                                                                                <a class="btn btn-danger" style="text-decoration: none; color: #FFF" href="DeleteRoomFeeController?id=${id}" onclick="return confirm('Are you sure you want to delete this fee?');">
                                                                                                                    <i class="fa-regular fa-trash-alt"></i>
                                                                                                                </a>
                                                                                                            </c:when>
                                                                                                            <c:otherwise>
                                                                                                            </c:otherwise>
                                                                                                        </c:choose>
                                                                                                    </td>
                                                                                                </tr>
                                                                                            </c:forEach>
                                                                                        </tbody>
                                                                                    </table>
                                                                                </div>

                                                                            </div>
                                                                            <!--                                                                                        <div class="pagination">
                                                                            <c:forEach begin="${1}" end="${requestScope.num}" var="i">
                                                                                <a class="${i==page?"active":""}" href="requesthistory?page=${i}">${i}</a>
                                                                            </c:forEach>
                                                                        </div>-->
                                                                        </div>


                                                                        <div class="row" style="margin-top:50px ">
                                                                            <div class="col-md-12">
                                                                                <div class="form-group d-flex justify-content-center">
                                                                                    <a style="padding: 10px 20px; font-size: 18px" href="/SWP391.E.BL5.G5/ListRenterController" class="btn btn-danger"><i class="fa-solid fa-chevron-left"></i>&nbsp;Back To List</a>
                                                                                </div>
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
    </body>

</html>