<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>个人中心--我的会议</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css"/>
</head>
<body>
<div class="page-body-wai">
        <div class="page-body">
            <div class="page-content">
                <div class="content-nav">
                    	个人中心 > 我的会议
                </div>
                <table class="listtable">
                    <caption>我参加的会议：</caption>
                    <tr class="listheader">
                        <th>会议名称</th>
                        <th>会议室名称</th>
                        <th>会议开始时间</th>
                        <th>会议结束时间</th>
                        <th>会议预定时间</th>
                        <th>预定者</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${requestScope.meetList}" var="meet" varStatus="loop">
	                <tr>
	                	<c:if test = "${meet.status == 1}">
	                    <td>${meet.mname}</td>
	                    <td>${requestScope.strRoomList[loop.count-1]}</td>
	                    <td><fmt:formatDate value="${meet.starttime}" type="both"/></td>
                    	<td><fmt:formatDate value="${meet.endtime}" type="both"/></td>
                    	<td><fmt:formatDate value="${meet.restime}" type="both"/></td>
	                    <td>${requestScope.strResNameList[loop.count-1]}</td>
	                    <td>
	                        <a class="clickbutton" href="${pageContext.request.contextPath}/MeetingDetailsServlet?mname=${meet.mname}">查看详情</a>
	                    </td>
	                    </c:if>
	                </tr>
	                </c:forEach>
                </table>
            </div>
        </div>
</div>
</body>
</html>