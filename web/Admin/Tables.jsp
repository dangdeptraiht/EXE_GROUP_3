<%-- 
    Document   : roomTable
    Created on : 27 thg 5, 2024, 11:02:30
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
         <meta charset="utf-8" />
        <link rel="icon" href="favicon.png">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Tables - SB Admin</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <link href="AdminCSS/css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="manage">Admin</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">

            </form>
            <!-- Navbar-->
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                       
                        <li><hr class="dropdown-divider" /></li>
                        <li><a class="dropdown-item" href="logout">Logout</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">


                            <div class="sb-sidenav-menu-heading">Addons</div>
                            <a class="nav-link" href="manage">
                                <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                                Account
                            </a>
                            
                            </a>
                            <a class="nav-link" href="selist">
                                <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                                Security List
                            </a>

                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as:</div>
                        Admin
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Tables</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="">Manage</a></li>
                            <li class="breadcrumb-item active">Account</li>
                        </ol>

                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                Manage Account
                            </div>
                            <div class="card-body">
                               

                                <br>
                                <table id="datatablesSimple" border="1">

                                    <thead>
                                    <th>Mail</th>
                                    <th>Password</th>
                                    <th>Role</th>
                                    <th>Action</th>
                                    </thead>
                                    <c:forEach var="acc" items="${account}">
                                        <tr>

                                            <td>${acc.userMail}</td>
                                            <td>${acc.userPassword}</td>
                                            <td><c:if test="${acc.userRole == 1}">
                                                    Renter
                                                </c:if>
                                                <c:if test="${acc.userRole == 2}">
                                                    Owner
                                                </c:if>
                                                <c:if test="${acc.userRole == 3}">
                                                    Security
                                                </c:if>
                                                <c:if test="${acc.userRole == 4}">
                                                    Admin
                                                </c:if>
                                                <c:if test="${acc.userRole == 0}">
                                                    DeActive
                                                </c:if></td>

                                            <td>
                                                <a href="#" data-bs-toggle="modal" data-bs-target="#editModal" data-email="${acc.userMail}" style="margin-right: 10px">
                                                    <i class="fa-regular fa-pen-to-square"></i>
                                                </a>


                                                <a href="changeRole?email=${acc.userMail}" onclick="return confirm('Are you sure you want to ban this user?')">DeActive</a>

                                            </td>
                                        </tr>
                                    </c:forEach>

                                </table>
                                <!--                                js ban-->

                            </div>
                        </div>
                    </div>
                    <div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="editModalLabel">Edit Account</h5>
                                    <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <c:if test="${not empty errorMessage}">
                                        <div class="alert alert-danger">${errorMessage}</div>
                                    </c:if>
                                    <form id="editAccountForm" action="edac" method="post">
                                        <div class="form-group">
                                            <label for="emailInput">Email address</label>
                                            <input type="email" name="email" class="form-control" id="emailInput" aria-describedby="emailHelp">
                                            <label for="passwordInput">Pasword:</label>
                                            <input type="password" name="password" placeholder="Abcdefg1"class="form-control" id="passwordInput" aria-describedby="emailHelp" required><!-- comment -->
                                            <label for="roleInput">Role:</label>
                                            <input type="number" name="role" placeholder="Role: 1,2,3" class="form-control" id="roleInput" aria-describedby="emailHelp" required><br>
                                            <input type="submit" value="Save" name="save" />
                                        </div>
                                        <!-- Additional form fields can go here -->
                                    </form>
                                </div>

                            </div>
                        </div>
                    </div>

                    <!-- Add Account Modal -->
                    <div class="modal fade" id="addAccountModal" tabindex="-1" role="dialog" aria-labelledby="addAccountModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="addAccountModalLabel">Add Account</h5>
                                    <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <form id="addAccountForm" action="addAccount" method="get">
                                        <div class="form-group">
                                            <label for="addEmailInput">Email address</label>
                                            <input type="email" name="email" class="form-control" id="addEmailInput" aria-describedby="emailHelp" required>
                                        </div>
                                        <div class="form-group">
                                            <label for="addPasswordInput">Password</label>
                                            <input type="password" name="password" placeholder="Abcdefg1" class="form-control" id="addPasswordInput" aria-describedby="emailHelp" required>
                                        </div>
                                        <div class="form-group">
                                            <label for="addRoleInput">Role</label>
                                            <input type="number" name="role" placeholder="Role: 1,2,3" class="form-control" id="addRoleInput" aria-describedby="emailHelp" required>
                                        </div>
                                        <button type="submit" value="Add" name="add" class="btn btn-primary" style="width: 70px">Add</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- js modal -->
                    <script>
                        <% if (request.getAttribute("errorMessage") != null) { %>
                        $('#editModal').modal('show');
                        <% } %>

                        $(document).ready(function () {
                            $('#editModal').on('show.bs.modal', function (event) {
                                var button = $(event.relatedTarget); // Button that triggered the modal
                                var email = button.data('email'); // Extract email from data-* attributes
                                var password = button.data('password'); // Extract password from data-* attributes
                                var role = button.data('role'); // Extract role from data-* attributes

                                var modal = $(this);
                                modal.find('.modal-body #emailInput').val(email); // Populate the email input field
                                modal.find('.modal-body #passwordInput').val(password); // Populate the password input field
                                modal.find('.modal-body #roleInput').val(role); // Populate the role input field
                            });
                            $('#addAccountModal').on('show.bs.modal', function (event) {
                                var modal = $(this);
                                modal.find('.modal-body').find('input').val('');
                            });
                        });
                    </script>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2023</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>

    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="AdminCSS/js/scripts.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
    <script src="AdminCSS/js/datatables-simple-demo.js"></script>

</body>
</html>