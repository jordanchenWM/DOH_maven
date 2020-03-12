<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
.modal-dialog,
.modal-content {
    height: 90%;
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
#JDBC_Add_Page{
	height:100% !important;
}
.Zebra_DatePicker_Icon{
	top: 8px !important;
}
</style>

</head>
<body>
<div class="modal fade" id="JDBC_Add_Page" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog modal-md" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">New JDBC Pool</h5>
	        <input type="hidden" id="HideName" />
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	       	<div class = display_block>
	       	 <div id="selectTree" class="ztree" style="width:700px;overflow:auto;"> 
	       	 </div>
	       	 	<p class ="display_block add_field">Alias Infomation</p>
	       	 	
	      		<span class ="form-group row">
	      			<label class="col-sm-3 col-form-label">Alias Name :</label>
					<input type="text" name="Alias_Name" id="Alias_Name" class="border rounded form-control col-sm-5"/>
	      		</span>
	      		
	      		<span class ="form-group row margin_top_5">
	      			<label class="col-sm-3 col-form-label">Alias Description :</label>
	      			<input type="text" name="Alias_Description" id="Alias_Description" class="border rounded form-control col-sm-5"/>
	      		</span>
	      		
	      		<p class ="display_block margin_top_5 add_field">Connection Management Properties</p>
	      		
		      	<span class ="form-group row margin_top_5">
	      			<label class="col-sm-3 col-form-label">Driver :</label>
					<select name="Driver" id="Driver" class="form-control col-sm-5">
						<option value='MySQL'>MySQL</option>
						<option value='Oracle'>Oracle</option>
						<option value='SQL_Server'>SQL Server</option>
						<option value='Sybase'>Sybase</option>
					</select>
		      	</span>
		      	
	      		<span class ="form-group row margin_top_5">
	      			<label class="col-sm-3 col-form-label">User ID:</label>
		       		<input type="text" name="Account" id="Account" class="border rounded form-control col-sm-5"/>
		      	</span>
		      	 
		      	<span class ="form-group row margin_top_5">
	      			<label class="col-sm-3 col-form-label">Password :</label>
		       		<input type="Password" name="Password" id="Password" class="border rounded form-control col-sm-5"/>
		      	</span>
		      	    	
		      	<!--span class ="display_block margin_top_5" >
	      			<label class="col-sm-3 col-form-label">DataSource class :</label>
		       		<input type="text" name="DataSource_class" id="DataSource_class" class="border rounded"/>
		      	</span-->
		      	
		      	<span class ="form-group row margin_top_5">
	      			<label class="col-sm-3 col-form-label">Simple URL :</label>
		       		<textarea name="Simple_URL" id="Simple_URL" class="border rounded form-control" cols="55" rows="3" disabled></textarea>
		      	</span>
		      	
	      		<span class ="form-group row margin_top_5">
	      			<label class="col-sm-3 col-form-label">URL :</label>
	      			<textarea name="URL" id="URL" class="border rounded form-control" cols="55" rows="3"></textarea>
	      		</span>
		      	
		      	<p class ="display_block margin_top_5 add_field">Connection Management Properties</p>
		      	
		      	<span class ="form-group row margin_top_5">
	      			<label class="col-sm-3 col-form-label">Pooling Enable :</label>
		       		<select name="Pooling_Enable" id="Pooling_Enable" class="form-control col-sm-5">
						<option value='1'>Enable</option>
						<option value='0'>Disable</option>
					</select>
		      	</span>
		      	
		      	<span class ="form-group row margin_top_5">
	      			<label class="col-sm-3 col-form-label">MinPoolSize :</label>
		       		<input type="number" name="MinPoolSize" id="MinPoolSize" class="border rounded form-control col-sm-5" min="0"/>
		      	</span>
		      	
		      	<span class ="form-group row margin_top_5">
	      			<label class="col-sm-3 col-form-label">MaxPoolSize :</label>
		       		<input type="number" name="MaxPoolSize" id="MaxPoolSize" class="border rounded form-control col-sm-5" min="0"/>
		      	</span>
		      	
		      	<!--  span class ="display_block margin_top_5">
	      			<label class="col-sm-3 col-form-label">Increment Size :</label>
		       		<input type="text" name="Pool_IncrementSize" id="Pool_IncrementSize" class="border rounded" onkeyup="value=value.replace(/[^\d]/g,'')"/>
		      	</span-->
		      	
		      	<span class ="form-group row margin_top_5">
	      			<label class="col-sm-3 col-form-label">Block Timeout :</label>
		       		<input type="number" name="Block_Timeout" id="Block_Timeout" class="border rounded form-control col-sm-5" min="0"/>
					<label class="col-sm-3 col-form-label">(Sec)</label>
		      	</span>
		      	
		      	<span class ="form-group row margin_top_5">
	      			<label class="col-sm-3 col-form-label">Expire Timeout :</label>
		       		<input type="number" name="Expire_Timeout" id="Expire_Timeout" class="border rounded form-control col-sm-5" min="0"/>
					<label class="col-sm-3 col-form-label">(Sec)</label>
		      	</span>
		      	
		      	<span class ="form-group row margin_top_5">
	      			<label class="col-sm-3 col-form-label">Startup Timeout :</label>
		       		<input type="number" name="Startup_Timeout" id="Startup_Timeout" class="border rounded form-control col-sm-5" min="0"/>
		       		<label class="col-sm-3 col-form-label">(Sec)</label>
		      	</span>
	      	</div>
	       </div>
           <div class="modal-footer">
	           <button id="save_newJDBC" class="btn btn-primary">新增</button>
	           <button class="btn btn-secondary" data-dismiss="modal">關閉</button>
	       </div>	
	    </div>
      </div>			
</div>

<script type="text/javascript">
	var JDBC_info = {};
	
	function showAdd_JDBCpool() {
		$('#JDBC_Add_Page').modal();	
	}
	
	function initPage() {
		
		$('#JDBC_Add_Page #Alias_Name, #Alias_Description, #Account, #Password, #URL').val("");
		$('#JDBC_Add_Page #MaxPoolSize, #MinPoolSize, #Pool_IncrementSize, #Block_Timeout, #Expire_Timeout, #Startup_Timeout').val("0");
		$('#JDBC_Add_Page #Driver').val('MySQL');
		$('#JDBC_Add_Page #Pooling_Enable').val('1');
		JDBC_info.method = "JBDC_add"
		$('#save_newJDBC').html("新增")
		$('#JDBC_Add_Page #Simple_URL').val("jdbc:mysql://(ip):(port)/(database)?useUnicode=yes&characterEncoding=UTF-8");
		$('#JDBC_Add_Page #Alias_Name').attr('disabled', false);
		$('#JDBC_Add_Page #save_newJDBC').attr('disabled', false);
		$('#JDBC_Add_Page #Alias_Name').focus();
	}
	
	function setJDBC_info() {
		
		JDBC_info.Alias_Name = $('#JDBC_Add_Page #Alias_Name').val();
		JDBC_info.HideName = $('#JDBC_Add_Page #HideName').val();
		JDBC_info.Alias_Description = $('#JDBC_Add_Page #Alias_Description').val();
		JDBC_info.Account = $('#JDBC_Add_Page #Account').val();
		JDBC_info.Password =  $('#JDBC_Add_Page #Password').val() ;
		//JDBC_info.DataSource_class =  $('#JDBC_Add_Page #DataSource_class').val() ;
		JDBC_info.Driver =  $('#JDBC_Add_Page #Driver').val() ;
		JDBC_info.URL =  $('#JDBC_Add_Page #URL').val() ;
		JDBC_info.Pooling_Enable =  $('#JDBC_Add_Page #Pooling_Enable').val() ;
		JDBC_info.MaxPoolSize =  $('#JDBC_Add_Page #MaxPoolSize').val() ;
		JDBC_info.MinPoolSize =  $('#JDBC_Add_Page #MinPoolSize').val() ;
		//JDBC_info.Pool_IncrementSize =  $('#JDBC_Add_Page #Pool_IncrementSize').val() ;
		JDBC_info.Block_Timeout =  $('#JDBC_Add_Page #Block_Timeout').val()*1000 ;
		JDBC_info.Expire_Timeout =  $('#JDBC_Add_Page #Expire_Timeout').val()*1000 ;
		JDBC_info.Startup_Timeout =  $('#JDBC_Add_Page #Startup_Timeout').val()*1000 ;
		
	}    
	
	function checkForm() {
		if($('#JDBC_Add_Page #Alias_Name').val() == ""){
			alert("please input Alias Name !");
			$('#Alias_Name').focus();
			return false;
		}
		
		if($('#JDBC_Add_Page #Alias_Description').val() == ""){
			alert("please input Alias Description !");
			$('#Alias_Description').focus();
			return false;
		}
		
		if($('#JDBC_Add_Page #Account').val() == ""){
			alert("please input Confirm Account !");
			$('#Account').focus();
			return false;
		}

		if($('#JDBC_Add_Page #Password').val() == ""){
			alert("please input Password !");
			$('#Password').focus();
			return false;
		}
		
		/*if($('#JDBC_Add_Page #DataSource_class').val() == ""){
			alert("please input DataSource class !");
			$('#DataSource_class').focus();
			return false;
		}*/
		
		if($('#JDBC_Add_Page #URL').val() == ""){
			alert("please input URL !");
			$('#URL').focus();
			return false;
		}
		
		if($('#JDBC_Add_Page #Pooling_Enable').val() == "1"){
			
			if($('#JDBC_Add_Page #MaxPoolSize').val() == ""){
				alert("please input MaxPoolSize !");
				$('#MaxPoolSize').focus();
				return false;
			}
			
			if($('#JDBC_Add_Page #MinPoolSize').val() == ""){
				alert("please input MinPoolSize !");
				$('#MinPoolSize').focus();
				return false;
			}
			
			/*if($('#JDBC_Add_Page #Pool_IncrementSize').val() == ""){
				alert("please input Increment Size !");
				$('#Pool_IncrementSize').focus();
				return false;
			}*/
			
			if($('#JDBC_Add_Page #Block_Timeout').val() == ""){
				alert("please input Block Timeout !");
				$('#Block_Timeout').focus();
				return false;
			}
			
			if($('#JDBC_Add_Page #Expire_Timeout').val() == ""){
				alert("please input Expire Timeout !");
				$('#Expire_Timeout').focus();
				return false;
			}
			
			if($('#JDBC_Add_Page #Startup_Timeout').val() == ""){
				alert("please input Startup Timeout !");
				$('#Startup_Timeout').focus();
				return false;
			}
			
			if(parseInt($('#JDBC_Add_Page #MinPoolSize').val()) > parseInt($('#JDBC_Add_Page #MaxPoolSize').val())){
				alert("MinPoolSize cannot more than MaxPoolSize !");
				$('#MaxPoolSize').focus();
				return false;
			}
		}
		
		return true;
	}
	
	function setEditJDBC_info(data) {
		initPage();
		$('#JDBC_Add_Page #Alias_Name').attr('disabled', true);
		$('#JDBC_Add_Page #Alias_Name, #HideName').val(data["Alias_Name"]);
		$('#JDBC_Add_Page #Alias_Description').val(data['Alias_Description'])
		$('#JDBC_Add_Page #Account').val(data["Account"]) 
		$('#JDBC_Add_Page #Password').val(data["Password"]);
		$('#JDBC_Add_Page #Driver').val(data["Driver"])		
		$('#JDBC_Add_Page #URL').val(data["URL"]) 
		//$('#JDBC_Add_Page #DataSource_class').val(data["DataSource_class"]);
		$('#JDBC_Add_Page #Pooling_Enable').val(data["Pooling_Enable"]) 
		$('#JDBC_Add_Page #MaxPoolSize').val(data["MaxPoolSize"]);
		$('#JDBC_Add_Page #MinPoolSize').val(data["MinPoolSize"]);
		//$('#JDBC_Add_Page #Pool_IncrementSize').val(data["Pool_IncrementSize"]);
		$('#JDBC_Add_Page #Block_Timeout').val(data["Block_Timeout"]/1000);
		$('#JDBC_Add_Page #Expire_Timeout').val(data["Expire_Timeout"]/1000);
		$('#JDBC_Add_Page #Startup_Timeout').val(data["Startup_Timeout"]/1000);
		
		if(data["Disabled"] == 0) {
			$('#JDBC_Add_Page #save_newJDBC').attr('disabled', true);
		}
		
		JDBC_info.method = 'JDBC_edit';
		$('#save_newJDBC').html("儲存")
		
		$('#JDBC_Add_Page #Driver').trigger('change')
	}
	 
	function JDBC_summit(){

		setJDBC_info();
		 
		$.ajax({		
			url: "AliasServlet",
			type: "POST",
			data: JDBC_info,
			success:function(data) {
				console.log(data)
				$('#JDBC_Add_Page').modal('hide');
				  Condition.method = "AliasTable";
				  refresh_Table(AliasTable);
			},error: function (xhr) {
          		stopLoader();
          		errorLog(xhr.responseText);
	  		}
		});
	}
	
	$(document).ready(function() {
		
		$('#JDBC_Add_Page').on('change', '#Driver', function(e) {
			if($('#Driver').val() == "MySQL"){
				$('#Simple_URL').val("jdbc:mysql://<ip>:<port>/<database>?useUnicode=yes&characterEncoding=UTF-8");
			}else if($('#Driver').val() == "Oracle"){
				$('#Simple_URL').val("jdbc:oracle:thin:@//<Ip>:<Port>/<Service Name>");
			}else if($('#Driver').val() == "SQL_Server"){
				$('#Simple_URL').val("jdbc:sqlserver://<server>:<port>;databaseName=<databaseName>");
			}else if($('#Driver').val() == "Sybase"){
				$('#Simple_URL').val("jdbc:jtds:sybase://<server>:<port>;DatabaseName=<database>"); 
			}
		})
		
		$('#JDBC_Add_Page').on('click', '#save_newJDBC', function(e) {
			if(checkForm()){
				$.ajax({		
					url: "AliasServlet",
					type: "POST",
					data: {	"method" : "checkJBDC" ,
			  				"Name" :  $('#JDBC_Add_Page #Alias_Name').val(),
			  				"hideName" : $('#JDBC_Add_Page #HideName').val()
			  			  } ,
					success:function(data) {
						if(data == true){
			        	  		alert("已有相同的Alias Name！")
			        	  		return;
		        	  		}else{
		        	  			JDBC_summit();
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