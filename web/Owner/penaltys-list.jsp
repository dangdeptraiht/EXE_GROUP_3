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
        <title>Penalties List</title>
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
                                    <li class="breadcrumb-item "><a href="index.html">Manager</a></li>
                                    <li class="breadcrumb-item active text-white-50" aria-current="page">Penaties</li>
                                </ol>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>

            <div class="main">
                <div class="container" style="margin-top: 2em">
                    <div class="col-3"><a href="insertPenalty"> <button type="button" class="btn btn-primary">Add Penalty</button></div></a>
                    <table id="guildLineTable" class="display">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Room Number</th>
                                <th>Description</th>
                                <th>Date</th>
                                <th>Rule</th>
                                <th>Status</th>
                                <th>Evidence</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
            </div>
        <jsp:include page="footer.jsp" flush="true"></jsp:include>
        </body>
        <script>
            $(document).ready(function () {
                var dataList = ${dataList};
                console.log(dataList);
                //var realData = JSON.parse(dataList);
                $('#guildLineTable').DataTable({
                    data: dataList,
                    columns: [
                        {title: "ID", data: "penID"},
                        {title: "Room Numer", data: "roomID.roomNumber"},
                        {title: "Description", data: "description"},
                        {title: "Date", data: "penDate"},
                        {title: "Rule", data: "ruleID.ruleName"},
                        {
                            title: "Status",
                            data: "penStatus",
                            render: function (data, type, row) {
                                if (data === 1)
                                    return '<span class="badge bg-danger">Penalty</span>';
                                else if (data === 0)
                                    return '<span class="badge bg-secondary">Waiting</span>';
                                else if (data === -1)
                                    return '<span class="badge bg-success">Removed</span>';
                            }
                        },
                        {
                            title: "Evidence",
                            data: "evidenceImg",
                            render: function (data, type, row) {
                                console.log(data);
                                if(data !== undefined && data.length > 0)return '<img src="' + data + '" alt="Image" width="300" height="300">';
                                else return 'No evidence';
                            }
                        },
                        {
                            title: "Action",
                            data: "penID",
                            render: function (data, type, row) {
                                return '\
            <a href="updatePenalty?id=' + data + '"><button type="button" class="btn btn-success"><i class="fa fa-edit"></i></button></a>\
            ';
                            },
                            orderable: false
                        }
                    ]
                });

            });

           
    </script>
</html>
