// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RoomEditsServlet.java

package servlet;

import bean.MeetingRoom;
import biz.AccountBiz;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/RoomEditsServlet")
public class RoomEditsServlet extends HttpServlet
{

    public RoomEditsServlet()
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
        String roomname = request.getParameter("roomname");
        roomname = roomname.replaceAll("'", "");
        try
        {
            MeetingRoom room = accountBiz.queryRoomDetailsByRoomname(roomname);
            String realname = accountBiz.queryNameById(room.getSid());
            request.setAttribute("room", room);
            request.setAttribute("realname", realname);
            request.getRequestDispatcher("meeting_booking/roomedits.jsp").forward(request, response);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private static final long serialVersionUID = 1L;
}
