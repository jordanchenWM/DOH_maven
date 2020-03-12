
function appendMethod(key, item){
	item.empty();
	$.ajax({		
		url: "PartnerServlet",
		data: { "method": "getDelivery" ,
				"PartnerID": key },
		type: "POST",
        success: function(datas) {
        	var host ;
        	var Port ;
        	$.each( datas, function( key, value ) { 	
        		value.Host == "" ? host = "" : host = value.Host + ":" ;
        				
    			item.append("<div class='delivery_div' ><a href='javascript:void(0)' id='remove_delivery_btn' ><i class='mdi mdi-close material-icons icon-red md-24'></i></a> " +
    					" <a href='javascript:void(0)' id='edit_delivery_btn'><i class='mdi mdi-pencil material-icons icon-green md-24'></i></a> " +
    					" <a>"+ value.Methods +"</a>" +
    					" <div style='text-align:center' ><span class='display_block'> Host / Port / Location: "+ host + value.Port + "/" + value.Location +"</span> " +
    					" <span class='display_block' style='margin-top: 1%;'> User Name : "+ value.UserName + "</span>" +
    					" <input type='hidden' id='delivery' value='" + value.DeliveryID + "'/> </div><div> ");
			});
	  	},
        error: function (jqXHR, exception) {
        	stopLoader();
        	errorLog(jqXHR.responseText);	
		}      
	});
}

function appendProtocol(PartnerID){
	
	startLoader();
	$.ajax({		
		url: "PartnerServlet",
		type: "POST",
		data: { "method" : "getPreferred" ,
				"PartnerID" : PartnerID},
        success: function(datas) {
        		if(datas[0] === undefined) {
        			$('#protocol').html("Queue for polling")
        		}else
        			$('#protocol').html(datas[0]['Methods'])
	        	stopLoader();
        },
        error: function (xhr) {
        		stopLoader();
        		errorLog(xhr.responseText);
        }
	});	
}

function delete_Delivery(deliveryID) {

	startLoader();
	$.ajax({		
		url: "PartnerServlet",
		type: "POST",
		data: { "method" : "delete_delivery" ,
				"deliveryID" : deliveryID},
        success: function(datas) {
        		appendMethod($('#hidePartnerID').val(), $('#method'))
	        	stopLoader();
        },
        error: function (xhr) {
        		stopLoader();
        		errorLog(xhr.responseText);
        }
	});	
};

function edit_delivery(deliveryID){
	
	$.ajax({		
		url: "PartnerServlet",
		type: "POST",
		data: { "method" : "getEditDeliveyInfo" ,
				"deliveryID" : deliveryID},
        success: function(datas) {
        		var Info = datas[0]
        		showAdd_Delivery();
        		setEditDeliveryPage(Info)
	        	stopLoader();
        },
        error: function (xhr) {
        		stopLoader();
        		errorLog(xhr.responseText);
        }
	});	
}

$('#method').on('click', '#remove_delivery_btn', function(e) {
	if(confirm('Are you sure you want to remove this delivery?')){
	  var deID = $(this).parent("div").children("div").children(":input").val();
	  delete_Delivery(deID);
	}
})

$('#method').on('click', '#edit_delivery_btn', function(e) {
	 var deID = $(this).parent("div").children("div").children(":input").val();
	 edit_delivery(deID);
})





