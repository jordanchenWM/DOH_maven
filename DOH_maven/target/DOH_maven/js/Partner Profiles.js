function getPartnerTable(){
	var table = $('#Partner').DataTable( { 
		"dom": 'Bfrtip',
		//"paging": false,
		"bInfo" : false,
		"order": [[ 1, "asc" ]],
        "columns": [ 
        		{"defaultContent": "<a href='javascript:void(0)' id='remove_btn' ><i class='mdi mdi-close material-icons icon-red md-24'></i></a>"},
       		//Partner Name
            {"data": "CorporationName",
        	 		"render":function(data,type,full,meta){
        	 			if(data == null | data == ""){
	    					return "Unknown"
	    				}else
	    					return"<a href='javascript:void(0)' id='Partner_href' value="+full.PartnerID+">"+data+"</a>"
        	 			},
        	 		},
            //Status
            {
        	 			"data": "Status",
		            	"render":function(data,type,full,meta){
		    	 			if(data == 1){
		    					return "<i class='mdi mdi-check icon-green material-icons md-24 '></i>"
		    				}else
		    					return"<i class='mdi mdi-close-circle-outline icon-red material-icons md-24 '></i>"
		    	 			}
    	 		},
    	 		//Last Modify
            {"data": "LastModified"},
            {"data": "PartnerID"},
            {"data": "OrgUnitName"}
            ],     
        "columnDefs": [
            {
                "targets": [ 4,5 ],
                "visible": false,
            }
        ]/*,
        "initComplete" : function() {
            $("#search_box").keyup(function() {
                var oTable = $('.dataTable').dataTable();
                oTable.fnFilter($(this).val());
            });
        }*/
	});
	//function(data,type,full,meta){
	return table;
}

function FirstRefresh_Table(table) {
	
	startLoader();
	
	$.ajax({		
		url: "PartnerServlet",
		type: "POST",
		data: Condition ,
        success: function(datas) {
        		if (table != undefined){
	  			table.rows().remove();
	  			table.rows.add(datas);
	  			table.draw(); 	
		  	}
	        	stopLoader();
	        	
	        	PartnerSeach = urlParam("PartnerID")
	        	//PartnerTable.search(PartnerSeach).draw();

	            if (PartnerSeach != 0 ){
	        		 $('a[value="' + PartnerSeach + '"]').click();
	        	}
	      	  
        },
        error: function (xhr) {
        		stopLoader();
        		errorLog(xhr.responseText);
        }
	});	
};

function refresh_Table(table) {
	
	startLoader();
	$.ajax({		
		url: "PartnerServlet",
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
