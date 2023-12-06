<!DOCTYPE html>
<%@page import="com.example.demo.cab.model.Cab"%>
<%@page import="java.util.List"%>
<html lang="en">

<head>
    <!-- Meta tags and external CSS/JS links -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Cabs</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <!-- Bootstrap Font Icon CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
          integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
          crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
          integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
          crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
          integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
          crossorigin="anonymous"></script>

    <style>
        /* Your existing styles remain unchanged */

        /* Custom styles for the image in the modal */
        .modal-body .pan-card-photo {
            display: flex;
            justify-content: flex-end;
            margin-bottom: 20px;
        }

        .modal-body .pan-card-photo img {
            max-width: 100px;
            max-height: 100px;
        }
        
        
        
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f8f9fa;
            color: #495057;
        }

        .container-header {
            background-color: #818FB4;
            padding: 20px;
            text-align: center;
        }

        h2 {
            color: #7d3cff;
        }

        table {
            margin-top: 20px;
        }

        th,
        td {
            text-align: center;
            border: none;
            /* Add this line to remove borders from th and td */
        }

        .table-dark th {
            background-color: #343a40;
        }

        .table-info tbody th,
        .table-info tbody td {
            background-color: #e2e3e5;
        }

        .table-info tbody tr:hover {
            background-color: #d0d2d3;
        }

        .btn {
            margin-right: 5px;
        }

        /* Add Employee Button Styles */
        .add-employee-btn {
            position: absolute;
            top: 20px;
            right: 20px;
        }

        .table-transparent tbody {
            background-color: transparent;
            border: none;
            /* Add this line to remove borders from tbody */
        }
        

        /* Position image at top right corner */
        .pan-card-photo {
            position: absolute;
            top: 10px;
            right: 10px;
            max-width: 100px; /* Adjust as needed */
            max-height: 100px; /* Adjust as needed */
            margin-right:43px;
        }

        /* Adjust attribute and value layout */
        .pan-card-details {
            margin-left: -7px; /* Space for the image */
        }

        .pan-attribute {
            margin-bottom: 0.5rem;
            font-weight: bold;
            text-align: left;
        }

        .pan-value {
            margin-bottom: 0.5rem;
            text-align: left;
        }
        .navbar{
        	text-align:center;
        	margin-left:600px;
        }
    </style>
</head>

<body style="background-image: url(https://wallpaperaccess.com/full/1732235.jpg);">
    <!-- Navbar -->
    <nav class="navbar">
       <h2> Manage Cabs </h2>
    </nav>
    
<%
	List<Cab> list=(List<Cab>)request.getAttribute("list_cab");

%>
<%String rs= (String)request.getAttribute("u");%>
 
 <div class="container text-center" style="width: 800px; margin-top: 5px;">
 <% 
 	if(rs.equals("updated")){
    %>
      <div class="alert" role="alert" id="myAlert" style="background-color:#E1D51E; color:black ;">
				 Updated Successfully!!
    </div>
 <% } %>
 </div>   



    <div class="container">
        <table class="table">
            <thead class="table-info">
                <tr>
                    <th scope="col">Cab Id</th>
                    <th scope="col">Cab Type</th>
                    <th scope="col">Km Per Rate</th>
                    <th scope="col">Actions</th>
                </tr>
            </thead>
            <tbody class="table-transparent tbody">
                <% for(Cab e: list){
                	
                	String deleteButtonId = "deleteButton_" + e.getCabId();
                	
                %>
                <tr>
                    <td><%=e.getCabId()%></td>
                    <td><%=e.getCabType()%></td>
                    <td><%=e.getPerKmRate()%></td>
                    <td>
                        <a href="<%=request.getContextPath() %>/admin/editcab/<%=e.getCabId() %>" class="btn btn-warning">
                            <i class="bi-pencil-square"></i> Edit
                        </a>
                        <!-- View button for displaying driver information -->
                        <button type="button" class="btn btn-info view-driver-btn"
                            data-toggle="modal" data-target="#viewPANModal_<%= e.getCabId() %>">
                            <i class="bi-person-fill"></i> View Driver
                        </button>
                    </td>
                </tr>

                <!-- Unique modal for each cab -->
                <div class="modal fade" id="viewPANModal_<%= e.getCabId() %>" tabindex="-1"
                    role="dialog" aria-labelledby="viewPANTitle_<%= e.getCabId() %>"
                    aria-hidden="true">
                    <!-- Modal content -->
                    <div class="modal-dialog modal-dialog-centered" role="document">
                        <div class="modal-content">
                            <!-- Modal header -->
                            <div class="modal-header">
                                <h5 class="modal-title" id="viewPANTitle_<%= e.getCabId() %>">Driver Details</h5>
                                <button type="button" class="close" data-dismiss="modal"
                                    aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>

                            <!-- Modal body -->
                            <div class="modal-body">
                                <!-- Replace the dummy data with actual PAN card details -->
                                <div class="pan-card-details">
                                    <div class="row">
                                        <div class="col-6">
                                            <p class="pan-attribute">Name:  <%= e.getDriver().getUsername() %> </p>
                                        </div>
                                      
                                    </div>
                                    <div class="row">
                                        <div class="col-6">
                                            <p class="pan-attribute">Email: <%= e.getDriver().getEmail() %></p>
                                        </div>
                                       
                                    </div>
                                    <div class="row">
                                        <div class="col-6">
                                            <p class="pan-attribute">License Number: <%= e.getDriver().getLicenceNo() %></p>
                                        </div>
          
                                    </div>
                                    <!-- You can add more details here -->
                                </div>

                                <!-- Image on the right-most side -->
                                <div class="pan-card-photo">
                                    <!-- Limiting the photo size -->
                                    <img src="http://localhost:5000/images/<%= e.getDriver().getImage().getId() %>"
                                        alt="Driver Image" class="pan-card-logo">
                                </div>
                            </div>

                            <!-- Modal footer -->
                            <div class="modal-footer">
                                <button type="button" class="btn btn-danger"
                                    data-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
                <% } %>
            </tbody>
        </table>
    </div>

    <!-- Script for handling modal and other functionalities -->
    <script>
    $(document).ready(function () {
        // Set the current delete button ID when clicking on the delete button in the modal
        $('#exampleModalLong').on('show.bs.modal', function (event) {
          var button = $(event.relatedTarget);
          var deleteButtonId = button.attr('id');
          $('#deleteButton').data('deleteButtonId', deleteButtonId);
        });

        // Handle the delete confirmation
        $('#deleteButton').on('click', function () {
          var deleteButtonId = $('#deleteButton').data('deleteButtonId');
          var deleteButtonHref = $("#" + deleteButtonId).attr("href");
          window.location.href = deleteButtonHref;
        });
      });
      
      setTimeout(function () {
          var alertDiv = document.getElementById('myAlert');
          alertDiv.style.opacity = 0;
          setTimeout(function () {
              alertDiv.style.display = 'none';
          }, 1000); // Assumes the CSS transition duration is 1s
      }, 4000);

    </script>
</body>

</html>
