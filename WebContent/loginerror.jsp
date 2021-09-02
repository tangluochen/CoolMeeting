<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登录发生错误</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" />
</head>
<body>
	<div class="page-body">
      <div class="page-content">
        <div class="content-nav">
		    <span style="color:red; font-weight:600; font-size:20px;">${requestScope.err}</span>
		    <input type="button" class="clickbutton" value="返回" onclick="window.history.back();"/>
        </div>
      </div>
    </div>
</body>
</html>