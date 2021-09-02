<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑详情</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css"/>
<script type="text/javascript">
function pNum(){
	var num = document.getElementById("maxpnum").value;
	if(isNaN(num)) {
		document.getElementById("pnum").innerHTML = "人数非数字";
		document.getElementById("maxpnum").value = "";
		document.getElementById("maxpnum").focus();
	} else {
		document.getElementById("pnum").innerHTML = "";
	}
}
function rNum(){
	var num = document.getElementById("roomnum").value;
	if(isNaN(num)) {
		document.getElementById("rnum").innerHTML = "门牌号非数字";
		document.getElementById("roomnum").value = "";
		document.getElementById("roomnum").focus();
	} else {
		document.getElementById("rnum").innerHTML = "";
	}
}
</script>
</head>
<body onload="body_load()">
<div class="page-body-wai">
        <div class="page-body">
            <div class="page-content">
                <div class="content-nav">
                    	查看会议室 > 编辑会议室
                </div>
                <form action="${pageContext.request.contextPath}/RoomEditsSubServlet" method="post">
                    <fieldset>
                        <legend>会议室信息</legend>
                        <table class="formtable">
                        	<input type="hidden" name="roomid" value="${requestScope.room.roomid}"/>
                            <tr>
                                <td>门牌号：</td>
                                <td><input type="text" id="roomnum" onblur="javascript:rNum()" name="roomnum" value="${requestScope.room.roomnum}"/><font id="rnum" color="red"></font></td>
                                
                            </tr>
                            <tr>
                                <td>会议室名称：</td>
                                <td><input type="text" name="roomname" value="${requestScope.room.roomname}"/></td>
                            </tr>
                            <tr>
                                <td>最大人数：</td>
                                <td><input type="text" id="maxpnum" onblur="javascript:pNum()" name="maxpnum" value="${requestScope.room.maxpnum}"/><font id="pnum" color="red"></font></td>
                            </tr>
                            <tr>
                                <td>会议室说明：</td>
                                <td>
                                    <textarea id="description" name="explain" rows="5">${requestScope.room.explain}</textarea>
                                </td>
                            </tr>
                            <tr>
                                <td>会议室状态：</td>
                              <c:if test="${requestScope.room.status == 1}">
                                <td><input type="radio" id="status" name="status" value="1" checked="checked"/><label for="status">启用</label>
                                <input type="radio" id="status" name="status" value="0"/><label for="status">停用</label>
                                <input type="radio" id="status" name="status" value="-1"/><label for="status">删除</label><td>
                              </c:if>
                              <c:if test="${requestScope.room.status == 0}">
                                <td><input type="radio" id="status" name="status" value="1"/><label for="status">启用</label>
                                <input type="radio" id="status" name="status" value="0" checked="checked"/><label for="status">停用</label>
                                <input type="radio" id="status" name="status" value="-1"/><label for="status">删除</label><td>
                              </c:if>
                              <c:if test="${requestScope.room.status == -1}">
                                <td><input type="radio" id="status" name="status" value="1"/><label for="status">启用</label>
                                <input type="radio" id="status" name="status" value="0"/><label for="status">停用</label>
                                <input type="radio" id="status" name="status" value="-1" checked="checked"/><label for="status">删除</label><td>
                              </c:if>
                                
                            </tr>
                            <tr>
                                <td>预定会议室员工：</td>
                                <td>${requestScope.realname}</td>
                            </tr>
                            <tr>
                                <td class="command" colspan="2">
                                	<input type="submit" class="clickbutton" value="确认"/>
                                    <input type="button" class="clickbutton" value="返回" onclick="window.history.back();"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
            </div>
        </div>
</div>
</body>
</html>