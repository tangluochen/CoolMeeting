// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LoginOffServlet.java

package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LoginOffServlet")
public class LoginOffServlet extends HttpServlet
{

    public LoginOffServlet()
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
        HttpSession s = request.getSession();
        s.invalidate();
        request.setAttribute("clogin", "\u8BF7\u767B\u5F55");
        response.sendRedirect("login.jsp");
    }

    private static final long serialVersionUID = 1L;
}
