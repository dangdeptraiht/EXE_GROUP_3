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
        <title>Guildlines Add</title>
    </head>
    <body>
        <jsp:include page="header.jsp" ></jsp:include>
            <div class="hero page-inner overlay" style="background-image: url('images/hero_bg_1.jpg');">

                <div class="container">
                    <div class="row justify-content-center align-items-center">
                        <div class="col-lg-9 text-center mt-5">
                            <h1 class="heading" data-aos="fade-up">GuideLines</h1>

                            <nav aria-label="breadcrumb" data-aos="fade-up" data-aos-delay="200">
                                <ol class="breadcrumb text-center justify-content-center">
                                    <li class="breadcrumb-item "><a href="#">Manager</a></li>
                                    <li class="breadcrumb-item active text-white-50" aria-current="page">GuideLine</li>
                                </ol>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>

            <div style="margin-bottom: 150px" class="main">
                <div class="container" style="margin-top: 2em">
                    <form action="addGuideline" method="post">
                        <div class="mb-3 mt-3">
                            <label for="guide-name" class="form-label">GuideLine Name: </label>
                            <input type="text" class="form-control" id="guideName" placeholder="Enter guideline name" name="guideName" required>
                        </div>
                        <div class="mb-3 mt-3">
                            <label for="image-guideline" class="form-label">Image GuideLine: </label>
                            <input type="text" class="form-control" id="img-guide" placeholder="Enter image guideline" name="imgGuide" required>
                        </div>
                        <button class="btn btn-sucess">Insert</button>
                    </form>
                </div>
            </div>
        <jsp:include page="footer.jsp" flush="true"></jsp:include>
    </body>
    <script>

    </script>
</html>
