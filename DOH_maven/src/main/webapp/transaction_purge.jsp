<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Transaction purge</title>
  <!-- plugins:css -->
  <link rel="stylesheet" href="vendors/iconfonts/mdi/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="vendors/css/vendor.bundle.base.css">
  <link rel="stylesheet" href="vendors/css/vendor.bundle.addons.css">
  <link rel="stylesheet" href="css/loader.css">
  <!-- endinject -->
  <!-- plugin css for this page -->
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <link rel="stylesheet" href="css/style.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="images/favicon.png" />
 
 <style>
.display_inlineblock{
  display:inlineblock;
}
.display_block{
  display:block;
}
.margin_5 {
	margin-top:5%;
}
</style>
  
</head>

<body style="display:none">
<section id="loader" class="loaders"><span class="loader loader-bars"><span> </span></span> Loading...</section>
  <div class="container-scroller">
    <!-- partial:partials/_navbar.html -->
   <jsp:include page="partials/_navbar.jsp"/>
    <!-- partial -->
    
    <div class="container-fluid page-body-wrapper">
      <!-- partial:partials/_sidebar.html -->
      <jsp:include page="partials/_sidebar.jsp"/>  
      <!-- partial -->
      <div class="main-panel"> 
        <div class="content-wrapper">
          <div class="row">
            <div class="col-md-12 grid-margin">
              <div class="card">
                  <div class="card-body" id="displayDiv">
					<div style="margin-top:1%">
		            		<span class="display_block">
							<label class="display_div_label_range">Number of days to retain (Ending with Today) :</label>
							<input id="start_day" class="display_div_label_range border rounded" value="30" onkeyup="value=value.replace(/[^\d]/g,'')"/>
						</span>	
		            	
		            		<span class="display_inlineblock margin_5">
							<label class="display_div_label_range">Archiving Batch Size :</label>
							<input id="size" class="display_div_label_range border rounded" value="10000" onkeyup="value=value.replace(/[^\d]/g,'')"/>
							
							<button id="Delete" class="display_inlineblock btn btn-primary" style="margin-left:15%">Delete</button>
            					<label class="display_inlineblock display_text_margin" style="margin-left:3%;color:red;font-size:18px;display:none" id="finish_word">Delete Finished</label>
						</span>	
						
            			</div>
            		</div>
              </div>
            </div>
          </div>
        </div>
        <!-- content-wrapper ends -->
        <jsp:include page="partials/_footer.html"/>    
        <!-- partial -->
      </div>
      <!-- main-panel ends -->
    </div>
    <!-- page-body-wrapper ends -->
  </div>
  <!-- container-scroller -->

  <!-- plugins:js -->  
  <script type="text/javascript" src="js/util.js"></script>
  
  <script>

  $(document).ready(function() {
	  checkSession();
	  	
	  //ReadyLoader();
	   
	  $('body').fadeIn();
	  
	  $('#displayDiv').on('click', '#Delete', function(e) {	
  		
  		startLoader();
  		$.ajax({		
			url: "TransactionServlet",
			type: "POST",
			data: { "method" : "transaction_purge" , 
					"start_day" : $('#displayDiv #start_day').val(),
					"size" : $('#displayDiv #size').val(),} ,
			success:function(data) {
					$('#finish_word').show(0,stopLoader())
			},
		    error: function (xhr) {
			    alert(xhr.responseText);
		    }
		});
  		
  	  })
  })
  </script>
</body>
</html>