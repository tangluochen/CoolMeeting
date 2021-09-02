<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>会议预定--修改会议预定</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css"/>

</head>
<body onload="body_load()">
<div class="page-body-wai">
        <div class="page-body">
            <div class="page-content">
                <div class="content-nav">
                    	会议预定 > 修改会议预定
                </div>
                <form>
                    <fieldset>
                        <legend>会议信息</legend>
                        <table class="formtable">
                            <tr>
                                <td>会议名称：</td>
                                <td>${requestScope.meeting.mname}</td>
                            </tr>
                            <tr>
                                <td>预计参加人数：</td>
                                <td>${requestScope.meeting.pnum}</td>
                            </tr>
                            <tr>
                                <td>预计开始时间：</td>
                                <td>${requestScope.meeting.starttime}</td>
                            </tr>
                            <tr>
                                <td>预计结束时间：</td>
                                <td>${requestScope.meeting.endtime}</td>
                            </tr>
                            <tr>
                                <td>会议说明：</td>
                                <td>
                                    <textarea id="description" rows="5" readonly>${requestScope.meeting.explain}</textarea>
                                </td>
                            </tr>
                            <tr>
                                <td>参会人员：</td>
                                <td>
                                    <table class="listtable">
                                    	<tr class="listheader">
                                            <th>姓名</th>
                                            <th>联系电话</th>
                                            <td>电子邮件</td>
                                        </tr>
                                      <c:forEach items="${requestScope.staffList}" var="staff">
                                    	
                                        <tr class="listheader">
                                            <th>${staff.realname}</th>
                                            <th>${staff.phone}</th>
                                            <td>${staff.email}</td>
                                        </tr>
                                        
                                      </c:forEach>
                                    </table>
                                </td>
                            </tr>
                            <tr>
                                <td class="command" colspan="2">
                                    <input type="button" class="clickbutton" value="撤销会议" onclick="window.location.href='${pageContext.request.contextPath}/personal_center/cancelmeeting.jsp?mname=${requestScope.meeting.mname}';"/>
                                    <input type="button" class="clickbutton" value="返回" onclick="window.history.back();"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
            </div>
        </div>
</div>
</body>
</html>