<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>会议预定--添加会议室</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css"/>
    <script type="text/javascript">
    	function fNum(){
    		var num = document.getElementById("roomcapacity").value;
    		if(isNaN(num)) {
    			document.getElementById("pnum").innerHTML = "人数非数字";
    			document.getElementById("roomcapacity").value = "";
    			document.getElementById("roomcapacity").focus();
    		} else {
    			document.getElementById("pnum").innerHTML = "";
    		}
    	}
    	function mNum(){
    		var num = document.getElementById("roomnumber").value;
    		if(isNaN(num)) {
    			document.getElementById("penum").innerHTML = "门牌号非数字";
    			document.getElementById("roomnumber").value = "";
    			document.getElementById("roomnumber").focus();
    		} else {
    			document.getElementById("penum").innerHTML = "";
    		}
    	}
    </script>
</head>
<body>
	<div class="page-body-wai">
		<div class="page-body">
            <div class="page-content">
                <div class="content-nav">
                    	会议预定 > 添加会议室
                </div>
                <form action="${pageContext.request.contextPath}/AddMeetingRoomSubServlet" method="post">
                    <fieldset>
                        <legend>会议室信息</legend>
                        <table class="formtable">
                            <tr>
                                <td>门牌号:</td>
                                <td>
                                    <input id="roomnumber" onblur="javascript:mNum()" name="roomnum" type="text" placeholder="例如：201" maxlength="10"/><font id="penum" color="red"></font>
                                </td>
                            </tr>
                            <tr>
                                <td>会议室名称:</td>
                                <td>
                                    <input id="capacity" name="roomname" type="text" placeholder="例如：第一会议室" maxlength="20"/>
                                </td>
                            </tr>
                            <tr>
                                <td>最多容纳人数：</td>
                                <td>
                                    <input id="roomcapacity" onblur="javascript:fNum()" name="maxpnum" type="text" placeholder="填写一个正整数"/><font id="pnum" color="red"></font>
                                </td>
                            </tr>
                            <tr>
                                <td>当前状态：</td>
                                <td>
                                    <input type="radio" id="status" name="status" checked="checked" value="1"/><label for="status">启用</label>
                                    <input type="radio" id="status" name="status" value="0"/><label for="status">停用</label>
                                    <input type="radio" id="status" name="status" value="-1"/><label for="status">删除</label>
                                </td>
                            </tr>
                            <tr>
                                <td>备注：</td>
                                <td>
                                    <textarea id="description" name="explain" maxlength="200" rows="5" cols="60" placeholder="200字以内的文字描述"></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" class="command">
                                    <input type="submit" value="添加" class="clickbutton"/>
                                    <input type="reset" value="重置" class="clickbutton"/>
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