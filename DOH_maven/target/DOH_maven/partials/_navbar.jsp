<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "web.util.Vars" %>

<style>
.logo {
	font-size: 1.4rem;
	line-height: 48px;
	margin: 0;
	padding: 10px;
}
.logo:hover{
	text-decoration: none;
}
.logo > i {
	color: rgb(2,108,223);
}
.logo-mini {
	font-size: 1.8rem;
} 

.logo-text {
	background:  linear-gradient( 107deg,  rgba(2,108,223,1) 27.4%, rgba(0,240,240,1) 92.7% );
	-webkit-background-clip: text;
	-webkit-text-fill-color: transparent;
}
</style>

<nav class="navbar default-layout col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
      <div class="text-center navbar-brand-wrapper d-flex align-items-top justify-content-center">
        <a class="logo brand-logo" href="transaction.jsp">
        	<i class="mdi mdi-cube-outline"></i>
        	<span class="logo-text">ecomsoftware</span>
        </a>
        <a class="logo logo-mini brand-logo-mini" href="transaction.jsp">
        	<i class="mdi mdi-cube-outline"></i>
        </a>
      </div>
      <div class="navbar-menu-wrapper d-flex align-items-center">
        <ul class="navbar-nav navbar-nav-right">
          <li class="nav-item dropdown">
            <a class="nav-link count-indicator dropdown-toggle" id="notificationDropdown" href="#" data-toggle="dropdown">
              <i class="mdi mdi-bell"></i>
              <span class="count">4</span>
            </a>
            <div class="dropdown-menu dropdown-menu-right navbar-dropdown preview-list" aria-labelledby="notificationDropdown">
              <a class="dropdown-item">
                <p class="mb-0 font-weight-normal float-left">You have 4 new notifications
                </p>
                <span class="badge badge-pill badge-warning float-right">View all</span>
              </a>
              <div class="dropdown-divider"></div>
              <a class="dropdown-item preview-item">
                <div class="preview-thumbnail">
                  <div class="preview-icon bg-success">
                    <i class="mdi mdi-alert-circle-outline mx-0"></i>
                  </div>
                </div>
                <div class="preview-item-content">
                  <h6 class="preview-subject font-weight-medium text-dark">Application Error</h6>
                  <p class="font-weight-light small-text">
                    Just now
                  </p>
                </div>
              </a>
              <div class="dropdown-divider"></div>
              <a class="dropdown-item preview-item">
                <div class="preview-thumbnail">
                  <div class="preview-icon bg-warning">
                    <i class="mdi mdi-comment-text-outline mx-0"></i>
                  </div>
                </div>
                <div class="preview-item-content">
                  <h6 class="preview-subject font-weight-medium text-dark">Settings</h6>
                  <p class="font-weight-light small-text">
                    Private message
                  </p>
                </div>
              </a>
              <div class="dropdown-divider"></div>
              <a class="dropdown-item preview-item">
                <div class="preview-thumbnail">
                  <div class="preview-icon bg-info">
                    <i class="mdi mdi-email-outline mx-0"></i>
                  </div>
                </div>
                <div class="preview-item-content">
                  <h6 class="preview-subject font-weight-medium text-dark">New user registration</h6>
                  <p class="font-weight-light small-text">
                    2 days ago
                  </p>
                </div>
              </a>
            </div>
          </li>
          <li class="nav-item dropdown d-none d-xl-inline-block" id="navName">
            <a class="nav-link dropdown-toggle" id="UserDropdown" href="#" data-toggle="dropdown" aria-expanded="false">
              	<span class="profile-text" >Hello, <%=session.getAttribute(Vars.frist_name)%>  <%=session.getAttribute(Vars.last_name)%></span>
              	<img class="img-xs rounded-circle" src="images/faces/face1.jpg" alt="Profile image">
            </a>
            <div class="dropdown-menu dropdown-menu-right navbar-dropdown" aria-labelledby="UserDropdown">
              <a class="dropdown-item p-0"> 
                <div class="d-flex border-bottom">
                  <div class="py-3 px-4 d-flex align-items-center justify-content-center border-left border-right" id="signOut">
                    <i class="mdi mdi-account-outline mr-0 text-gray"></i>&nbsp;Sign Out
                  </div>
                </div>
              </a>
            </div>
          </li>
        </ul>
        <button class="navbar-toggler navbar-toggler-right d-lg-none align-self-center" type="button" data-toggle="offcanvas">
          <span class="mdi mdi-menu"></span>
        </button>
      </div>
    </nav>
      
  	<script src="vendors/js/vendor.bundle.base.js"></script>
  	<script src="vendors/js/vendor.bundle.addons_mini.js"></script>
  	
    <script src="js/misc.js"></script>
	<script src="js/dashboard.js"></script>
	<script src="js/off-canvas.js"></script>
	<script type="text/javascript" src="js/es6.js"></script>
   