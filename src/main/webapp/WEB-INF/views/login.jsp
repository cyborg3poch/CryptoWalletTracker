<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOC TYPE html>
<html lang="en">

<head>
   <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="apple-touch-icon" sizes="76x76" href="${pageContext.request.contextPath}/static/assets/img/apple-icon.png">
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/static/assets/img/favicon.png">
    <title>
      Material Dashboard 2 by Creative Tim
    </title>
    <!--     Fonts and icons     -->
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,900|Roboto+Slab:400,700" />
    <!-- Nucleo Icons -->
    <link href="${pageContext.request.contextPath}/static/css/nucleo-icons.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/static/css/nucleo-svg.css" rel="stylesheet" />
    <!-- Font Awesome Icons -->
    <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
    <!-- Material Icons -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Round" rel="stylesheet">
    <!-- CSS Files -->
    <link id="pagestyle" href="${pageContext.request.contextPath}/static/css/material-dashboard.css?v=3.0.4" rel="stylesheet" />

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

<body class="bg-gray-200">
 
  <main class="main-content  mt-0">
    <div class="page-header align-items-start min-vh-100" style="background-image: url('https://images.unsplash.com/photo-1497294815431-9365093b7331?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1950&q=80');">
      <span class="mask bg-gradient-dark opacity-6"></span>
      <div class="container my-auto">
        <div class="row">
          <div class="col-lg-4 col-md-8 col-12 mx-auto">
            <div class="card z-index-0 fadeIn3 fadeInBottom">
              <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
                <div class="bg-gradient-primary shadow-primary border-radius-lg py-3 pe-1">
                  <h4 class="text-white font-weight-bolder text-center mt-2 mb-0">Sign in</h4>
                  <div class="row mt-3">
                   
                  </div>
                </div>
              </div>
              <div class="card-body">
                <div class="row mt-2">
                  <c:if test="${param.error != null}">
                    <div class="alert alert-dismissible alert-danger-custom text-danger text-xs" role="alert">
                      Invalid credentials . Please check username / password
                    </div>
                  </c:if>

                  <c:if test="${param.registrationError != null}">
                    <div class="alert alert-dismissible alert-danger-custom text-danger text-xs" role="alert">
                      Something went wrong !
                    </div>
                  </c:if>

                  <c:if test="${param.logout != null}">
                    <div class="alert alert-dismissible alert-info-custom text-info text-xs" role="alert">
                     You have successfully logged out.
                    </div>
                  </c:if>
                  
                  <c:if test="${param.RegisterSuccess != null}">
                    <div class="alert alert-dismissible alert-success-custom text-success text-xs" role="alert">
                     Registration successful! Please login.
                    </div>
                  </c:if>

                  <c:if test="${param.emailAlreadyExists != null}">
                    <div class="alert alert-dismissible alert-info-custom text-info text-xs" role="alert">
                     Account Already registered ! Try login
                    </div>
                  </c:if>
                 
                </div>
                <form:form role="form" action="login-process" modelAttribute="UserReg" method="POST" class="text-start">
                  <div class="input-group input-group-outline my-3">
                    <label class="form-label">Email</label>
                    <form:input type="text" class="form-control" path="email" />
                  </div>
                  <div class="input-group input-group-outline mb-3">
                    <label class="form-label">Password</label>
                    <form:password path="password" class="form-control" />
                  </div>
                  <div class="form-check form-switch d-flex align-items-center mb-3">
                    <input class="form-check-input" type="checkbox" id="rememberMe" checked>
                    <label class="form-check-label mb-0 ms-3" for="rememberMe">Remember me</label>
                  </div>
                  <div class="text-center">
                    <input type="submit" class="btn bg-gradient-primary w-100 my-4 mb-2"/>
                  </div>
                  <p class="mt-4 text-sm text-center">
                    Don't have an account?
                    <a href="${pageContext.request.contextPath}/signup" class="text-primary text-gradient font-weight-bold">Sign up</a>
                  </p>
                </form:form>
              </div>
            </div>
          </div>
        </div>
      </div>
      <footer class="footer position-absolute bottom-2 py-2 w-100">
        <div class="container">
          <div class="row align-items-center justify-content-lg-between">
            <div class="col-12 col-md-6 my-auto">
              <div class="copyright text-center text-sm text-white text-lg-start">
                copyright <script>
                  document.write(new Date().getFullYear())
                </script>
                <a href="https://3poch.xyz" class="font-weight-bold text-white" target="_blank">Epoch</a>
               Trading LLC
              </div>
            </div>
            <div class="col-12 col-md-6">
              <ul class="nav nav-footer justify-content-center justify-content-lg-end">

                <li class="nav-item">
                  <a href="#" class="nav-link pe-0 text-white">Terms</a>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </footer>
    </div>
  </main>
  <!--   Core JS Files   -->
   <script src="${pageContext.request.contextPath}/static/js/core/popper.min.js"></script>
   <script src="${pageContext.request.contextPath}/static/js/core/bootstrap.min.js"></script>
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
   <script src="${pageContext.request.contextPath}/static/js/material-dashboard.min.js?v=3.0.4"></script>
</body>

</html>