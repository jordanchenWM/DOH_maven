<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
.modal-dialog,
.modal-content {
    /* 80% of window height */
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
.display_new_partner_range{
	width:40%;
}
.display_CIMA_Edit_left{
	width:450px;
}
.display_new_partner_margin_top{
	margin-top:5%;
}
#FieldType_Add_Page{
	height:250px !important;
	margin:10%;
}
</style>

</head>
<body>
<div class="modal fade" id="FieldType_Add_Page" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog modal-md" role="document">
	    <div class="modal-content" >
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">New FieldType</h5>
	        
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	       	<div class = display_block>
	      		<span class ="display_block ">
	      			<label class="display_new_partner_range">Type Name :</label>
					<input type="search" name="type_name" id="type_name" class="border rounded"/>
	      		</span>
	      	</div>
	       </div>
           <div class="modal-footer">
	           <button id="save_newType" class="btn btn-primary">新增</button>
	           <button class="btn btn-secondary" data-dismiss="modal">關閉</button>
	       </div>	
	    </div>
      </div>			
</div>		
	           
	<script type="text/javascript">
	
	var Type_Info = {};
	
	function showAdd_FieldType() {
		$('#FieldType_Add_Page').modal();	
	}
	
	function initTypePage() {	
		$('#type_name').val("");
	}
	
	function setType_Info() {
		initPage();
		
		Type_Info.method = "newType";
		Type_Info.typeName = $('#type_name').val();
	}
	
	function checkType_Page() {
		
		if($('#type_name').val() == "" ){
			alert('Type Name cannot be empty!')
			return false;
		}
		
		return true;
	}
	
	function summitTypePage() {
		setType_Info();
		$.ajax({		
			url: "PartnerServlet",
			type: "POST",
			data: Type_Info,
			success:function(data) {
				$('#FieldType_Add_Page').modal('hide');
				location.reload();
			},
			error: function (xhr) {
	      		stopLoader(); 
	      		errorLog(xhr.responseText);
	      	}
		});
		stopLoader(); 
	}
	
	$(document).ready(function() {
		
		$('#FieldType_Add_Page #save_newType').click(function() {
			if(checkType_Page()){ 
				startLoader(); 
				//檢查重複
				$.ajax({		
					url: "PartnerServlet",
					type: "POST",
					data: {"method" : "checkType" ,
						   "typeName" : $('#type_name').val() 
						  },
					success:function(datas) {
						if(Boolean(datas) == true){
							alert("this Type is existing !")
			        	  	}else{
			        	  		summitTypePage()
			        	  	}
					},
					error: function (xhr) {
			      		stopLoader(); 
			      		errorLog(xhr.responseText);
			      	}
				});
			}
		})
		
	})
	</script>
</body>
</html>