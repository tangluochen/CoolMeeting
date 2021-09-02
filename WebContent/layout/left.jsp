<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>left</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css"/>
</head>
<body>
   		<div class="page-body">
            <div class="page-sidebar">
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle">个人中心</div>
                    <ul class="sidebar-menu">
                        <li class="sidebar-menuitem"><a href="${pageContext.request.contextPath}/SelectNoticeMeetingServlet" target="three">最新通知</a></li>
                        <li class="sidebar-menuitem active"><a href="${pageContext.request.contextPath}/SelectReserveMeeting" target="three">我的预定</a></li>
                        <li class="sidebar-menuitem"><a href="${pageContext.request.contextPath}/SelectAttendMeeting" target="three">我的会议</a></li>
                    </ul>
                </div>
                
                <c:if test = "${sessionScope.bl == true}">
                
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle">人员管理</div>
                    <ul class="sidebar-menu">
                        <li class="sidebar-menuitem"><a href="${pageContext.request.contextPath}/SelectAllDepartmentsServlet" target="three">部门管理</a></li>
                        <li class="sidebar-menuitem"><a href="${pageContext.request.contextPath}/RegisterServlet" target="three">员工注册</a></li>
                        <li class="sidebar-menuitem"><a href="${pageContext.request.contextPath}/ApprovalServlet" target="three">注册审批</a></li>
                        <li class="sidebar-menuitem"><a href="${pageContext.request.contextPath}/QueryStaffSubServlet" target="three">搜索员工</a></li>
                    </ul>
                </div>
                
                </c:if>
                
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle">会议预定</div>
                    <ul class="sidebar-menu">
                        <li class="sidebar-menuitem"><a href="${pageContext.request.contextPath}/AddMeetingRoomServlet" target="three">添加会议室</a></li>
                        <li class="sidebar-menuitem"><a href="${pageContext.request.contextPath}/QueryMeetingRoomServlet" target="three">查看会议室</a></li>
                        <li class="sidebar-menuitem"><a href="${pageContext.request.contextPath}/BookMeetingServlet" target="three">预定会议</a></li>
                        <li class="sidebar-menuitem"><a href="${pageContext.request.contextPath}/QueryMeetingSubServlet" target="three">搜索会议</a></li>
                    </ul>
                </div>
            </div>
     	</div>
</body>
</html>
