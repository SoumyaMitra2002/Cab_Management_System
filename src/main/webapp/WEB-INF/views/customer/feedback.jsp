
<!DOCTYPE html>
<%@page import="com.example.demo.customer.model.Customer"%>
<%@page import="com.example.demo.driver.model.Driver"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link rel="stylesheet" href="addemp.css">

    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>

</head>
<body style="background-image:url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcShn7pGuji9k2KhsXVKTAfuTXxN1VYZ6--5RQ&usqp=CAU')">
<style>

    @charset "ISO-8859-1";
    @import url('https://fonts.googleapis.com/css?family=Montserrat:400,700&display=swap');

    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: 'Montserrat', sans-serif;
    }

    body {
        /*background: #0d46e2;*/
        background-image: url('/new.svg');
        padding: 0 10px;
        background-size: cover;

    }

    .wrapper {
        max-width: 500px;
        width: 100%;
        background: white;
        margin: 20px auto;
        box-shadow: 1px 1px 2px rgba(0, 0, 0, 0.125);
        padding: 30px;
        margin-top: 130px;

    }

    .wrapper .title {
        font-size: 24px;
        font-weight: 700;
        margin-bottom: 25px;
        color: violet;
        text-transform: uppercase;
        text-align: center;
    }

    .wrapper .form {
        width: 100%;
    }

    .wrapper .form .inputfield {
        margin-bottom: 15px;
        display: flex;
        align-items: center;
    }

    .wrapper .form .inputfield label {
        width: 200px;
        color: black;
        margin-right: 4px;
        font-size: 14px;
    }

    .wrapper .form .inputfield .input,
    .wrapper .form .inputfield .textarea {
        width: 100%;
        outline: none;
        border: 1px solid #d5dbd9;
        font-size: 15px;
        padding: 8px 10px;
        border-radius: 3px;
        transition: all 0.3s ease;
    }

    .wrapper .form .inputfield .textarea {
        width: 100%;
        height: 125px;
        resize: none;
    }

    .wrapper .form .inputfield .custom_select {
        position: relative;
        width: 100%;
        height: 37px;
    }

    .wrapper .form .inputfield .custom_select:before {
        content: "";
        position: absolute;
        top: 12px;
        right: 10px;
        border: 8px solid;
        border-color: #d5dbd9 transparent transparent transparent;
        pointer-events: none;
    }

    .wrapper .form .inputfield .custom_select select {
        -webkit-appearance: none;
        -moz-appearance: none;
        appearance: none;
        outline: none;
        width: 100%;
        height: 100%;
        border: 0px;
        padding: 8px 10px;
        font-size: 15px;
        border: 1px solid #d5dbd9;
        border-radius: 3px;
    }


    .wrapper .form .inputfield .input:focus,
    .wrapper .form .inputfield .textarea:focus,
    .wrapper .form .inputfield .custom_select select:focus {
        border: 1px solid #fec107;
    }

    .wrapper .form .inputfield p {
        font-size: 14px;
        color: #757575;
    }

    .wrapper .form .inputfield .check {
        width: 15px;
        height: 15px;
        position: relative;
        display: block;
        cursor: pointer;
    }

    .wrapper .form .inputfield .check input[type="checkbox"] {
        position: absolute;
        top: 0;
        left: 0;
        opacity: 0;
    }

    .wrapper .form .inputfield .check .checkmark {
        width: 15px;
        height: 15px;
        border: 1px solid violet;
        display: block;
        position: relative;
    }

    .wrapper .form .inputfield .check .checkmark:before {
        content: "";
        position: absolute;
        top: 1px;
        left: 2px;
        width: 5px;
        height: 2px;
        border: 2px solid;
        border-color: transparent transparent #fff #fff;
        transform: rotate(-45deg);
        display: none;
    }

    .wrapper .form .inputfield .check input[type="checkbox"]:checked~.checkmark {
        background: #fec107;
    }

    .wrapper .form .inputfield .check input[type="checkbox"]:checked~.checkmark:before {
        display: block;
    }

    .wrapper .form .inputfield .btn {
        width: 42%;
        padding: 8px 10px;
        font-size: 15px;
        border: 0px;
        background: violet;
        color: #fff;
        cursor: pointer;
        border-radius: 3px;
        outline: none;
        margin-left: 126px;
    }

    .wrapper .form .inputfield .btn:hover {
        background: #ffd658;
    }

    .wrapper .form .inputfield:last-child {
        margin-bottom: 0;
    }

    @media (max-width:420px) {
        .wrapper .form .inputfield {
            flex-direction: column;
            align-items: flex-start;
        }

        .wrapper .form .inputfield label {
            margin-bottom: 5px;
        }

        .wrapper .form .inputfield.terms {
            flex-direction: row;
        }
    }
    .soumm{
        height: 100px;
        width: 440px;
        padding: 10px 10px;
    }

    .btn.sj{

        height: 60px;
    }

</style>

<!-- <%
    boolean dup=false;
    if(request.getAttribute("dup")!=null) {
        dup = (Boolean) request.getAttribute("dup");
    }
%>

<%
if(dup)
{
%>
<script>
Swal.fire({
icon: 'error',
title: 'Not Permitted',
text: 'EMAIL ID is already present',
});

</script>
<%
}
%> -->

<%
Driver driver=(Driver)request.getAttribute("driver");
Customer customer=(Customer)request.getAttribute("customer");
Integer tripId=(Integer)request.getAttribute("tripid");
%>

<form  action="<%= request.getContextPath() %>/customer/rateprocess" method="post"  enctype="multipart/form-data">
    <div class="wrapper">
        <div class="title">
            FeedBack
        </div>
        <div class="form">
            <div class="inputfield">
                <label>Driver</label>
                <input type="text" disabled class="input" name="drivername" value="<%= driver.getUsername()%>">
            </div>
            <div class="inputfield">
                <input type="hidden" class="input" name="driverid"  value="<%= driver.getDriverId() %>" required>
                <input type="hidden" class="input" name="customername"  value="<%= customer.getUsername() %>" required>
                <input type="hidden" class="input" name="tripid"  value="<%=tripId %>" required>
                
            </div>
            
            <div class="inputfield">
                <label>Rating</label>
                <div class="custom_select">
                    <select name="rate">
                        <option value="1"  >1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>

                    </select>
                </div>
            </div>
            <center>Comment</center>
            <div class="inputfield">
                <textarea name="msg" id="sou1" class="soumm"></textarea>
            </div>
           
            <div class="inputfield">
                <input type="submit" value="Rate" class="btn sj">
            </div>
        </div>
    </div>
</form>


</body>
</html>
