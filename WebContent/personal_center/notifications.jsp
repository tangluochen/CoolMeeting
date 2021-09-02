<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.List"%>
<%@ page import="bean.Meeting"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.text.ParseException"%>


<%!
/* boolean bl = false;
boolean panduan(Date sdate,Date after7days,Date date) {
	System.out.println(sdate +"    ,    "+ after7days +"    ,    "+ date);
	if(date.getTime() <= sdate.getTime() && sdate.getTime() <= after7days.getTime()){
		bl = true;
		System.out.println(bl);
	}
	return bl;
} */
%>

<%
/* Date date = new Date();      //获取当前时间
Calendar calendar = Calendar.getInstance(); // 得到日历
calendar.setTime(date);// 把当前时间赋给日历
calendar.add(Calendar.DAY_OF_MONTH, 7); // 设置为7天后
Date after7days = calendar.getTime(); // 得到7天后的时间 */
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>个人中心--最新通知</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css"/>
</head>
<body>
   <div class="page-body-wai">
    <div class="page-body">
         <div class="page-content">
            <div class="content-nav">
                个人中心 > <a href="notifications">最新通知</a>
            </div>
            <table class="listtable">
                <caption>
                    	未来7天我要参加的会议:
                </caption>
                <tr class="listheader">
                    <th style="width:200px">会议名称</th>
                    <th>会议室</th>
                    <th>起始时间</th>
                    <th>结束时间</th>
                    <th style="width:100px">操作</th>
                </tr>
                <c:forEach items="${requestScope.meetList7}" var="meet" varStatus="loop">
                <tr>
                	<c:if test = "${meet.status == 1}">
                	<%-- <c:set var="st" value="${meet.starttime}" scope="request" /> --%>
                	<%
                	/* SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                	Date st = sdf.parse(sdf.format(request.getAttribute("st"))); */
                	%>
                	<%-- <c:if test = "<%=panduan(st,after7days,date) == true%>"> --%>
                	<%/* System.out.println(panduan(st,after7days,date)); */%>
                	<td>${meet.mname}</td>
                    <td>${requestScope.strRoomList[loop.count-1]}</td>
                    <td><fmt:formatDate value="${meet.starttime}" type="both"/></td>
                    <td><fmt:formatDate value="${meet.endtime}" type="both"/></td>
                    <td>
                        <a class="clickbutton" href="${pageContext.request.contextPath}/MeetingDetailsServlet?mname='${meet.mname}'">查看详情</a>
                    </td>
                    </c:if>
                	<%-- </c:if> --%>
                </tr>
                </c:forEach>
            </table>
            <table class="listtable">
                <caption>
                    	已取消的会议:
                </caption>
                <tr class="listheader">
                    <th style="width:200px">会议名称</th>
                    <th>会议室</th>
                    <th>起始时间</th>
                    <th>结束时间</th>
                    <th>取消原因</th>
                    <th style="width:100px">操作</th>
                </tr>
                <c:forEach items="${requestScope.meetList}" var="meet" varStatus="loop">
                <tr>
                	<c:if test = "${meet.status == 0}">
                    <td>${meet.mname}</td>
                    <td>${requestScope.strRoomList[loop.count-1]}</td>
                    <td><fmt:formatDate value="${meet.starttime}" type="both"/></td>
                    <td><fmt:formatDate value="${meet.endtime}" type="both"/></td>
                    <td>${meet.canclereason}</td>
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
    <script>
    	/* function myFunction() {
    		location.href="${pageContext.request.contextPath}/MeetingDetailsServlet?mname="+x;
    	} */
    </script>
</body>
</html>
