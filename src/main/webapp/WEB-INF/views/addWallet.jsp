<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="apple-touch-icon" sizes="76x76" href="/WalletTracker/static/assets/img/apple-icon.png">
   
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
    <link id="pagestyle" href="/WalletTracker/static/css/material-dashboard.css" rel="stylesheet" />

    
<style>
.modal-backdrop
{
    opacity:0.5 !important;
}
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
  <body class="g-sidenav-show  bg-gray-200" id="bodyID">
    <main class="main-content position-relative max-height-vh-100 h-100 border-radius-lg ">
      <!-- Navbar -->
      <nav class="navbar navbar-main navbar-expand-lg px-0 mx-4 shadow-none border-radius-xl" id="navbarBlur" data-scroll="true">
        <div class="container-fluid py-1 px-3">
          <nav aria-label="breadcrumb">
            <ol class="breadcrumb bg-transparent mb-0 pb-0 pt-1 px-0 me-sm-6 me-5">
              <li class="breadcrumb-item text-sm"><a class="opacity-5 text-dark" href="#">Home</a></li>
              <li class="breadcrumb-item text-sm text-dark active" aria-current="page">Dashboard</li>
            </ol>
          </nav>
          <div class="collapse navbar-collapse mt-sm-0 mt-2 me-md-0 me-sm-4 justify-content-lg-end" id="navbar">
           
            <ul class="navbar-nav  justify-content-end">
             
             
            
              <li class="nav-item dropdown pe-2 d-flex align-items-center">
                <a href="javascript:;" class="nav-link text-body p-0" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false">
                  <i class="fa fa-cog cursor-pointer"></i>
                </a>
                <ul class="dropdown-menu  dropdown-menu-end  px-2 py-3 me-sm-n4" aria-labelledby="dropdownMenuButton">
                  <li class="mb-2">
                    <a class="dropdown-item border-radius-md" href="javascript:;">
                      <div class="d-flex py-1">
                        <div class="avatar avatar-sm  me-3 my-auto">
                          <i class="fa fa-power-off me-1 text-dark"></i>
                        </div>
                        <div class="d-flex flex-column justify-content-center">
                          <h6 class="text-sm font-weight-normal mb-1">
                              <form:form action="logout" method="POST">
                                  <input type="submit" class="text-bold" value="Log out" />
  
                              </form:form>
                             
                           
                          </h6>
                        </div>
                      </div>
                    </a>
                  </li>
                
                 
                </ul>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <!-- End Navbar -->
      <div class="container-fluid py-4">
  
          <div class="row mb-4 mt-2">
              <div class="col-6 d-flex align-items-center">
                <h6 class="mb-0">Hi ,Username</h6>
              </div>
             
            </div>
            <div class="row mb-2 mt-2">
              <c:if test="${param.ExistingWallet != null}">
                <div class="col-4 alert alert-dismissible alert-danger-custom text-danger text-xs" role="alert">
                 This wallet is already being tracked
                </div>
              </c:if>
            </div>
         
            <div class="row">
                <div class="col-xl-6 col-sm-6 mb-xl-0 mb-4">
                    <div class="card p-3">
                        <form:form action="track-wallet" modelAttribute="walletDto" method="POST" class="text-start">
                       
                            <form:errors path="address" class="text-danger text-xs" />
                            <div class="input-group input-group-outline my-4">
                                <label class="form-label">Wallet Address</label>
                                <form:input type="text" class="form-control" path="address" />
                              </div>
                              
                              <div class="input-group input-group-outline my-4">
                                
                                <form:select path="chain" class="form-control">
                                  <form:option value="ETH" label="Ethereum" />
                                  <form:option value="MATIC" label="Polygon" />
                                  </form:select>
                              </div>
                          
                          <button type="submit" class="btn btn-primary">Submit</button>
                          
                        </form:form> 
                    </div>
                   
                </div>
            </div>
       
      </div>
  
      <div class="row">
          <footer class="footer position-absolute py-2 w-100">
              <div class="container">
                <div class="row align-items-center justify-content-lg-between">
                  <div class="col-12 col-md-6 my-auto">
                    <div class="copyright text-center text-sm text-lg-start">
                      copyright <script>
                        document.write(new Date().getFullYear())
                      </script>
                      <a href="https://3poch.xyz" class="font-weight-bold" target="_blank">Epoch</a>
                     Trading LLC
                    </div>
                  </div>
                  <div class="col-12 col-md-6">
                    <ul class="nav nav-footer justify-content-center justify-content-lg-end">
          
                      <li class="nav-item">
                        <a href="#" class="nav-link pe-0">Terms</a>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
            </footer>
  
      </div>
  
  
    
    </main>
    <script
    src="https://code.jquery.com/jquery-3.6.0.min.js"
    integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
    crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.9.2/umd/popper.min.js" integrity="sha512-2rNj2KJ+D8s1ceNasTIex6z4HWyOnEYLVC3FigGOmyQCZc2eBXKgOxQmo3oKLHyfcj53uz4QMsRCWNbLd32Q1g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
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
 <script src="/WalletTracker/static/js/material-dashboard.js"></script>


  </body>
</html>