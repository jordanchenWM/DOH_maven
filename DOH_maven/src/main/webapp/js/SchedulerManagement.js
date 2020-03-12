function getScheduleTable(){
	var table = $('#Schedule_table').DataTable( { 
		"bInfo" : false,
		"scrollX": true,
		"order": [[ 1, "asc" ]],
        "columns": [ 
        	 	{"defaultContent": "<a href='javascript:void(0)' id='delete_btn' ><i class='mdi mdi-close material-icons icon-red md-24'></i></a>" +
        	 		"<a href='javascript:void(0)' id='edit_schedule' style='margin-left:10%;'><i class='mdi mdi-pencil material-icons icon-green md-24'></i></a>"},			
            {
        	 	"data": "TASK_NAME",
    	 		 "className": "text-left"
    	 	},
 			//STATE
            {
        		"data": "STATE" ,
    	 		"render":function(data){
    	 			var word ;
    	 			if(parseInt(data) == 1){
    	 				return "<i class='mdi mdi-run icon-green material-icons md-24 '></i>"
    	 			}else {
    	 				return"<i class='mdi mdi-sleep text-muted material-icons md-24 '></i>"
    	 			}
    	 		}
            },
        	 	{
            		"data": "STATE" ,
        	 		"render":function(data){
        	 			var word ;
        	 			if(parseInt(data) == 0){
        	 				return "<a href='javascript:void(0)' id='Active_btn' class='icon-green' ><i class='mdi mdi-play material-icons md-24'></i>Active</a>"
        	 			}else {
        	 				return "<a href='javascript:void(0)' id='Suspended_btn'><i class='mdi mdi-stop  material-icons md-24'></i>Suspended</a>"
        	 			}
        	 		}
            },
       		//DESCRIPTION 
            {
            	"data": "DESCRIPTION",
   	 		 	"className": "text-left"
   	 		 },
            //SERVICE
            {"data": "SERVICE"},
            //STARTTIME
            {"data": "STARTTIME"},
            //ENDTIME
            {"data": "ENDTIME"},
            //NEXTRUN
            {"data": "NEXTRUN"},
            //LASTERROR
            {"data": "LASTERROR"},
            //TIMEINTERVAL
            { "data": "TIMEINTERVAL"},
            //HOURMASK
            { "data": "HOURMASK" },
            //MINUTEMASK
            { "data": "MINUTEMASK" },
            {"data": "UUID"},
        ], 
        "columnDefs": [
            {
                "targets": [ 10, 11, 12, 13 ],
                "visible": false,
                "searchable": false
            }
        ],
        "initComplete" : function() {
            $("#scheduleSearch_box").keyup(function() {
                var oTable = $('#Schedule_table').dataTable();
                oTable.fnFilter($(this).val());
            });
        },
	});
	return table;
}

function refresh_Table(table, condition) {
	$('#Schedule_table_filter').hide();
	startLoader();
	$.ajax({		
		url: "SchedulerManagementServlet",
		type: "POST",
		data: condition ,
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
