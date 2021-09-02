<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>会议预定--看会议室</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css"/>
</head>
<body>
<div class="page-body-wai">
	<div class="page-body">
			<div class="page-content">
                <div class="content-nav">
                    会议预定 > 查看会议室
                </div>
                <table class="listtable">
                    <caption>所有会议室:</caption>
                    <tr class="listheader">
                        <th>门牌编号</th>
                        <th>会议室名称</th>
                        <th>容纳人数</th>
                        <th>当前状态</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${requestScope.roomList}" var="room">
                    <tr>
                        <td>${room.roomnum}</td>
                        <td>${room.roomname}</td>
                        <td>${room.maxpnum}</td>
                        <td>
                        <c:if test = "${room.status == 1}">
                        	启用
                        </c:if>
                        <c:if test = "${room.status == 0}">
                        	停用
                        </c:if>
                        <c:if test = "${room.status == -1}">
                        	删除
                        </c:if>
                        </td>
                        <td>
                        	<a class="clickbutton" href="${pageContext.request.contextPath}/RoomEditsServlet?roomname=${room.roomname}">编辑会议室</a>
                            <a class="clickbutton" href="${pageContext.request.contextPath}/RoomDetailsServlet?roomname=${room.roomname}">查看详情</a>
                        </td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
</div>
</body>
</html>