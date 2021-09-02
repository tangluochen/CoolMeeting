<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.List"%>
<%@ page import="biz.AccountBiz"%>
<%@ page import="bean.Staff"%>
<%@ page import="bean.MeetingRoom"%>
<%@ page import="bean.Department"%>
<%
AccountBiz accountBiz = new AccountBiz();
List<Department> deptList = (List<Department>)request.getAttribute("deptList");
//List<Staff> staffList = (List<Staff>)request.getAttribute("staffList");
%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>会议预定--预定会议</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/opt.js"></script>
		<style type="text/css">
            #divfrom{
                float:left;
                width:150px;
            }
            #divto{
                float:left;
                width:150px;
            }
            #divoperator{
                float:left;
                width:50px;
                padding:60px 5px;
            }
            #divoperator input[type="button"]{
                margin:10px 0;
            }
            #selDepartments{
                display:block;
                width:100%;
            }
            #selEmployees{
                display:block;
                width:100%;
                height:200px;
            }
            #selSelectedEmployees{
                display:block;
                width:100%;
                height:225px;
            }
        </style>
        <script type="application/javascript">
        <%-- 
            function employee(employeeid, employeename){
                this.employeeid = employeeid;
                this.employeename = employeename;
            }
            function department(departmentid, departmentname, employees){
                this.departmentid = departmentid;
                this.departmentname = departmentname;
                this.employees = employees;
            }
            var data = new Array(
            	<%for(int i = 0; i < deptList.size(); i++){%>
                new department(<%=deptList.get(i).getDid()%>,"<%=deptList.get(i).getDname()%>", new Array(
                	<%
                	List<Staff> staffList = accountBiz.queryStaffByDid(deptList.get(i).getDid());
                	for(int j = 0; j < staffList.size(); j++){
                	%> new employee(<%=staffList.get(j).getSid()%>, "<%=staffList.get(j).getRealname()%>"),
                    <%}%>)),
            	<%}%>);
            var selDepartments;
            var selEmployees;
            var selSelectedEmployees;
            
            function body_load(){
                selDepartments = document.getElementById("selDepartments");
                selEmployees = document.getElementById("selEmployees");
                selSelectedEmployees = document.getElementById("selSelectedEmployees");
                
                for(var i=0;i<data.length;i++){
                    var dep = document.createElement("option");
                    dep.value = data[i].departmentid;
                    dep.text = data[i].departmentname;
                    selDepartments.appendChild(dep);
                }
                
                fillEmployees();
            }
            
            function fillEmployees(){
                clearList(selEmployees);
                var departmentid = selDepartments.options[selDepartments.selectedIndex].value;
                var employees;
                for(var i=0;i<data.length;i++){
                    if (departmentid == data[i].departmentid){
                        employees = data[i].employees;
                        break;
                    }
                }
                for(i=0;i<employees.length;i++){
                    var emp = document.createElement("option");
                    emp.value = employees[i].employeeid;
                    emp.text = employees[i].employeename;
                    selEmployees.appendChild(emp);
                }
            }
            
            function clearList(list){
                while(list.childElementCount > 0){
                    list.removeChild(list.lastChild);
                }
            }
            
            function selectEmployees(){
                for(var i=0;i<selEmployees.options.length;i++){
                    if (selEmployees.options[i].selected){
                        addEmployee(selEmployees.options[i]);
                        selEmployees.options[i].selected = false;
                    }
                }
            }
            
            function deSelectEmployees(){
                var elementsToRemoved = new Array();
                var options = selSelectedEmployees.options;
                for(var i=0;i<options.length;i++){
                    if (options[i].selected){
                        elementsToRemoved.push(options[i]);
                    }
                }
                for(i=0;i<elementsToRemoved.length;i++){
                    selSelectedEmployees.removeChild(elementsToRemoved[i]);
                }
            }
            
            function addEmployee(optEmployee){
                var options = selSelectedEmployees.options;
                var i = 0;
                var insertIndex = -1;
                while(i < options.length){
                    if (optEmployee.value == options[i].value){
                        return;
                    } else if (optEmployee.value < options[i].value) {
                        insertIndex = i;
                        break;
                    }
                    i++;
                }
                var opt = document.createElement("option");
                opt.value = optEmployee.value;
                opt.text = optEmployee.text;
                
                if (insertIndex == -1){
                    selSelectedEmployees.appendChild(opt);
                } else {
                    selSelectedEmployees.insertBefore(opt, options[insertIndex]);
                }
            }      
            --%>
            
            
            
            function fNum(){
        		var num = document.getElementById("numofattendents").value;
        		if(isNaN(num)) {
        			document.getElementById("penum").innerHTML = "人数非数字";
        			document.getElementById("numofattendents").value = "";
        			document.getElementById("numofattendents").focus();
        		} else {
        			document.getElementById("penum").innerHTML = "";
        		}
        	}
        </script>
        
        
        
</head>
	<body onload="body_load()">
	<div class="page-body-wai">
        <div class="page-body">
            <div class="page-content">
                <div class="content-nav">
                    会议预定 > 预定会议
                </div>
                <form id="formid" action="${pageContext.request.contextPath}/BookMeetingSubServlet" method="post">
                    <fieldset>
                        <legend>会议信息</legend>
                        <table class="formtable">
                            <tr>
                                <td>会议名称：</td>
                                <td>
                                    <input type="text" id="meetingname" name="mname" maxlength="20"/>
                                </td>
                            </tr>
                            <tr>
                                <td>预计参加人数：</td>
                                <td>
                                    <input type="text" onblur="javascript:fNum()" id="numofattendents" name="pnum"/><font id="penum" color="red"></font>
                                </td>
                            </tr>
                            <tr>
                                <td>预计开始时间：</td>
                                <td>
                                    <input id="startdate" type="text" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" onchange="getRooms()" name="starttime"/>
                                  
                                </td>
                            </tr>
                            <tr>
                                <td>预计结束时间：</td>
                                <td>
                                    <input id="enddate" type="text" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" onchange="getRooms()" name="endtime"/>
                                   
                                </td>
                            </tr>
							 <tr>
                                <td>会议室：</td>
                                <td>
                                    <select id="meetingroom" name="roomid">
                                    		<option value="0">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请选择会议室&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
                                    	<%-- <c:forEach items="${requestScope.roomList}" var="room">
                                    	<c:if test="${room.status == 1}">
                                        	<option value="${room.roomid}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${room.roomname}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
                                    	</c:if>
									    </c:forEach> --%>
									</select>
									<font  color="red">注意：这个会议室一定是这段时是没有人占用才显示出来</font>
                                   
                                </td>
                            </tr>
                            <tr>
                                <td>会议说明：</td>
                                <td>
                                    <textarea id="description" rows="5" name="explain"></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td>选择参会人员：</td>
                                <td>
                                    <div id="divfrom">
                                        <select id="selDepartments" name="xxx">  <!-- onchange="fillEmployees()" --> 
                                        	<option value="">请选择部门</option>
                                        	<c:forEach items="${requestScope.deptList}" var="dept">
                                        		<option value="${dept.did}">${dept.dname}</option>
                                        	</c:forEach>
                                        </select>
                                        
                                        <select id="selEmployees" multiple="multiple" name="yyy">
                                        
                                        </select>
                                    </div>
                                    
                                    <div id="divoperator">
                                        <input type="button" class="clickbutton" value="&gt;" onclick="selectEmployee()"/>
                                        <input type="button" class="clickbutton" value="&lt;" onclick="deSelectEmployee()"/>
                                    </div>
                                    
                                    <div id="divto">
                                        <select id="selSelectedEmployees" multiple="multiple" name="staffname">
                                        </select>
                                        <input type="hidden" id="hidden" name="staffid" value="" />
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="command" colspan="2">
                                    <input type="submit" class="clickbutton" value="预定会议"/>
                                    <input type="reset" class="clickbutton" value="重置"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
	    <script>
	    /* 设置个隐藏域<input type="hidden" />，提交获取全部 option 值放到隐藏域中，后台取隐藏域的值 */
			 document.getElementById("formid").onsubmit = function () {
	    		var arr = [];
	    		var op = document.getElementById("selSelectedEmployees").options;
	    		for (var i = 0; i < op.length; i++)
	        		arr[i] = op[i].value;
	    		document.getElementById("hidden").value = arr.join(",");
	    		/* alert(document.getElementById("hidden").value); */
			} 
		</script>
	
    </body>
</html>