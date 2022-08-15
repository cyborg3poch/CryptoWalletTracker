
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOC TYPE html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="apple-touch-icon" sizes="76x76" href="/WalletTracker/static/assets/img/apple-icon.png">
  <link rel="icon" type="image/png" href="/WalletTracker/static/assets/img/favicon.png">
  <title>
    Material Dashboard 2 by Creative Tim
  </title>
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,900|Roboto+Slab:400,700" />
  <!-- Nucleo Icons -->
  <link href="/WalletTracker/static/css/nucleo-icons.css" rel="stylesheet" />
  <link href="/WalletTracker/static/css/nucleo-svg.css" rel="stylesheet" />
  <!-- Font Awesome Icons -->
  <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
  <!-- Material Icons -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Round" rel="stylesheet">
  <!-- CSS Files -->
  <link id="pagestyle" href="/WalletTracker/static/css/material-dashboard.css?v=3.0.4" rel="stylesheet" />

  <style>
     .alert-danger-custom
      {
        color: #721c24;
        background-color: #f8d7da;
        border-color: #f5c6cb;
      }

      .alert-info-custom 
      {
        color: #0c5460;
       background-color: #d1ecf1;
        border-color: #bee5eb;
      }
      .alert-success-custom 
      {
        color: #155724;
    background-color: #d4edda;
    border-color: #c3e6cb;
      }
  </style>

</head>

<body class="">

  <main class="main-content  mt-0">
    <section>
      <div class="page-header min-vh-100">
        <div class="container">
          <div class="row">
            <div class="col-6 d-lg-flex d-none h-100 my-auto pe-0 position-absolute top-0 start-0 text-center justify-content-center flex-column">
              <div class="position-relative bg-gradient-primary h-100 m-3 px-7 border-radius-lg d-flex flex-column justify-content-center" style="background-image: url('/WalletTracker/static/img/nft/original.jpg'); background-size: cover;">
              </div>
            </div>
            <div class="col-xl-4 col-lg-5 col-md-7 d-flex flex-column ms-auto me-auto ms-lg-auto me-lg-5">
              <div class="card card-plain">
                <div class="card-header">
                  <h4 class="font-weight-bolder">Sign Up</h4>
                  <p class="mb-0">Enter your email and password to register</p>
                </div>
                <div class="card-body">
                <form:form action= "signup-process" modelAttribute="UserReg" method="POST" >

                 
                  <form:errors path="email" class="text-danger text-xs"/>
                    <div class="input-group input-group-outline mb-3">
                      <label class="form-label">Email</label>
                      <form:input type="email" class="form-control" path="email" />
                     
                    </div>
                    <form:errors path="phone" class="text-danger text-xs"/>
                      <div class="input-group input-group-outline mb-3">
                        <label class="form-label">Phone</label>
                        <form:input type="text" class="form-control" path="phone" />
                      
                      </div>
                      <form:errors path="password" class="text-danger text-xs"/>
                    <div class="input-group input-group-outline mb-3">
                      <label class="form-label">Password</label>
                      <form:password class="form-control" path="password" />
                      <br>
                     
                    </div>
                    <form:errors path="firstname" class="text-danger text-xs"/>
                      <div class="input-group input-group-outline mb-3">
                          <label class="form-label">First Name</label>
                          <form:input  class="form-control" path="firstname" />
                                        
                      </div>
                      <form:errors path="lastname" class="text-danger text-xs"/>
                    <div class="input-group input-group-outline mb-3">
                        <label class="form-label">Last Name</label>
                         <form:input  class="form-control" path="lastname" />
                        
                      </div>
                    <div class="form-check form-check-info text-start ps-0">
                      <form:checkbox path="TosCheck" class="form-check-input" id="flexCheckDefault"  />
                      <label class="form-check-label" for="flexCheckDefault">
                        I agree the <a href="javascript:;" class="text-dark font-weight-bolder">Terms and Conditions</a>
                      </label>
                      <br>
                      <form:errors path="TosCheck" class="text-danger text-xs" role="alert" />
                    </div>
                    <div class="text-center">
                      <input type="submit" class="btn btn-lg bg-gradient-primary btn-lg w-100 mt-4 mb-0" value="Sign Up" />
                    </div>
                  </form:form>
                </div>
                <div class="card-footer text-center pt-0 px-lg-2 px-1">
                  <p class="mb-2 text-sm mx-auto">
                    Already have an account?
                    <a href="${pageContext.request.contextPath}/login" class="text-primary text-gradient font-weight-bold">Sign in</a>
                  </p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </main>
  <!--   Core JS Files   -->
  <script src="/WalletTracker/static/js/core/popper.min.js"></script>
  <script src="/WalletTracker/static/js/core/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/static/js/plugins/perfect-scrollbar.min.js"></script>
   <script src="${pageContext.request.contextPath}/static/js/plugins/smooth-scrollbar.min.js"></script>
   <script>
    var win = navigator.platform.indexOf('Win') > -1;
    if (win && document.querySelector('#sidenav-scrollbar')) {
      var options = {
        damping: '0.5'
      }
      Scrollbar.init(document.querySelector('#sidenav-scrollbar'), options);
    }
  </script>

  <!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
  <script src="/WalletTracker/static/js/material-dashboard.min.js?v=3.0.4"></script>
</body>

</html>