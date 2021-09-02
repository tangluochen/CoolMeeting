// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BookMeetingSubServlet.java

package servlet;

import bean.*;
import biz.AccountBiz;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/BookMeetingSubServlet")
public class BookMeetingSubServlet extends HttpServlet
{

    public BookMeetingSubServlet()
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
        AccountBiz accountBiz = new AccountBiz();
        List meetList = new ArrayList();
        Staff staff = (Staff)s.getAttribute("staff");
        String username = staff.getUsername();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try
        {
            String mname = request.getParameter("mname");
            int pnum = Integer.parseInt(request.getParameter("pnum"));
            Date starttime = sdf.parse(request.getParameter("starttime"));
            Date endtime = sdf.parse(request.getParameter("endtime"));
            Date restime = new Date();
            int roomid = Integer.parseInt(request.getParameter("roomid"));
            String explain = request.getParameter("explain");
            String str = request.getParameter("staffid");
            int resid = accountBiz.selectSidByUsername(username);
            int status = 1;
            Meeting m = new Meeting();
            m.setMname(mname);
            m.setPnum(pnum);
            m.setStarttime(starttime);
            m.setEndtime(endtime);
            m.setRestime(restime);
            m.setRoomid(roomid);
            m.setExplain(explain);
            m.setResid(resid);
            m.setStatus(status);
            accountBiz.insertMeeting(m);
            int meetingid = accountBiz.queryMidByMname(mname);
            String as[];
            int j = (as = str.split(",")).length;
            for(int i = 0; i < j; i++)
            {
                String id = as[i];
                int staffid = Integer.parseInt(id);
                MeetingStaff ms = new MeetingStaff();
                ms.setMeetingid(meetingid);
                ms.setStaffid(staffid);
                accountBiz.insertMeetingStaff(ms);
            }

            request.getRequestDispatcher("QueryMeetingSubServlet").forward(request, response);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private static final long serialVersionUID = 1L;
}
