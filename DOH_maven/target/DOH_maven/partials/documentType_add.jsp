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
    height: 96%;
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
#DocumentType_Add_Page{
	height:80% !important;
	
}
</style>

</head>
<body>
<div class="modal fade" id="DocumentType_Add_Page" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog modal-md" role="document">
	    <div class="modal-content" >
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">New DocumentType</h5>
	        
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	       	<div class = display_block>
		       	<input type="hidden" name="type_id" id="type_id"/>
		       	
		       	<p class ="display_block add_field">DocumentType Infomation</p>
	       	
	      		<span class ="form-group row" >
	      			<label class="col-sm-3 col-form-label">Type Name :</label>
					<input type="text" name="type_name" id="type_name" class="border rounded form-control col-sm-5"/>
	      		</span>
	      		
	      		<span class ="form-group row margin_top_5" >
	      			<label class="col-sm-3 col-form-label">TypeDescription :</label>
	      			<input type="text" name="TypeDescription" id="TypeDescription" class="border rounded form-control col-sm-5"/>
	      		</span>
	      		
	      		<p class ="display_block add_field">DocumentType Properties</p>
	      		
	      		<span class ="form-group row margin_top_5" >
	      			<label class="col-sm-3 col-form-label">RootTag :</label>
	      			<input type="text" name="RootTag" id="RootTag" class="border rounded form-control col-sm-5"/>
	      		</span>
	      		
	      		<span class ="form-group row margin_top_5">
	      			<label class="col-sm-3 col-form-label">ReceiverType :</label>
					<select name="ReceiverType" id="ReceiverType" class="form-control col-sm-5">
					<option value=''>請選擇</option>
					</select>
	      		</span>
	      		
	      		<span class ="form-group row margin_top_5" >
	      			<label class="col-sm-3 col-form-label">ReceiverID :</label>
	      			<input type="text" name="ReceiverPath" id="ReceiverPath" class="border rounded form-control col-sm-5" placeholder="//Xpath..."/>
	      		</span>
	      		
	      		<span class ="form-group row margin_top_5">
	      			<label class="col-sm-3 col-form-label">SenderType :</label>
					<select name="SenderType" id="SenderType" class="form-control col-sm-5">
					<option value=''>請選擇</option>
					</select>
	      		</span>
	      		
	      		<span class ="form-group row margin_top_5" >
	      			<label class="col-sm-3 col-form-label">SenderID :</label>
	      			<input type="text" name="SenderPath" id="SenderPath" class="border rounded form-control col-sm-5" placeholder="//Xpath..."/>
	      		</span>
	      		
	      		<span class ="form-group row margin_top_5" >
	      			<label class="col-sm-3 col-form-label">DocumentID :</label>
	      			<input type="text" name="DocumentPath" id="DocumentPath" class="border rounded form-control col-sm-5" placeholder="//Xpath..."/>
	      		</span>
	      		
	      		<span class ="form-group row margin_top_5" >
	      			<label class="col-sm-3 col-form-label">ConversationID :</label>
	      			<input type="text" name="ConversationPath" id="ConversationPath" class="border rounded form-control col-sm-5"/>
	      		</span>
	      		
	      		<span class ="form-group row margin_top_5" >
	      			<label class="col-sm-3 col-form-label">SchemaPath :</label>
	      			<input type="text" name="SchemaPath" id="SchemaPath" class="border rounded form-control col-sm-5"/>
	      		</span>
		      	<span class="form-group row margin_top_5">
					<label class="col-sm-3 col-form-label">Status:</label>
					<select name="Status" id="Status" class="form-control col-sm-5">
					<option value='1'>Enable</option>
					<option value='0'>Disable</option>
					</select>
				</span>
	      	 </div>
	        </div>
           <div class="modal-footer">
	           <button id="save_newDocument" class="btn btn-primary">新增</button>
	           <button class="btn btn-secondary" data-dismiss="modal">關閉</button>
	       </div>	
	    </div>
      </div>			
</div>		
	<script type="text/javascript">
	
	var DocumentType_Info = {};
	
	function showAdd_DocumentType() {
		$('#DocumentType_Add_Page').modal();	
	}
	
	function initPage() {	
			//checkSession();    
			$('#DocumentType_Add_Page #type_name, #TypeDescription, #RootTag, #SenderPath').val("")
			$('#DocumentPath, #ConversationPath, #SchemaPath, #ReceiverPath, #type_id, #SenderType, #ReceiverType').val("");
			$('#DocumentType_Add_Page #Status').val("1");
			DocumentType_Info.method = 'Document_add'
			$('#save_newDocument').html('新增');
	}
	
	function setDocumentType_Info() {
		
		DocumentType_Info.type_id = $('#DocumentType_Add_Page #type_id').val();
		DocumentType_Info.type_name = $('#DocumentType_Add_Page #type_name').val();
		DocumentType_Info.TypeDescription = $('#DocumentType_Add_Page #TypeDescription').val();
		DocumentType_Info.RootTag = $('#DocumentType_Add_Page #RootTag').val();
		DocumentType_Info.SenderPath =  $('#DocumentType_Add_Page #SenderPath').val() ;
		DocumentType_Info.ReceiverPath = $('#DocumentType_Add_Page #ReceiverPath').val();
		DocumentType_Info.DocumentPath = $('#DocumentType_Add_Page #DocumentPath').val();
		DocumentType_Info.ConversationPath = $('#DocumentType_Add_Page #ConversationPath').val();
		DocumentType_Info.SchemaPath = $('#DocumentType_Add_Page #SchemaPath').val();
		DocumentType_Info.Status = $('#DocumentType_Add_Page #Status').val();
		DocumentType_Info.SenderType = $('#DocumentType_Add_Page #SenderType').val();
		DocumentType_Info.ReceiverType = $('#DocumentType_Add_Page #ReceiverType').val();
	}
	
	function setEditPage(data) {
		initPage();
		
		$('#DocumentType_Add_Page #type_id').val(data['TypeID']);
		$('#DocumentType_Add_Page #type_name').val(data['TypeName']);
		$('#DocumentType_Add_Page #TypeDescription').val(data['TypeDescription']);
		$('#DocumentType_Add_Page #RootTag').val(data['RootTag']);
		$('#DocumentType_Add_Page #ReceiverPath').val(data['ReceiverPath']);
		$('#DocumentType_Add_Page #SenderPath').val(data['SenderPath']);
		$('#DocumentType_Add_Page #DocumentPath').val(data['DocumentPath']);
		$('#DocumentType_Add_Page #ConversationPath').val(data['ConversationPath']);
		$('#DocumentType_Add_Page #SchemaPath').val(data['SchemaPath']);
		$('#DocumentType_Add_Page #Status').val(data['Status']) ;
		$('#DocumentType_Add_Page #SenderType').val(data['SenderType']);
		$('#DocumentType_Add_Page #ReceiverType').val(data['ReceiverType']);
		
		DocumentType_Info.method = 'Document_edit'
		$('#save_newDocument').html('儲存');
	}
	
	function checkDocumentType_info() {
		
		if($('#DocumentType_Add_Page #type_name').val() == ""){
			alert("please input Type Name !")
			return false;
		}
	
		if($('#DocumentType_Add_Page #TypeDescription').val() == ""){
			alert("please input TypeDescription !")
			return false;
		}
		
		if($('#DocumentType_Add_Page #RootTag').val() == ""){
			alert("please input RootTag !")
			return false;
		}
		
		if($('#DocumentType_Add_Page #SenderType').val() == ""){
			alert("please select SenderType !")
			return false;
		}
		
		if($('#DocumentType_Add_Page #SenderPath').val() == ""){
			alert("please input SenderPath !")
			return false;
		}
		
		if($('#DocumentType_Add_Page #type_name').val() == ""){
			alert("please select ReceiverType !")
			return false;
		}
		
		if($('#DocumentType_Add_Page #ReceiverPath').val() == ""){
			alert("please input ReceiverPath !")
			return false;
		}
		
		if($('#DocumentType_Add_Page #DocumentPath').val() == ""){
			alert("please input DocumentPath !")
			return false;
		}
		
		if($('#DocumentType_Add_Page #ConversationPath').val() == ""){
			alert("please input ConversationPath !")
			return false;
		}
		
		if($('#DocumentType_Add_Page #SchemaPath').val() == ""){
			alert("please input SchemaPath !")
			return false;
		}
		return true;
	}
	
	$(document).ready(function() {
		
		initFieldType($('#SenderType , #ReceiverType'));
		
		$('#DocumentType_Add_Page #save_newDocument').click(function() {
			if(checkDocumentType_info()){
				setDocumentType_Info();
				
				$.ajax({		
					url: "DocumentTypeServlet",
					type: "POST",
					data: DocumentType_Info,
					success:function(data) {
						$('#DocumentType_Add_Page').modal('hide');
						Condition.method = 'DocumentTypeTable';
						refresh_Table(documentTypeTable);
					},
					error: function (xhr) {
			        		stopLoader();
						alert(xhr.responseText);
		        		}
				});
			}
		});
	});
	</script>
</body>
</html>