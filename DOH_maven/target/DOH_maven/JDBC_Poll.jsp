<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>JDBC Pool</title>
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
<body>
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
               		<button id="add_alia" class=" btn btn-primary">
					<i class='mdi mdi-yeast material-icons md-24'></i>Add</button>
		            	
            		</div>
            		<div class="alert alert-danger">
				  		<a href="#" class="close" >&times;</a>
						<strong>Error!</strong> <p id="error_msg">Error Message . </p>
					</div>
            		<div class="card-body">
            			<table id="JDBC_pool" class="table table-striped w-100"  >
		        			<thead>
			            		<tr> 
			            			<th width="160px"></th>
				           		<th width="200px">Alias_Name</th>
				           		<th width="300px">Alias_Description</th>
				           		<th width="150px">Driver</th>
				           		<th width="40px">Status</th>
				           		<th></th>
				           		<th></th>
				           		<th></th>
				           		<th></th>
				           		<th></th>
				           		<th></th>
				           		<th></th>
				           		<th></th>
				           		<th></th>
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
  
  <!-- endinject -->
  <!-- Custom js for this page-->
  <!-- End custom js for this page-->
  <script type="text/javascript" language="javascript" src="js/zebra_datepicker.min.js"></script>
  
  <script type="text/javascript" language="javascript" src="js/util.js"></script>
  <script type="text/javascript" language="javascript" src="js/JDBC_Poll.js"></script>

  <jsp:include page="partials/JDBC_pool_add.jsp"/>
  <script>
  var AliasTable;
  
  var Condition = {} ;
  
  function setTest_Connection(data){
	  
	  Condition.method = "test_conn";
	  
	  Condition.URL = data['URL'];
	  Condition.Account = data['Account']; 
	  Condition.Password = data['Password'];
	  Condition.Driver = data['Driver'];
	  Condition.DataSource_class = data['DataSource_class'];
  }
  
  $(document).ready(function() {
	  checkSession();
	  
	  //ReadyLoader();
	
	  AliasTable = getAliasTable();
	  
	  Condition.method = "AliasTable";
	  
	  refresh_Table(AliasTable);
	  
	  $('body').fadeIn()
	  
	  $('#JDBC_pool').on('click', '#enable_Alias', function(e) {
		  if(confirm("Are you sure you want to change this Alia's status ?")){
			  var data = AliasTable.row($(this).parents('tr')).data();
			  
			  Condition.method = "enable_Alias";
			  Condition.Alias_Name = data['Alias_Name'];
			  Condition.Disabled = data['Disabled'];
			  Condition.Pooling_Enable = data['Pooling_Enable'];
			  
			  refresh_Table(AliasTable);
		  }
	  })
	  
	  $('#serachDiv').on('click', '#add_alia', function(e) {
		  initPage();
		  showAdd_JDBCpool();
	  })
	  
	  $('#JDBC_pool').on('click', '#edit_Alias', function(e) {
		  var data = AliasTable.row($(this).parents('tr')).data(); 
		  
		  setEditJDBC_info(data);
		  showAdd_JDBCpool();
	  })
	  
	  $('#JDBC_pool').on('click', '#delete_btn', function(e) {
		  if(confirm("Are you sure you want to remove this Alia?")){
			  var data = AliasTable.row($(this).parents('tr')).data();
			  if(parseInt(data['Disabled']) == 0){
				  alert('please disable before delete!')
				  return;
			  }else{
				  Condition.method = "delete_alias";
				  Condition.Alias_Name = data['Alias_Name'];
				  refresh_Table(AliasTable);
			  }
		  }
	  })
	  
	  $('.close').click(function(e) {
			$(this).parent().hide();
		  });
	  
  })
  </script>
</body>
</html>