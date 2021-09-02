// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   EmployeesServlet.java

package servlet;

import biz.AccountBiz;
import com.alibaba.fastjson.JSON;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/EmployeesServlet")
public class EmployeesServlet extends HttpServlet
{

    public EmployeesServlet()
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
        int did = Integer.parseInt(request.getParameter("did"));
        try
        {
            java.util.List staffList = accountBiz.queryStaffByDid(did);
            String str = JSON.toJSONString(staffList);
            response.setContentType("application/json;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write(str);
            out.flush();
            out.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private static final long serialVersionUID = 1L;
}
