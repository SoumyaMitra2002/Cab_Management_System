<!DOCTYPE html>
<%@page import="com.example.demo.driver.model.Driver"%>
<html lang="en">
<%@page import="com.example.demo.customer.model.Customer" %>
    <%@page import="com.example.demo.location.model.Location" %>

        <head>
            <!-- Required meta tags -->
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

            <!-- Bootstrap CSS -->
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
                integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
                crossorigin="anonymous">

            <title>Confirmation</title>

            <style>
                .card-header.ben {
                    background-color: green;
                    color: white;

                }

                .form-control.ss {
                    width: 367px !important;
                    margin-left: 332px;
                }

                .card-body.soo {
                    background-color: rgb(129, 212, 129);
                }

                .sa {
                    background-color: rgb(170, 255, 127);
                }

                .final.sq {
                    margin-top: 100px;
                }
            </style>
        </head>

        <body class="sa">
            <% Location location1=(Location)request.getAttribute("src"); %>
                <% Location location2=(Location)request.getAttribute("dest"); %>
                    <% Customer customer=(Customer) session.getAttribute("customer"); %>
                        <% Integer fare=(Integer) request.getAttribute("fare"); %>
                        <% Driver driver=(Driver) request.getAttribute("dri"); %>
                            <div class="final sq">
                                <div class="container text-center">
                                    <div class="card">
                                        <div class="card-header ben">
                                            Confirmation
                                        </div>
                                        <div class="card-body soo">
                                            <form action="<%= request.getContextPath()%>/customer/finalprocess" method="post">
                                                <div class="container text-center">
                                                    <div class="form-group">
                                                        <label for="exampleInputEmail1">Customer Name</label>
                                                        <input type="text" disabled class="form-control ss"
                                                            id="exampleInputEmail1" aria-describedby="emailHelp"
                                                            value="<%= customer.getUsername() %>">
                                                    </div>
                                                </div>
                                                <div class="container">
                                                    <div class="form-group">
                                                        <label for="exampleInputPassword1">Source</label>
                                                        <input type="text" disabled class="form-control ss"
                                                            id="exampleInputPassword1"
                                                            value="<%= location1.getLocationName() %>">
                                                    </div>
                                                </div>
                                                <div class="container">
                                                    <div class="form-group">
                                                        <label for="exampleInputPassword1">Destination</label>
                                                        <input type="text" disabled class="form-control ss"
                                                            id="exampleInputPassword1"
                                                            value="<%= location2.getLocationName() %>">
                                                    </div>
                                                </div>
                                                <div class="container">
                                                    <div class="form-group">
                                                        <label for="exampleInputPassword1">Fare</label>
                                                        <input type="number" disabled class="form-control ss"
                                                            id="exampleInputPassword1" value="<%= fare %>">
                                                    </div>
                                                </div>
                                                <input type="hidden" value="<%= customer.getCustomerId() %>" name="customer" class="hidden"/>
                                                <input type="hidden" value="<%= location1.getLocationId() %>" name="src" class="hidden"/>
                                                <input type="hidden" value="<%= location2.getLocationId() %>" name="dest" class="hidden"/>
                                                <input type="hidden" value="<%= fare %>" name="fare" class="hidden"/>
                                                <input type="hidden" value="<%= driver.getDriverId() %>" name="driver" class="hidden"/>

                                                <button style="color: white;" type="submit"
                                                    class="btn btn-outline-success">Submit</button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- Optional JavaScript -->
                            <!-- jQuery first, then Popper.js, then Bootstrap JS -->
                            <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
                                integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
                                crossorigin="anonymous"></script>
                            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
                                integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
                                crossorigin="anonymous"></script>
                            <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
                                integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
                                crossorigin="anonymous"></script>

        </body>

</html>