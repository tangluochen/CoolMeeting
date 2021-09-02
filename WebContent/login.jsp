<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>CoolMeeting-登录</title>
	<link rel="stylesheet" href="<%=basePath%>css/common.css" />
</head>
<body>
	<span style="color:red; font-weight:600; font-size:20px;">${requestScope.clogin}</span>
	<div class="page-body">
      <div class="page-content">
        <div class="content-nav">
                  登录
        </div>
        <form action="<%=basePath%>LoginServlet" method="post">
          <fieldset>
            <legend>登录信息</legend>
            <table class="formtable" style="width:50%">
              <tr>
                <td>账号名:</td>
                <td>
                  <input id="accountname" name="username" type="text" />
                </td>
              </tr>
              <tr>
                <td>密码:</td>
                <td>
                  <input id="new" name="password" type="password" />
                </td>
              </tr>
              <tr>
                <td colspan="2" class="command">
                  <input type="submit" value="登录" class="clickbutton" onclick=""/>
                  <input type="button" value="注册" class="clickbutton" onclick="window.location.href='<%=basePath%>RegisterServlet'"/>
                </td>
              </tr>
            </table>
          </fieldset>
        </form>
      </div>
    </div>
    <div class="page-footer">
      <hr/>
           更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
      <img src="images/footer.png" alt="CoolMeeting"/>
    </div>
</body>
</html>