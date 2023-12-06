<!DOCTYPE html>

<%@page import="com.example.demo.location.model.Location"%>
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
  <h2 style="color: black;">Locations</h2>
  <!-- Button to trigger modal -->
  <a href="<%=request.getContextPath() %>/location/addlocation" class="btn btn-success add-employee-btn"><i class="bi bi-geo-alt-fill"></i> Add Location </a>
</div>

<%
	List<Location> listf=(List<Location>)request.getAttribute("list");
%>

<div class="container text-center" style="width: 800px; margin-top: 5px;">

	<%String rs= (String)request.getAttribute("u");%>
	
	<%
	
	if(rs.equals("added"))
	{
	%>
	 <div class="alert" role="alert" id="myAlert" style="background-color:#006400; color: #ffffff;">
           Added Successfully!!
    </div>
    
    <%
	}
	%>
</div>

<div class="container">
  <table class="table">
    <thead class="table-info">
    <tr>
      <th scope="col">Location Id</th>
      <th scope="col">Location Name</th>
      <th scope="col">Location Altitude</th>
      
    </tr>
    </thead>
    <tbody class="table-transparent tbody">

	<%
	for(Location location : listf){
	%>   
    <tr>
      <td><%=location.getLocationId() %></td>
      <td><%=location.getLocationName() %></td>
      <td><%=location.getAltitude() %></td>

      
    </tr>
  
	<%
	}
	%>
    </tbody>
  </table>

  <!-- Modal for Add Employee Form -->


</div>


<script>
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