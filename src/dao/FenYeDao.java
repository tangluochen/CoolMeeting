// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FenYeDao.java

package dao;

import bean.Meeting;
import bean.Staff;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.DbUtils;

public class FenYeDao
{

    public FenYeDao()
    {
    }

    public List queryMeetingByMRR(String mname, int roomid, int resid, String startdate, String enddate, int startTiaoNum, int endTiaoNum, 
            int tiaoNum)
        throws Exception
    {
        List meetList = new ArrayList();
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        startTiaoNum--;
        String sql = "select * from meeting where 0=0";
        if(mname != null && mname != "")
            sql = (new StringBuilder(String.valueOf(sql))).append(" and mname like '%").append(mname).append("%'").toString();
        if(roomid != -1)
            sql = (new StringBuilder(String.valueOf(sql))).append(" and roomid = ").append(roomid).toString();
        if(resid != -1)
            sql = (new StringBuilder(String.valueOf(sql))).append(" and resid = ").append(resid).toString();
        if(startdate != null && startdate != "")
            sql = (new StringBuilder(String.valueOf(sql))).append(" and starttime >= str_to_date('").append(startdate).append("', '%Y-%m-%d')").toString();
        if(enddate != null && enddate != "")
            sql = (new StringBuilder(String.valueOf(sql))).append(" and endtime <= str_to_date('").append(enddate).append("', '%Y-%m-%d')").toString();
        sql = (new StringBuilder(String.valueOf(sql))).append(" ORDER BY restime DESC limit ").append(startTiaoNum).append(", ").append(tiaoNum).toString();
        Meeting meeting;
        for(ResultSet rs = stm.executeQuery(sql); rs.next(); meetList.add(meeting))
        {
            meeting = new Meeting();
            int mid = rs.getInt("mid");
            String mname0 = rs.getString("mname");
            int pnum = rs.getInt("pnum");
            java.util.Date starttime = rs.getTimestamp("starttime");
            java.util.Date endtime = rs.getTimestamp("endtime");
            java.util.Date restime = rs.getTimestamp("restime");
            int roomid0 = rs.getInt("roomid");
            String explain = rs.getString("explain");
            int resid0 = rs.getInt("resid");
            int status = rs.getInt("status");
            meeting.setMid(mid);
            meeting.setMname(mname0);
            meeting.setPnum(pnum);
            meeting.setStarttime(starttime);
            meeting.setEndtime(endtime);
            meeting.setRestime(restime);
            meeting.setRoomid(roomid0);
            meeting.setExplain(explain);
            meeting.setResid(resid0);
            meeting.setStatus(status);
        }

        return meetList;
    }

    public int getCountMM(String mname, int roomid, int resid, String startdate, String enddate)
        throws Exception
    {
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = "select count(*) as num from meeting where 0=0";
        if(mname != null && mname != "")
            sql = (new StringBuilder(String.valueOf(sql))).append(" and mname like '%").append(mname).append("%'").toString();
        if(roomid != -1)
            sql = (new StringBuilder(String.valueOf(sql))).append(" and roomid = ").append(roomid).toString();
        if(resid != -1)
            sql = (new StringBuilder(String.valueOf(sql))).append(" and resid = ").append(resid).toString();
        if(startdate != null && startdate != "")
            sql = (new StringBuilder(String.valueOf(sql))).append(" and starttime >= str_to_date('").append(startdate).append("', '%Y-%m-%d')").toString();
        if(enddate != null && enddate != "")
            sql = (new StringBuilder(String.valueOf(sql))).append(" and endtime <= str_to_date('").append(enddate).append("', '%Y-%m-%d')").toString();
        ResultSet rs = stm.executeQuery(sql);
        if(rs.next())
            return rs.getInt("num");
        else
            return 0;
    }

    public List queryStaffByRUS(String realname, String username, int status, int startTiaoNum, int endTiaoNum, int tiaoNum)
        throws Exception
    {
        List staffList = new ArrayList();
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        startTiaoNum--;
        String sql = "select * from staff where 0 = 0";
        if(realname != null && realname != "")
            sql = (new StringBuilder(String.valueOf(sql))).append(" and realname like '%").append(realname).append("%'").toString();
        if(username != null && username != "")
            sql = (new StringBuilder(String.valueOf(sql))).append(" and username like '%").append(username).append("%'").toString();
        if(status != -9)
            sql = (new StringBuilder(String.valueOf(sql))).append(" and `status` = ").append(status).toString();
        sql = (new StringBuilder(String.valueOf(sql))).append(" ORDER BY sid DESC limit ").append(startTiaoNum).append(", ").append(tiaoNum).toString();
        Staff staff;
        for(ResultSet rs = stm.executeQuery(sql); rs.next(); staffList.add(staff))
        {
            staff = new Staff();
            int sid = rs.getInt("sid");
            String realname0 = rs.getString("realname");
            String username0 = rs.getString("username");
            String password = rs.getString("password");
            String phone = rs.getString("phone");
            String email = rs.getString("email");
            int did = rs.getInt("did");
            int role = rs.getInt("role");
            int staff0 = rs.getInt("status");
            staff.setSid(sid);
            staff.setRealname(realname0);
            staff.setUsername(username0);
            staff.setPassword(password);
            staff.setPhone(phone);
            staff.setEmail(email);
            staff.setDid(did);
            staff.setStatus(staff0);
            staff.setRole(role);
        }

        return staffList;
    }

    public int getCountS(String realname, String username, int status)
        throws Exception
    {
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = "select count(*) as num from staff where 0=0";
        if(realname != null && realname != "")
            sql = (new StringBuilder(String.valueOf(sql))).append(" and realname like '%").append(realname).append("%'").toString();
        if(username != null && username != "")
            sql = (new StringBuilder(String.valueOf(sql))).append(" and username like '%").append(username).append("%'").toString();
        if(status != -9)
            sql = (new StringBuilder(String.valueOf(sql))).append(" and `status` = ").append(status).toString();
        ResultSet rs = stm.executeQuery(sql);
        if(rs.next())
            return rs.getInt("num");
        else
            return 0;
    }

    public List queryMeeting(int startTiaoNum, int endTiaoNum, int tiaoNum)
        throws Exception
    {
        List meetingList = new ArrayList();
        startTiaoNum--;
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = (new StringBuilder("select * from meeting ORDER BY restime DESC limit ")).append(startTiaoNum).append(", ").append(tiaoNum).toString();
        Meeting meeting;
        for(ResultSet rs = stm.executeQuery(sql); rs.next(); meetingList.add(meeting))
        {
            meeting = new Meeting();
            int mid = rs.getInt("mid");
            String mname = rs.getString("mname");
            int pnum = rs.getInt("pnum");
            java.util.Date starttime = rs.getTimestamp("starttime");
            java.util.Date endtime = rs.getTimestamp("endtime");
            java.util.Date restime = rs.getTimestamp("restime");
            int roomid = rs.getInt("roomid");
            String explain = rs.getString("explain");
            int resid = rs.getInt("resid");
            int status = rs.getInt("status");
            meeting.setMid(mid);
            meeting.setMname(mname);
            meeting.setPnum(pnum);
            meeting.setStarttime(starttime);
            meeting.setEndtime(endtime);
            meeting.setRestime(restime);
            meeting.setRoomid(roomid);
            meeting.setExplain(explain);
            meeting.setResid(resid);
            meeting.setStatus(status);
        }

        return meetingList;
    }

    public List queryStaff(int startTiaoNum, int endTiaoNum, int tiaoNum)
        throws Exception
    {
        List staffList = new ArrayList();
        startTiaoNum--;
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = (new StringBuilder("select * from ORDER BY sid DESC staff limit ")).append(startTiaoNum).append(", ").append(tiaoNum).toString();
        Staff staff;
        for(ResultSet rs = stm.executeQuery(sql); rs.next(); staffList.add(staff))
        {
            staff = new Staff();
            int sid = rs.getInt("sid");
            String realname = rs.getString("realname");
            String username = rs.getString("username");
            String password = rs.getString("password");
            String phone = rs.getString("phone");
            String email = rs.getString("email");
            int did = rs.getInt("did");
            int status = rs.getInt("status");
            int role = rs.getInt("role");
            staff.setSid(sid);
            staff.setRealname(realname);
            staff.setUsername(username);
            staff.setPassword(password);
            staff.setPhone(phone);
            staff.setEmail(email);
            staff.setDid(did);
            staff.setStatus(status);
            staff.setRole(role);
        }

        return staffList;
    }

    public int getCountM()
        throws Exception
    {
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = "select count(*) as num from meeting";
        ResultSet rs = stm.executeQuery(sql);
        if(rs.next())
            return rs.getInt("num");
        else
            return 0;
    }

    public int getCount()
        throws Exception
    {
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = "select count(*) as num from staff";
        ResultSet rs = stm.executeQuery(sql);
        if(rs.next())
            return rs.getInt("num");
        else
            return 0;
    }
}
