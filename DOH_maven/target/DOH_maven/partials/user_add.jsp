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
    height: 97%;
    max-width: 65%;
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
#User_Add_Page{
	height:600px !important;
}
</style>

</head>
<body>
<div class="modal fade" id="User_Add_Page" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog modal-md" role="document">
	    <div class="modal-content" >
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">New User</h5>
	        
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	       	<div class = display_block>
	       		<p class ="display_block add_field">User Basic Infomation</p>
	       		<input type="hidden" name="hidden_account" id="hidden_account"/>
	      		
	      		<span class ="form-group row" id="user_hide">
	      			<label class="col-sm-3 col-form-label">User ID :</label>
					<input type="text" name="account" id="account" class="border rounded form-control col-sm-5"/>
	      		</span>
	      		
	      		<span class ="form-group row margin_top_5" >
	      			<label class="col-sm-3 col-form-label">Password :</label>
	      			<input type="password" name="Password" id="Password" class="border rounded form-control col-sm-5"/>
	      		</span>
	      		
	      		<span class ="form-group row margin_top_5" id="CP">
	      			<label class="col-sm-3 col-form-label">Confirm Password :</label>
	      			<input type="password" name="CPassword" id="CPassword" class="border rounded form-control col-sm-5"/>
	      		</span>
	      		
	      		<p class ="display_block margin_top_5 add_field">User Other Infomation</p>
	      		
	      		<span class ="form-group row margin_top_5" >
	      			<label class="col-sm-3 col-form-label">Frist Name :</label>
		       		<input type="text" name="Frist_Name" id="Frist_Name" class="border rounded form-control col-sm-5"/>
		      	</span>
		      	
		      	<span class ="form-group row margin_top_5" >
	      			<label class="col-sm-3 col-form-label">Last Name :</label>
		       		<input type="text" name="Last_Name" id="Last_Name" class="border rounded form-control col-sm-5"/>
		      	</span>
		      	
		      	<span class ="form-group row margin_top_5" >
	      			<label class="col-sm-3 col-form-label">Phone :</label>
		       		<input type="text" name="Phone" id="Phone" class="border rounded form-control col-sm-5"/>
		      	</span>
		      	
		      	<span class ="form-group row margin_top_5" >
	      			<label class="col-sm-3 col-form-label">E-mail :</label>
		       		<input type="text" name="Mail" id="Mail" class="border rounded form-control col-sm-5"/>
		      	</span>
		      	
		      	<span class="form-group row margin_top_5">
					<label class="col-sm-3 col-form-label">Role:</label>
					<select name="Role" id="Role" class="form-control col-sm-5">
					<option value='Admin'>Admin</option>
					<option value='User'>User</option>
					</select>
				</span>
	      	</div>
	       </div>
           <div class="modal-footer">
	           <button id="save_newUser" class="btn btn-primary">新增</button>
	           <button class="btn btn-secondary" data-dismiss="modal">關閉</button>
	       </div>	
	    </div>
      </div>			
</div>		
	           
	<script type="text/javascript">
	var user_info = {};
	
	function showAdd_User() {
		$('#User_Add_Page').modal();	
	}
	
	function initPage() {	
		//checkSession();    
		$('#User_Add_Page #account').val("");
		$('#User_Add_Page #Password').val("");
		$('#User_Add_Page #Frist_Name').val("");
		$('#User_Add_Page #Last_Name').val("");
		$('#User_Add_Page #Mail').val("");
		$('#User_Add_Page #CPassword').val("");
		$('#User_Add_Page #Phone').val("") ;
		$('#User_Add_Page #Role').val("Admin");
		user_info.method = 'user_add'
		$('#save_newUser').html('新增');
	}
	
	function setUser_info() {
		
		user_info.account = $('#User_Add_Page #account').val();
		user_info.Password = $('#User_Add_Page #Password').val();
		user_info.Frist_Name = $('#User_Add_Page #Frist_Name').val();
		user_info.Last_Name =  $('#User_Add_Page #Last_Name').val() ;
		user_info.Phone =  $('#User_Add_Page #Phone').val() ;
		user_info.Mail = $('#User_Add_Page #Mail').val();
		user_info.Role = $('#User_Add_Page #Role').val();
	}
	
	function setEditPage(data) {
		initPage();
		
		$('#User_Add_Page #account').val(data['Account']);
		$('#User_Add_Page #user_hide').hide();
		$('#User_Add_Page #Password').val(data['Password']);
		$('#User_Add_Page #Mail').val(data['Mail']);
		$('#User_Add_Page #Frist_Name').val(data['frist_name']);
		$('#User_Add_Page #Last_Name').val(data['last_name']);
		$('#User_Add_Page #Phone').val(data['Phone']);
		$('#User_Add_Page #Role').val(data['Role']) ;
		user_info.method = 'User_edit'
		$('#save_newUser').html('儲存');
	}
	
	function checkForm() {
		var acc = $('#account').val().trim().toLowerCase()
		if(acc == ""){
			alert("please input account !");
			$('#account').focus();
			return false;
		}else if(acc == "admin") {
			alert("account must not be Admin!");
			$('#account').focus();
			return false;
		}
		
		if($('#Password').val() == ""){
			alert("please input Password !");
			$('#Password').focus();
			return false;
		}
		
		if($('#CPassword').val() == ""){
			alert("please input Confirm Password !");
			$('#CPassword').focus();
			return false;
		}

		if($('#Frist_Name').val() == ""){
			alert("please input Frist_Name !");
			$('#Frist_Name').focus();
			return false;
		}
		
		if($('#Last_Name').val() == ""){
			alert("please input Last_Name !");
			$('#Last_Name').focus();
			return false;
		}
		
		if($('#Password').val() != $('#CPassword').val() ){
			alert("Password & Confirm Password must be same !");
			$('#Password').focus();
			return false;
		}
		return true;
	}
	   
	function user_summit() {
		setUser_info();
		$.ajax({		
			url: "UserManagementServlet",
			type: "POST",
			data: user_info,
			success:function(data) {
				$('#User_Add_Page').modal('hide');
				Condition.method = 'UserTable';
				refresh_Table(UserTable);
			}
		});	
	}
	
	$(document).ready(function() {
		$('#User_Add_Page #save_newUser').click(function() {
			if(checkForm()){
				$.ajax({		
					url: "UserManagementServlet",
					type: "POST",
					data: {	"method" : "User_check" ,
			  				"Name" :  $('#User_Add_Page #account').val()
			  			  } ,
					success:function(data) {
						if(data == true){
			        	  		alert("已有相同的User ID！")
			        	  		return;
		        	  		}else{
		        	  			user_summit();
		        	  		}
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