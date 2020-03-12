function getDocumentTypeTable(){
	var table = $('#DocumentType_table').DataTable( { 
		"dom": 'Bfrtip',
		"paging": false,
		"scrollX": true,
		"bInfo" : false,
		"order": [[ 1, "asc" ]],
        "columns": [ 
        	 	{"defaultContent": "<a href='javascript:void(0)' id='remove_btn' ><i class='mdi mdi-close material-icons icon-red md-24'></i></a>" +
        	 		"<a href='javascript:void(0)' id='edit_btn' style='margin-left:10%;'><i class='mdi mdi-pencil material-icons icon-green md-24'></i></a>"},
       		//TypeName
            {
        	 	"data": "TypeName",
        	 	"className": "text-left"
        	 },
            //TypeDescription
            {
        		 "data": "TypeDescription",
     	 		 "className": "text-left"
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
            //LastModified
            {"data": "LastModified"},
            {
            	"data": "RootTag",
    	 		 "className": "text-left"
    	 	},
            {"data": "ReceiverTypeName"},
            {
            	"data": "ReceiverPath",
    	 		 "className": "text-left"
    	 	},
            {"data": "SenderTypeName"},
            {
            	"data": "SenderPath",
    	 		 "className": "text-left"
    	 	},
            {
    	 		"data": "DocumentPath",
    	 		 "className": "text-left"
    	 	},
            {
    	 		"data": "ConversationPath",
    	 		 "className": "text-left"
    	 	},
            {
            	"data": "SchemaPath",
    	 		 "className": "text-left"
    	 	},
            {"data": "ReceiverType"},
            {"data": "SenderType"},
            {"data": "TypeID"},
            ],     
        "columnDefs": [
            {
                "targets": [ 13, 14, 15 ],
                "visible": false,
            }
        ],
        "buttons": [
            { 
                extend: 'colvisGroup',
                text: 'Office info',
                show: [ 1, 2 ],
                hide: [ 3, 4, 5 ]
            },
            {
                extend: 'colvisGroup',
                text: 'HR info',
                show: [ 3, 4, 5 ],
                hide: [ 1, 2 ]
            },
            {
                extend: 'colvisGroup',
                text: 'Show all',
                show: ':hidden'
            }
        ],
        "initComplete" : function() {
            $("#DocumentType_search_box").keyup(function() {
                var oTable = $('#DocumentType_table').dataTable();
                oTable.fnFilter($(this).val());
            });
        },
	});
	//function(data,type,full,meta){
	return table;
}



function refresh_Table(table) {
	
	$('#DocumentType_table_filter').hide()
	
	startLoader();
	$.ajax({		
		url: "DocumentTypeServlet",
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


