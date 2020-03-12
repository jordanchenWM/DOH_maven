<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Transaction</title>
  <!-- plugins:css -->
  <link rel="stylesheet" href="vendors/css/vendor.bundle.base.css">  
  <link rel="stylesheet" href="vendors/css/vendor.bundle.addons.css">
  <link rel="stylesheet" href="vendors/iconfonts/mdi/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="vendors/iconfonts/font-awesome/css/font-awesome.css">
  
  
  <!--link rel="stylesheet" href="css/jquery.dataTables.css"-->
  <link rel="stylesheet" href="css/zebra_datepicker.css" >
  <link rel="stylesheet" href="css/calendar.css" >
  <link rel="stylesheet" href="css/loader.css">
  <link rel="stylesheet" href="css/style.css">
   <link rel="stylesheet" href="css/custom.css">
   
  <link rel="shortcut icon" href="images/favicon.png" />
 
 <style>

#BizDocContent_Content th ,#Activity_full_message th {
  text-align: center;
}


/*
#detail_table th{
	background-color:  lightslategray !important;
}*/

.mdi-details:before.active {
	transform:rotate(3.14159rad);
}

.background-burlywood {
    background: #e0e5df !important;
}
.icon-clickred {
    color: #8ba2b5 !important;
}
.180_rotate{
	transform: rotate(3.14159rad);
}

</style>
</head>

<body>
<section id="loader" class="loaders"><span class="loader loader-bars"><span> </span></span> Loading...</section>
  <div class="container-scroller" >
    <!-- partial:partials/_navbar.html -->
    <jsp:include page="partials/_navbar.jsp"/>   
    <!-- partial -->
    
    <div class="container-fluid page-body-wrapper">
      <jsp:include page="partials/_sidebar.jsp"/>    
       <div class="main-panel"> 
        <div class="content-wrapper" id="Transaction_div">
          <div class="row">
            <div class="col-md-12 grid-margin">
              <div class="card">
                <div class="card-body" id="displayDiv">
  
                 	<div class="row">
                 	<div class="col-md-5">
                	<div class="form-group row">
                          <label class="col-sm-4 col-form-label">Date</label>
                          <div class="col-sm-8">
                            <select name="date_range" id="date_range" class="form-control">
								<option value='all'>All</option>
								<option value='this_day'>This Day</option>
								<option value='this_week'>This Week</option>
								<option value='this_month'>This Month</option>
								<option value='this_year'>This Year</option>
								<option value='previous_day'>Previous Day</option>
								<option value='previous_week'>Previous Week</option>
								<option value='previous_month'>Previous Month</option>
								<option value='previous_year'>Previous Year</option>
								<option value='last_hour'>Last Hour</option>
								<option value='last_four_hour'>Last Four Hour</option>
								<option value='last_twenty-four_hour'>Last Twenty-Four Hours</option>
								<option value='last_two_days'>Last Two Days</option>
								<option value='last_seven_days'>Last Seven Days</option>
								<option value='last_fourteen_days'>Last Fourteen Days</option>
								<option value='last_thirty_days'>Last Thirty Days</option>
								<option value='last_sixty_days'>Last Sixty Days</option>
								<option value='last_ninety_days'>Last Ninety Days</option>
								<option value='last_year_days'>Last 365 Days</option>
							</select>
                          </div>
                        </div>
                        </div>
                       </div>
				  <div class="row">
                  <div class="col-md-5">
				  <div class="form-group row">
                          <label class="col-sm-4 col-form-label" >開始時間</label>
                          <div class="col-sm-8">
                          		<input type="text" id="start_date" class="form-control"/>
                          </div>
                  </div>
                  </div>
                  </div>
                  
	          	 <div class="row">
	                 <div class="col-md-5 col-sm-12" >
			          	 <div class="form-group row">
		                          <label class="col-sm-4 col-form-label" >結束時間</label>
		                          <div class="col-sm-8">
		                          		<input type="text" id="end_date" class="form-control"/>
		                          </div>
		                  </div>
	                  </div>
	                   <div class="col-md-7 col-sm-12">
	                   		<button id="Refresh" class="btn btn-inverse-primary btn-rounded btn-fw" style="margin-left:5%">
							<i class='fa fa-search'></i>Search</button>
					
							<button id="resummit" class="btn btn-inverse-success btn-rounded btn-fw" style="margin-left:2%;">
							<i class='fa fa-reply'></i>Resummit</button>
	                   </div>
                  </div>
                </div>
                
                <input type="hidden" id="hidePartnerID"/>
	          	<input type="hidden" id="hidePartnerStatus"/>
	          	<input type="hidden" id="hidePartnerOrgUnit"/>
	          		
            	<div class="alert alert-danger">
					<a href="#" class="close" >&times;</a>
					<strong>Error!</strong> <p id="error_msg">Error Message .</p>
				</div>
				
            	<div class="card-body">
            		<table id="BizDoc_log"  class="table table-striped w-100" >
		        		<thead>
			           		<tr> 
			           		<th></th>
				       		<th style="min-width: 120px">Receive Time</th>
				       		<th style="min-width: 100px">DocType</th>
				       		<th style="min-width: 100px">Sender</th>
				       		<th style="min-width: 100px">Receiver</th>
				       		<th style="min-width: 90px">Status</th>
				       		<th style="min-width: 90px">User Status</th>
				       		<th>ConversationID</th>
				       		<th>DocumentID</th>
				       		<th></th>
			           		</tr>
		        		</thead>		        	      
		   			</table>
                </div>
                
                <div class="card-body"  id="BizDoc_Detail" style="display: none">
                	<nav>
                    <div class="nav nav-tabs" id="nav-tab" role="tablist">
                      <a class="nav-item nav-link active" id="nav-activity-tab" data-toggle="tab" href="#nav-activity" role="tab" aria-controls="nav-activity" aria-selected="true">Activity log</a>
                      <a class="nav-item nav-link" id="nav-content-tab" data-toggle="tab" href="#nav-content" role="tab" aria-controls="nav-content" aria-selected="false">Content</a>
                    </div>
                  </nav>
                  <div class="tab-content py-3 px-3 px-sm-0" id="nav-tabContent">
                    <div class="tab-pane fade show active" id="nav-activity" role="tabpanel" aria-labelledby="nav-activity-tab">
                      <table id="Activity_log"  class="table table-striped w-100">
				    		<thead>
				            		<tr>
				            		<th style="min-width: 10px">Type</th>
					           		<th style="min-width: 120px">Receive Time</th>
					           		<th style="min-width: 120px">Brief Message</th>
					           		<th style="min-width: 80px">Entry Class</th>
					           		<th style="min-width: 80px">B2BUser</th>
					           		<th style="min-width: 80px">RelatedPartnerID</th>
					           		<th style="min-width: 10px">Detail</th>
				           			</tr>
		        				</thead>	 	      
		   				</table>
		   				<table id="Activity_full_message" class="table table-striped w-100">
			        			<thead>
				            		<tr> 	            
					           		<th width="100%">FullMessage</th>
				           		</tr>
			        			</thead>		        	      
		   				</table>
                    </div>
                    <div class="tab-pane fade" id="nav-content" role="tabpanel" aria-labelledby="nav-content-tab">
                    	<table id="BizDocContent_log" class="table table-striped w-100">
        						<thead>
	            					<tr> 	            
					           		<th>PartName</th>
					           		<th>ContentLength</th>
					           		<th>MimeType</th>
					           		<th></th>
				           		</tr>
        						</thead>		        	      
   						</table>
   						
   						<table id="BizDocContent_Content" class="table table-striped w-100"  >
			        			<thead>
				            		<tr><th width="100%">Content</th></tr>
			        			</thead>		        	      
			        			<tbody>
			        			 <tr><td>
			        			  <textarea class="w-100" style="border: none; background: #dddddd1f;" rows="8" id="contentXML" disabled></textarea>
			        			</td></tr>
			        			</tbody>
		   				</table>
                    </div>                    
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
  <!--script type="text/javascript" language="javascript" src="js/jquery.dataTables.js"></script-->
  <script type="text/javascript" language="javascript" src="js/Partner_Detail.js"></script>
  <script type="text/javascript" language="javascript" src="js/moment.js"></script>  
  <script type="text/javascript" src="js/util.js"></script>
  <script type="text/javascript" src="js/Transaction.js"></script>
  
  
  <script>
  var BizDocTable;
  var ActivityTable;
  var BizDocContentTable;
  var ActivityFullMessageTable;
  var ContentTable;
  var detailTable;
  
  var Condition = {} ;
  var partner_Info = {};
  
  $(document).ready(function() {
	  
	  checkSession();
	  
	 // ReadyLoader();
	  initDatePicker($('#start_date, #end_date'))
	  
	  BizDocTable = getBizDocTable();
	  detailTable = getPartnerDetailTable();
	  ActivityTable = getActivityTable();
	  BizDocContentTable = getBizDocContentTable();
	  ActivityFullMessageTable = getActivityFullMessageTable();
	  
	  //$('body').fadeIn();
	  
	  $('#Refresh').click(function() {
 		  $('#BizDoc_Detail').hide();
		  
		  setCondition();
		  Condition.method='BizDocTable';
		  
		  refresh_Table(BizDocTable);
	  });
	  
	  $('#BizDoc_log_wrapper').on('click', '.ts_time_btn', function(e) {
		   var btn = $(this).parents('tr').find('#BizDoc_detail_btn');
		   btn.trigger('click');
	  })
	  
	  
	  //第二層 
	  $('#BizDoc_log').on('click', '#BizDoc_detail_btn', function(e) {
		  
		  $('#BizDoc_Detail').show();
		  //$('#tab1').show();
		  //$('#tab2').hide();
		  $('#Activity_full_message').hide();
		  $('#BizDocContent_Content').hide();		  		  
		  
		  Condition.method='ActivityTable';
		  Condition.DocTypeID = BizDocTable.row($(this).parents('tr')).data()['DocTypeID'] 
		  Condition.DocID = BizDocTable.row($(this).parents('tr')).data()['DocID']
		  refresh_Table(ActivityTable)
		  
		  Condition.method='BizDocContentTable';
		  Condition.DocID = BizDocTable.row($(this).parents('tr')).data()['DocID']
		  refresh_Table(BizDocContentTable)
		  $('#BizDoc_Detail').fadeIn();
		  //$('#Activity_log, #BizDocContent_log').addClass("display_table");
		  
		  ClickChange($(this))
		  $('html,body').animate({scrollTop:$('#BizDoc_Detail').offset().top},800)
	  })
	   
	  //第三層  full msg
	  $('#Activity_log').on('click', '#Activity_detail_btn', function(e) {
		   
		  Condition.method='ActivityFullMessageTable';
		  Condition.ActivityLogID = ActivityTable.row($(this).parents('tr')).data()['ActivityLogID'] 
		  refresh_Table(ActivityFullMessageTable)
		  
		  $('#Activity_full_message').fadeIn();
		  ClickChange($(this))
		  $('html,body').animate({scrollTop:$('#Activity_full_message').offset().top},800)
	  })
	  
	  //Content
	  $('#BizDocContent_log').on('click', '#BizDocContent_detail_btn', function(e) {
		  
		  Condition.method='ContentTable';
		  Condition.DocID = BizDocContentTable.row($(this).parents('tr')).data()['DocID'] 
		  Condition.PartName = BizDocContentTable.row($(this).parents('tr')).data()['PartName'] 
		  refreshXML_Table(ContentTable)
		  
		  $('#BizDocContent_Content').fadeIn();
		  ClickChange($(this))
		  $('html,body').animate({scrollTop:$('#BizDocContent_Content').offset().top},800)
	  })
	  
	  $('#date_range').change( function(){
 		  var range = $('#displayDiv #date_range').val();
		  change_range(range)
	  });
	  
	  
	  $('#displayDiv').on('click', '#resummit', function(e) {
		  if(confirm("Are you sure you want to resubmit ?")){
			  var DocIDArray = [];
			  $('#BizDoc_log input:checkbox').each(function() {
				  if ($(this).prop('checked') ==true) {
					  DocIDArray.push(BizDocTable.row($(this).parents('tr')).data()["DocID"]);
				  }
			  });
			  if(DocIDArray.length == 0){
				  alert('You did not select any items to act on. Select one or more items and retry the action')
				  return;
			  }else{
				  console.log(DocIDArray)
				  resummit_check(DocIDArray)
			  }
		  }
	  })
	  
	  
	  $('.close').click(function(e) {
			$(this).parent().hide();
		  });
	  
	  BizDocTable.on('page.dt', function() {
  		$('html, body').animate({
	    scrollTop: $(".dataTables_wrapper").offset().top - 73
	  	}, 'fast');
	  $('.dataTables_scrollBody').scrollTop(0);
	});
	  });
  </script>
</body>
</html>