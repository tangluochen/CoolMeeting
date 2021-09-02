// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MeetingDetailsServlet.java

package servlet;

import biz.AccountBiz;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/MeetingDetailsServlet")
public class MeetingDetailsServlet extends HttpServlet
{

    public MeetingDetailsServlet()
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
        String mname = request.getParameter("mname");
        mname = mname.replaceAll("'", "");
        try
        {
            bean.Meeting meeting = accountBiz.selectMeetingByMname(mname);
            java.util.List staffList = accountBiz.selectStaffListByMname(mname);
            request.setAttribute("meeting", meeting);
            request.setAttribute("staffList", staffList);
            request.getRequestDispatcher("personal_center/meetingdetails.jsp").forward(request, response);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private static final long serialVersionUID = 1L;
}
