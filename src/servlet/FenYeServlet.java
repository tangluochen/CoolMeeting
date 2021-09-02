// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FenYeServlet.java

package servlet;

import biz.FenYeBiz;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/FenYeServlet")
public class FenYeServlet extends HttpServlet
{

    public FenYeServlet()
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
        FenYeBiz biz = new FenYeBiz();
        try
        {
            int currentPage = -999;
            String page = request.getParameter("page");
            if(page == null)
                currentPage = 1;
            else
                currentPage = Integer.parseInt(page);
            if(currentPage < 1)
                currentPage = 1;
            int totalNum = biz.getCount();
            int tiaoNum = 3;
            int totalPageNum = (totalNum - 1) / tiaoNum + 1;
            if(currentPage > totalPageNum)
                currentPage = totalPageNum;
            int startTiaoNum = (currentPage - 1) * tiaoNum + 1;
            int endTiaoNum = startTiaoNum + tiaoNum;
            request.setAttribute("currentPage", Integer.valueOf(currentPage));
            request.setAttribute("totalNum", Integer.valueOf(totalNum));
            request.setAttribute("totalPageNum", Integer.valueOf(totalPageNum));
            request.setAttribute("staffList", biz.queryStaff(startTiaoNum, endTiaoNum, tiaoNum));
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
