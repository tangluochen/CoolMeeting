// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ChangePwdServlet.java

package servlet;

import bean.Staff;
import biz.AccountBiz;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ChangePwdServlet")
public class ChangePwdServlet extends HttpServlet
{

    public ChangePwdServlet()
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
        AccountBiz accountBiz = new AccountBiz();
        HttpSession s = request.getSession();
        String username = ((Staff)s.getAttribute("staff")).getUsername();
        String password1 = ((Staff)s.getAttribute("staff")).getPassword();
        String password2 = request.getParameter("password1");
        String password = request.getParameter("password2");
        try
        {
            boolean result = accountBiz.changePwd(username, password1, password2, password);
            if(result)
                request.getRequestDispatcher("success.jsp").forward(request, response);
            else
                request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private static final long serialVersionUID = 1L;
}
