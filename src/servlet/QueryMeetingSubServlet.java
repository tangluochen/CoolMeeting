// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   QueryMeetingSubServlet.java

package servlet;

import bean.Meeting;
import biz.AccountBiz;
import biz.FenYeBiz;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/QueryMeetingSubServlet")
public class QueryMeetingSubServlet extends HttpServlet
{

    public QueryMeetingSubServlet()
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
        FenYeBiz biz = new FenYeBiz();
        AccountBiz accountBiz = new AccountBiz();
        String mname = request.getParameter("m_name");
        String roomname = request.getParameter("room_name");
        String resname = request.getParameter("res_name");
        String Mstartdate = request.getParameter("Mstartdate");
        String Menddate = request.getParameter("Menddate");
        request.setAttribute("mname", mname);
        request.setAttribute("roomname", roomname);
        request.setAttribute("resname", resname);
        request.setAttribute("Mstartdate", Mstartdate);
        request.setAttribute("Menddate", Menddate);
        int roomid = -1;
        int resid = -1;
        try
        {
            if(roomname != null && roomname != "")
                roomid = accountBiz.queryRoomidByRoomname(roomname);
            if(resname != null && resname != "")
                resid = accountBiz.queryResidByResname(resname);
            List meetList = (List)request.getAttribute("meetList");
            int currentPage = -999;
            String page = request.getParameter("page");
            if(page == null)
                currentPage = 1;
            else
                currentPage = Integer.parseInt(page);
            if(currentPage < 1)
                currentPage = 1;
            int totalNum = 0;
            if(meetList != null)
                totalNum = 1;
            else
                totalNum = biz.getCountMM(mname, roomid, resid, Mstartdate, Menddate);
            int tiaoNum = 3;
            int totalPageNum = (totalNum - 1) / tiaoNum + 1;
            if(currentPage > totalPageNum)
                currentPage = totalPageNum;
            int startTiaoNum = (currentPage - 1) * tiaoNum + 1;
            int endTiaoNum = startTiaoNum + tiaoNum;
            request.setAttribute("currentPage", Integer.valueOf(currentPage));
            request.setAttribute("totalNum", Integer.valueOf(totalNum));
            request.setAttribute("totalPageNum", Integer.valueOf(totalPageNum));
            request.setAttribute("meetList", meetList);
            List meetListFenYe = biz.queryMeetingByMRR(mname, roomid, resid, Mstartdate, Menddate, startTiaoNum, endTiaoNum, tiaoNum);
            List strRoomList = new ArrayList();
            List strResNameList = new ArrayList();
            for(int index = 0; index < meetListFenYe.size(); index++)
            {
                roomid = ((Meeting)meetListFenYe.get(index)).getRoomid();
                int meetingid = ((Meeting)meetListFenYe.get(index)).getMid();
                roomname = accountBiz.selectRoomNameByRoomId(roomid);
                resname = accountBiz.selectReserveNameByMeetingId(meetingid);
                strRoomList.add(roomname);
                strResNameList.add(resname);
            }

            request.setAttribute("strRoomList", strRoomList);
            request.setAttribute("strResNameList", strResNameList);
            request.setAttribute("meetListFenYe", meetListFenYe);
            if(meetList != null)
            {
                List strRoomList2 = new ArrayList();
                List strResNameList2 = new ArrayList();
                for(int index = 0; index < meetList.size(); index++)
                {
                    roomid = ((Meeting)meetList.get(index)).getRoomid();
                    int meetingid = ((Meeting)meetList.get(index)).getMid();
                    roomname = accountBiz.selectRoomNameByRoomId(roomid);
                    resname = accountBiz.selectReserveNameByMeetingId(meetingid);
                    strRoomList2.add(roomname);
                    strResNameList2.add(resname);
                }

                request.setAttribute("strRoomList2", strRoomList2);
                request.setAttribute("strResNameList2", strResNameList2);
            }
            request.setAttribute("meetList", meetList);
            request.getRequestDispatcher("meeting_booking/queryMeeting.jsp").forward(request, response);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private static final long serialVersionUID = 1L;
}
