<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>CoolMeeting-注册</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css"/>
    <script type="text/javascript">
    	function x1(){
    		if(document.getElementById("employeename").value == "") {
        		document.getElementById("employeename").focus();
        		document.getElementById("name").innerHTML = "姓名未输入";
        	} else {
    			document.getElementById("name").innerHTML = "";
    		}
    	}
    	function x2(){
    		if(document.getElementById("accountname").value == "") {
        		document.getElementById("accountname").focus();
        		document.getElementById("uname").innerHTML = "账号未输入";
        	} else {
    			document.getElementById("uname").innerHTML = "";
    		}
    	}
    	function x3(){
    		if(document.getElementById("password").value == "") {
        		document.getElementById("password").focus();
        		document.getElementById("pwd").innerHTML = "密码未输入";
        	} else {
    			document.getElementById("pwd").innerHTML = "";
    		}
    	}
    	function x4(){
    		if(document.getElementById("confirm").value == "" && document.getElementById("password").value != "") {
        		document.getElementById("confirm").focus();
        		document.getElementById("conpwd").innerHTML = "确认密码未输入";
        	} else if(document.getElementById("confirm").value != document.getElementById("password").value && document.getElementById("password").value != "") {
        		document.getElementById("confirm").focus();
    			document.getElementById("conpwd").innerHTML = "两次输入密码不一致";
    		} else {
    			document.getElementById("conpwd").innerHTML = "";
    		}
    	}
    </script>
</head>
<body>
<div class="page-body-wai">
<div class="page-body">
    <div class="page-content">
        <div class="content-nav">
                     人员管理 > 员工注册
        </div>
        <form action="${pageContext.request.contextPath}/RegisterSubServlet" method="post">
            <fieldset>
                <legend>员工信息</legend>
                <table class="formtable" style="width:50%">
                    <tr>
                        <td>姓名：</td>
                        <td>
                            <input type="text" id="employeename" onblur="javascript:x1()" maxlength="20" name="realname"/><font id="name" color="red"></font>
                        </td>
                    </tr>
                    <tr>
                        <td>账户名：</td>
                        <td>
                            <input type="text" id="accountname" onblur="javascript:x2()" maxlength="20" name="username"/><font id="uname" color="red"></font>
                        </td>
                    </tr>
                    <tr>
                        <td>密码：</td>
                        <td>
                            <input type="password" id="password" onblur="javascript:x3()" maxlength="20" placeholder="请输入密码" name="password"/><font id="pwd" color="red"></font>
                        </td>
                    </tr>
                    <tr>
                        <td>确认密码：</td>
                        <td>
                            <input type="password" id="confirm" onblur="javascript:x4()" maxlength="20" name="confirmpassword"/><span id="conpwd" style="color:red;font-size:14px"></span>
                        </td>
                    </tr>
                    <tr>
                        <td>所属部门：</td>
                        <td>
                            <select name="did">
                                <!-- <option>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请选择部门&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option> -->
                                <c:forEach items="${requestScope.deptList}" var="dept">
                                    <c:if test="${dept.dstatus == 1}">
                                        <option value="${dept.did}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${dept.dname}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
                                    </c:if>
								</c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>联系电话：</td>
                        <td>
                            <input type="text" id="phone" maxlength="20" name="phone"/>
                        </td>
                    </tr>
                    <tr>
                        <td>电子邮件：</td>
                        <td>
                            <input type="text" id="email" maxlength="20" name="email"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="6" class="command">
                            <input type="submit" class="clickbutton" value="注册"/>
                            <input type="reset" class="clickbutton" value="清空"/>
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
