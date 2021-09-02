// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LoginServlet.java

package servlet;

import bean.Staff;
import biz.AccountBiz;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet
{

    public LoginServlet()
    {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        AccountBiz accountBiz = new AccountBiz();
        try
        {
            int count = accountBiz.selectStaffByUserAndPwd(username, password);
            if(count == 1)
            {
                HttpSession s = request.getSession();
                Staff staff = new Staff();
                staff.setUsername(username);
                staff.setPassword(password);
                s.setAttribute("staff", staff);
                AccountBiz acb = new AccountBiz();
                boolean bl = acb.queryRoleByUsername(username);
                int status = acb.queryStatusByUsername(username, password);
                if(status == 1)
                {
                    s.setAttribute("bl", Boolean.valueOf(bl));
                    request.getRequestDispatcher("layout/index.jsp").forward(request, response);
                } else
                if(status == 0)
                {
                    request.setAttribute("err", "\u8BE5\u5458\u5DE5\u6B63\u5728\u5BA1\u6279\u4E2D\uFF01");
                    request.getRequestDispatcher("loginerror.jsp").forward(request, response);
                } else
                if(status == 2)
                {
                    request.setAttribute("err", "\u8BE5\u5458\u5DE5\u5BA1\u6279\u672A\u901A\u8FC7\uFF01");
                    request.getRequestDispatcher("loginerror.jsp").forward(request, response);
                }
            } else
            {
                request.setAttribute("err", "\u8D26\u53F7\u6216\u5BC6\u7801\u8F93\u5165\u9519\u8BEF\uFF01");
                request.getRequestDispatcher("loginerror.jsp").forward(request, response);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private static final long serialVersionUID = 1L;
}
