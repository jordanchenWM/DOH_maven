function getProcessTable(){
	var table = $('#Processing_table').DataTable( { 
		"dom": 'Bfrtip',
		"paging": false,
		"scrollX": true,
		"bInfo" : false,
		"order": [[ 1, "asc" ]],
        "columns": [ 
        	 	{"defaultContent": "<a href='javascript:void(0)' id='remove_btn' ><i class='mdi mdi-close material-icons icon-red md-24'></i></a>" +
        	 		"<a href='javascript:void(0)' id='edit_btn' style='margin-left:10%;'><i class='mdi mdi-pencil material-icons icon-green md-24'></i></a>"},
       		//RuleIndex
            {"data": "RuleIndex"},
            //RuleName
            {"data": "RuleName"},
            //RuleDescription
            {"data": "RuleDescription"},
            //Status 
            {	
	            	"data": "Disabled",
	            	"render":function(data,type,full,meta){
	    	 			if(data == 0){
	    					return "<i class='mdi mdi-check icon-green material-icons md-24 '></i>"
	    				}else
	    					return"<i class='mdi mdi-close-circle-outline icon-red material-icons md-24 '></i>"
	    	 			}
            }, 
            //SenderName
            {
            		"data": "SenderName" ,
            		"render":function(data,type,full,meta){
        	 			if(data == null | data == "" || full.SenderID == "00001"){
	    					return "unknown"
	    				}else if(full.SenderID == "00001" || full.SenderID == "Any"){
	    					return data
	    				}else
	    					return"<a href='partner_Profiles.jsp?PartnerID="+full.SenderID+"' value="+full.SenderID+">"+data+"</a>"
        	 		},
            },
            //ReceiverName
            {
            		"data": "ReceiverName",
            		"render":function(data,type,full,meta){
        	 			if(data == null | data == "" || full.ReceiveID == "00001"){
	    					return "Unknown"
	    				}else if(full.ReceiverID == "00001" || full.ReceiverID == "Any"){
	    					return data
	    				}else
	    					return"<a href='partner_Profiles.jsp?PartnerID="+full.ReceiverID+"' value="+full.ReceiverID+">"+data+"</a>"
        	 		},
        	 	},
        	 	//DocTypeName
            {"data": "DocTypeName"},
            //SERVICE
            {"data": "Service"},
            //LastModified
            {"data": "LastModified"},
            {"data": "RuleID"},
            {"data": "SenderID"},
            {"data": "ReceiverID"},
            {"data": "DocTypeID"},
            ],     
        "columnDefs": [
            {
                "targets": [ 10, 11, 12, 13 ],
                "visible": false,
                "searchable": false
            }
        ],
        "initComplete" : function() {
            $("#Processing_search_box").keyup(function() {
                var oTable = $('#Processing_table').dataTable();
                oTable.fnFilter($(this).val());
            });
        },
	});
	//function(data,type,full,meta){
	return table;
}



function refresh_Table(table) {
	$('#Processing_table_filter').hide()
	
	startLoader();
	$.ajax({		
		url: "ProcessingServlet",
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