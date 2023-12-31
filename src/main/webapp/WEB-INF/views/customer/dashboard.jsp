<%@page import="com.example.demo.customer.model.Customer"%>
<html>

<head>
  <title>User Dashboard</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <!-- Add Bootstrap CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

  <!-- Add Font Awesome Icons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
    }

    .header {
      background-color: #333;
      color: white;
      padding: 15px 0;
      text-align: center;
    }

    h1 {
      margin-top: 0;
      font-size: 2.5rem;
      font-weight: bold;
      text-transform: uppercase;
    }

    .container {
      max-width: 800px;
      margin: auto;
      padding: 20px;
    }

    .card-body {
      display: flex;
      align-items: center;
      justify-content: center;
      flex-direction: column;
      padding: 30px;
      background-color: #fff;
      border-radius: 10px;
      box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);
      transition: transform 0.3s;
      text-align: center;
    }

    .card-body:hover {
      transform: translateY(-10px);
    }

    .card-body i {
      font-size: 5rem;
      margin-bottom: 20px;
    }

    .card-body h3 {
      font-size: 1.8rem;
      font-weight: bold;
      margin: 0;
    }

    .card-body p {
      font-size: 1rem;
      margin: 0;
    }

    .card-body.ben {
      height: 325px !important;
      border-radius: 0%;
    }

    .card-body.ben1 {
      height: 321px !important;
      border-radius: 0%;
    }

    .card-body.ben2 {
      height: 322px !important;
      border-radius: 0%;
    }

    .card-body.ben3 {
      height: 321px !important;
      border-radius: 0%;
    }

    /* Improve the UI of the page */
    body {
      background-color: #f4f4f4;
      font-family: Arial, Helvetica, sans-serif;
      font-size: 16px;
      line-height: 1.6em;
      margin: 0;
      padding: 0;
    }
  </style>
</head>


<%
	Customer customer=(Customer)session.getAttribute("customer");
%>
<body style="background-image: url(https://wallpaperswide.com/download/light_background-wallpaper-3840x2400.jpg);">
  <div>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
        aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
          <li class="nav-item active">
            <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
          </li>





          <li class="nav-item ml-auto">
            <img src="http://localhost:5000/images/<%=customer.getImage().getId()%>" class="rounded-circle" width="50" height="50" alt="Profile Picture">
          </li>



        </ul>


      </div>



      <div>
        <a href="logout" class="btn btn-danger">
          <i class="fa fa-sign-out"></i> Log out
        </a>


      </div>


    </nav>
  </div>



  <div class="container text-center">
    <h2 style="color: blue; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
            animation: move-left-right 5s infinite;">
      Hi <%= customer.getUsername() %>
    </h2>
  </div>

  <style>
    @keyframes move-left-right {
      0% {
        transform: translateX(0);
      }

      50% {
        transform: translateX(50%);
      }

      100% {
        transform: translateX(0);
      }
    }
  </style>


  <div class="container">
    <div class="row">
      <div class="col-md-6 col-lg-3 mb-4">
        <a href="/customer/addtrip" class="card-body ben">
          <i class="fa fa-car text-success"></i>
          <h3 style="color: blueviolet;">Add Trips</h3>
          <p style="color: green;">Add your trips , you want to travel</p>
        </a>
      </div>
      <div class="col-md-6 col-lg-3 mb-4">
        <a href="/customer/details/<%=customer.getCustomerId() %>" class="card-body ben1">
          <i class="fa fa-user"></i>
          <h3 style="color: olive">Show Profile</h3>
          <p>View all Your profile information in single click</p>
        </a>
      </div>
      <div class="col-md-6 col-lg-3 mb-4">
        <a href="#" class="card-body ben2">
          <i class="fa fa-users text-danger"></i>
          <br>
          <h3 style="color: red;">Complain</h3>
          <p style="color: grey;">In case you are not satisfied with service provided</p>

        </a>
      </div>


      <div class="col-md-6 col-lg-3 mb-4">
        <a href="/customer/history" class="card-body ben3">
          <i class="fa fa-briefcase text-warning" aria-hidden="true"></i>
          <h3 style="color: green;">Trip History</h3>
          <p style="color: brown;"> Show all your trips from where to where you have travelled </p>

        </a>
      </div>


    </div>




  </div>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
    integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
    crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
    integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
    crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
    crossorigin="anonymous"></script>
</body>

</html>