<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Setting</title>
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
 #ServerLog {
	font-size:13px;
	line-height:1.7;
    width: 100%;
}
#ServerLog td{
	border-color:#DDDDDD;
}
.display_inlineblock{
  display:inlineblock;
}
.display_block{
  display:block;
}
</style>
  
</head>

<body style="display:none">

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
					<textarea id="config" cols="60" rows="8" >
					
					</textarea>
					<button id="Refresh" class="display_inlineblock btn btn-primary" style="margin-left:15px">Refresh</button>
					<button id="Save" class="display_inlineblock btn btn-primary" style="margin-left:15px">Save</button>
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

  <script type="text/javascript" src="js/util.js"></script>
  
  <script>

  var method ;
  
  $( document ).ready(function() {
	  checkSession();
	  
	  //ReadyLoader();
	  
	  $('body').fadeIn();
	  function sendContent() {
		  startLoader();
		  $.ajax({		
			  url: "ConfigServlet",
			  type: "POST",
			  data: {"ConfigContent" : $('#config').val() ,
				 	 "method" : method } ,
		      dataType:"text",  
			  success:function(data) {
				  $('#config').val(data);
			  },
			  error: function (xhr) {
				  alert(xhr.responseText);
			  }
		  });
		  stopLoader();
	  }
	  	
	  $('#displayDiv').on('click', '#Refresh', function(e) {
		  
		  method = "refresh";
		  
		  sendContent();
	  })
	  
	  $('#displayDiv').on('click', '#Save', function(e) {
		  
		  method = "save";
		  
		  sendContent();
	  })
	    
  	  $('#Refresh').trigger('click');
		    	
  });
</script>
</body>
</html>