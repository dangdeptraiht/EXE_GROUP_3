<%-- 
    Document   : Adduser
    Created on : Jul 5, 2024, 7:58:44 AM
    Author     : pc
--%>

<%@page import="model.UserDetail,java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.Base64" %>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="icon" href="favicon.png">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js" rel="stylesheet"><!-- comment -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js" rel="stylesheet">
        <style>
            body {

                background-color: rgb(102, 179, 255);
            }

            .form-control:focus {
                box-shadow: none;

                background-color: rgba(255, 255, 255, 0.5);
            }

            .profile-button {
                background: rgb(99, 39, 120);
                box-shadow: none;
                border: none
            }

            .profile-button:hover {
                background: #682773
            }

            .profile-button:focus {
                background: #682773;
                box-shadow: none
            }

            .profile-button:active {
                background: #682773;
                box-shadow: none
            }

            .back:hover {
                color: #682773;
                cursor: pointer
            }

            .labels {
                font-size: 11px
            }

            .add-experience:hover {
                background: #BA68C8;
                color: #fff;
                cursor: pointer;
                border: solid 1px #BA68C8
            }
            .file-input-wrapper {
                position: relative;
                overflow: hidden;
                display: inline-block;
                margin-top: 10px;
            }
            .file-input-wrapper input[type="file"] {
                position: absolute;
                top: 0;
                right: 0;
                margin: 0;
                padding: 0;
                font-size: 20px;
                cursor: pointer;
                opacity: 0;
                filter: alpha(opacity=0);
            }
            .file-input-wrapper button {
                background-color: #007bff;
                border: none;
                color: white;
                padding: 10px 20px;
                font-size: 16px;
                cursor: pointer;
                border-radius: 4px;
                font-weight: normal;
            }
            .file-input-wrapper button:hover {
                background-color: #0056b3;
            }
            .file-input-info {
                font-size: 14px;
                color: #6c757d;
                margin-top: 5px;
            }
            .error-message {
                color: red;
                margin-top: 5px;
                display: none;
            }
        </style>
        <!-- background-image: url(images/R.jpg);-->
    </head>
    <body>
        <div class="container rounded bg-white mt-5 mb-5">
            <div class="row justify-content-center"> <!-- Thêm lớp justify-content-center để căn giữa các cột -->
                <div class="col-md-5 border-right">
                    <div class="p-3 py-5">
                        <div class="d-flex justify-content-between align-items-center mb-3">
                            <h4 class="text-right">Profile Settings</h4>
                        </div>

                        <form action="Edituser" method="post"> 
                            <div class="row mt-2">
                                <label class="labels">Name</label>
                                <input type="text" name="name" class="form-control" placeholder="Name">
                            </div>
                            <div class="row mt-3">
                                <div class="col-md-12">
                                    <label class="labels">Gender</label>
                                    <input type="text" name="gender" class="form-control" placeholder="Enter female/male">
                                </div>
                                <div class="col-md-12">
                                    <label class="labels">Date of birth</label>
                                    <input type="date" name="dob" class="form-control" placeholder="Enter your date of birth">
                                </div>
                                <div class="col-md-12">
                                    <label class="labels">Address</label>
                                    <input type="text" name="address" class="form-control" placeholder="Enter address line">
                                </div>
                                <div class="col-md-12">
                                    <label class="labels">Phone</label>
                                    <input type="text" name="phone" class="form-control" placeholder="Enter your phone">
                                </div>
                                <div class="col-md-12">
                                    <label class="labels">Image</label>
                                    <input type="file" name="image" class="form-control">
                                </div>
                            </div>
                            <div class="mt-5 text-center">
                                <button class="btn btn-primary profile-button" type="submit">Save Profile</button>
                            </div>
                        </form>         

                    </div>
                </div>
            </div>
        </div>


    </body>
</html>
