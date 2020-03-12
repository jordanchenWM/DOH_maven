<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>DocumentType Management</title>
  <!-- plugins:css -->
   <link rel="stylesheet" href="vendors/css/vendor.bundle.base.css">
  <link rel="stylesheet" href="vendors/css/vendor.bundle.addons.css">
  <link rel="stylesheet" href="vendors/iconfonts/mdi/css/materialdesignicons.min.css">

  <link rel="stylesheet" href="css/loader.css">
  <link rel="stylesheet" href="css/zebra_datepicker.css" >
  <!-- endinject -->	

  <!-- inject:css -->
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/custom.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="images/favicon.png" />
 
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
               		<button id="add_DocumentType" class=" btn btn-primary">
					<i class='mdi mdi-account-plus'></i>Add</button>
            		</div>
            		<div class="alert alert-danger">
				  		<a href="javascipt:void(0)" class="close" >&times;</a>
						<strong>Error!</strong> <p id="error_msg">Error Message . </p>
					</div>
            		<div class="card-body">
            			<table id="DocumentType_table" class="table table-striped w-100"  >
		        			<thead>
		        				<tr> 	            
				           		<th width="50px"></th>
				           		<th width="250px">TypeName</th>
				           		<th width="200px">TypeDescription</th>
				           		<th width="70px">Status</th>
				           		<th width="150px">LastModified</th>
				           		<th width="130px">RootTag</th>
				           		<th width="100px">ReceiverType</th>
				           		<th width="200px">ReceiverPath</th>
				           		<th width="100px">SenderType</th>
				           		<th width="200px">SenderPath</th>
				           		<th width="200px">DocumentPath</th>
				           		<th width="200px">ConversationPath</th>
				           		<th width="200px">SchemaPath</th>
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
  
  <!-- End custom js for this page-->
  <script type="text/javascript" language="javascript" src="js/zebra_datepicker.min.js"></script>
  
  <script type="text/javascript" language="javascript" src="js/util.js"></script>
  <script type="text/javascript" language="javascript" src="js/DocumentType_profile.js"></script>
  
  <jsp:include page="partials/documentType_add.jsp"/>
  
  <script>
  var documentTypeTable;
  
  var Condition = {};
  
  $(document).ready(function() {
	  checkSession();
	  
	  //ReadyLoader();
	
	  documentTypeTable = getDocumentTypeTable();
	  
	  Condition.method = "DocumentTypeTable";
	  
	  refresh_Table(documentTypeTable);
	  
	  urlParam = function(name) {
		  var results = new RegExp('[\\?&]' + name + '=([^&#]*)').exec(window.location.href);
		  if (!results) { return 0; }
		  return results[1] || 0;
	  }
	  console.log(urlParam("pp"));
	   
	  documentTypeTable.search(urlParam("TypeName"));
	  
	  
	  //parents('tbody').children('tr').children('td').removeClass("background-burlywood");
	 //	button.parents('tr').children('td').addClass("background-burlywood");
	  function delete_summit(data){
		  
		  Condition.method='documentType_delete';
		  Condition.TypeID = data['TypeID'];
		  refresh_Table(documentTypeTable)
	  }
	  
	  $('#serachDiv').on('click', '#add_DocumentType', function(e) {
		  
		  initPage();
		  showAdd_DocumentType();
	  })
	  
	  $('#DocumentType_table').on('click', '#remove_btn', function(e) {
		  
		  if(confirm('Are you sure you want to remove this DocumentType?')){
			  var data = documentTypeTable.row($(this).parents('tr')).data();
			  var ID = data['TypeID'];
				 $.ajax({		
				  		url: "DocumentTypeServlet",
				  		type: "POST",
				  		data: {	
				  				"method" : "checkDocumentExist" ,
				  				"ID" :  ID ,	
				  			  },
				  		success: function(datas) {
				        	  	if(datas == true){
				        	  		alert("Bizdoc已有資料！")
				        	  	}else{
				        	  		delete_summit(data);
				        	  	}
				        	},
				  		error: function (xhr) {
			          		stopLoader();
			          		alert(xhr.responseText);
				  		}
				 });
		  }
	  })
	  
	  $('#DocumentType_table').on('click', '#edit_btn', function(e) {
		  
		  var data = documentTypeTable.row($(this).parents('tr')).data();
		  
		  setEditPage(data)
		  
		  showAdd_DocumentType();
	  })
	  
  })
  </script>
</body>
</html>