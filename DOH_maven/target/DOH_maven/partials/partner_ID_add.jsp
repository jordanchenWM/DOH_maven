<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>


.modal-dialog,
.modal-content {
    height: 94%;
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
#Detail_Add_Page{
	height:45vh !important;
	margin:10%;
}
</style>
</head>
<body>
<div class="modal fade" id="Detail_Add_Page" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog modal-md" role="document">
	    <div class="modal-content" >
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">New Detail</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	       	<div class = display_block>
	       	 	<input type="hidden" id="hidden_name"/>
	       	 	<input type="hidden" id="hidden_val"/>
	      		
	      		<span class ="form-group row">
	      			<label class="col-sm-3 col-form-label">Field Name :</label>
					<select name="field_name" id="field_name" class="form-control col-sm-5">
					<option value=''>請選擇</option>
					</select>
	      		</span>
	      		
	      		<span class ="form-group row">
	      			<label class="col-sm-3 col-form-label">Field Value :</label>
					<input type="search" name="field_val" id="field_val" class="border rounded form-control col-sm-5"/>
	      		</span>
	      	</div>
	       </div>
           <div class="modal-footer">
           	   <button id="add_fieldType" class="btn btn-inverse-secondary btn-rounded btn-fw" >Add FieldType</button>
	           <button id="save_newDetail" class="btn btn-primary">新增</button>
	           <button class="btn btn-secondary" data-dismiss="modal">關閉</button>
	       </div>	
	    </div>
      </div>			
</div>		
	           
	<script type="text/javascript">
	
	var detail_Info = {};
	var check = 0;
	
	function showAdd_Detail() {
		$('#Detail_Add_Page').modal();	
	}
	
	function initDetailPage() {	
		$('#field_name, #field_val').val("");
		$('#save_newDetail').html('新增');
		
		detail_Info.method = "newDetail";
	}
	
	function check_detail() {
		
		if($('#field_name').val() == "" || $('#field_val').val() == ""){
			alert('Field Name & Field Value Cannot be empty !')
			return false;
		}
		return true;
	}
	
	function setDetail_Info() {
		
		detail_Info.field_name = $('#Detail_Add_Page #field_name').val();
		detail_Info.field_val = $('#Detail_Add_Page #field_val').val();
		detail_Info.hidePartnerID = $('#hidePartnerID').val();
	}
	
	function editDetail_Info(data) {
		
		$('#Detail_Add_Page  #field_name').val(data['Field_ID']);
		$('#Detail_Add_Page #hidden_name').val(data['Field_ID'])
		$('#Detail_Add_Page  #field_val').val(data['Field_Value']);
		$('#Detail_Add_Page #hidden_val').val(data['Field_Value'])
		
		detail_Info.method = 'detail_edit'
		detail_Info.FieldID = data['FieldID']
		$('#save_newDetail').html('儲存');
	}
	
	$(document).ready(function() { 
		
		$('#add_fieldType').click(function() {
			  initTypePage();
			  showAdd_FieldType();
		  });
		
		$('#Detail_Add_Page #save_newDetail').click(function() {
			if(check_detail()){
				if(!($('#Detail_Add_Page #hidden_name').val() == $('#Detail_Add_Page #field_name').val() && $('#Detail_Add_Page #hidden_val').val() == $('#Detail_Add_Page #field_val').val())){
					check_duplicateDetail($('#Detail_Add_Page #field_name').val(), $('#Detail_Add_Page #field_val').val())
				}else{
					$('#Detail_Add_Page').modal('hide');
				}
			}
		})
		
		initFieldType($('#field_name')); 
	})
	</script>
</body>
</html>