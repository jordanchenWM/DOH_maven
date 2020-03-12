function getBizDocTable(){
	var table = $('#BizDoc_log').DataTable( {  
		"iDisplayLength": 15,
		//"searching": false,
		"order": [[ 1, "desc" ]],
		"scrollX": true,
		"scrollY": "580px",
		"scrollCollapse": true,
		"lengthMenu": [15, 30, 50, 100],
        "columns": [
        		{
        			"defaultContent":"<input type='checkbox'/>",
        			"orderable": false
        		},
            //Receive Time
            {
        		"data": "DocTimestamp",
            	"render":function(data, type, full, meta) {
            		return "<a href='javascript:void(0);' class='ts_time_btn'>" + data +"</a>";
            	}
        	},
            //Doc type
            {	
            		"data": "DocTypeName" ,
            		"className" : "text-center",
            		"render":function(data,type,full,meta){
            			if(data == null || data == ""){
    						return "unknown"
    					}else if(full.DocTypeID == "00001"){
    						return data;
    					}else{
    						return"<a href='documentType_profile.jsp?TypeName="+full.DocTypeID+"' id='DocType_href' value="+full.DocTypeID+">"+data+"</a>"
    					}
            			/*
            			if($('#role').html().toLowerCase() == 'admin'){
            				if(data == null || data == ""){
    	    						return "unknown"
    	    					}else if(full.DocTypeID == "00001"){
    	    						return data;
    	    					}else{
    	    						return"<a href='DocumentType_profile.jsp?TypeName="+full.DocTypeID+"' id='DocType_href' value="+full.DocTypeID+">"+data+"</a>"
    	    					}
            			}else{
            				return data;
            			}
            			*/
	    			}
            },
            //Sender
		    {	
            		"data": "SenderName",
	            	"render":function(data,type,full,meta){
	            		if(data == null | data == "" || full.SenderID == "00001"){
	    					return "unknown"
	    				}else if(full.SenderID == "00001" || full.SenderID == "Any"){
	    					return data
	    				}else {
	    					return"<a href='partner_Profiles.jsp?PartnerID="+full.SenderID+"' id='Partner_href' value="+full.SenderID+">"+data+"</a>"
	    				}
	            		/*
	            		if($('#role').html().toLowerCase() == 'admin'){
		    				if(data == null | data == "" || full.SenderID == "00001"){
		    					return "unknown"
		    				}else if(full.SenderID == "00001" || full.SenderID == "Any"){
		    					return data
		    				}else {
		    					return"<a href='Partner Profiles.jsp?PartnerID="+full.SenderID+"' id='Partner_href' value="+full.SenderID+">"+data+"</a>"
		    				}
		    			}else {
		    				return data;
		    			}
	            		*/
	            	}
            },
            //Receiver
	        {	
            		"data": "ReceiverName",
            		"render":function(data,type,full,meta){
            			if(data == null | data == "" || full.ReceiverID == "00001"){
	    					return "unknown"
	    				}else if(full.ReceiverID == "00001" || full.ReceiverID == "Any"){
	    					return data
	    				}else{
	    					return"<a href='partner_Profiles.jsp?PartnerID="+full.ReceiverID+"' id='Partner_href' value="+full.ReceiverID+">"+data+"</a>"
	    				}
            			/*
            			if($('#role').html().toLowerCase() == 'admin'){
		    				if(data == null | data == "" || full.ReceiverID == "00001"){
		    					return "unknown"
		    				}else if(full.ReceiverID == "00001" || full.ReceiverID == "Any"){
		    					return data
		    				}else{
		    					return"<a href='Partner Profiles.jsp?PartnerID="+full.ReceiverID+"' id='Partner_href' value="+full.ReceiverID+">"+data+"</a>"
		    				}
		    			}else{
		    				return data;
		    			}
            			*/
            		}
            },
            //Processing Status
            {"data": "RoutingStatus"},
            //User Status 
            {"data": "UserStatus"},
            {"data": "ConversationID"},
            {"data": "NativeID"},
            //Detail
            {
            	"orderable": false,	
            	"defaultContent":"<a href='javascript:void(0)' id='BizDoc_detail_btn'><i class='mdi mdi-yeast material-icons icon-green md-24' id='detail_mdi'></i></a>"
            },
            //ActivityTable's key
            {"data" : "DocID"},
            {"data": "SenderID"},
            {"data": "ReceiverID"},
            {"data": "DocTypeID"}
        ],     
        "columnDefs": [
            {
                "targets": [ 10, 11, 12, 13 ],
                "visible": false,
                "searchable": false
            }
        ]
	});
	  
	return table;
}


function getActivityTable(){
	var table = $('#Activity_log').DataTable( {  		
		"searching": false,
		"scrollX": true,
		"scrollCollapse": true,
		"paging": false,
		"bInfo" : false,
		"order": [[ 1, "desc" ]],		
        "columns": [ 
            //EntryType
            {
            		"data": "EntryType",
            		"className" : "text-center",
            		"orderable": false,
            		"render":function(data, type, full, meta) {
            			switch (data) {
            			case "0":
            				return "<i class='fa fa-times-circle text-danger'></i>" 
            				break;
            			case "1":
            				return "<i class='fa fa-warning text-warning'></i>"            				
            				break;
            			case "2":
            				return "<i class='fa fa-info-circle text-primary'></i>"
            				break;      
            			default:
            				return data;
            			}
    					//return "<a href='javascript:void(0)' id='replay_btn' style='align:center'><i class='mdi mdi-reply material-icons icon-green md-24'></i></a>"
                	}
            },
            //EntryTimestamp
            { "data": "EntryTimestamp"},
            //BriefMessage
	        {"data": "BriefMessage"},
            //EntryClass
	        {"data": "EntryClass"},
            //B2BUser
            {"data": "B2BUser"},
            //RelatedPartnerID
            {"data": "RelatedPartnerID"},
            //Detail
            { 	"orderable": false,
            	"className" : "text-center", "defaultContent":"<a href='javascript:void(0)' id='Activity_detail_btn'><i class='mdi mdi-arrow-down-bold material-icons icon-green md-24'></i></a>" 
            },
            //FullMessage key 
            {"data": "ActivityLogID"}
        ],  
        "columnDefs": [
            {
                "targets": [ 7 ],
                "visible": false,
                "searchable": false
            }            
        ]
	});
	  
	return table;
}


function getBizDocContentTable(){
	var table = $('#BizDocContent_log').DataTable( {  		
		"searching": false,
		"paging": false,
		"bInfo" : false,
		"scrollX": true,
		"ordering": false,
        "columns": [ 
            //PartName
            {"data": "PartName"},
            //ContentLength
            {"data": "ContentLength"},
            //MimeType
	        {"data": "MimeType"},
            //Detail
            {"className" : "text-center","defaultContent":"<a href='javascript:void(0)' id='BizDocContent_detail_btn'><i class='mdi mdi-arrow-right-bold-hexagon-outline material-icons icon-green md-24'></i></a>" },
            //Content key
            {"data": "DocID"},
        ], 
        "columnDefs": [
            {
                "targets": [ 4 ],
                "visible": false,
                "searchable": false
            }
        ]
	});
	  
	return table;
}


function getActivityFullMessageTable(){
	var table = $('#Activity_full_message').DataTable( {  
		"searching": false,
		"paging": false,
		"bInfo" : false,
		"ordering": false,
        "columns": [ 
            //full_message
            {"data": "FullMessage"}
            ],     
	});
	  
	return table;
}



function getContentTable(){
	var table = $('#BizDocContent_Content').DataTable( {  
		"searching": false,
		"paging": false,
		"bInfo" : false,
		"ordering": false,
        "columns": [ 
            //Content
            {"data": "Content"},
            ],     
	});
	  
	return table;
}


function refresh_Table(table) {
	
	startLoader();
	$.ajax({		
		url: "TransactionServlet",
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



function refreshXML_Table(table) {
	
	startLoader();
	$.ajax({		
		url: "TransactionServlet",
		type: "POST",
		data: Condition ,
        success: function(datas) {
        console.log(datas[0]['Content'])
        $('#contentXML').text(datas[0]['Content'])
	        	stopLoader();
        },
        error: function (xhr) {
        		stopLoader();
        		errorLog(xhr.responseText);
        }
	});	
};

function resummit_check(checkbox) {
	
	startLoader();
	$.ajax({		
		url: "TransactionServlet",
		type: "POST",
		data: { "method" : "resummit" ,
				"checkboxs" : checkbox } ,
        success: function(datas) {
        	    Condition.method='BizDocTable';
   		    refresh_Table(BizDocTable);
        },
        error: function (xhr) {
        		stopLoader();
        		errorLog(xhr.responseText);
        }
	});	
};

function initCondition(){
	
	Condition = {};
	Condition.start_date = '';
	Condition.end_date = '';
	
}

function ClickChange(button){
	button.parents('tr').parents('tbody').children('tr').children('td').removeClass("background-burlywood");
	button.parents('tr').parents('tbody').children('tr').children('td').children('a').children('i').removeClass('icon-clickred');
	button.parents('tr').children('td').addClass("background-burlywood");
	button.children('i').addClass('icon-clickred');
	button.parents('td').addClass('180_rotate');
	//button.css('color', 'red !important;')
}

function setCondition(){
	
	initCondition();
	Condition.start_date = $('#start_date').val();
	Condition.end_date = $('#end_date').val();
}

function moment_sub(num, unit){
	
	return moment().subtract(num, unit).format("Y-MM-DD  HH:mm:ss")
}

function change_range(range){

	switch(String(range)){
	  
	  case "all":
		  $('#start_date, #end_date').val("");
		  break;
	  case "this_day":
		  $('#start_date').val(moment().format("Y-MM-DD  00:00"));
		  $('#end_date').val(moment().format("Y-MM-DD  23:59"));
		  
		  break;
	  case "this_week":
		  $('#start_date').val(moment().startOf('isoWeek').format("Y-MM-DD  00:00"));
		  $('#end_date').val(moment().endOf('isoWeek').format("Y-MM-DD  23:59"));
		  break;
	  case "this_month":
		  $('#start_date').val(moment().startOf('month').format("Y-MM-DD  00:00"));
		  $('#end_date').val(moment().endOf('month').format("Y-MM-DD  23:59"));
		  break;
	  case "this_year":
		  $('#start_date').val(moment().startOf('year').format("Y-MM-DD  00:00"));
		  $('#end_date').val(moment().endOf('year').format("Y-MM-DD  23:59"));
		  break;
	  case "previous_day":
		  $('#start_date').val(moment().subtract(1, 'day').format("Y-MM-DD  00:00"));
		  $('#end_date').val(moment().subtract(1, 'day').format("Y-MM-DD  23:59"));
		  break;
	  case "previous_week":
		  $('#start_date').val(moment().startOf('isoWeek').subtract(1, 'week').format("Y-MM-DD  00:00"));
		  $('#end_date').val(moment().endOf('isoWeek').subtract(1, 'week').format("Y-MM-DD  23:59"));
		  break;
	  case "previous_month":
		  $('#start_date').val(moment().startOf('month').subtract(1, 'month').format("Y-MM-DD  00:00"));
		  $('#end_date').val(moment().endOf('month').subtract(1, 'month').format("Y-MM-DD  23:59"));
		  break;
	  case "previous_year":
		  $('#start_date').val(moment().startOf('year').subtract(1, 'year').format("Y-MM-DD  00:00"));
		  $('#end_date').val(moment().endOf('year').subtract(1, 'year').format("Y-MM-DD  23:59"));
		  break;
	  case "last_hour":
		  $('#start_date').val(moment_sub(1, 'hour'));
		  $('#end_date').val(moment_sub());
		  break;
	  case "last_four_hour":
		  $('#start_date').val(moment_sub(4, 'hour'));
		  $('#end_date').val(moment_sub());
		  break;
	  case "last_twenty-four_hour":
		  $('#start_date').val(moment_sub(24, 'hour'));
		  $('#end_date').val(moment_sub());
		  break;
	  case "last_two_days":
		  $('#start_date').val(moment_sub(2, 'day'));
		  $('#end_date').val(moment_sub());
		  break;
	  case "last_seven_days":
		  $('#start_date').val(moment_sub(7, 'day'));
		  $('#end_date').val(moment_sub());
		  break;
	  case "last_fourteen_days":
		  $('#start_date').val(moment_sub(14, 'day'));
		  $('#end_date').val(moment_sub());
		  break;
	  case "last_thirty_days":
		  $('#start_date').val(moment_sub(30, 'day'));
		  $('#end_date').val(moment_sub());
		  break;
	  case "last_sixty_days":
		  $('#start_date').val(moment_sub(60, 'day'));
		  $('#end_date').val(moment_sub());
		  break;
	  case "last_ninety_days":
		  $('#start_date').val(moment_sub(90, 'day'));
		  $('#end_date').val(moment_sub());
		  break;
	  case "last_year_days":
		  $('#start_date').val(moment_sub(1, 'year'));
		  $('#end_date').val(moment_sub());
		  break;
	  }
	
	
}
