<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Partner Profiles</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
.modal-dialog,
.modal-content {
    /* 80% of window height */
    height: 90%;
    max-width: 62%;
    margin: 30px auto;
}
.modal-body {
    overflow-y: scroll;
}
.modal {
	overflow-y: hidden !important;
}
#exampleModalLabel{
	font-weight: bold;
}
#Delivery_Add_Page{
	height:80% !important;
}
</style>
</head>
<body>
<div class="modal fade" id="Delivery_Add_Page" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog modal-md" role="document">
	    <div class="modal-content" >
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">New Delivery</h5>
	        
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	       	<div class = display_block>
	       	<input type="hidden" id="HidedeliveryID" />
	       	<p class ="display_block add_field">Delivery Infomation</p>
	       	
	      		<span class ="form-group row" id="deMethod">
	      			<label class="col-sm-3 col-form-label">Delivery Protocol :</label>
	      			<select name="delivery_protocol" id="delivery_protocol" class="form-control col-sm-5">
					<option value=''>請選擇</option>
					</select>
	      		</span>
	      		
	      		<span class ="form-group row margin_top_5" id="deMethod">
	      			<label class="col-sm-3 col-form-label">Delivery Type :</label>
	      			<select name="delivery_tpye" id="delivery_type" class="form-control col-sm-5">
					<option value=''>請選擇</option>
					</select>
	      		</span>
	      		
	      		<span class ="form-group row margin_top_5" style="display:none" id="name_span" >
	      			<label class="col-sm-3 col-form-label" id="protocol"></label>
	      			<input type="text" name="Method_name" id="Method_name" class="border rounded form-control col-sm-5"/>
	      		</span>
	      		
	      		<span class ="form-group row margin_top_5" >
	      			<label class="col-sm-3 col-form-label">Host :</label>
	      			<input type="text" name="host" id="host" class="border rounded form-control col-sm-5"/>
	      		</span>
	      		
	      		<span class ="form-group row margin_top_5">
	      			<label class="col-sm-3 col-form-label">*Port:</label>
					<input type="number" name="port" id="port" class="border rounded form-control col-sm-5"/>
	      		</span>
	      		
	      		<span class ="form-group row margin_top_5" >
	      			<label class="col-sm-3 col-form-label">*Location :</label>
	      			<input type="text" name="location" id="location" class="border rounded form-control col-sm-5"/>
	      		</span>
	      		
	      		<span class ="form-group row margin_top_5" >
	      			<label class="col-sm-3 col-form-label">User Name:</label>
	      			<input type="text" name="user_name" id="user_name" class="border rounded form-control col-sm-5"/>
	      		</span>
	      		
	      		<span class ="form-group row margin_top_5" >
	      			<label class="col-sm-3 col-form-label">Password :</label>
	      			<input type="password" name="password" id="password" class="border rounded form-control col-sm-5"/>
	      		</span>
	      		
		      	<span class="form-group row margin_top_5">
					<label class="col-sm-3 col-form-label">Preferred protocol:</label>
					<input type="checkbox" name="preferred" id="preferred" class="margin_top_2"/>
				</span>
	      	</div>
	       </div>
           <div class="modal-footer">
	           <button id="save_newDelivery" class="btn btn-primary">新增</button>
	           <button class="btn btn-secondary" data-dismiss="modal">關閉</button>
	       </div>	
	    </div>
      </div>			
</div>		
	<script type="text/javascript">
	
	var Delivery_Info = {};
	
	function showAdd_Delivery() {
		$('#Delivery_Add_Page').modal();	
	}
	
	function initDeliveryPage() {	
		checkSession();
		
		initProtocol($('#delivery_protocol'));
		initType($('#delivery_type'))
		
		$('#Delivery_Add_Page #deMethod').show()
		$('#Delivery_Add_Page #name_span').hide();
		$('#delivery_method, #host, #port, #location, #user_name, #password').val("");
		$('#Delivery_Add_Page #preferred').prop('checked', false)
		Delivery_Info.method = 'Delivery_add'
		$('#save_newDelivery').html('新增');
	}
	
	function setDelivery_Info() {
		
		Delivery_Info.HideDeliveryID = $('#Delivery_Add_Page #HidedeliveryID').val();
		Delivery_Info.PartnerID = $('#hidePartnerID').val();
		Delivery_Info.host = $('#Delivery_Add_Page #host').val();
		Delivery_Info.port = $('#Delivery_Add_Page #port').val();
		Delivery_Info.location = $('#Delivery_Add_Page #location').val();
		Delivery_Info.user_name =  $('#Delivery_Add_Page #user_name').val() ;
		Delivery_Info.password = $('#Delivery_Add_Page #password').val();
		Delivery_Info.preferred = $('#Delivery_Add_Page #preferred').prop("checked");
		
		if($('#Delivery_Add_Page #delivery_type').val() == "Other"){
			Delivery_Info.delivery_method = $('#Delivery_Add_Page #delivery_protocol').val() +"-"+ $('#Delivery_Add_Page #Method_name').val();
		}else{
			Delivery_Info.delivery_method = $('#Delivery_Add_Page #delivery_protocol').val() +"-"+ $('#Delivery_Add_Page #delivery_type').val();
		}
			
	}
	
	function setEditDeliveryPage(data) {
		initDeliveryPage();
		$('#Delivery_Add_Page #deMethod').hide()
		
		$('#Delivery_Add_Page #HidedeliveryID').val(data['DeliveryID']);
		$('#Delivery_Add_Page #host').val(data['Host']);
		$('#Delivery_Add_Page #port').val(data['Port']);
		$('#Delivery_Add_Page #location').val(data['Location']);
		$('#Delivery_Add_Page #user_name').val(data['UserName']);
		$('#Delivery_Add_Page #password').val(data['Password']);
		if(data['Preferred'] == 0){
			$('#Delivery_Add_Page #preferred').prop("checked", false);
		}else
			$('#Delivery_Add_Page #preferred').prop("checked", true);
		
		Delivery_Info.method = 'Delivery_edit'
		$('#save_newDelivery').html('儲存');
	}
	
	function checkForm() { 
		
		if($('#save_newDelivery').html() == "新增"){
			
			if($('#Delivery_Add_Page #delivery_protocol').val() == ""){
				alert("please select delivery_protocol !");
				$('#delivery_protocol').focus();
				return false;
			}
			
			if($('#Delivery_Add_Page #delivery_type').val() == ""){
				alert("please select delivery_type !");
				$('#delivery_type').focus();
				return false;
			}
		}
		
		if($('#Delivery_Add_Page #delivery_type').val == "Other"){
			
			if($('#Delivery_Add_Page #Method_name').val() == ""){
				alert("please input Method_name !");
				$('#Method_name').focus();
				return false;
			}
		}
			
		if($('#Delivery_Add_Page #port').val() == ""){
			alert("please input port !");
			$('#port').focus();
			return false;
		}
		
		if($('#Delivery_Add_Page #location').val() == ""){
			alert("please input location !");
			$('#location').focus();
			return false;
		}
		
		return true;
	}
	
	function DeliverySummit(){
		
		startLoader();
		$.ajax({		
			url: "PartnerServlet",
			type: "POST",
			data: Delivery_Info,
			success:function(data) {
				$('#Delivery_Add_Page').modal('hide');
				appendMethod($('#hidePartnerID').val(), $('#method'))
				appendProtocol($('#hidePartnerID').val())
				stopLoader();
			},
			error: function (xhr) {
	        		stopLoader();
	        		errorLog(xhr.responseText);
        		}
		});
	} 
	
	$(document).ready(function() {
		
		$('#Delivery_Add_Page').on('change', '#delivery_type', function(e) {
			
			if($('#Delivery_Add_Page #delivery_type').val() == "Other"){
				$('#Delivery_Add_Page #name_span').show();
			}else
				$('#Delivery_Add_Page #name_span').hide();
		})
		
		$('#Delivery_Add_Page').on('change', '#delivery_protocol', function(e) {
			$('#Delivery_Add_Page #protocol').html($('#Delivery_Add_Page #delivery_protocol').val() + "-");
		})
		
		$('#Delivery_Add_Page').on('click', '#save_newDelivery', function(e) {
			setDelivery_Info();
			if(checkForm()) {
				if($('#save_newDelivery').html() == "儲存") {
					DeliverySummit();
				}else {
					$.ajax({		
						url: "PartnerServlet",
						type: "POST",
						data: { "method" : "checkDelivery" ,
								"delivery_method" : Delivery_Info.delivery_method,
								"partnerID" : Delivery_Info.PartnerID
								},
						success:function(data) {
							if(data==true){
								alert("this Protocol/Type has been existing !")
								return;
							}else{
								DeliverySummit();
							}
						},
						error: function (xhr) {
				        		stopLoader();
				        		errorLog(xhr.responseText);
			        		}
					});
				}
			}
		});
	})
	</script>
</body>
</html>