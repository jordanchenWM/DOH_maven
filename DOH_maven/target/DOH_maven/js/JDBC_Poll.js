function getAliasTable(){
	var table = $('#JDBC_pool').DataTable( { 
		"dom": 'Bfrtip',
		"paging": false,
		"bInfo" : false,
		"order": [[ 1, "asc" ]],
        "columns": [ 
        		{
        			"data": "Disabled",
	            	"render":function(data,type,full,meta){
	            		var icon = ""; 
	    	 			var delete_btn = "";
	            		if(data == 0){
	            			delete_btn = "<a href='javascript:void(0)' id='delete_btn' ><i class='mdi mdi-close material-icons icon-red md-24'></i></a>"
	    	 				icon = "<a href='#' id='enable_Alias' style='margin-left:5%;'><i class='mdi mdi-stop material-icons icon-orange md-24'></i></a>"
	    				}else{
	    					delete_btn = "<a href='javascript:void(0)' id='delete_btn' disabled='disabled' ><i class='mdi mdi-close material-icons icon-red md-24'></i></a>"
	    					icon = "<a href='#' id='enable_Alias' style='margin-left:5%;'><i class='mdi mdi-play material-icons icon-blue md-24'></i></a>"
	    				}
        			
	            		return delete_btn + 
	            		"<a href='javascript:void(0)' id='edit_Alias' style='margin-left:5%;'><i class='mdi mdi-pencil material-icons icon-green md-24'></i></a>" +
		 		icon
	            	}
	        },
       		//Alias_Name
            {"data": "Alias_Name"},
            //Alias_Description
            {"data": "Alias_Description"},
            //Driver
            {"data": "Driver"},
            //disable
            {
	            	"data": "Disabled",
	            	"render":function(data,type,full,meta){
	    	 			if(data == 0){
	    					return "<i class='mdi mdi-check icon-green material-icons md-24 '></i>"
	    				}else
	    					return"<i class='mdi mdi-close-circle-outline icon-red material-icons md-24 '></i>"
	    	 			}
            },
            //URL
            {"data": "URL"},
            {"data": "Account"},
            {"data": "Password"},
            {"data": "DataSource_class"},
            {"data": "Pooling_Enable"},
            {"data": "MaxPoolSize"},
            {"data": "MinPoolSize"},
            {"data": "Block_Timeout"},
            {"data": "Expire_Timeout"},
            {"data": "Startup_Timeout"},
            {"data": "Disabled"} 
            ],
        "columnDefs": [
            {
                "targets": [ 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 ],
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
	$('#JDBC_pool_filter').hide();
	startLoader();
	$.ajax({		
		url: "AliasServlet",
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

function test_Connection() {
	$('#JDBC_pool_filter').hide();
	startLoader();
	$.ajax({		
		url: "AliasServlet",
		type: "POST",
		data: Condition ,
        success: function(datas) {
        		alert(datas)
	        	stopLoader();
        },
        error: function (xhr) {
        		stopLoader();
			alert(xhr.responseText);
        }
	});	
};




