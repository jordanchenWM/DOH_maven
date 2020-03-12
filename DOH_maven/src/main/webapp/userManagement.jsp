<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>User Management</title>
  <!-- plugins:css -->
  <link rel="stylesheet" href="vendors/iconfonts/mdi/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="vendors/css/vendor.bundle.base.css">
  <link rel="stylesheet" href="vendors/css/vendor.bundle.addons.css">
  <link rel="stylesheet" href="css/loader.css">
  <link rel="stylesheet" href="css/zebra_datepicker.css" >
  
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/custom.css">
  
  <link rel="shortcut icon" href="images/favicon.png" />

</head>
<body style="display:none">
<section id="loader" class="loaders"><span class="loader loader-bars"><span> </span></span> Loading...</section>
  <div class="container-scroller">
    <!-- partial:partials/_navbar.html -->
    <jsp:include page="partials/_navbar.jsp"/>
    
    <div class="container-fluid page-body-wrapper">
       <jsp:include page="partials/_sidebar.jsp"/>  
       <div class="main-panel"> 
        <div class="content-wrapper">
          <div class="row">
            <div class="col-md-12 grid-margin">
              <div class="card">
                <div class="card-body" id="serachDiv" style="margin-left:2%">
               		<button id="add_user" class="btn btn-primary">
					<i class='mdi mdi-yeast material-icons md-24'></i>Add</button>
		            	
            		</div> 
            		<div class="card-body">
            			<table id="User" class="table table-striped w-100" >
		        			<thead>
			            		<tr> 	             
				           		<th width="70px"></th>
				           		<th width="130px">User ID</th>
				           		<th width="130px">Last Name</th>
				           		<th width="130px">Frist Name</th>
				           		<th width="120px">Phone</th>
				           		<th width="140px">Mail</th>
				           		<th width="60px">Role</th>
			           		</tr>
		        			</thead>		        	      
		   			</table>
                </div>
              </div>
            </div>
          </div>
        </div>
       <jsp:include page="partials/_footer.html"/>    
      </div>
    </div>
  </div>
  
  <script type="text/javascript" language="javascript" src="js/zebra_datepicker.min.js"></script>
  <script type="text/javascript" language="javascript" src="js/util.js"></script>
  <script type="text/javascript" language="javascript" src="js/UserManagement.js"></script>
  
  
  <jsp:include page="partials/user_add.jsp"/>
  
  <script>
  var UserTable;
  var Condition = {} ;
  
  $(document).ready(function() {
	  checkSession();
	  
	  //ReadyLoader();
	  UserTable = getUserTable();
	  Condition.method = 'UserTable';
	  refresh_Table(UserTable);
	  
	  $('body').fadeIn();
	  
	  $('#serachDiv').on('click', '#add_user', function(e) {
		  checkSession();
		  initPage();
		  showAdd_User();
	  })
	  
	  $('#User').on('click', '#remove_btn', function(e) {
		  if(confirm("Are you sure you want to remove this user ?")){
			  Condition.account = UserTable.row($(this).parents('tr')).data()['Account'];
			  if(Condition.account.toLowerCase() == "admin" ){
				  alert("Admin Cannot be deleted！")
			  }else {
				  Condition.method ='user_delete'
				  
				  refresh_Table(UserTable);
			  }
		  }
	  })
	  
	  $('#User').on('click', '#edit_user', function(e) {
		  var data = UserTable.row($(this).parents('tr')).data();
				  
		  setEditPage(data);
		  showAdd_User();
	  })
  })
  </script>
</body>
</html>