<%-- 
    Document   : list
    Created on : Jun 10, 2024, 9:56:50 PM
    Author     : DAT
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="model.Guideline" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="images/favicon.png">
        <title>Rule Add</title>
    </head>
    <body>
        <jsp:include page="header.jsp" flush="true"></jsp:include>
            <div class="hero page-inner overlay" style="background-image: url('images/hero_bg_1.jpg');">

                <div class="container">
                    <div class="row justify-content-center align-items-center">
                        <div class="col-lg-9 text-center mt-5">
                            <h1 class="heading" data-aos="fade-up">Rules</h1>

                            <nav aria-label="breadcrumb" data-aos="fade-up" data-aos-delay="200">
                                <ol class="breadcrumb text-center justify-content-center">
                                    <li class="breadcrumb-item "><a href="index.html">Manager</a></li>
                                    <li class="breadcrumb-item active text-white-50" aria-current="page">Rule</li>
                                </ol>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>

            <div class="main">
                <div class="container" style="margin-top: 2em">
                    <form action="insertRule" method="post">
                        <div class="mb-3 mt-3">
                            <label for="guide-name" class="form-label">Rule Name: </label>
                            <input type="text" class="form-control" id="guideName" placeholder="Enter rule name" name="ruleName" required>
                        </div>
                        <div class="mb-3 mt-3">
                            <label for="image-guideline" class="form-label">Image rule: </label>
                            <input type="text" class="form-control" id="img-guide" placeholder="Enter image rule" name="img" required>
                        </div>
                        <div class="mb-3 mt-3">
                            <label for="image-guideline" class="form-label">Score Change: </label>
                            <input type="number" class="form-control" id="img-guide" placeholder="Enter score change" name="score" required>
                        </div>
                        <div class="mb-3 mt-3">
                            <label for="image-guideline" class="form-label">Penalty money </label>
                            <input type="number" class="form-control" id="img-guide" placeholder="Enter penalty money rule" name="penMoney" required>
                        </div>
                        <button class="btn btn-sucess">Insert</button>
                    </form>
                </div>
            </div>
        
    </body>
    <script>

    </script>
</html>
