<%-- 
    Document   : formOwnerProfile
    Created on : 28 thg 5, 2024, 00:13:35
    Author     : quocp
--%>

<%@page import="dao.RoomDAO,java.util.List"%>
<%@page import="model.RoomDetailSe"%>
<%@ page import="java.text.DecimalFormat" %>

<% RoomDetailSe roomDetail = (RoomDetailSe) request.getAttribute("roomDetail"); 
   String[] listItemNames = (String[]) request.getAttribute("listItem");
   String error = (String) request.getAttribute("error");
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="images/favicon.png">
        <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css'>
        <title>Edit Owner Profile</title>
 <link href='https://api.mapbox.com/mapbox-gl-js/v2.6.1/mapbox-gl.css' rel='stylesheet' />
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Work+Sans:wght@400;500;600;700&display=swap" rel="stylesheet">


        <script src='https://api.mapbox.com/mapbox-gl-js/v2.7.0/mapbox-gl.js'></script>
        <link href='https://api.mapbox.com/mapbox-gl-js/v2.7.0/mapbox-gl.css' rel='stylesheet' />

        <link rel="stylesheet" href="fonts/icomoon/style.css">
        <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

        <link rel="stylesheet" href="css/tiny-slider.css">
        <link rel="stylesheet" href="css/aos.css">
        <link rel="stylesheet" href="css/style.css">

        <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css'>

        <style>
            #map {
                height: 400px;
                width: 100%;
            }
            body{
                background: #f7f7ff;
                margin-top:20px;
            }
            .card {
                position: relative;
                display: flex;
                flex-direction: column;
                min-width: 0;
                word-wrap: break-word;
                background-color: #fff;
                background-clip: border-box;
                border: 0 solid transparent;
                border-radius: .25rem;
                margin-bottom: 1.5rem;
                box-shadow: 0 2px 6px 0 rgb(218 218 253 / 65%), 0 2px 6px 0 rgb(206 206 238 / 54%);
            }
            .me-2 {
                margin-right: .5rem!important;
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

            .switch {
                position: relative;
                display: inline-block;
                width: 60px;
                height: 34px;
            }

            .switch input {
                opacity: 0;
                width: 0;
                height: 0;
            }

            .slider {
                position: absolute;
                cursor: pointer;
                top: 0;
                left: 0;
                right: 0;
                bottom: 0;
                background-color: #ccc;
                transition: .4s;
                border-radius: 34px;
            }

            .slider:before {
                position: absolute;
                content: "";
                height: 26px;
                width: 26px;
                left: 4px;
                bottom: 4px;
                background-color: white;
                transition: .4s;
                border-radius: 50%;
            }

            input:checked + .slider {
                background-color: #4CAF50;
            }

            input:checked + .slider:before {
                transform: translateX(26px);
            }

            .button-group {
                text-align: center;
                margin-top: 20px;
            }

            .under-repair-form {
                margin: 20px auto; 
                padding: 15px;
                border: 1px solid #ddd;
                border-radius: 5px;
                background-color: #f9f9f9;
                width: 400px; 
            }

            .under-repair-form select {
                width: 100%;
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 5px;
                font-size: 16px;
                box-sizing: border-box; 
            }

            .under-repair-form input[type="submit"] {
                margin-top: 20px;
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                background-color: #007bff;
                color: #fff;
                font-size: 16px;
                cursor: pointer;
                display: block;
                width: 100%; 
            }

            .under-repair-form input[type="submit"]:hover {
                background-color: #0056b3;
            }

            .under-repair-form .form-group {
                margin-bottom: 15px;
            }

            .under-repair-form .form-group label {
                font-weight: bold;
                margin-bottom: 5px;
                display: block;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="main-body">

                <div>
                    <nav class="site-nav" style="width: 73%">
                        <div class="container" >
                            <div class="menu-bg-wrap">
                                <div class="site-navigation">
                                    <a href="owner/OwnerProfile.jsp" class="logo m-0 float-start" style="text-decoration: none;">Edit Room</a>

                                    <jsp:include page="navbar.jsp"></jsp:include>

                                        <a href="#" class="burger light me-auto float-end mt-1 site-menu-toggle js-menu-toggle d-inline-block d-lg-none" data-toggle="collapse" data-target="#main-navbar">
                                            <span></span>
                                        </a>

                                    </div>
                                </div>
                            </div>
                        </nav>
                    </div>

                    <div class="row" style="margin-top: 120px;">                        

                        <div class="col-lg-8 mx-auto">                       
                            <div class="card">
                            <% if (error != null) { %>
                            <p style="margin: 0px; text-align: center; color: red; margin: 10px 0px; background: beige"><%= error %></p>
                            <%}%>
                            <form action="OwnerController" method="post" enctype="multipart/form-data">
                                <div class="card-body">                                    
                                    <div class="row mb-3">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Room Number</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            <input  type="text" class="form-control" name="roomNumber" value="<%= roomDetail.getRoomNumber()%>" readonly="">
                                        </div>
                                    </div>                              
                                    <div class="row mb-3">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Room Fee</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            <%
                                                DecimalFormat df = new DecimalFormat("#.##");
                                                String formattedFee = df.format(roomDetail.getRoomFee());
                                            %>
                                            <input type="text" class="form-control" name="roomFee" value="<%= formattedFee %>">
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Room Size</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            <input readonly="" type="text" class="form-control" name="roomSize" value="<%= roomDetail.getRoomSize()%>">
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Room Image</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">                                           
                                            <input type="file" class="form-control" name="roomImg" value="<%= roomDetail.getRoomImg()%>" required="" >
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <h6 class="mb-0" style="padding-left: 220px; padding-bottom: 20px; padding-top: 10px; font-weight: 800">Items in the room</h6>
                                        <table id="itemTable" class="table table-bordered">
                                            <thead>
                                                <tr>
                                                    <th>Item</th>
                                                    <th>Quantity</th>
                                                    <th>Action</th>
                                                </tr>
                                            </thead>
                                            <tbody>                       
                                                <%
                                                    if (roomDetail.getItemName() != null) {
                                                    String[] itemNames = roomDetail.getItemName();
                                                    int[] quantities = roomDetail.getQuantity();
                                                    int[] itemIDs = roomDetail.getItemID();
                                                    int roomID_updateItem = roomDetail.getRoomID();
                                                    if (itemNames != null && quantities != null && itemNames.length == quantities.length) {
                                                        for (int i = 0; i < itemNames.length; i++) {
                                                            String itemName = itemNames[i];
                                                            int quantity = quantities[i];
                                                            int itemID = itemIDs[i];
                                                %>
                                                <tr data-itemid="<%= itemID %>">
                                                    <td><input type="text" class="form-control" name="itemNames" value="<%= itemName %>" readonly="" ></td>
                                                    <td><input type="text" class="form-control" name="quantities" value="<%= quantity %>" ></td>
                                            <input type="hidden" name="roomID_updateItem" value="<%= roomID_updateItem %>"> 
                                            <td>
                                                <a href="OwnerController?service=deleteItem&itemID=<%= itemID%>&roomID=<%= roomDetail.getRoomID()%>" class="btn btn-danger">Delete</a>
                                            </td>
                                            </tr>
                                            <% 
                                                    }
                                                }
                                            }
                                            %>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="container">
                                        <div class="row" style="margin-top: 50px">
                                            <div class="col-sm-2"></div>
                                            <div class="col-sm-10 text-secondary">
                                                <button type="button" id="updateButton" class="btn btn-success" onclick="updateRoomItems()">Update Room Item</button>
                                                <a href="#" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#addItemModal">Add Room Item</a>
                                                <input type="submit" class="btn btn-primary px-4" value="Save Changes">                                           
                                            </div>
                                        </div>

                                    </div>
                                    <input type="hidden" name="roomID" value="<%= roomDetail.getRoomID()%>">
                                    <input type="hidden" class="btn btn-primary px-4" name="service" value="updateRoomDetail">
                                </div>               
                            </form>  
                            <%
                                int roomStatus = roomDetail.getRoomStatus();
                                String statusLabel;

                                switch (roomStatus) {
                                    case 0:
                                        statusLabel = "Rented";
                                        break;
                                    case 1:
                                        statusLabel = "Available";
                                        break;
                                    case 2:
                                        statusLabel = "Under Repair";
                                        break;
                                    default:
                                        statusLabel = "Unknown";
                                }
                            %>

                            <form id="roomForm" action="OwnerController" method="post">
                                <input type="hidden" name="service" value="updateRoomStatus">
                                <input type="hidden" name="roomID" value="<%= roomDetail.getRoomID() %>">
                                <input type="hidden" name="roomOccupant" value="<%= roomDetail.getRoomOccupant() %>">
                                <input type="hidden" id="roomStatusInput" name="roomStatus" value="<%= roomStatus %>">
                                <div class="row button-group">
                                    <div class="col-sm-12 text-center">
                                        <div class="status-container">
                                            <label class="switch">
                                                <input type="checkbox" id="toggle" onclick="toggleButton()" <%= roomStatus == 1 ? "checked" : "" %>>
                                                <span class="slider"></span>
                                            </label>
                                            <p>Status: <span id="status"><%= statusLabel %></span></p>

                                        </div>
                                    </div>
                                </div>
                            </form>
                            <form action="OwnerController" method="post" class="under-repair-form">
                                <input type="hidden" name="service" value="setUnderRepair">
                                <input type="hidden" name="roomID" value="<%= roomDetail.getRoomID() %>">
                                <input type="hidden" name="roomStatus" value="<%= roomDetail.getRoomStatus() %>">
                                <div class="form-group">
                                    <label for="updateRoomStatus">Update Room Status</label>
                                    <select name="updateRoomStatus" id="updateRoomStatus">
                                        <option selected disabled hidden>Repair</option>
                                        <option value="2">Under Repair</option>
                                        <option value="0">Rented</option>
                                    </select>
                                </div>
                                <input style="text-align: center" type="submit" value="Submit">
                            </form>                
                            <div class="modal fade" id="addItemModal" tabindex="-1" aria-labelledby="addItemModalLabel" aria-hidden="true">
                                <div class="modal-dialog modal-dialog-centered">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="addItemModalLabel">Add Room Item</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">                                                    
                                            <form id="addItemFormModal" action="OwnerController" method="get" enctype="multipart/form-data">
                                                <div class="mb-3">
                                                    <label for="itemNameModal" class="form-label">Item Name</label>
                                                    <select class="form-control" id="itemNameModal" name="itemName">
                                                        <% 
                                                            for (int i = 0; i < listItemNames.length; i++) { 
                                                            String itemName = listItemNames[i];
                                                        %>
                                                        <option><%= itemName %></option>
                                                        <% } %>
                                                    </select>
                                                </div>
                                                <div class="mb-3">
                                                    <label for="newQuantityModal" class="form-label">Quantity</label>
                                                    <input type="int" class="form-control" id="newQuantityModal" name="quantity" max="10">
                                                </div>
                                                <input type="hidden" name="service" value="addItem">
                                                <input type="hidden" name="roomID" value="<%= roomDetail.getRoomID()%>">
                                                <button type="button" class="btn btn-primary" id="btnSubmitNewItemModal">Add Item</button>
                                            </form>
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
</div>

<script src='https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js'></script>
<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/tiny-slider.js"></script>
<script src="js/aos.js"></script>
<script src="js/navbar.js"></script>
<script src="js/counter.js"></script>
<script src="js/custom.js"></script>     
<script>
                                                    document.getElementById('btnSubmitNewItemModal').addEventListener('click', function () {
                                                        var quantityInput = document.getElementById('newQuantityModal').value.trim();
                                                        var quantity = parseFloat(quantityInput);

                                                        if (!Number.isInteger(quantity) || quantity <= 0) {
                                                            alert('Quantity is not valid. Please enter a positive integer');
                                                        } else if (quantity > 10) {
                                                            alert('Quantity is not valid. Quantity cannot be greater than 10');
                                                        } else {
                                                            var form = document.getElementById('addItemFormModal');
                                                            form.submit();
                                                        }
                                                    });
</script>

<script>
    let isUpdating = false;
    function updateRoomItems() {

        if (isUpdating) {
            return;
        }

        isUpdating = true;

        console.log("Update Room Items button clicked.");
        const rows = document.querySelectorAll("#itemTable tbody tr");
        const updatedItems = [];
        const roomID_updateItem = document.querySelector('input[name="roomID_updateItem"]').value;
        let hasInvalidQuantity = false;

        rows.forEach(row => {
            const itemNameInput = row.querySelector('input[name="itemNames"]');
            const quantityInput = row.querySelector('input[name="quantities"]');

            if (itemNameInput && quantityInput) {
                const itemName = itemNameInput.value;
                const quantity = quantityInput.value;
                const itemID = row.getAttribute("data-itemid");

                if (quantity < 0) {
                    hasInvalidQuantity = true;
                    alert("Quantity cannot be less than 0 for item: " + itemName);
                    return;
                } 

                updatedItems.push({itemID: itemID, itemName: itemName, quantity: quantity, roomID: roomID_updateItem});
            }
        });

        if (hasInvalidQuantity) {
            isUpdating = false;
            return;
        }

        console.log("Updated items: ", updatedItems);



        const xhr = new XMLHttpRequest();
        xhr.open("POST", "OwnerController?service=updateRoomItem", true);
        xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4) {
                if (xhr.status === 200) {
                    console.log("Room items updated successfully!");
                    window.location.href = "OwnerController?service=updateRoomItem";
                } else {
                    console.log("Error: " + xhr.status);
                }
            }
        };
        xhr.send(JSON.stringify(updatedItems));
    }
</script>

<script>
    function setUnderRepair() {
        var form = document.getElementById("updateStatusForm");
        var roomID = form.roomID.value;
        var roomOccupant = form.roomOccupant.value;

        document.getElementById("roomStatus").value = 2;

        var xhr = new XMLHttpRequest();
        xhr.open("POST", "OwnerController", true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.send("service=updateRoomStatus&roomID=" + roomID + "&roomOccupant=" + roomOccupant + "&roomStatus=2");

    }

</script>
<script>
    function toggleButton() {
        var checkbox = document.getElementById('toggle');
        var form = document.getElementById('roomForm');
        var roomStatusInput = document.getElementById('roomStatusInput');
        var statusLabel = document.getElementById('status');

        if (checkbox.checked) {
            // Checkbox was checked (turning ON)
            roomStatusInput.value = 2; // Set room status to "Available"
            statusLabel.textContent = 'Available';
            form.submit(); // Submit the form
        } else {
            // Checkbox was unchecked (turning OFF)
            var confirmOff = confirm('Are you sure you want to set the status to Off?');
            if (confirmOff) {
                roomStatusInput.value = 1; // Set room status to "Occupied"
                statusLabel.textContent = 'Occupied';
                form.submit(); // Submit the form
            } else {
                checkbox.checked = true; // Keep the checkbox checked if cancelled
            }
        }
    }

    function setUnderRepair() {
        var form = document.getElementById('roomForm');
        var roomStatusInput = document.getElementById('roomStatusInput');
        roomStatusInput.value = 2; // Set room status to "Under Repair"
        document.getElementById('status').textContent = 'Under Repair';
        form.submit(); // Submit the form
    }
</script>

</body>
</html>
