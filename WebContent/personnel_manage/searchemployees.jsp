<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.List"%>
<%@ page import="bean.Staff"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<Staff> staff = (List<Staff>) request.getAttribute("staffList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>会议预定--搜索员工</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css"/>
<script type="text/javascript">
	function re(){
		document.getElementById("employeename").value = "";
		document.getElementById("accountname").value = "";
	}
</script>
</head>
<body>
<div class="page-body-wai">
	<div class="page-body">
			<div class="page-content">
                <div class="content-nav">
                    会议预定 > 搜索员工
                </div>
                <form action="${pageContext.request.contextPath}/QueryStaffSubServlet" method="post">
                    <fieldset>
                        <legend>搜索员工</legend>
                        <table class="formtable">
                            <tr>
                                <td>姓名：</td>
                                <td>
                                    <input type="text" id="employeename" name="real_name" value='${requestScope.realname}' maxlength="20"/>
                                </td>
                                <td>账号名：</td>
                                <td>
                                    <input type="text" id="accountname" name="user_name" value='${requestScope.username}' maxlength="20"/>
                                </td>
                                <td>状态：</td>
                                <td>
                                <c:choose>
                                	<c:when test="${requestScope.status == 1}">
                                		<input type="radio" id="status" name="status" value="1" checked="checked"/><label>已批准</label>
                                    	<input type="radio" id="status" name="status" value="0"/><label>待审批</label>
                                    	<input type="radio" id="status" name="status" value="2"/><label>已关闭</label>
                                	</c:when>
                                    <c:when test="${requestScope.status == 0}">
                                		<input type="radio" id="status" name="status" value="1"/><label>已批准</label>
                                    	<input type="radio" id="status" name="status" value="0" checked="checked"/><label>待审批</label>
                                    	<input type="radio" id="status" name="status" value="2"/><label>已关闭</label>
                                	</c:when>
                                	<c:when test="${requestScope.status == 2}">
                                		<input type="radio" id="status" name="status" value="1"/><label>已批准</label>
                                    	<input type="radio" id="status" name="status" value="0"/><label>待审批</label>
                                    	<input type="radio" id="status" name="status" value="2" checked="checked"/><label>已关闭</label>
                                	</c:when>
                                	<c:otherwise>
                                		<input type="radio" id="status" name="status" value="1" checked="checked"/><label>已批准</label>
                                    	<input type="radio" id="status" name="status" value="0"/><label>待审批</label>
                                    	<input type="radio" id="status" name="status" value="2"/><label>已关闭</label>
                                	</c:otherwise>
                                </c:choose>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="6" class="command">
                                    <input type="submit" class="clickbutton" value="查询"/>
                                    <input type="button" class="clickbutton" onclick="javascript:re()" value="重置"/>
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
                            <a class="clickbutton" href="<%=basePath%>QueryStaffSubServlet?page=1&real_name=${requestScope.realname}&user_name=${requestScope.username}&status=${requestScope.status}">首页</a>
                            <c:if test="${requestScope.currentPage > 1}">
								<a class="clickbutton" href="<%=basePath%>QueryStaffSubServlet?page=${requestScope.currentPage-1}&real_name=${requestScope.realname}&user_name=${requestScope.username}&status=${requestScope.status}">上页</a>
							</c:if>
							<c:if test="${requestScope.currentPage < requestScope.totalPageNum}">
								<a class="clickbutton" href="<%=basePath%>QueryStaffSubServlet?page=${requestScope.currentPage+1}&real_name=${requestScope.realname}&user_name=${requestScope.username}&status=${requestScope.status}">下页</a>
							</c:if>
							<a class="clickbutton" href="<%=basePath%>QueryStaffSubServlet?page=${requestScope.totalPageNum}&real_name=${requestScope.realname}&user_name=${requestScope.username}&status=${requestScope.status}">末页</a>
                            	跳到第<input type="text" name="pagenum" id="pagenum" class="nav-number"/>页
                            <input type="button" class="clickbutton" onclick="getNum()" value="跳转"/>
                            <%-- <a class="clickbutton" href="<%=basePath%>QueryStaffServlet?page=${requestScope.pageNum}">跳转</a> --%>
                        </div>
                    </div>
                </div>
                <table class="listtable">
                    <tr class="listheader">
                        <th>姓名</th>
                        <th>账号名</th>
                        <th>联系电话</th>
                        <th>电子邮件</th>
                        <th>操作</th>
                        <th>状态</th>
                    </tr>
                    
                    <c:choose>
                    <c:when test="<%=staff != null%>">
                    <c:forEach items="${requestScope.staffList}" var="staff">
                    
                    	<tr>
                        	<td>${staff.realname}</td>
                        	<td>${staff.username}</td>
                        	<td>${staff.phone}</td>
                        	<td>${staff.email}</td>
                        	<td>
                            <c:if test="${staff.status == 1}">
                            	<input type="button" class="clickbutton" onclick="revoke('${staff.username}')" value="撤销员工账号"/>
                        	</c:if>
                        	<c:if test="${staff.status == 0}">
                            	<input type="button" class="clickbutton" onclick="recovery('${staff.username}')" value="恢复员工账号"/>
                        	</c:if>
                        	</td>
                        	<c:if test="${staff.status == 1}"><td><font color="red">已批准</font></td></c:if>
                        	<c:if test="${staff.status == 0}"><td><font color="red">待审批</font></td></c:if>
                        	<c:if test="${staff.status == 2}"><td><font color="red">已关闭</font></td></c:if>
                    	</tr>
                    </c:forEach>
                    </c:when>
                    <c:otherwise>
                    <c:forEach items="${requestScope.staffListFenYe}" var="staff">
                    	<tr>
                        	<td>${staff.realname}</td>
                        	<td>${staff.username}</td>
                        	<td>${staff.phone}</td>
                        	<td>${staff.email}</td>
                        	<td>
                        	<c:if test="${staff.status == 1}">
                            	<input type="button" class="clickbutton" onclick="revoke('${staff.username}')" value="撤销员工账号"/>
                        	</c:if>
                        	<c:if test="${staff.status == 0}">
                            	<input type="button" class="clickbutton" onclick="recovery('${staff.username}')" value="恢复员工账号"/>
                        	</c:if>
                        	</td>
                        	<c:if test="${staff.status == 1}"><td><font color="red">已批准</font></td></c:if>
                        	<c:if test="${staff.status == 0}"><td><font color="red">待审批</font></td></c:if>
                        	<c:if test="${staff.status == 2}"><td><font color="red">已关闭</font></td></c:if>
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
		location.href="${pageContext.request.contextPath}/QueryStaffSubServlet?page="+num+"&realname=${requestScope.realname}&username=${requestScope.username}&status=${requestScope.status}";
	}
	
	function revoke(x){
    	location.href="${pageContext.request.contextPath}/CloseServlet?user_name="+x;
    }
	function recovery(x){
    	location.href="${pageContext.request.contextPath}/OpenServlet?user_name="+x;
    }
	</script>
</body>
</html>