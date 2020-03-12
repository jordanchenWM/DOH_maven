<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>ServerLog</title>
  <!-- plugins:css -->
  <link rel="stylesheet" href="vendors/iconfonts/mdi/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="vendors/css/vendor.bundle.base.css">
  <link rel="stylesheet" href="vendors/css/vendor.bundle.addons.css">
  <link rel="stylesheet" href="css/loader.css">
  
  <link rel="stylesheet" href="css/style.css">

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
.form-group {
	margin-right: 10px;
}
.alert {
	display: none;
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
              	<div class="card-body">
              		<h4 class="card-title">Log display controls</h4>
              		<div class="form-radio">
                    		<label class="form-check-label">
                     	<input type="radio" class="form-check-input" name="sequence" id="Ascending" value="Ascending" > Ascending sequence
                     	<i class="input-helper"></i></label>
                     </div>
                     <div class="form-radio">
                    		<label class="form-check-label">
                     	<input type="radio" class="form-check-input" name="sequence" id="Descending" value="Descending" checked> Descending sequence
                     	<i class="input-helper"></i></label>
                     </div>
                     
                     <div class="form-inline">  
                     	<div class="form-group row"> 
                       	 	<label class="col-sm-6">顯示行起點:</label>
                       		<input type="number" min="0" id="first_display" value="0" class="form-control col-sm-6">
                       	 </div>
                      	<div class="form-group row">
                          <label class="col-sm-6">顯示行數:</label>
                          <input type="number" min="0" id="display_number" class="form-control col-sm-6" value="40">                          
                        </div>
                      	<div class="form-group">
                      		<button id="refresh_btn" class="btn btn-inverse-primary btn-rounded btn-fw" >Refresh</button>
                      	</div>
                    </div>
                    
              	</div>              	
              </div>
            </div>
            <div class="col-md-12 grid-margin">
              <div class="card">
            		<div class="alert alert-danger">
				  <a href="#" class="close" >&times;</a>
					<strong>Error!</strong> <p id="error_msg">Indicates a successful or positive action.</p>
				</div>
            		<table id="ServerLog" border=1 solid>
                </table>
              </div>
            </div>
          </div>
        </div>
        <jsp:include page="partials/_footer.html"/>    
      </div>
    </div>
  </div>
  
  <script type="text/javascript" src="js/util.js"></script>
  <script>

  $( document ).ready(function() {
	  
	checkSession();
	  	
	//ReadyLoader();
	    
	var Info = {};
	  
	$('body').fadeIn();
	  
	function logDisplayInfo() {
		
		Info.sequence = $('input[name=sequence]:checked').val();
		Info.first_line = $('#first_display').val();
		Info.display_number = $('#display_number').val();
	}
	
	$('.close').click(function(e) {
		$(this).parent().hide();
	});
	  	
	$('#refresh_btn').click(function(e) {
		logDisplayInfo();
    		startLoader();
    		$.ajax({		
			url: "SeverlogSeverlet",
			type: "POST",
			data: Info ,
		    dataType:"text",  
			success:function(data) {
					$('#ServerLog').html(data);
			},
		    error: function (xhr) {
			    //alert(xhr.responseText);
			    var rs = xhr.responseText;
			    if (rs.length > 400) {
			    		rs = rs.substring(0, 400) + "... ..."
			    }
			    
			    $('#error_msg').text(rs);
			    $('.alert').show();
		    }
		});
    		stopLoader()
	});
	
	$('#refresh_btn').trigger('click');
		    	
	});
	</script>
</body>
</html>