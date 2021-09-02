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
    <title>人员管理--部门管理</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css"/>
</head>
<body>
		<div class="page-body-wai">
        
            <div class="page-content">
                <div class="content-nav">
                    	人员管理 > 部门管理
                </div>
                <form action="<%=basePath%>AddDepartmentsServlet" method="post">
                    <fieldset>
                        <legend>添加部门</legend>
                        	部门名称:
                        <input type="text" name="dname" id="departmentname" maxlength="20"/>
                        <input type="submit" class="clickbutton" value="添加"/>
                    </fieldset>
                </form>
                <table class="listtable">
                    <caption>所有部门:</caption>
                    <tr class="listheader">
                        <th>部门编号</th>
                        <th>部门名称</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${requestScope.depList}" var="dep">
                    <c:if test="${dep.dstatus == 1}">
                    <tr>
                        <td>${dep.did}</td>
                        <td>${dep.dname}</td>
                        <td>
                            <a class="clickbutton" href="${pageContext.request.contextPath}/EditDepartmentsServlet?did=${dep.did}">编辑</a>
                            <a class="clickbutton" href="${pageContext.request.contextPath}/DeleteDepartmentsServlet?did=${dep.did}">删除</a>
                        </td>
                    </tr>
                    </c:if>
                    </c:forEach>
                </table>
            </div>
      </div>
</body>
</html>