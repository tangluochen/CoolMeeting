<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看详情</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css"/>
</head>
<body onload="body_load()">
<div class="page-body-wai">
        <div class="page-body">
            <div class="page-content">
                <div class="content-nav">
                    	查看会议室 > 查看会议室详情
                </div>
                <form>
                    <fieldset>
                        <legend>会议室信息</legend>
                        <table class="formtable">
                            <tr>
                                <td>门派编号：</td>
                                <td>${requestScope.room.roomnum}</td>
                            </tr>
                            <tr>
                                <td>会议室名称：</td>
                                <td>${requestScope.room.roomname}</td>
                            </tr>
                            <tr>
                                <td>最大人数：</td>
                                <td>${requestScope.room.maxpnum}</td>
                            </tr>
                            <tr>
                                <td>会议室说明：</td>
                                <td>
                                    <textarea id="description" rows="5" readonly>${requestScope.room.explain}</textarea>
                                </td>
                            </tr>
                            <tr>
                                <td>预定会议室员工：</td>
                                <td>${requestScope.realname}</td>
                            </tr>
                            <tr>
                                <td class="command" colspan="2">
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