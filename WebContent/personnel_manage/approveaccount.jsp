<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";


%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>人员管理--注册审批</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css"/>
</head>
<body>
	<div class="page-body-wai">
        <div class="page-body">
            <div class="page-content">
                <div class="content-nav">
                    人员管理 > 注册审批
                </div>
                
                <table class="listtable">
                    <caption>所有待审批注册信息：</caption>
                    <tr class="listheader">
                        <th>姓名</th>
                        <th>账号名</th>
                        <th>联系电话</th>
                        <th>电子邮件</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${requestScope.staffList}" var="staff">
                    <c:if test = "${staff.status == 0}">
                    <tr>
                        <td>${staff.realname}</td>
                        <td>${staff.username}</td>
                        <td>${staff.phone}</td>
                        <td>${staff.email}</td>
                        <td>
                            <input type="button" class="clickbutton" onclick="pass('${staff.username}')" value="通过"/>
                            <input type="button" class="clickbutton" onclick="refuse('${staff.username}')" value="拒绝"/>
                        </td>
                    </tr>
                    </c:if>
                    </c:forEach>
                </table>
            </div>
        </div>
   </div>   
        <script>
        
        	function pass(x){
        	  location.href="${pageContext.request.contextPath}/PassServlet?user_name="+x;
        	  
        	}
        	function refuse(x){
          	  location.href="${pageContext.request.contextPath}/RefuseServlet?user_name="+x;
          	
          	}
        </script>
        
</body>
</html>