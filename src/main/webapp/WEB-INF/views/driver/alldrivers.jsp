<!DOCTYPE html>
<%@page import="com.example.demo.driver.model.Driver"%>
<%@page import="java.util.List"%>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Manage Driver</title>

  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
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
      border: none; /* Add this line to remove borders from th and td */
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
      border: none; /* Add this line to remove borders from tbody */
    }

  </style>

</head>

<body style="background-image: url(https://wallpaperaccess.com/full/1732235.jpg);">
<div class="container-header">
  <h2 style="color: black;">Manage Drivers</h2>
  <!-- Button to trigger modal -->
  <a href="adddriver" class="btn btn-success add-employee-btn"><i class="bi-person-plus-fill"></i> Add Driver </a>
</div>

<%
List<Driver> list= (List<Driver>)request.getAttribute("drivers");
%>

<!-- Modal -->
<div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle"
     aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <div class="container text-center">
          <h5 class="modal-title" id="exampleModalLongTitle" style="color: yellowgreen;">Confirmation</h5>
        </div>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body" style="color: red;">
        Are you sure you want to delete?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-info" data-dismiss="modal">Close</button>
        <a class="btn btn-danger" id="deleteButton"><i class="bi-trash"></i> Delete</a>
      </div>
    </div>
  </div>
</div>
<div class="container">
  <table class="table">
    <thead class="table-info">
    <tr>
      <th scope="col">Driver Id</th>
      <th scope="col">License No.</th>
      <th scope="col">Email</th>
      <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody class="table-transparent tbody">
   
   <%
   for(Driver d: list )
   {
	   
       String deleteButtonId = "deleteButton_" + d.getDriverId();

   %>
   
    <tr>
      <td><%=d.getDriverId() %></td>
      <td><%=d.getLicenceNo() %></td>
      <td><%=d.getEmail() %></td>

      <td>
        <a href="aboutdriver/<%= d.getDriverId() %>" class="btn btn-primary"><i class="bi-eye-fill"></i> View</a>
        <a href="editdriver/<%=d.getDriverId() %>" class="btn btn-warning"><i class="bi-pencil-square"></i> Edit</a>
       <a id="<%=deleteButtonId%>" href="deletedriver/<%=d.getDriverId() %>" class="btn btn-danger"
           data-toggle="modal" data-target="#exampleModalLong"><i class="bi-trash"></i> Delete</a>
      </td>
    </tr>
    
    <%
   }
    %>
  

    </tbody>
  </table>

  <!-- Modal for Add Employee Form -->


</div>

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
</script>

</body>

</html>