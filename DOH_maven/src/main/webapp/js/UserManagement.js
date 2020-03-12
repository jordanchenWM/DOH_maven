function getUserTable(){
	var table = $('#User').DataTable( { 
		"dom": 'Bfrtip',
		"paging": false,
		"bInfo" : false,
		"order": [[ 6, "asc" ]],
        "columns": [ 
        	 	{
        	 		"data": "Account",
        	 		"render": function(data,type,full,meta){
        	 			if(data == "Admin"){
        	 				return "" ;
        	 			}else{
        	 				return "<a href='javascript:void(0)' id='remove_btn' ><i class='mdi mdi-close material-icons icon-red md-24'></i></a>" +
                	 		"<a href='javascript:void(0)' id='edit_user' style='margin-left:10%;'><i class='mdi mdi-pencil material-icons icon-green md-24'></i></a>"
        	 			}
        	 		}
        	 	},
       		//Account 
            {"data": "Account",
        	 		"render":function(data,type,full,meta){
        	 			if(data == null | data == ""){
	    					return "Unknown"
	    				}else
	    					return"<a href='javascript:void(0)' id='Partner_href' value=''>"+data+"</a>"
        	 			},
        	 		},
            //Last Name
            {"data": "last_name"},
            //Frist Name
            {"data": "frist_name"},
            {"data": "Phone"},
            //Mail
            {"data": "Mail"},
            //Role
            {"data": "Role"},
            {"data": "Password"}
            ],     
        "columnDefs": [
            {
                "targets": [ 7 ],
                "visible": false,
                "searchable": false
            }
        ],
        "initComplete" : function() {
            $("#search_box").keyup(function() {
                var oTable = $('.dataTable').dataTable();
                oTable.fnFilter($(this).val());
            });
        },
	});
	return table;
}


function refresh_Table(table) {
	$('#User_filter').hide();
	startLoader();
	$.ajax({		
		url: "UserManagementServlet",
		type: "POST",
		data: Condition ,
        success: function(datas) {
        		if (table != undefined){
	  			table.rows().remove();
	  			table.rows.add(datas);
	  			table.draw(); 	
		  	}
	        	stopLoader();
        },
        error: function (xhr) {
        		stopLoader();
        		errorLog(xhr.responseText);
        }
	});	
};





