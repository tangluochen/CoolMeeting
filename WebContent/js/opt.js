$(function(){
	
	$("#selDepartments").change(function() {
		getEmployees();
	});
	
	/*$("#meetingroom").click(function() {
		getRooms();
	});*/

});


function getRooms() {
	var startdate = $("#startdate").val();
	var enddate = $("#enddate").val();
	//alert(startdate,enddate);
	if(startdate != null && startdate != "" && enddate != null && enddate != "") {
		$.post (
			"RoomServlet",
			{startdate : startdate , enddate : enddate},
			callBackRooms
		);
	}/* else {
		alert("开始时间和结束时间均不能为空!!!");
	}*/
}


function callBackRooms(jsondata) {
	var str = "";
	for(var i = 0; i <jsondata.length; i++) {
		str += "<option value=\"" + jsondata[i].roomid + "\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + jsondata[i].roomname + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>";
	}
	var b=$("#meetingroom option:first").text();
	$("#meetingroom").html('<option>'+b+'</option>');
	$("#meetingroom").append(str);
}

function getEmployees() {
	var did = $("#selDepartments").val();
	$.post (
		"EmployeesServlet",
		{did : did},
		callBackEmployees
	);
}
		
function callBackEmployees(jsondata) {
	var str = "";
	for(var i = 0; i <jsondata.length; i++) {
		str += "<option value=\"" + jsondata[i].sid + "\">" + jsondata[i].realname + "</option>";
	}
	$("#selEmployees").html("");
	$("#selEmployees").append(str);
}

function  selectEmployee(){
	
    var  str ="";
    
     $("#selEmployees option:selected").each(function () {
        
        str="<option value=\""+$(this).val()+"\">"+$(this).text()+"</option>"
        //alert($(this).val() + "," + $(this).text());
        $("#selSelectedEmployees").append(str);
        $(this).remove();
       
       
     });

}

function  deSelectEmployee(){
	
    var  str ="";
    
     $("#selSelectedEmployees option:selected").each(function () {
        
        str="<option value=\""+$(this).val()+"\">"+$(this).text()+"</option>"
        
        $("#selEmployees").append(str);
        $(this).remove();
       
       
     });

}