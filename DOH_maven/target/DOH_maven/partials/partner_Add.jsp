<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>Partner Profiles</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>


.modal-dialog,
.modal-content {
    height: 96%;
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
#service_note {
	vertical-align: middle;
 	width: 250px;
 	height: 150px;
}
#Partner_Add_Page{
	height: 90%;
}
.display_detail{
	margin-left: 1%;
}
.height_50{
	height: 60% !important;
}
</style>

</head>
<body>
<div class="modal fade" id="Partner_Add_Page" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog modal-md" role="document">
	    <div class="modal-content" id='content'>
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">New Partner</h5>
	        
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body" id="body">
	       	<div class = display_block>
	      		
	      		<span class ="form-group row" Style="display:none">
	      			<label class="col-sm-3 col-form-label">PartnerID :</label>
	      			<input type="search" name="PartnerID" id="PartnerID" class="border rounded form-control col-sm-5"/>
	      		</span>
	      		
	      		<span class ="form-group row" >
	      			<label class="col-sm-3 col-form-label">Corporation Name :</label>
	      			<input type="search" name="Corporation_Name" id="Corporation_Name" class="border rounded form-control col-sm-5"/>
	      		</span>
	      		
	      		<span class ="form-group row margin_top_5" >
	      			<label class="col-sm-3 col-form-label">OrgUnit Name :</label>
		       		<input type="search" name="OrgUnit_Name" id="OrgUnit_Name" class="border rounded form-control col-sm-5"/>
		      	</span>
		      	
		      	<span class="form-group row margin_top_5">
					<label class="col-sm-3 col-form-label">Status:</label>
					<select name="Status" id="Status" class="form-control col-sm-5">
					<option value='1'>Enable</option>
					<option value='0'>Disable</option>
					</select>
				</span>
	      	</div>
	      	<div id="mid_label">
		      	<label class="display_inlineblock" style="font-size:18px;color:#fffef1;background: #5aabf3">Partner Detail</label>
		      	<a href='#' id='add_one_detail' class="display_inlineblock" ><i class='mdi mdi-plus-circle material-icons icon-bule md-24'></i></a>
	      	</div>
	      	<div class ="display_block" style="border-width:1px;border-style: double;" id="div_IDtype">
	      	<span class ="form-group row margin_top_2">
	      			<label class="col-sm-3 col-form-label display_detail">Field Name :</label>
					<select name="field" id="field" class="form-control col-sm-5">
					<option value=''>請選擇</option>
					</select>
	      		</span>
	      		
	      		<span class ="form-group row">
	      			<label class="col-sm-3 col-form-label display_detail">Field Value :</label>
					<input type="search" name="val" id="val" class="border rounded form-control col-sm-5"/>
	      		</span>
	      	
	      	</div>
	       </div>
           <div class="modal-footer">
	           <button id="save_newPartner" class="btn btn-primary">新增</button>
	           <button class="btn btn-secondary" data-dismiss="modal">關閉</button>
	       </div>	
	    </div>
      </div>			
</div>		
	           
<script type="text/javascript">
	
	var partner_Info = {};
	var detail_num = 0; 
	var check_num = 0;
	var dup_num = 0
	
	function showAdd_Partner() {
		$('#Partner_Add_Page').modal();	
	}
	
	function initPage() {	
		for(var i=0;i <= detail_num;i++){
			$("#addDiv"+i).remove();
		}
		
		detail_num = 0 ;
		$('#Partner_Add_Page #Partner_ID, #Corporation_Name, #OrgUnit_Name, #field, #val').val("");
		$('#Partner_Add_Page #Status').val("1");
		$('#Partner_Add_Page').removeClass('height_50')
		partner_Info.method = 'partner_add'
		
		$('#save_newPartner').html('新增');
		$('#body #div_IDtype , #body #mid_label').show();
		
	}
	
	function setPartner_Info() {
		partner_Info.PartnerID = $('#Partner_Add_Page #PartnerID').val();
		partner_Info.Corporation_Name = $('#Partner_Add_Page #Corporation_Name').val();
		partner_Info.OrgUnit_Name = $('#Partner_Add_Page #OrgUnit_Name').val();
		partner_Info.Status =  $('#Partner_Add_Page #Status').val() ;
		partner_Info.field = $('#Partner_Add_Page #field').val() ;
		partner_Info.val = $('#Partner_Add_Page #val').val() ;
		partner_Info.detail_num = detail_num ;
		for(var i=0;i < detail_num;i++){
			partner_Info['field'+(i+1)] = $('#field'+ (i+1)).val();
			partner_Info['val'+(i+1)] = $('#val'+ (i+1)).val();
		}
	}
	
	function setEditPartner() {
		initPage();
		
		$('#div_IDtype #field').val("1") ;
		$('#div_IDtype #val').val("none") ;
		$('#Partner_Add_Page #PartnerID').val($('#hidePartnerID').val());
		$('#Partner_Add_Page #Corporation_Name').val($('#corporation').html());
		$('#Partner_Add_Page #OrgUnit_Name').val($('#hidePartnerOrgUnit').val());
		$('#Partner_Add_Page #Status').val($('#hidePartnerStatus').val()) ;
		
		$('#body #div_IDtype , #body #mid_label').hide();
		
		partner_Info.method = 'partner_edit';
		$('#save_newPartner').html('儲存');
		$('#Partner_Add_Page').addClass('height_50')
	} 
	
	function checkPartner() {
		
		if($('#Partner_Add_Page #Corporation_Name').val() == ""){
			alert("please input Corporation Name !")
			return false;
		}
		
		if($('#Partner_Add_Page #OrgUnit_Name').val() == ""){
			alert("please input OrgUnit Name !")
			return false;
		} 
		
		if($('#Partner_Add_Page #field').val() == ""){
			alert("please select Field Name !")
			return false;
		}
		
		if($('#Partner_Add_Page #val').val() == ""){
			alert("please input Field Value !")
			return false;
		}
		
		return true;
	}
	
	function partnerSummit(){
		startLoader();
		setPartner_Info();
		$.ajax({		
			url: "PartnerServlet",
			type: "POST",
			data: partner_Info,
			success:function(data) {
				$('#Partner_Add_Page').modal('hide');
				if(partner_Info.method == 'partner_edit'){
					 $('#corporation').html($('#Partner_Add_Page #Corporation_Name').val());
					if($('#Partner_Add_Page #Status').val() == 1){
						 $('#status').html("<i class='mdi mdi-check icon-green material-icons md-24 '></i>") 
					}else{
						 $('#status').html("<i class='mdi mdi-close-circle-outline icon-red material-icons md-24 '></i>")
					}
					  $('#hidePartnerStatus').val($('#Partner_Add_Page #Status').val()); 
					  $('#hidePartnerOrgUnit').val($('#Partner_Add_Page #OrgUnit_Name').val());
				}
				stopLoader();
				$('#Partner_Add_Page').modal('hide');
				Condition.method = 'PartnerTable';
				refresh_Table(PartnerTable);
			},
			error: function (xhr) {
	      		stopLoader();
				alert(xhr.responseText);
	      	}
		});
	}
	
	$(document).ready(function() {
		initFieldType($('#field')); 
		
	  	$('#mid_label').on('click', '#add_one_detail', function(e) {
	  		detail_num = detail_num + 1;
	  		$('#body').append('<div class ="display_block" style="border-width:1px;border-style: double;margin-top:1%" id="addDiv'+ detail_num+ '">'+
	  			'<span class ="form-group row margin_top_2">' +
	      		'<label class="col-sm-3 col-form-label display_detail">Field Name :</label> ' +
				'<select name="field'+ detail_num+ '" id="field'+ detail_num+ '" class="form-control col-sm-5"> ' +
				'<option value="">請選擇</option>' +
				'</select>' +
	      		'</span>' +
	      		'<span class ="form-group row"> ' +
	      		'<label class="col-sm-3 col-form-label display_detail">Field Value :</label> ' +
				'<input type="search" name="val'+ detail_num+ '" id="val'+ detail_num+ '" class="border rounded form-control col-sm-5"/> ' +
	      		'</span>' +
	      		'</div>'	);
	  		$("addDiv"+ detail_num).focus();
	  		initFieldType($('#field'+detail_num)); 
	  	})
	
		$('#Partner_Add_Page #save_newPartner').click(function() {
			check_num = 0 ;
			if(checkPartner()){
				if(partner_Info.method == 'partner_edit'){
					partnerSummit();
				}else if(partner_Info.method == 'partner_add'){
					console.log("detail_num="+detail_num)
					for(var i=0;i < detail_num+1;i++){
					  console.log('check')
					  $.ajax({		
					  		url: "PartnerServlet",
					  		type: "POST",
					  		data: {	"method" : "checkDetail" ,
					  				"col1" :  $('#field'+ (i == 0 ? "":(i))).val()	,	
					  				"col2" :  $('#val'+ (i == 0 ? "":(i))).val()
					  				} ,
					  		success: function(datas) {
					  			console.log('success')
					        	  	if(datas == true){
					        	  		alert("Detail資料重複！")
					        	  		return;
					        	  	}else{
					        	  		check_num+=1;
					        	  		if(check_num === (detail_num+1)){
					        	  			console.log('partnerSummit')
					        	  			partnerSummit();
					        	  		}
					        	  	}
					        	},
					  		error: function (xhr) {
				          		stopLoader();
				          		alert(xhr.responseText);
					  		}
					 });
				   }
				}
			}
		});
	});
</script>
</body>
</html>