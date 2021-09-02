<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String mname = request.getParameter("mname");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>会议预定--删除预定的会议</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css"/>
		
</head>
<body onload="body_load()">
<div class="page-body-wai">
	<div class="page-body">
            <div class="page-content">
                <div class="content-nav">
                    	会议预定 > 撤销会议预定
                </div>
                <form action="${pageContext.request.contextPath}/CancelMeetingServlet" method="post">
                    <fieldset>
                        <legend>撤销预定</legend>
                        <table class="formtable">
                            <tr>
                                <td>会议名称：</td>
                                <td><input name="mname" type="text" style="border:none;background-color:rgb(211,211,211);outline:none;" readonly="readonly" value="<%=mname%>" ></td>
                            </tr>
                            <tr>
                                <td>撤销理由：</td>
                                <td>
                                	<textarea id="description" name="canclereason" maxlength="200" rows="5" cols="60" placeholder="20字以内的文字描述"></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td class="command" colspan="2">
                                    <input type="submit" class="clickbutton" value="确认撤销"/>
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