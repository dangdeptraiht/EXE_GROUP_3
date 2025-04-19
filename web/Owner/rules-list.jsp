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
        <title>Rule List</title>
    </head>
    <body>
        <jsp:include page="header.jsp" flush="true"></jsp:include>
            <div class="hero page-inner overlay" style="background-image: url('images/hero_bg_1.jpg');">

                <div class="container">
                    <div class="row justify-content-center align-items-center">
                        <div class="col-lg-9 text-center mt-5">
                            <h1 class="heading" data-aos="fade-up">Rules</h1>


                        </div>
                    </div>
                </div>
            </div>

            <div class="main">
                <div class="container" style="margin-top: 2em">
                    <div class="col-3"><a href="insertRule"><button type="button" class="btn btn-primary">Add Rule</button></div></a>
                    <table id="guildLineTable" class="display">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Image</th>
                                <th>Score</th>
                                <th>Penalty money</th>
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
                        {title: "ID", data: "ruleID"},
                        {title: "Name", data: "ruleName"},
                        {
                            title: "Image",
                            data: "img",
                            render: function (data, type, row) {
                                return '<img src="' + data + '" alt="Image" width="300" height="300">';
                            }
                        },
                        {
                            title: "Score",
                            data: "scoreChange",
                            render: function (data, type, row) {
                                return '<p class="text-center">' + data + '</p>';
                            }
                        },
                        {
                            title: "Penalty Money",
                            data: "penMoney",
                            render: function (data, type, row) {
                                return '<p class="text-center">' + data + '</p>';
                            }
                        },
                        {
                            title: "Action",
                            data: "ruleID",
                            render: function (data, type, row) {
                                return '\
                                <a href="updateRule?id=' + data + '">\n\
                                <button type="button" class="btn btn-success"><i class="fa fa-edit"></i></button></a>\
                                <button type="button"class="btn btn-danger" onclick="deleteItem(' + data + ')"><i class="fa fa-trash"></i></button>';
                            },
                            orderable: false
                        }
                    ]
                });

            });

            function deleteItem(data) {
                var confirmDialog = confirm('Do you want to delete this item ?');
                if (confirmDialog === true) {
                    window.location.href = 'deleteRule?id=' + data;
                }
            }
    </script>
</html>
