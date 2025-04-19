<%-- 
    Document   : list
    Created on : Jun 10, 2024, 9:56:50 PM
    Author     : DAT
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="model.Penalty" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Penalties Add</title>
    </head>
    <body>
        <jsp:include page="header.jsp" flush="true"></jsp:include>
            <div class="hero page-inner overlay" style="background-image: url('images/hero_bg_1.jpg');">

                <div class="container">
                    <div class="row justify-content-center align-items-center">
                        <div class="col-lg-9 text-center mt-5">
                            <h1 class="heading" data-aos="fade-up">Penalties</h1>

                            <nav aria-label="breadcrumb" data-aos="fade-up" data-aos-delay="200">
                                <ol class="breadcrumb text-center justify-content-center">
                                    <li class="breadcrumb-item "><a href="#">Manager</a></li>
                                    <li class="breadcrumb-item active text-white-50" aria-current="page">Penalties</li>
                                </ol>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>

            <div style="margin-bottom: 150px" class="main">
                <div class="container" style="margin-top: 2em">
                    <form action="insertPenalty" method="post">
                        <div class="mb-3 mt-3">
                            <label for="room-number" class="form-label">Room Number: </label>
                            <select class="form-select" name="roomId">
                            <c:forEach items="${rooms}" var="r">
                                <option value="${r.roomID}">${r.roomNumber}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3 mt-3">
                        <label for="description" class="form-label">Description: </label>
                        <textarea class="form-control" id="description" 
                                  rows="5" name="description" required></textarea>
                    </div>
                    <div class="mb-3 mt-3">
                        <label for="date" class="form-label">Date: </label>
                        <input type="date" class="form-control" id="date" name="date" required>
                    </div>
                    <div class="mb-3 mt-3">
                        <label for="rule" class="form-label">Rule: </label>
                        <select class="form-select" name="ruleId">
                            <c:forEach items="${rules}" var="r">
                                <option value="${r.ruleID}">${r.ruleName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3 mt-3">
                        <label for="image-evidence" class="form-label">Evidence Image : </label>
                        <input type="text" class="form-control" id="img-evidence" placeholder="Enter evidence image" name="evidenceImg">
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
