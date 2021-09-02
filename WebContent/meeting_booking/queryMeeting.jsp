<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.List"%>
<%@ page import="bean.Meeting"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<Meeting> meetingList = (List<Meeting>) request.getAttribute("meetList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>会议预定--搜索会议</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css"/>
</head>
<body>
<div class="page-body-wai">
	<div class="page-body">
			<div class="page-content">
                <div class="content-nav">
                    	会议预定 > 搜索会议
                </div>
                <form action="${pageContext.request.contextPath}/QueryMeetingSubServlet" method="post">
                    <fieldset>
                        <legend>搜索会议</legend>
                        <table class="formtable">
                            <tr>
                                <td>会议名称：</td>
                                <td>
                                    <input type="text" name="m_name" value="${requestScope.mname}" id="meetingname" maxlength="20"/>
                                </td>
                                <td>会议室名称：</td>
                                <td>
                                    <input type="text" name="room_name" value="${requestScope.roomname}" id="roomname" maxlength="20"/>
                                </td>
                                <td>预定者姓名：</td>
                                <td>
                                    <input type="text" name="res_name" value="${requestScope.resname}" id="reservername" maxlength="20"/>
                                </td>
                            </tr>
                            
                            <tr>
                                <td>会议日期：</td>
                                <td colspan="5">
                                    	从&nbsp;<input type="date" value="${requestScope.Mstartdate}" name="Mstartdate" id="meetingfromdate" placeholder="例如：2020-10-01"/>
                                    	到&nbsp;<input type="date" value="${requestScope.Menddate}" name="Menddate" id="meetingtodate" placeholder="例如：2020-10-07"/>
                                </td>
                            </tr>
                            
                            <tr>
                                <td colspan="6" class="command">
                                    <input type="submit" class="clickbutton" value="查询"/>
                                    <input type="reset" class="clickbutton" value="重置"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
                <div>
                    <h3 style="text-align:center;color:black">查询结果</h3>
                    <div class="pager-header">
                        <div class="header-info">
                            	共<span class="info-number">${requestScope.totalNum}</span>条结果，
                            	分成<span class="info-number">${requestScope.totalPageNum}</span>页显示，
                            	当前第<span class="info-number">${requestScope.currentPage}</span>页
                        </div>
                        <div class="header-nav">
                            <a class="clickbutton" href="<%=basePath%>QueryMeetingSubServlet?page=1&mname=${requestScope.mname}&roomname=${requestScope.roomname}&resname=${requestScope.resname}&Mstartdate=${requestScope.Mstartdate}&Menddate=${requestScope.Menddate}">首页</a>
                            <c:if test="${requestScope.currentPage > 1}">
								<a class="clickbutton" href="<%=basePath%>QueryMeetingSubServlet?page=${requestScope.currentPage-1}&mname=${requestScope.mname}&roomname=${requestScope.roomname}&resname=${requestScope.resname}&Mstartdate=${requestScope.Mstartdate}&Menddate=${requestScope.Menddate}">上页</a>
							</c:if>
							<c:if test="${requestScope.currentPage < requestScope.totalPageNum}">
								<a class="clickbutton" href="<%=basePath%>QueryMeetingSubServlet?page=${requestScope.currentPage+1}&mname=${requestScope.mname}&roomname=${requestScope.roomname}&resname=${requestScope.resname}&Mstartdate=${requestScope.Mstartdate}&Menddate=${requestScope.Menddate}">下页</a>
							</c:if>
							<a class="clickbutton" href="<%=basePath%>QueryMeetingSubServlet?page=${requestScope.totalPageNum}&mname=${requestScope.mname}&roomname=${requestScope.roomname}&resname=${requestScope.resname}&Mstartdate=${requestScope.Mstartdate}&Menddate=${requestScope.Menddate}">末页</a>
                            	跳到第<input type="text" name="pagenum" id="pagenum" class="nav-number"/>页
                            <input type="button" class="clickbutton" onclick="getNum()" value="跳转"/>
                        </div>
                    </div>
                </div>
                <table class="listtable">
                    <tr class="listheader">
                        <th>会议名称</th>
                        <th>会议室名称</th>
                        <th>会议开始时间</th>
                        <th>会议结束时间</th>
                        <th>会议预定时间</th>
                        <th>预定者</th>
                        <th>操作</th>
                    </tr>
                    <c:choose>
                    <c:when test="<%=meetingList != null%>">
                    <c:forEach items="${requestScope.meetList}" var="meeting" varStatus="loop">
                    <tr>
	                    <td>${meeting.mname}</td>
	                    <td>${requestScope.strRoomList2[loop.count-1]}</td>
	                    <td><fmt:formatDate value="${meeting.starttime}" type="both"/></td>
                    	<td><fmt:formatDate value="${meeting.endtime}" type="both"/></td>
                    	<td><fmt:formatDate value="${meeting.restime}" type="both"/></td>
	                    <td>${requestScope.strResNameList2[loop.count-1]}</td>
	                    <td>
	                        <a class="clickbutton" href="${pageContext.request.contextPath}/MeetingDetailsServlet?mname=${meeting.mname}">查看详情</a>
	                    </td>
	                </tr>
                    </c:forEach>
                    </c:when>
                    <c:otherwise>
                    <c:forEach items="${requestScope.meetListFenYe}" var="meet" varStatus="loop">
	                <tr>
	                    <td>${meet.mname}</td>
	                    <td>${requestScope.strRoomList[loop.count-1]}</td>
	                    <td><fmt:formatDate value="${meet.starttime}" type="both"/></td>
                    	<td><fmt:formatDate value="${meet.endtime}" type="both"/></td>
                    	<td><fmt:formatDate value="${meet.restime}" type="both"/></td>
	                    <td>${requestScope.strResNameList[loop.count-1]}</td>
	                    <td>
	                        <a class="clickbutton" href="${pageContext.request.contextPath}/MeetingDetailsServlet?mname=${meet.mname}">查看详情</a>
	                    </td>
	                </tr>
	                </c:forEach>
                    </c:otherwise>
                    </c:choose>
                </table>
            </div>
	</div>
	</div>
	<script>
	function getNum(){
		var num = document.getElementById('pagenum').value;
		location.href="${pageContext.request.contextPath}/QueryMeetingSubServlet?page="+num+"&mname=${requestScope.mname}&roomname=${requestScope.roomname}&resname=${requestScope.resname}&Mstartdate=${requestScope.Mstartdate}&Menddate=${requestScope.Menddate}";
	}
	</script>
</body>
</html>