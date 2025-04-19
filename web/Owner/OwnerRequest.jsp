<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
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

        <link rel="stylesheet" href="css/Table.css"/>
        <link rel="stylesheet" href="fonts/icomoon/style.css">
        <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">
        <link rel="stylesheet" href="vcss/tiny-slider.css">
        <link rel="stylesheet" href="vcss/aos.css">
        <link rel="stylesheet" href="vcss/style.css">
        <link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">	
        <link rel="stylesheet" href="CSS/Renter.css"/>

        <link
            rel="stylesheet"
            type="text/css"
            href="bootstrap-5.0.2-dist/css/bootstrap.min.css"
            />
        <script
            type="text/javascript"
            src="bootstrap-5.0.2-dist/js/bootstrap.min.js"
        ></script>
        <link
            href="https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css"
            rel="stylesheet"
            />
        <link rel="stylesheet" href="fontawesome-free-6.5.1-web/css/all.css">
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
                        <a href="RenterHome.jsp" class="logo m-0 float-start">Renter</a>

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
                            <h1 class="heading" data-aos="fade-up">List Request </h1>
                            <nav aria-label="breadcrumb" data-aos="fade-up" data-aos-delay="200">
                                <ol class="breadcrumb text-center justify-content-center">
                                    <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                                    <li class="breadcrumb-item active text-white-50" aria-current="page">Contact</li>
                                </ol>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
            <div class="Table-responsive">
                <main>
                    <h1>List Request</h1>
                <% 
// Retrieve message from session
String message = (String) session.getAttribute("message");
    
// Clear the message from the session after displaying it
if (message != null) {
    session.removeAttribute("message");
                %>
                <div class="alert alert-info" role="alert">
                    <%= message %>
                </div>
                <% 
                    } 
                %>
                <div role="region" aria-labelledby="Cap1" tabindex="0">
                    <table id="Books">
                        <caption id="Cap1">The list will run Hope so...</caption>
                        <tr>
                            <th>User Name</th>
                            <th>Title</th>
                            <th>Description</th>
                            <th>Type Name</th>
                            <th>Created At</th>
                            <th>Status</th>
                        </tr>
                        <c:forEach var="request" items="${requests}">
                            <tr>
                                <td>${request.userName}</td>
                                <td>${request.title}</td>
                                <td>${request.description}</td>
                                <td>${request.typeName}</td>
                                <td>${request.createAt}</td>
                                <td>
                                    <form action="OwnerController" method="post">
                                        <input type="hidden" name="requestId" value="${request.requestID}">
                                        <input type="hidden" name="service" value="changereqstatus">
                                        <select name="status">
                                            <option value="Pending" ${request.resStatus == 'Pending' ? 'selected' : ''}>Pending</option>
                                            <option value="Denied" ${request.resStatus == 'Denied' ? 'selected' : ''}>Denied</option>
                                            <option value="Accepted" ${request.resStatus == 'Accepted' ? 'selected' : ''}>Accepted</option>
                                        </select>
                                        <button type="submit">Update</button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>

                    </table>
                </div>

        </div>
        <div class="site-footer">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4">
                        <div class="widget">
                            <h3>Contact</h3>
                            <address>43 Raymouth Rd. Baltemoer, London 3910</address>
                            <ul class="list-unstyled links">
                                <li><a href="tel://11234567890">+1(123)-456-7890</a></li>
                                <li><a href="tel://11234567890">+1(123)-456-7890</a></li>
                                <li><a href="mailto:info@mydomain.com">info@mydomain.com</a></li>
                            </ul>
                        </div>
                    </div>
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
                        </div>
                    </div>
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
                        </div>
                    </div>
                </div>
                <div class="row mt-5">
                    <div class="col-12 text-center">
                        <p>&copy;<script>document.write(new Date().getFullYear());</script> All Rights Reserved. &mdash; Designed with love by <a href="https://untree.co">Untree.co</a> <!-- License information: https://untree.co/license/ --></p>
                    </div>
                </div>
            </div>
        </div>

        <div id="overlayer"></div>
        <div class="loader">
            <div class="spinner-border" role="status">
                <span class="visually-hidden">Loading...</span>
            </div>
        </div>

        <script src="js/bootstrap.bundle.min.js"></script>
        <script src="js/tiny-slider.js"></script>
        <script src="js/aos.js"></script>
        <script src="js/navbar.js"></script>/
        <script src="js/counter.js"></script>
        <script src="js/custom.js"></script>
    </main>
    <script>
                            function ResponsiveCellHeaders(elmID) {
                                try {
                                    var THarray = [];
                                    var table = document.getElementById(elmID);
                                    var ths = table.getElementsByTagName("th");
                                    for (var i = 0; i < ths.length; i++) {
                                        var headingText = ths[i].innerHTML;
                                        THarray.push(headingText);
                                    }
                                    var styleElm = document.createElement("style"),
                                            styleSheet;
                                    document.head.appendChild(styleElm);
                                    styleSheet = styleElm.sheet;
                                    for (var i = 0; i < THarray.length; i++) {
                                        styleSheet.insertRule(
                                                "#" +
                                                elmID +
                                                " td:nth-child(" +
                                                (i + 1) +
                                                ')::before {content:"' +
                                                THarray[i] +
                                                ': ";}',
                                                styleSheet.cssRules.length
                                                );
                                    }
                                } catch (e) {
                                    console.log("ResponsiveCellHeaders(): " + e);
                                }
                            }
                            ResponsiveCellHeaders("Books");

                            function AddTableARIA() {
                                try {
                                    var allTables = document.querySelectorAll('table');
                                    for (var i = 0; i < allTables.length; i++) {
                                        allTables[i].setAttribute('role', 'table');
                                    }
                                    var allRowGroups = document.querySelectorAll('thead, tbody, tfoot');
                                    for (var i = 0; i < allRowGroups.length; i++) {
                                        allRowGroups[i].setAttribute('role', 'rowgroup');
                                    }
                                    var allRows = document.querySelectorAll('tr');
                                    for (var i = 0; i < allRows.length; i++) {
                                        allRows[i].setAttribute('role', 'row');
                                    }
                                    var allCells = document.querySelectorAll('td');
                                    for (var i = 0; i < allCells.length; i++) {
                                        allCells[i].setAttribute('role', 'cell');
                                    }
                                    var allHeaders = document.querySelectorAll('th');
                                    for (var i = 0; i < allHeaders.length; i++) {
                                        allHeaders[i].setAttribute('role', 'columnheader');
                                    }
                                    // this accounts for scoped row headers
                                    var allRowHeaders = document.querySelectorAll('th[scope=row]');
                                    for (var i = 0; i < allRowHeaders.length; i++) {
                                        allRowHeaders[i].setAttribute('role', 'rowheader');
                                    }
                                    // caption role not needed as it is not a real role and
                                    // browsers do not dump their own role with display block
                                } catch (e) {
                                    console.log("AddTableARIA(): " + e);
                                }
                            }

                            AddTableARIA();
                            function confirmDelete(element) {
                                if (confirm("Are you sure you want to delete this request?")) {
                                    element.parentNode.submit();
                                } else {
                                    return false;
                                }
                            }
    </script>
</body>
</html>
