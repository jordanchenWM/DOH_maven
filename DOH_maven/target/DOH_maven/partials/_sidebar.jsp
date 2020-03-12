<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import = "web.util.Vars" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<nav class="sidebar sidebar-offcanvas" id="sidebar">
        <ul class="nav">        
          <li class="nav-item" id="Server_Log">
            <a class="nav-link" href="serverlog.jsp">
              <i class="menu-icon mdi mdi-television"></i>
              <span class="menu-title">Server Log</span>
            </a>
          </li>
          
          <li class="nav-item" id="Transaction">
            <a class="nav-link" href="transaction.jsp">
              <i class="menu-icon mdi mdi-comment-check-outline"></i>
              <span class="menu-title">Transaction</span>
            </a>
          </li>
          
          <li class="nav-item" id="Admin">
            <a class="nav-link" data-toggle="collapse" href="#ui-basic" aria-expanded="false" aria-controls="ui-basic">
              <i class="menu-icon mdi mdi-content-copy"></i>
              <span class="menu-title">Administrator</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="ui-basic">
              <ul class="nav flex-column sub-menu">          
			      <li class="nav-item" id="Scheduler_Management">
		            <a class="nav-link" href="schedulerManagement.jsp">
		              <i class="menu-icon mdi mdi-table"></i>
		              <span class="menu-title">Scheduler</span>
		            </a>
		          </li>
		          <li class="nav-item" id="Partner_Profiles">
		            <a class="nav-link" href="partner_Profiles.jsp" >
		              <i class="menu-icon mdi mdi-account"></i>
		              <span class="menu-title">Partner Profiles</span>
		            </a>
		          </li>
		          <li class="nav-item" id="Document_Type" >
		             <a class="nav-link" href="documentType_profile.jsp" >
		               <i class="menu-icon mdi mdi-file-xml"></i>
		               <span class="menu-title">Document Type</span>
		            </a>
		          </li>
			      <li class="nav-item" id='System_Monitor'>
		            <a class="nav-link" href="pages/charts/chartjs.html">
		              <i class="menu-icon mdi mdi-television"></i>
		              <span class="menu-title">System Monitor</span>
		            </a>
		          </li>
		          <li class="nav-item" id="License_Management" >
		            <a class="nav-link" href="licenseManagement.jsp">
		              <i class="menu-icon mdi mdi-key"></i>
		              <span class="menu-title">License Management</span>
		           	</a>
		          </li>
		          <li class="nav-item" id="JDBC_Configuration">
		            <a class="nav-link" href="processing_Rule.jsp">
		              <i class="menu-icon mdi mdi-settings"></i>
		              <span class="menu-title">Processing Rule</span>
		            </a>
		          </li>
		          <li class="nav-item" id="JDBC_Configuration">
		            <a class="nav-link" href="JDBC_Poll.jsp">
		              <i class="menu-icon mdi mdi-database"></i>
		              <span class="menu-title">JDBC Configuration</span>
		            </a>
		          </li>
		          <li class="nav-item" id="User_Management" >
		            <a class="nav-link" href="userManagement.jsp" >
		              <i class="menu-icon mdi mdi-account"></i>
		              <span class="menu-title">User Management</span>
		            </a>
		          </li>
		          <li class="nav-item" id="Tran_purge">
		            <a class="nav-link" href="transaction_purge.jsp">
		              <i class="menu-icon mdi mdi-format-clear"></i>
		              <span class="menu-title">Transaction Purge</span>
		            </a>
		          </li>
		          <li class="nav-item" id="Extend">
		            <a class="nav-link" href="setConfig.jsp">
		              <i class="menu-icon mdi mdi-settings"></i>
		              <span class="menu-title">Extend</span>
		            </a>
		          </li>
              </ul> 
           </div>   
            </li>
		</ul>                    
      </nav>
</head>
<body>
<script>

  $(document).ready(function() {
	  	  
	  var role = '<%=session.getAttribute(Vars.Role)%>';
	  if (role.toLowerCase() != 'admin') {
		  $('#Admin').hide();
	  }
	  
	  $('.alert > .close').click(function(e) {
			$(this).parent().hide();
	   }); 
	  
  })
  
  </script>
</body>
</html>