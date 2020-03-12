<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script src="vendors/js/vendor.bundle.base.js"></script>
  <script src="vendors/js/vendor.bundle.addons.js"></script>
   <script type="text/javascript" language="javascript" src="js/zebra_datepicker.min.js"></script>
<script type="text/javascript" language="javascript" src="js/util.js"></script>

 <link rel="stylesheet" href="css/zebra_datepicker.css" >
  

<title>Insert title here</title>
</head>
<body>
<span class ="display_block display_new_partner_margin_top" >
	      			<label class="display_new_partner_range">Start Time* :</label>
		       		<input type="text" name="StartTime" id="StartTime" class="border rounded"/>
		      	</span>
		      	
		      	<span class ="display_block display_new_partner_margin_top" >
	      			<label class="display_new_partner_range">End Time :</label>
		       		<input type="text" name="EndTime" id="EndTime" class="border rounded"/>
		      	</span>
</body>
<script type="text/javascript">

initDatePicker($('#StartTime, #EndTime'));
$(document).ready(function() {
	$('#EndTime').val("2019-03-19  18:24").data('Zebra_DatePicker')
})
</script>
</html>