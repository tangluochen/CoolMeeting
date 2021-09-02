// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   QueryStaffSubServlet.java

package servlet;

import biz.FenYeBiz;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/QueryStaffSubServlet")
public class QueryStaffSubServlet extends HttpServlet
{

    public QueryStaffSubServlet()
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
        String realname = request.getParameter("real_name");
        String username = request.getParameter("user_name");
        int status = -9;
        if(request.getParameter("status") != null && request.getParameter("status") != "")
            status = Integer.parseInt(request.getParameter("status"));
        request.setAttribute("realname", realname);
        request.setAttribute("username", username);
        request.setAttribute("status", Integer.valueOf(status));
        FenYeBiz biz = new FenYeBiz();
        try
        {
            List staffList = (List)request.getAttribute("staffList");
            int currentPage = -999;
            String page = request.getParameter("page");
            if(page == null)
                currentPage = 1;
            else
                currentPage = Integer.parseInt(page);
            if(currentPage < 1)
                currentPage = 1;
            int totalNum = 0;
            if(staffList != null)
                totalNum = 1;
            else
                totalNum = biz.getCountS(realname, username, status);
            int tiaoNum = 3;
            int totalPageNum = (totalNum - 1) / tiaoNum + 1;
            if(currentPage > totalPageNum)
                currentPage = totalPageNum;
            int startTiaoNum = (currentPage - 1) * tiaoNum + 1;
            int endTiaoNum = startTiaoNum + tiaoNum;
            request.setAttribute("currentPage", Integer.valueOf(currentPage));
            request.setAttribute("totalNum", Integer.valueOf(totalNum));
            request.setAttribute("totalPageNum", Integer.valueOf(totalPageNum));
            request.setAttribute("staffList", staffList);
            List staffListFenYe = biz.queryStaffByRUS(realname, username, status, startTiaoNum, endTiaoNum, tiaoNum);
            request.setAttribute("staffListFenYe", staffListFenYe);
            request.getRequestDispatcher("personnel_manage/searchemployees.jsp").forward(request, response);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private static final long serialVersionUID = 1L;
}
