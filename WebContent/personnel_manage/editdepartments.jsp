<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>部门编辑</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css"/>
</head>
<body>
		<div class="page-body-wai">
			<div class="page-content">
                <div class="content-nav">
                    	人员管理 > 部门编辑
                </div>
                <form action="${pageContext.request.contextPath}/EditDepartmentsSubServlet" method="post">
                    <fieldset>
                        <legend>部门编辑</legend>
                        <table class="formtable">
                            <tr>
                                <td>部门编号：</td>
                                <td><input type="text" style="border:none;background-color:rgb(211,211,211);outline:none;" readonly="readonly" name="did" maxlength="20" value="${requestScope.dept.did}" ></td>
                            </tr>
                            <tr>
                                <td>部门名称：</td>
                                <td><input type="text" name="dname" maxlength="20" value="${requestScope.dept.dname}" οnfοcus="if (value =='${requestScope.dept.dname}'){value =''}" οnblur="if (value ==''){value='${requestScope.dept.dname}'}"></td>
                            </tr>
                            <%-- <tr>
                                <td>部门状态：</td>
                                <td><input type="hidden" name="dstatus" maxlength="20" placeholder="${requestScope.dept.dstatus}"></td>
                            </tr> --%>
                            <tr>
                                <td class="command" colspan="2">
                                	<input type="submit" class="clickbutton" value="确认"/>
                                    <input type="button" class="clickbutton" value="返回" onclick="window.history.back();"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
            </div>
      </div>
</body>
</html>