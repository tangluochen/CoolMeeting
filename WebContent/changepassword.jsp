<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>密码修改</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" />
</head>
<body>
<div class="page-body-wai">
	<div class="page-body">
		<div class="page-content">
			<form action="${pageContext.request.contextPath}/ChangePwdServlet" method="post">
				<fieldset>
					<legend>修改密码</legend>
					<table class="formtable" style="width:50%">
					<tr>
						<td>原密码:</td>
						<td>
							<input id="pass" name="password1" type="password" />
						</td>
					</tr>
			        <tr>
						<td>新密码:</td>
						<td>
							<input id="new" name="password2" type="password" />
						</td>
					</tr>
					<tr>
						<td colspan="2" class="command">
							<input type="submit" value="提交" class="clickbutton" onclick=""/>
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