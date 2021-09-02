// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AddMeetingRoomSubServlet.java

package servlet;

import bean.Staff;
import biz.AccountBiz;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/AddMeetingRoomSubServlet")
public class AddMeetingRoomSubServlet extends HttpServlet
{

    public AddMeetingRoomSubServlet()
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
            int roomnum = Integer.parseInt(request.getParameter("roomnum"));
            String roomname = request.getParameter("roomname");
            int maxpnum = Integer.parseInt(request.getParameter("maxpnum"));
            int status = Integer.parseInt(request.getParameter("status"));
            String explain = request.getParameter("explain");
            int sid = accountBiz.selectSidByUsername(username);
            accountBiz.insertMeetingRoom(roomnum, roomname, maxpnum, status, explain, sid);
            request.getRequestDispatcher("QueryMeetingRoomServlet").forward(request, response);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private static final long serialVersionUID = 1L;
}
