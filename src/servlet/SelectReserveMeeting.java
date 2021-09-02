// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SelectReserveMeeting.java

package servlet;

import bean.Meeting;
import bean.Staff;
import biz.AccountBiz;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SelectReserveMeeting")
public class SelectReserveMeeting extends HttpServlet
{

    public SelectReserveMeeting()
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
        Staff staff = (Staff)s.getAttribute("staff");
        String username = staff.getUsername();
        try
        {
            List strRoomList = new ArrayList();
            List meetList = accountBiz.selectReserveMeetingByResId(username);
            for(int index = 0; index < meetList.size(); index++)
            {
                int roomid = ((Meeting)meetList.get(index)).getRoomid();
                String roomname = accountBiz.selectRoomNameByRoomId(roomid);
                strRoomList.add(roomname);
            }

            request.setAttribute("strRoomList", strRoomList);
            request.setAttribute("meetList", meetList);
            request.getRequestDispatcher("personal_center/mybookings.jsp").forward(request, response);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private static final long serialVersionUID = 1L;
}
