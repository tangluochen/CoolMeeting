// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JumpServlet.java

package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/JumpServlet")
public class JumpServlet extends HttpServlet
{

    public JumpServlet()
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
        int pageNum = Integer.parseInt(request.getParameter("page_num"));
        request.setAttribute("pageNum", Integer.valueOf(pageNum));
        request.getRequestDispatcher("personnel_manage/searchemployees.jsp").forward(request, response);
    }

    private static final long serialVersionUID = 1L;
}
