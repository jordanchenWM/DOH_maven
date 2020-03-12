  
  function getPartnerDetailTable(){
		var table = $('#detail_table').DataTable( { 
			"dom": 'Bfrtip',
			"searching": false,
			"paging": false,
			"bInfo" : false,
			"order": [[ 1, "desc" ]],
	        "columns": [ 
	        		{"defaultContent": "<a href='#' id='remove_btn' ><i class='mdi mdi-close material-icons icon-red md-24'></i></a>" +
	        			"<a href='#' id='edit_btn' style='margin-left:3%;'><i class='mdi mdi-pencil material-icons icon-green md-24'></i></a>"},
	       		//Field
	            {"data": "Field"},
	            //Field_Value
	            {"data": "Field_Value"},
	            //FieldID
	            {"data": "FieldID"},
	            //PartnerID
	            {"data": "PartnerID"},
	            //Field_ID
	            {"data": "Field_ID"}
	        ],
	        "columnDefs": [
	            {
	                "targets": [ 3, 4, 5 ],
	                "visible": false,
	                "searchable": false
	            }
	        ],
		});
		return table;
	}


  function refresh_PartnerTable(table,codition) {
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
  
  function check_duplicateDetail(Field_name, Field_val) {
	  $.ajax({		
	  		url: "PartnerServlet",
	  		type: "POST",
	  		data: {	"method" : "checkDetail" ,
	  				"col1" : Field_name	,	
	  				"col2" : Field_val
	  				} ,
	  		success: function(datas) {
	        	  	if(datas == true){
	        	  		errorLog("此筆與其他資料重複！")
	        	  	}else{
	        	  		summit();
	        	  	}
	        	},
	  		error: function (xhr) {
          		stopLoader();
          		errorLog(xhr.responseText);
	  		}
	 });
  }
  
  function summit(){
	  
		setDetail_Info();
		
		$.ajax({		
			url: "PartnerServlet",
			type: "POST",
			data: detail_Info,
			success:function(data) {
				Condition.method='Detail';
				refresh_PartnerTable(detailTable, Condition)
				$('#Detail_Add_Page').modal('hide');
			},
			error: function (xhr) {
	      		stopLoader(); 
	      		errorLog(xhr.responseText);
	      	}
		});
  }
  
  $('#detail_table').on('click', '#remove_btn', function(e) {
	  if(confirm('Are you sure you want to remove this Field Value ?')){
		  var data = detailTable.row($(this).parents('tr')).data(); 
		  
		  Condition.method='Detail_delete';
		  Condition.FieldID = data['FieldID']
		  Condition.PartnerID = data['PartnerID']
		  refresh_PartnerTable(detailTable, Condition)
	  }
  })
  
  $('#detail_table').on('click', '#edit_btn', function(e) {
		  var data = detailTable.row($(this).parents('tr')).data(); 
		  
		  editDetail_Info(data);
		  showAdd_Detail();
  })
  
  
    function detailStatus(ID) {
  	
  	startLoader();
  	$.ajax({		
  		url: "PartnerServlet",
  		type: "POST",
  		data: {	"ID" : ID ,
  				"method" : "PartnerOne"} ,
          success: function(datas) {
        	  var data = datas[0]
    		  $('#corporation').html(data['CorporationName']);
    		  if(data['Deleted'] == 1){
    			  $('#status').html("<i class='mdi mdi-check icon-green material-icons md-24 '></i>") 
    			}else{
    			  $('#status').html("<i class='mdi mdi-close-circle-outline icon-red material-icons md-24 '></i>")
    			}
    		  
    		  $('#hidePartnerID').val(data['PartnerID'])
    		  $('#hidePartnerStatus').val(data['Deleted']); 
    		  $('#hidePartnerOrgUnit').val(data['OrgUnitName']);
    		  
  	        	stopLoader();
          },
          error: function (xhr) {
          		stopLoader();
          		errorLog(xhr.responseText);
          }
  	});	
  };
  
  
  