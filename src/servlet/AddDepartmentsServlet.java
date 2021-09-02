// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AddDepartmentsServlet.java

package servlet;

import biz.AccountBiz;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/AddDepartmentsServlet")
public class AddDepartmentsServlet extends HttpServlet
{

    public AddDepartmentsServlet()
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
        String dname = request.getParameter("dname");
        if(dname != "" && dname != null)
        {
            int id = 0;
            try
            {
                id = accountBiz.insertDepart(dname);
                java.util.List depList = accountBiz.selectAllDepart();
                request.setAttribute("depList", depList);
                request.getRequestDispatcher("personnel_manage/departments.jsp").forward(request, response);
            }
            catch(Exception e)
            {
                e.printStackTrace();
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } else
        {
            try
            {
                java.util.List depList = accountBiz.selectAllDepart();
                request.setAttribute("depList", depList);
                request.getRequestDispatcher("personnel_manage/departments.jsp").forward(request, response);
            }
            catch(Exception e)
            {
                e.printStackTrace();
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        }
    }

    private static final long serialVersionUID = 1L;
}
