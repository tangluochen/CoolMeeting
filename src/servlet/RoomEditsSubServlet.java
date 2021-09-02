// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RoomEditsSubServlet.java

package servlet;

import biz.AccountBiz;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/RoomEditsSubServlet")
public class RoomEditsSubServlet extends HttpServlet
{

    public RoomEditsSubServlet()
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
        try
        {
            int roomid = Integer.parseInt(request.getParameter("roomid"));
            int roomnum = Integer.parseInt(request.getParameter("roomnum"));
            String roomname = request.getParameter("roomname");
            roomname = roomname.replaceAll("'", "");
            int maxpnum = Integer.parseInt(request.getParameter("maxpnum"));
            int status = Integer.parseInt(request.getParameter("status"));
            String explain = request.getParameter("explain");
            accountBiz.updateMeetingRoom(roomnum, roomname, maxpnum, status, explain, roomid);
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
