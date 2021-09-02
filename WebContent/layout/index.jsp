<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>index</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css"/>
</head>
	<frameset id="yi" rows="15%,70%,*" border="1" noresize="noresize">
        <frame id="top" name="one" src="layout/top.jsp" >
        <frameset id="er" cols="17%,10%,*" border="1" noresize="noresize">
        	<frame style="background-color:rgb(211,211,211)">
            <frame id="left" name="two" src="layout/left.jsp" scrolling="no">
            <frame id="right" name="three" src="${pageContext.request.contextPath}/SelectNoticeMeetingServlet" >
        </frameset>
        <frame id="bottom" name="four" src="layout/bottom.jsp" >
    </frameset>
</html>
