<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Processing Rule</title>
  <!-- plugins:css -->
  <link rel="stylesheet" href="vendors/iconfonts/mdi/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="vendors/css/vendor.bundle.base.css">
  <link rel="stylesheet" href="vendors/css/vendor.bundle.addons.css">
  <link rel="stylesheet" href="css/loader.css">
  <link rel="stylesheet" href="css/zebra_datepicker.css" >
  <!-- endinject -->	

  <!-- inject:css -->
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/custom.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="images/favicon.png" />
 
 <style>

.width-100 {
	width:100%;
}
.color_blue {
  background-color: 	#4682B4 !important;
}
.material-icons.md-24 { 
	font-size: 24px; 
	line-height: 50%; 
	width:100%;
	height: 100%;
}
.font-14 {
	font-size: 14px; 
}
.display_table{
	display:table;
	width:100% !important;
}
.icon-red {
    color: red !important;
}
.icon-green {
    color: #32CD32;
}
.margin_top3 {
	margin-top:3%;
}
.alert {
	display: none;
} 
</style>
</head>
<body>
<section id="loader" class="loaders"><span class="loader loader-bars"><span> </span></span> Loading...</section>
  <div class="container-scroller">
    <!-- partial:partials/_navbar.html -->
    <jsp:include page="partials/_navbar.jsp"/>
    <!-- partial -->
    
    <div class="container-fluid page-body-wrapper">
      <jsp:include page="partials/_sidebar.jsp"/>    
       <div class="main-panel"> 
        <div class="content-wrapper">
          <div class="row">
            <div class="col-md-12 grid-margin">
              <div class="card">
                <div class="card-body" id="serachDiv" style="margin-left:2%">
                	<input type="hidden" id="hidePartnerID"/>
	          		<input type="hidden" id="hidePartnerStatus"/>
	          		<input type="hidden" id="hidePartnerOrgUnit"/>
               		<button id="add_ProcessingRule" class=" btn btn-primary">
					<i class='mdi mdi-yeast material-icons md-24'></i>Add</button>
		            		
            		</div>
            		<div class="alert alert-danger">
				  		<a href="javascript:void(0)" class="close" >&times;</a>
						<strong>Error!</strong> <p id="error_msg">Indicates a successful or positive action.</p>
					</div>
            		<div class="card-body">
            			<table id="Processing_table" class="table table-striped w-100">
		        			<thead>
		        				<tr> 	            
				           		<th width="50px"></th>
				           		<th width="50px">Index</th>
				           		<th width="130px">RuleName</th>
				           		<th width="150px">RuleDescription</th>
				           		<th width="70px">Status</th>
				           		<th width="100px">Sender</th>
				           		<th width="100px">Receiver</th>
				           		<th width="130px">DocType</th>
				           		<th width="400px">SERVICE</th>
				           		<th width="150px">LastModified</th>
				           		<th width="10px"></th>
				           		<th width="10px"></th>
				           		<th width="10px"></th>
				           		<th width="10px"></th>
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

  <script type="text/javascript" src="js/zebra_datepicker.min.js"></script>
  <script type="text/javascript" src="js/util.js"></script>
  <script type="text/javascript" src="js/Processing_Rule.js"></script>
  <script type="text/javascript" src="js/Partner_Detail.js"></script>
  
  <jsp:include page="partials/processing_rule_add.jsp"/>
  
  <script>
  var ProcessTable;
  
  var Condition = {} ;
  $(document).ready(function() {
	  checkSession();
	  
	  //ReadyLoader();
	  
	  detailTable = getPartnerDetailTable();
	  ProcessTable = getProcessTable();
	  Condition.method = 'getProcessingTable';
	  refresh_Table(ProcessTable);
	  
	  $('#serachDiv').on('click', '#add_ProcessingRule', function(e) {
		  
		  initRulePage();
		  showAdd_RuleAdd();
	  })
	  
	  $('#Processing_table').on('click', '#remove_btn', function(e) {
		  
		  if(confirm('Are you sure you want to remove this processing rule ?')){
			  Condition.method = "delete";
			  Condition.RuleID = ProcessTable.row($(this).parents('tr')).data()['RuleID']; 
			
			  refresh_Table(ProcessTable);
		  }
	  })
	  
	  $('#Processing_table').on('click', '#edit_btn', function(e) {
		  var data = ProcessTable.row($(this).parents('tr')).data();
		
		  setEditSchedule_info(data);
		  showAdd_RuleAdd();
	  })
	  
	  
  })
  </script>
</body>
</html>