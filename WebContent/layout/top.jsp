<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="bean.Staff"%>
<%@ page import="biz.AccountBiz"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	HttpSession s = request.getSession();
	Staff staff = (Staff)s.getAttribute("staff");
	AccountBiz accountBiz = new AccountBiz();
	Staff staff1 = (Staff)accountBiz.selectStaffByUsername(staff.getUsername()).get(0);
	String realname = staff1.getRealname();
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>top</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css"/>
</head>
<body>
   <div class="page-header">
            <div class="header-banner">
                <img src="${pageContext.request.contextPath}/images/header.png" alt="CoolMeeting"/>
            </div>
            <div class="header-title">
                欢迎访问Cool-Meeting会议管理系统
            </div>
            <div class="header-quicklink">
                	欢迎您，<strong><%=realname%></strong>
                <a href="${pageContext.request.contextPath}/changepassword.jsp" target="three">[修改密码]</a>
                <strong><a href="${pageContext.request.contextPath}/LoginOffServlet" target="_top">退出</a></strong>
            </div>
        </div>
     
</body>
</html>
