<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
.display_range{
	width:30%;
}
.display_new_partner_margin_top{
	margin-top:5%;
}
#Rule_Add_Page{
	height:100% !important;
	
}
.Zebra_DatePicker_Icon{
	top: 8px !important;
}
</style>

</head>
<body>
<div class="modal fade" id="Rule_Add_Page" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog modal-md" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">New Processing Rule</h5>
	        <input type="hidden" id="HideName" />
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	       	<div class = display_block>
	       	 <div id="selectTree" class="ztree" style="width:700px;overflow:auto;"> 
	       	 </div>
	       	 	<p class ="display_block add_field">Rule Infomation</p>
	       	 	
	       	 	<input type="hidden" name="hideID" id="hideID"/>
	       	 	<input type="hidden" name="hideIndex" id="hideIndex"/>
	       	 	
	      		<span class ="form-group row">
	      			<label class="col-sm-3 col-form-label">Rule Name :</label>
					<input type="text" name="RuleName" id="RuleName" class="border rounded form-control col-sm-5"/>
	      		</span>
	      		
	      		<span class ="form-group row display_new_partner_margin_top">
	      			<label class="col-sm-3 col-form-label">Rule Description :</label>
	      			<input type="text" name="RuleDescription" id="RuleDescription" class="border rounded form-control col-sm-5"/>
	      		</span>
	      		
	      		<p class ="form-group row display_new_partner_margin_top add_field">Rule Properties</p>
	      		
	      		<span class ="form-group row display_new_partner_margin_top" id="index">
	      			<label class="col-sm-3 col-form-label">Rule Index :</label>
		       		<input type="text" name="RuleIndex" id="RuleIndex" class="border rounded form-control col-sm-5" value="0" onkeyup="value=value.replace(/[^\d]/g,'')"/>
		      	</span>
		      	
		      	<span class ="form-group row display_new_partner_margin_top">
	      			<label class="col-sm-3 col-form-label">Status :</label>
		       		<select class="form-control col-sm-5" name="Pooling_Enable" id="Rule_Enable">
						<option value='0'>Enable</option>
						<option value='1'>Disable</option>
					</select>
		      	</span>
		      	
	      		<span class ="form-group row display_new_partner_margin_top">
	      			<label class="col-sm-3 col-form-label">Sender :</label>
		       		<select class="form-control col-sm-5" name="SenderID" id="SenderID">
						<option value="">請選擇</option>
					</select>
		      	</span>
		      	 
		      	<span class ="form-group row display_new_partner_margin_top">
	      			<label class="col-sm-3 col-form-label">Receive :</label>
		       		<select class="form-control col-sm-5" name="ReceiveID" id="ReceiveID">
						<option value="">請選擇</option>
					</select>
		      	</span>
		      	    	
		      	<span class ="form-group row display_new_partner_margin_top">
	      			<label class="col-sm-3 col-form-label">DocType :</label>
		       		<select class="form-control col-sm-5" name="DocTypeID" id="DocTypeID">
						<option value="">請選擇</option>
					</select>
		      	</span>
		      	
		      	<span class="form-group row display_new_partner_margin_top">
	      			<label class="col-sm-3 col-form-label">Service :</label>
		       		<select class="form-control col-sm-5" name="Service" id="Service">
						<option value="">請選擇</option>
					</select>
		      	</span>
	      	</div>
	       </div>
           <div class="modal-footer">
	           <button id="save_newRule" class="btn btn-primary">新增</button>
	           <button class="btn btn-secondary" data-dismiss="modal">關閉</button>
	       </div>	
	    </div>
      </div>			
</div>

<script type="text/javascript">
	var Rule_info = {};
	
	function showAdd_RuleAdd() {
		$('#Rule_Add_Page').modal();	
	}
	
	function initRulePage() {	       
		$('#Rule_Add_Page #hideID, #RuleName, #RuleDescription, #SenderID').val("");
		$('#Rule_Add_Page #ReceiveID, #DocTypeID, #Service, #Rule_Enable').val("");
		$('#Rule_Add_Page #Rule_Enable, #RuleIndex, #hideIndex').val('0')
		
		Rule_info.method = 'Rule_add'
		
		$('#Rule_Add_Page #index').hide();
		$('#save_newRule').html("新增")
	}
	
	function setRule_info() {
		
		Rule_info.hideID = $('#Rule_Add_Page #hideID').val();
		Rule_info.RuleName = $('#Rule_Add_Page #RuleName').val();
		Rule_info.RuleDescription = $('#Rule_Add_Page #RuleDescription').val();
		Rule_info.SenderID =  $('#Rule_Add_Page #SenderID').val() ;
		Rule_info.ReceiveID =  $('#Rule_Add_Page #ReceiveID').val() ;
		Rule_info.DocTypeID =  $('#Rule_Add_Page #DocTypeID').val() ;
		Rule_info.Service =  $('#Rule_Add_Page #Service').val() ;
		Rule_info.Rule_Enable =  $('#Rule_Add_Page #Rule_Enable').val() ;
		Rule_info.RuleIndex =  $('#Rule_Add_Page #RuleIndex').val() ;
		Rule_info.hideIndex =  $('#Rule_Add_Page #hideIndex').val() ;
	}
	
	function setEditSchedule_info(data) {
		initRulePage();
		
		$('#Rule_Add_Page #hideID').val(data["RuleID"]);
		$('#Rule_Add_Page #RuleName').val(data["RuleName"]);
		$('#Rule_Add_Page #RuleDescription').val(data["RuleDescription"]);
		$('#Rule_Add_Page #SenderID').val(data["SenderID"]) ;
		$('#Rule_Add_Page #ReceiveID').val(data["ReceiverID"]) ;
		$('#Rule_Add_Page #DocTypeID').val(data["DocTypeID"]) ;
		$('#Rule_Add_Page #Service').val(data["Service"]) ;
		$('#Rule_Add_Page #Rule_Enable').val(data["Disabled"]) ;
		$('#Rule_Add_Page #RuleIndex').val(data["RuleIndex"]) ;
		$('#Rule_Add_Page #hideIndex').val(data["RuleIndex"]) ;
		
		$('#Rule_Add_Page #index').show();
		Rule_info.method = 'Rule_edit'
		$('#save_newRule').html("儲存")
	}
	
	function checkSchedule_info() {
	
		
		if($('#Rule_Add_Page #RuleName').val() == ""){
			alert("please input Rule Name !")
			return false;
		}
		
		if($('#Rule_Add_Page #RuleDescription').val() == ""){
			alert("please input Rule Description !")
			return false;
		}
		
		if($('#Rule_Add_Page #SenderID').val() == ""){
			alert("please select Sender !")
			return false;
		}
		
		if($('#Rule_Add_Page #ReceiveID').val() == ""){
			alert("please select Receive !")
			return false;
		}
		
		if($('#Rule_Add_Page #DocTypeID').val() == ""){
			alert("please input DocType !")
			return false;
		}
		
		if($('#Rule_Add_Page #Service').val() == ""){
			alert("please input Service !")
			return false;
		}
		
		if($('#Rule_Add_Page #Rule_Enable').val() == ""){
			alert("please input Status !")
			return false;
		}
		
		if($('#Rule_Add_Page #RuleIndex').val() == ""){
			alert("please input Rule Index !")
			return false;
		}
		
		return true;
	}
	
	$(document).ready(function() {
		
		$('#Rule_Add_Page').on('click', '#save_newRule', function(e) {
			if(checkSchedule_info()){
				setRule_info();
				 
				$.ajax({		
					url: "ProcessingServlet",
					type: "POST",
					data: Rule_info,
					success:function(data) {
						$('#Rule_Add_Page').modal('hide');
						Condition.method = 'getProcessingTable';
						refresh_Table(ProcessTable);
					},error: function (xhr) {
		          		stopLoader();
		          		errorLog(xhr.responseText);
			  		}
				});
			}	
		})
		
		initPartner($('#SenderID, #ReceiveID'));
		initDocType($('#DocTypeID'));
		initFileList($('#Service'));
	})
</script>
</body>
</html>