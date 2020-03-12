<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Partner Profiles</title>
    
  <link rel="stylesheet" href="vendors/css/vendor.bundle.base.css">
  <link rel="stylesheet" href="vendors/css/vendor.bundle.addons.css">
  <link rel="stylesheet" href="vendors/iconfonts/mdi/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="vendors/iconfonts/font-awesome/css/font-awesome.css">
  
  <link rel="stylesheet" href="css/loader.css">
  <link rel="stylesheet" href="css/zebra_datepicker.css" >
  
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/custom.css">
  
 <style>
 
.material-icons.md-24 { 
	font-size: 24px; 
	line-height: 50%; 
	width:100%;
	height: 100%;
}



</style>
</head>

<body >
<input type="hidden" id="hidePartnerID" ></input> 
<input type="hidden" id="hidePartnerStatus"></input>
<input type="hidden" id="hidePartnerOrgUnit"></input>

<section id="loader" class="loaders"><span class="loader loader-bars"><span> </span></span> Loading...</section>
  <div class="container-scroller">
   <jsp:include page="partials/_navbar.jsp"/>   
    <div class="container-fluid page-body-wrapper">
      <jsp:include page="partials/_sidebar.jsp"/>    
       <div class="main-panel"> 
        <div class="content-wrapper">
          <div class="row">
            <div class="col-md-12 grid-margin">
              <div class="card">
              	
              	<div class="alert alert-danger">
				  		<a href="#" class="close" >&times;</a>
						<strong>Error!</strong> <p id="error_msg">Error Message .</p>
				</div>
				
                <!-- main_div -->
				<div id="main_div">
	              	<div class="card-body" id="serachDiv" >
	              		<button id="add_partner" class="btn btn-inverse-primary btn-rounded btn-fw">
						<i class='mdi mdi-account-plus'></i>Add Partner</button>				
	              	</div>
	              	
	              	<div class="card-body">
	           			<table id="Partner"  class="table table-striped w-100" >
	           			<thead>
			            		<tr> 	            
				           		<th width=10% ></th>
				           		<th width=30%>Partner</th>
				           		<th width=30%>Status</th>
				           		<th width=30%>Last Modify</th>
				           		<th></th>
				           		<th></th>
			           		</tr>
		        			</thead>		        	      
		   				</table>
	               	</div>               	
               	</div>
               	<!-- end of main_div -->
               	
               	<!-- detail_div -->
               	<div id="detail_div" style="display:none;">
               		<div class="card-body">               		
               			<table>
               				<tr><td>Partner :</td><td id="corporation"></td></tr>
               				<tr><td>Status :</td><td id="status"></td> </tr>
               			</table>
               		
               		<!-- buttons -->
               		<div style="margin-top:2%;" >               			
               		
               			<button id="back" class="btn btn-icons btn-rounded btn-inverse-danger" >
						<i class='mdi mdi-keyboard-backspace'></i></button>	
						
						<button id="edit_partner" class="btn btn-light btn-rounded btn-fw" >
						<i class='mdi mdi-account-edit'></i>Edit</button>
						
						<button id="add_detail" class="btn btn-light btn-rounded btn-fw " >
						<i class='fa fa-plus'></i>Add ID</button>
						
						<button id="add_Delivery" style="display:none" class=" btn btn-light btn-rounded btn-fw " >
						<i class='fa fa-plus'></i>Add Delivery</button>
					</div>
					<!-- end of buttons -->
					</div>
					
					<div class="card-body" >
						<nav>
		                    <div class="nav nav-tabs" id="nav-tab" role="tablist">
		                      <a class="nav-item nav-link active" id="nav-ids-tab" data-toggle="tab" href="#nav-ids" role="tab" aria-controls="nav-ids" aria-selected="true">External IDs</a>
		                      <a class="nav-item nav-link" id="nav-delivery-tab" data-toggle="tab" href="#nav-delivery" role="tab" aria-controls="nav-delivery" aria-selected="false">Delivery</a>
		                    </div>
	                  </nav>
					  <div class="tab-content py-3 px-3 px-sm-0" id="nav-tabContent">
					  		<div class="tab-pane fade show active" id="nav-ids" role="tabpanel" aria-labelledby="nav-ids-tab">
					  			<table id="detail_table" class="table table-striped w-100"  >
					        			<thead>
					        				<tr> 	 
						            		<th width="10%"></th>           
							           		<th width="200px">Field</th>
							           		<th width="200px">Value</th>
						           			</tr>
					        			</thead>		        	      
				   				</table>
					  		</div>
					  		<div class="tab-pane fade" id="nav-delivery" role="tabpanel" aria-labelledby="nav-delivery-tab">
									<p  >Preferred Protocol: <span id="protocol"></span></p>
									<div id="method" style="margin-top:2%;">
						  </div>
					  </div>
				</div>
               	<!-- end of detail_div -->
              	</div>
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

  <script type="text/javascript" src="js/util.js"></script>
  <script type="text/javascript" src="js/Partner Profiles.js"></script>
  <script type="text/javascript" language="javascript" src="js/Partner_Delivery.js"></script>
  <script type="text/javascript" language="javascript" src="js/Partner_Detail.js"></script>
  
  
 <jsp:include page="partials/partner_Add.jsp"/>
 <jsp:include page="partials/partner_ID_add.jsp"/> 
 <jsp:include page="partials/partner_Delivery_add.jsp" />

 <jsp:include page="partials/fieldType_add.jsp" />
  
  <script>
  var PartnerTable ;
  var Condition = {} ;
  var PartnerSeach ;
  
  $(document).ready(function() {
	  checkSession();
	  
	  //ReadyLoader();
	  
	  PartnerTable = getPartnerTable();
	  detailTable = getPartnerDetailTable();
	  
	  Condition.method = 'PartnerTable';
	  FirstRefresh_Table(PartnerTable);
	  
	  
	  //main div
	  $('#add_partner').click(function() {
		  initPage();
		  showAdd_Partner();
	  });
	  
	  
	  //detail div
	  $('#back').click(function() {
		    Condition.method = 'PartnerTable';
			refresh_Table(PartnerTable);
		  	$('#main_div, #detail_div').toggle();
	  });
	  
	  $('#add_detail').click(function() {
		   Condition.hidePartnerID = $('#hidePartnerID').val();
		   initDetailPage();
		   showAdd_Detail();
	  });
	  
	  $('#edit_partner').click(function() {
		  setEditPartner();
		  showAdd_Partner();
	  });
	  
	  
	  $('#Partner').on('click', '#remove_btn', function(e) {
		  if (confirm('Are you sure you want to remove this partner?')){
			  var data = PartnerTable.row($(this).parents('tr')).data();
			  
			  Condition.method='partner_delete';
			  Condition.PartnerID = data['PartnerID'];
			  refresh_Table(PartnerTable)
		  }
	  })
	  
	  $('#Partner').on('click', '#Partner_href', function(e) {
		  
		  var data = PartnerTable.row($(this).parents('tr')).data();
		  
		  Condition.method='Detail';
		  Condition.PartnerID = $(this).attr("value")
		  $('#corporation').html(data['CorporationName']);
		  
		  if (data['Status'] == 1){
			  $('#status').html("<i class='mdi mdi-check icon-green material-icons md-24 '></i>") 
		  } else{
			  $('#status').html("<i class='mdi mdi-close-circle-outline icon-red material-icons md-24 '></i>")
		  }
		  
		  $('#hidePartnerID').val(data['PartnerID'])
		  $('#hidePartnerStatus').val(data['Status']); 
		  $('#hidePartnerOrgUnit').val(data['OrgUnitName']);
		  
		  refresh_PartnerTable(detailTable, Condition)
		  
		  //$('#detail_table').addClass("display_table");
		  
		  $('#main_div, #detail_div').toggle();
		  
		  appendProtocol($('#hidePartnerID').val())
		  appendMethod($('#hidePartnerID').val(), $('#method'))
	  });
	  
	  $('#nav-tab .nav-link').click(function() {
		  $('#add_detail').toggle();
		  $('#add_Delivery').toggle();
	  });
	  
	   
	
	  
	  
	 
	  
	 
	  
/*
	  $("#tabs-nav a").click(function() {
	      $("#tabs-nav a").removeClass("tabs-active");
	      $(this).addClass("tabs-active");
	      $(".tabs-panel").hide();
	      $(".tabs-panel").removeClass("display_table");
	      var tab_id = $(this).attr("href");
	      $(tab_id).addClass("display_table");
	      $(tab_id).fadeIn();
	      return false;
      });*/

	  
	  $('#add_Delivery').click(function() {
		  showAdd_Delivery();
		  initDeliveryPage();
	  });
	  /*
	  $('#tab2').on('click', '#add_Delivery', function(e) {		  
		  showAdd_Delivery();
		  initDeliveryPage();
	  })*/
	  
  })
  </script>
</body>
</html>