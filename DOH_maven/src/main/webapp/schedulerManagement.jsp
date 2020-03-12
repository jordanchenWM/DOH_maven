<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Schedule Management</title>
  <!-- plugins:css -->
  <link rel="stylesheet" href="vendors/iconfonts/mdi/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="vendors/css/vendor.bundle.base.css">
  <link rel="stylesheet" href="vendors/css/vendor.bundle.addons.css">
  <link rel="stylesheet" href="css/zebra_datepicker.css" >
  
  <link rel="stylesheet" href="css/loader.css">
  <link rel="stylesheet" href="css/style.css">
   <link rel="stylesheet" href="css/custom.css">
   
  <link rel="shortcut icon" href="images/favicon.png" />
 
 <style>
#Schedule_table_wrapper{	
	min-width:100%;
}
</style>

</head>

<body>
<section id="loader" class="loaders"><span class="loader loader-bars"><span> </span></span> Loading...</section>
  <div class="container-scroller">
    <!-- span id="nav"></span-->
    <jsp:include page="partials/_navbar.jsp"/>    
    <div class="container-fluid page-body-wrapper">
      <!-- span id="sidebar"></span-->
      <jsp:include page="partials/_sidebar.jsp"/>    
       <div class="main-panel"> 
        <div class="content-wrapper">
          <div class="row">
            <div class="col-md-12 grid-margin">
              <div class="card">
                	<div class="card-body" id="serachDiv">
                		<div class="alert alert-danger">
					  		<a href="#" class="close" >&times;</a>
							<strong>Error!</strong> <p id="error_msg">Error Message .</p>
						</div>
               			<button id="add_Schedule" class="btn btn-inverse-primary btn-rounded btn-fw">
						<i class='mdi mdi-yeast material-icons md-24'></i>Add</button>		            	
            		</div>
            		
            		<div class="card-body">            			
            			<table id="Schedule_table" class="table table-striped w-100" >
		        			<thead>  
		        				<tr> 	            
				           		<th width="50px"></th>
				           		<th width="200px">Task Name</th>
				           		<th width="70px">Status</th>
				           		<th width="100px">Action</th>
				           		<th width="150px">Description</th>
				           		<th width="150px">Service</th>
				           		<th width="120px">Start Time</th>
				           		<th width="120px">End Time</th>
				           		<th width="110px">Next Run</th>
				           		<th width="250px">Last Error</th>
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
  
  <jsp:include page="partials/schedule_add.html"/>    
  
  <script type="text/javascript" language="javascript" src="js/zebra_datepicker.min.js"></script>
  <script type="text/javascript" language="javascript" src="js/util.js"></script>
  <script type="text/javascript" language="javascript" src="js/SchedulerManagement.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.9/validator.min.js"></script>
   

  
  <script>
  var scheduleTable;
  
  
  $(document).ready(function() {
	  checkSession();
	  
	  //ReadyLoader();
	  //$("#schedule_add").load("partials/schedule_add.html");
	  
	  scheduleTable = getScheduleTable();
	  var condition = {};
	  condition.method = 'ScheduleTable';
	  
	  refresh_Table(scheduleTable, condition);
	  
	  $('#add_Schedule').click(function() {
		  initPage();		  
		  showAdd_Schedule();
	  });
	  
	  $('#Schedule_table').on('click', '#edit_schedule', function(e) {
			var data = scheduleTable.row($(this).parents('tr')).data();
			setEditSchedule_info(data);
			showAdd_Schedule();
	  });
	  
	  
	  $('#Schedule_table').on('click', '#Active_btn', function(e) {
		  if (confirm("Are you sure you want to active task?")){

			  var condition = {};
			  condition.method = "active";
			  condition.UUID = scheduleTable.row($(this).parents('tr')).data()['UUID'];
			  refresh_Table(scheduleTable, condition);
		  }
	  });
	
	  //suspended schedule
	  $('#Schedule_table').on('click', '#Suspended_btn', function(e) {
		  if (confirm("Are you sure you want to suspend task?")) {
			  
			  var condition = {};
			  condition.method = "suspended";
			  condition.UUID = scheduleTable.row($(this).parents('tr')).data()['UUID']; 
			  refresh_Table(scheduleTable, condition);
		  }
	  });
	  
	  //delete schedule
	  $('#Schedule_table').on('click', '#delete_btn', function(e) {
		  
		  console.log(scheduleTable.row($(this).parents('tr')).data()["STATE"])
		  
		  var data = scheduleTable.row($(this).parents('tr')).data();
		  if (parseInt(data["STATE"]) == 1) {
				alert("schedule in running!")
				return;
		  } 
		  
		  if (confirm('Are you sure you want to remove this task?')) {
			  var condition = {};
			  condition.method = "delete";
			  condition.UUID = data['UUID']; 
			  
			  refresh_Table(scheduleTable, condition);
		  }
	  });
	  
	
  })
  </script>
</body>
</html>