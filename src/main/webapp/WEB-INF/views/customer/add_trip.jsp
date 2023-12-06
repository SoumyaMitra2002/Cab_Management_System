<!doctype html>
<%@page import="com.example.demo.driver.model.Driver"%>
<%@page import="com.example.demo.location.model.Location"%>
<%@page import="java.util.List"%>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <style>
        /* Custom CSS for glow effect */
        /* .glow-container {
            display: flex;
            flex-direction: row;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.5); */
        /* Adjust the values for the glow effect */
        /* border-radius: 10px;
            width: 80%; */
        /* Adjust the width as needed */
        /* padding: 20px; */
        /* } */
        /* 
        .stokes{
            display: flex !important;

        } */
        .body {
            background-color: bisque !important;
            width: 1000px;
        }

        .soumya {
            display: flex;
            flex-direction: row;
            padding: 64px;
            gap: 90px;
            width: 1374px;
            border: 3px solid black;
            margin-left: -118px;
        }

        .soumya .form-group.form12 {
            width: 320px;
        }

        .soumya .form-group.form13 {
            width: 320px;
        }

        .soumya .form-group.form14 {
            width: 320px;
        }

        .btn.btn-success.baal {
            margin-top: 300px;
            margin-left: -817px;
        }

        .stokes {
            width: 1000px;
        }

        #dog-names {
            width: 182px;
            height: 58px;
        }

        .container.text-center {
            width: 1000px !important;
            background-color: yellow;
        }

        .final {
            background-color: rgb(226, 172, 106) !important;
        }

        .full-width-container.text-center {
            width: 100%;
            padding-right: 15px;
            padding-left: 15px;
            margin-right: auto;
            margin-left: auto;
            background-color: yellow;
        }
    </style>

    <title>Add Trip</title>
</head>

<body class="final">
    <div class="full-width-container text-center">
        <h2>Add Trip</h2>
    </div>
<% List<Location> list1=(List<Location>)request.getAttribute("locations"); 
List<Driver> list2=(List<Driver>)request.getAttribute("drivers");
%>
    <div class="container text-cent">
        <div class="glow-container">
            <div class="stokes">
                <form class="soumya" action="<%= request.getContextPath() %>/customer/trip_process" method="post">
                    <!-- <label for="dog-names">Choose a dog name:</label> -->
                    <h2 style="margin-left: -61px;">Driver</h2>
                    <select name="drivers" id="dog-names">
                        <option value="rigatoni">Driver</option>
                        <%
                        for(Driver d:list2){
                        %>
                        <option value="<%= d.getDriverId() %>"><%= d.getUsername() %> (<%=d.getCab().getCabType() %>,<%=d.getCab().getPerKmRate() %>)</option>
                        <%
                        }
                        %>
                    </select>
                    <h2>Source</h2>
                    <select name="source" id="dog-names">
                        <option value="rigatoni">From</option>
                        <%
                        for(Location l:list1){
                        %>
                        <option value="<%= l.getLocationId() %>"><%= l.getLocationName() %></option>
                        <%
                        }
                        %>
                    </select>
                    <h2>Destination</h2>
                    <select name="destination" id="dog-names">
                        <option value="rigatoni">To</option>
                        <%
                        for(Location l:list1){
                        %>
                        <option value="<%= l.getLocationId() %>"><%= l.getLocationName() %></option>
                        <%
                        }
                        %>
                    </select>

                    <!-- <div class="form-group form12">
                        <label for="exampleFormControlInput1">Subject</label>
                        <input type="text" class="form-control" id="exampleFormControlInput1"
                            placeholder="Enter Job Title" name="sub">
                    </div> -->

                    <!-- <div class="form-group form13">
                        <label for="exampleFormControlSelect2">Select Employees</label>
                        <select multiple class="form-control" id="exampleFormControlSelect2" name="emps">

                            <option value="#">#</option>

                        </select>
                    </div> -->
                    <!-- <div class="form-group form14">
                        <label for="exampleFormControlTextarea1">Task Description</label>
                        <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="desc"></textarea>
                    </div> -->

                    <button type="submit" class="btn btn-success baal">Proceed</button>
                </form>
            </div>
            <h1 style="margin-left: 442px; margin-top: 20px;">Thank you!</h1>
        </div>
    </div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>

</html>