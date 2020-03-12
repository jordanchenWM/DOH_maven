/*
urlParam = function(name) {
		  var results = new RegExp('[\\?&]' + name + '=([^&#]*)').exec(window.location.href);
		  if (!results) { return 0; }
		  return results[1] || 0;
}
*/

function urlParam(name) {
	var results = new RegExp('[\\?&]' + name + '=([^&#]*)').exec(window.location.href);
	if (!results) { return 0; }
	return results[1] || 0;
}
	  
function startLoader() {
	$('#loader').show();
}

function stopLoader() {
	$('#loader').fadeOut();
}

function displayChange(showDiv, hideDiv) {
	hideDiv.hide();
	showDiv.fadeIn();
}

function ReadyLoader() { 
	console.log( "ready!" );
	$("#sidebar").load("partials/_sidebar.jsp");
	$("#nav").load("partials/_navbar.jsp");	
	$("#footer").load("partials/_footer.html");
}

function checkSession() {
	$.ajax({			
		url: "UtilServlet",
		data: { "method": "checkSession" },
		type: "POST",
		async: false,
		success: function(response) {
			if (response != "session exist") {
				alert('session timeout 麻煩重登囉!!!');				
				window.location.href = 'login.html';
			}
		}
	});
}

function initDatePicker(dateItems,date) {
  	dateItems.Zebra_DatePicker({ 
  		//days:[ 'Saturday','Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday'],
  		format:'Y-m-d H:i',
  		enabled_hours:"True",
  		enabled_minutes:"True",
  		first_day_of_week: '0' ,
  		show_icon:"TRUE",
  		icon_position:"right",
  		open_icon_only:"TRUE",			
  		offset:[20,200],
  		//start_date: '2019-04-03'
  	});
 }
  
function initFieldType(selectItem) {
	$.ajax({		
		url: "UtilServlet",
		data: { "method": "FieldType" },
		type: "POST",
        success: function(datas) {         	
        	$.each( datas, function( key, value ) { 				
        			selectItem.append($("<option></option>").attr("value", value.Field_ID).text(value.Field_Type));
			});
        	
	  	},
        error: function (jqXHR, exception) {
        		errorLog(jqXHR.responseText);	
		}      
	});
}	 

function initPartner(selectItem) {
	 
	$.ajax({		
		url: "UtilServlet",
		data: { "method": "Partner" },
		type: "POST",
        success: function(datas) {         	
        	$.each( datas, function( key, value ) { 				
        			selectItem.append($("<option></option>").attr("value", value.PartnerID).text(value.CorporationName));
			});
	  	},
        error: function (jqXHR, exception) {
        		errorLog(jqXHR.responseText);	
		}      
	});
}	

function initDocType(selectItem) {
	 
	$.ajax({		
		url: "UtilServlet",
		data: { "method": "DocumentType" },
		type: "POST",
        success: function(datas) {         	
        	$.each( datas, function( key, value ) { 				
        			selectItem.append($("<option></option>").attr("value", value.TypeID).text(value.TypeName));
			});
	  	},
        error: function (jqXHR, exception) {
        		errorLog(jqXHR.responseText);	
		}      
	});
}

function initFileList(selectItem) {
	 
	$.ajax({		
		url: "ServiceList",
		data: { "method": "FolderFileList" },
		type: "POST",
        success: function(datas) {
        	$.each( datas, function( key, value ) { 
        		selectItem.append($("<option></option>").attr("value", value.service).text(value.service));
			});
	  	},
        error: function (jqXHR, exception) {
        	errorLog(jqXHR.responseText);	
		}      
	});
}

function initProtocol(selectItem) {
	selectItem.empty().append($("<option></option>").attr("value", "").text("請選擇"));
	$.ajax({		
		url: "UtilServlet",
		data: { "method": "Protocol"},
		type: "POST",
        success: function(datas) {
	        	$.each( datas, function( key, value ) { 		
	        			selectItem.append($("<option></option>").attr("value", value.Protocol).text(value.Protocol));
	        	})
	  	},
        error: function (jqXHR, exception) {
        		errorLog(jqXHR.responseText);	
		}      
	});
}

function initType(selectItem) {
	selectItem.empty().append($("<option></option>").attr("value", "").text("請選擇"));
	$.ajax({		
		url: "UtilServlet",
		data: {"method": "DeliveryType"},
		type: "POST",
        success: function(datas) {
	        	$.each( datas, function( key, value ) { 		
	        			selectItem.append($("<option></option>").attr("value", value.Type).text(value.Type));
	        	})
	        	selectItem.append($("<option></option>").attr("value", "Other").text("Other"));
	  	},
        error: function (jqXHR, exception) {
        		errorLog(jqXHR.responseText);	
		}      
	});
}

function initOneToSixty(selectItem){
	
	for(var i=0;i<60;i++){
		selectItem.append($("<option></option>").attr("value", i).text(i));
	}
}

function initOneToTwentyfour(selectItem){
	
	for(var i=0;i<24;i++){
		selectItem.append($("<option></option>").attr("value", i).text(i));
	}
}

function errorLog(Content) {
	console.log(Content)
    if (Content.length > 400) {
    	Content = Content.substring(0, 400) + "... ..."
    }
    
    $('#error_msg').text(Content);
    $('.alert').show();
}
