<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>HoLa Motel - Add Room</title>
        <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">
        <link href="css/style_owner.css" rel="stylesheet">
        <style>
            body {
                background-color: #f8f9fa;
            }

            .card {
                border-radius: 15px;
                box-shadow: 0 0 15px rgba(0,0,0,0.1);
            }

            .form-label {
                font-weight: 500;
            }

            .heading {
                color: white;
                font-size: 3rem;
                font-weight: bold;
            }

            #fileError {
                font-size: 0.9rem;
            }

            .btn i {
                margin-right: 5px;
            }
        </style>
    </head>
    <body>

        <jsp:include page="navbar.jsp" />

        <div class="hero page-inner overlay" style="background-image: url('images/hero_bg_3.jpg'); padding: 80px 0;">
            <div class="container">
                <div class="row justify-content-center text-center">
                    <div class="col-lg-9">
                        <h1 class="heading">🛏️ Add New Room</h1>
                    </div>
                </div>
            </div>
        </div>

        <div class="container my-5">
            <div class="card p-4">
                <h3 class="mb-4 text-center"><i class="fas fa-plus-circle text-primary"></i> Room Information</h3>
                <form action="addroom" method="post" enctype="multipart/form-data">

                    <div class="row g-3">
                        <div class="col-md-6">
                            <label for="roomFloor" class="form-label">Room Floor</label>
                            <input type="number" class="form-control" id="roomFloor" name="roomFloor" required>
                        </div>
                        <div class="col-md-6">
                            <label for="roomNumber" class="form-label">Room Number</label>
                            <input type="number" class="form-control" id="roomNumber" name="roomNumber" required>
                        </div>
                        <div class="col-md-6">
                            <label for="roomSize" class="form-label">Room Size (m²)</label>
                            <input type="number" class="form-control" id="roomSize" name="roomSize" required>
                        </div>
                        <div class="col-md-6">
                            <label for="roomFee" class="form-label">Room Fee</label>
                            <input type="number" class="form-control" id="roomFee" name="roomFee" step="0.01" required>
                        </div>
                        <div class="col-md-6">
                            <label for="roomOccupant" class="form-label">Room Occupant</label>
                            <input type="number" class="form-control" id="roomOccupant" name="roomOccupant" required>
                        </div>
                        <div class="col-md-6">
                            <label for="total" class="form-label">Total</label>
                            <input type="number" class="form-control" id="total" name="total" required>
                        </div>
                        <div class="col-md-6">
                            <label for="vipId" class="form-label">VipId</label>
                            <input type="number" class="form-control" id="vipId"" name="vipId" required>
                        </div>
                        <!--                        <div class="col-md-6">
                                                    <label for="item" class="form-label">Item</label>
                                                    <input type="text" class="form-control" id="item" name="item" required>
                                                </div>
                                                <div class="col-md-6">
                                                    <label for="roomitem" class="form-label">Room Item</label>
                                                    <input type="text" class="form-control" id="roomitem" name="roomitem" required>
                                                </div>
                        -->                        <div class="col-md-12">
                            <label for="roomImg" class="form-label">Room Image</label>
                            <input id="roomImg" type="file" class="form-control" name="roomImg" accept="image/jpeg,image/png" required>
                            <span id="fileError" class="text-danger"></span>
                        </div>
                    </div>

                    <div class="text-center mt-4">
                        <button type="submit" class="btn btn-success px-4" onclick="return validateFile()">
                            <i class="fas fa-check-circle"></i> Submit
                        </button>
                        <a href="OwnerController" class="btn btn-outline-secondary px-4">
                            <i class="fas fa-arrow-left"></i> Back to List
                        </a>
                    </div>
                </form>
            </div>
        </div>

        <script>
            function validateFile() {
                const fileInput = document.getElementById('roomImg');
                const fileError = document.getElementById('fileError');
                fileError.textContent = '';

                if (!fileInput.files.length) {
                    fileError.textContent = 'Please select a file.';
                    return false;
                }

                const file = fileInput.files[0];
                const allowedTypes = ['image/jpeg', 'image/png'];
                const maxSize = 1 * 1024 * 1024;

                if (!allowedTypes.includes(file.type)) {
                    fileError.textContent = 'Only JPEG and PNG files are allowed.';
                    return false;
                }

                if (file.size > maxSize) {
                    fileError.textContent = 'File size must be less than 1MB.';
                    return false;
                }

                return true;
            }
        </script>

        <jsp:include page="./footer.jsp" />

    </body>
</html>
