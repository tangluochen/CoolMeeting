// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AccountDao.java

package dao;

import bean.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import util.DbUtils;

public class AccountDao
{

    public AccountDao()
    {
    }

    public boolean queryRoleByUsername(String username)
        throws Exception
    {
        boolean bl = false;
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = (new StringBuilder("select role from staff where username = '")).append(username).append("'").toString();
        for(ResultSet rs = stm.executeQuery(sql); rs.next();)
        {
            int role = rs.getInt("role");
            if(role == 1)
                bl = true;
        }

        return bl;
    }

    public int queryStatusByUsername(String username, String password)
        throws Exception
    {
        int status = -999;
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = (new StringBuilder("select status from staff where username = '")).append(username).append("' and password = '").append(password).append("'").toString();
        for(ResultSet rs = stm.executeQuery(sql); rs.next();)
            status = rs.getInt("status");

        return status;
    }

    public MeetingRoom queryRoomDetailsByRoomname(String roomname)
        throws Exception
    {
        MeetingRoom room = new MeetingRoom();
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = (new StringBuilder("select * from meetingroom where roomname = '")).append(roomname).append("'").toString();
        int sid;
        for(ResultSet rs = stm.executeQuery(sql); rs.next(); room.setSid(sid))
        {
            int roomid = rs.getInt("roomid");
            int roomnum = rs.getInt("roomnum");
            String roomname0 = rs.getString("roomname");
            int maxpnum = rs.getInt("maxpnum");
            int status = rs.getInt("status");
            String explain = rs.getString("explain");
            sid = rs.getInt("sid");
            room.setRoomid(roomid);
            room.setRoomnum(roomnum);
            room.setRoomname(roomname0);
            room.setMaxpnum(maxpnum);
            room.setStatus(status);
            room.setExplain(explain);
        }

        return room;
    }

    public String queryNameById(int sid)
        throws Exception
    {
        String realname = null;
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = (new StringBuilder("select realname from staff where sid = ")).append(sid).toString();
        ResultSet rs = stm.executeQuery(sql);
        if(rs.next())
            realname = rs.getString("realname");
        return realname;
    }

    public boolean changePwd(String username, String password1, String password2, String password)
        throws Exception
    {
        boolean bl = false;
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        if(password1.equals(password2))
        {
            String sql = (new StringBuilder("update staff set password = '")).append(password).append("' where username = '").append(username).append("'").toString();
            int rs = -999;
            rs = stm.executeUpdate(sql);
            if(rs != -999)
                bl = true;
        }
        return bl;
    }

    public void updateMeetingRoom(int roomnum, String roomname, int maxpnum, int status, String explain, int roomid)
        throws Exception
    {
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = (new StringBuilder("update meetingroom set roomnum = ")).append(roomnum).append(",roomname = '").append(roomname).append("',maxpnum = ").append(maxpnum).append(",`status` = ").append(status).append(",`explain` = '").append(explain).append("' where roomid = ").append(roomid).toString();
        stm.executeUpdate(sql);
    }

    public int editDepartment(int did, String dname)
        throws Exception
    {
        int i = 0;
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = (new StringBuilder("update department set dname = '")).append(dname).append("',dstatus = ").append(1).append(" where did = ").append(did).toString();
        i = stm.executeUpdate(sql);
        return i;
    }

    public void deleteDepartmentsById(int did)
        throws Exception
    {
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = (new StringBuilder("update department set dstatus = 0 where did = ")).append(did).toString();
        stm.executeUpdate(sql);
    }

    public void deleteMeeting(String mname, String canclereason)
        throws Exception
    {
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = (new StringBuilder("update meeting set status = 0,canclereason = '")).append(canclereason).append("' where mname = '").append(mname).append("'").toString();
        stm.executeUpdate(sql);
    }

    public void updateStaffStatus(String username, int status)
        throws Exception
    {
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = (new StringBuilder("update staff set status = ")).append(status).append(" where username = '").append(username).append("'").toString();
        stm.executeUpdate(sql);
    }

    public void insertStaff(Staff s)
        throws Exception
    {
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = (new StringBuilder("insert into staff (realname,username,`password`,phone,email,did,`status`,role) values ('")).append(s.getRealname()).append("','").append(s.getUsername()).append("','").append(s.getPassword()).append("','").append(s.getPhone()).append("','").append(s.getEmail()).append("',").append(s.getDid()).append(",").append(0).append(",").append(2).append(")").toString();
        stm.executeUpdate(sql);
    }

    public void insertMeetingStaff(MeetingStaff ms)
        throws Exception
    {
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = (new StringBuilder("insert into meetingstaff (meetingid,staffid) values ( ")).append(ms.getMeetingid()).append(",").append(ms.getStaffid()).append(")").toString();
        stm.executeUpdate(sql);
    }

    public void insertMeeting(Meeting m)
        throws Exception
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = (new StringBuilder("insert into meeting (mname,pnum,starttime,endtime,restime,roomid,`explain`,resid,`status`) values ('")).append(m.getMname()).append("',").append(m.getPnum()).append(",'").append(sdf.format(m.getStarttime())).append("','").append(sdf.format(m.getEndtime())).append("','").append(sdf.format(m.getRestime())).append("',").append(m.getRoomid()).append(",'").append(m.getExplain()).append("',").append(m.getResid()).append(",").append(m.getStatus()).append(");").toString();
        stm.executeUpdate(sql);
    }

    public int insertDepart(String dname)
        throws Exception
    {
        int id = 0;
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = (new StringBuilder("insert into department (dname,dstatus) values ( '")).append(dname).append("',1)").toString();
        id = stm.executeUpdate(sql);
        return id;
    }

    public void insertMeetingRoom(int roomnum, String roomname, int maxpnum, int status, String explain, int sid)
        throws Exception
    {
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = (new StringBuilder("insert into meetingroom (roomnum,roomname,maxpnum,`status`,`explain`,sid) values ( ")).append(roomnum).append(",'").append(roomname).append("',").append(maxpnum).append(",").append(status).append(",'").append(explain).append("',").append(sid).append(")").toString();
        stm.executeUpdate(sql);
    }

    public List selectAttendMeetingById(String username)
        throws Exception
    {
        List meetList = new ArrayList();
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = (new StringBuilder("select * from meeting where mid in (select meetingid from meetingstaff where staffid in (select sid from staff where username = '")).append(username).append("')) ORDER BY starttime DESC;").toString();
        Meeting meeting;
        for(ResultSet rs = stm.executeQuery(sql); rs.next(); meetList.add(meeting))
        {
            meeting = new Meeting();
            int mid = rs.getInt("mid");
            String mname = rs.getString("mname");
            int pnum = rs.getInt("pnum");
            Date starttime = rs.getTimestamp("starttime");
            Date endtime = rs.getTimestamp("endtime");
            Date restime = rs.getTimestamp("restime");
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

        return meetList;
    }

    public List selectReserveMeetingByResId(String username)
        throws Exception
    {
        List meetList = new ArrayList();
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = (new StringBuilder("select * from meeting where resid in (select sid from staff where username ='")).append(username).append("') ORDER BY restime DESC").toString();
        Meeting meeting;
        for(ResultSet rs = stm.executeQuery(sql); rs.next(); meetList.add(meeting))
        {
            meeting = new Meeting();
            int mid = rs.getInt("mid");
            String mname = rs.getString("mname");
            int pnum = rs.getInt("pnum");
            Date starttime = rs.getTimestamp("starttime");
            Date endtime = rs.getTimestamp("endtime");
            Date restime = rs.getTimestamp("restime");
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

        return meetList;
    }

    public List selectAllDepart()
        throws Exception
    {
        List dep = new ArrayList();
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = "select * from department ORDER BY did DESC";
        Department depart;
        for(ResultSet rs = stm.executeQuery(sql); rs.next(); dep.add(depart))
        {
            depart = new Department();
            int did = rs.getInt("did");
            String dname = rs.getString("dname");
            int dstatus = rs.getInt("dstatus");
            depart.setDid(did);
            depart.setDname(dname);
            depart.setDstatus(dstatus);
        }

        return dep;
    }

    public String selectReserveNameByMeetingId(int mid)
        throws Exception
    {
        String resname = null;
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = (new StringBuilder("select realname from staff where sid in (select resid from meeting where mid = ")).append(mid).append(");").toString();
        ResultSet rs = stm.executeQuery(sql);
        if(rs.next())
            resname = rs.getString("realname");
        return resname;
    }

    public List queryMeetingRoomByTime(String startdate, String enddate)
        throws Exception
    {
        List roomList = new ArrayList();
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = "select * from meetingroom where `status` = 1 and roomid in (select meetingroom.roomid from meeting,meetingroom where meetingroom.roomid not in (select meeting.roomid from meeting) group by meetingroom.roomid\r\n) \r\nor roomid in (select roomid from meeting where 0=0 ";
        if(startdate != null && startdate != "" && enddate != null && enddate != "")
            sql = (new StringBuilder(String.valueOf(sql))).append("and roomid in(select b.roomid from (select roomid from meeting where \r\n(starttime >= str_to_date('").append(enddate).append("', '%Y-%m-%d %H:%i:%s') \r\n").append("or endtime <= str_to_date('").append(startdate).append("', '%Y-%m-%d %H:%i:%s')) \r\n").append("group by meeting.roomid)b \r\n").append("where b.roomid not in (select roomid from \r\n").append("(select roomid from meeting where \r\n").append("(starttime <= str_to_date('").append(startdate).append("', '%Y-%m-%d %H:%i:%s') and endtime >= str_to_date('").append(enddate).append("', '%Y-%m-%d %H:%i:%s')) \r\n").append("or(starttime >= str_to_date('").append(startdate).append("', '%Y-%m-%d %H:%i:%s') and starttime <= str_to_date('").append(enddate).append("', '%Y-%m-%d %H:%i:%s')) \r\n").append("or(endtime >= str_to_date('").append(startdate).append("', '%Y-%m-%d %H:%i:%s') and endtime <= str_to_date('").append(enddate).append("', '%Y-%m-%d %H:%i:%s')) \r\n").append("group by roomid)c))").toString();
        sql = (new StringBuilder(String.valueOf(sql))).append(")").toString();
        MeetingRoom room;
        for(ResultSet rs = stm.executeQuery(sql); rs.next(); roomList.add(room))
        {
            room = new MeetingRoom();
            int roomid = rs.getInt("roomid");
            int roomnum = rs.getInt("roomnum");
            String roomname = rs.getString("roomname");
            int maxpnum = rs.getInt("maxpnum");
            int status = rs.getInt("status");
            String explain = rs.getString("explain");
            int sid = rs.getInt("sid");
            room.setRoomid(roomid);
            room.setRoomnum(roomnum);
            room.setRoomname(roomname);
            room.setMaxpnum(maxpnum);
            room.setStatus(status);
            room.setExplain(explain);
            room.setSid(sid);
        }

        return roomList;
    }

    public List queryAllMeetingRoom()
        throws Exception
    {
        List roomList = new ArrayList();
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = "select * from meetingroom order by roomid desc";
        MeetingRoom room;
        for(ResultSet rs = stm.executeQuery(sql); rs.next(); roomList.add(room))
        {
            room = new MeetingRoom();
            int roomid = rs.getInt("roomid");
            int roomnum = rs.getInt("roomnum");
            String roomname = rs.getString("roomname");
            int maxpnum = rs.getInt("maxpnum");
            int status = rs.getInt("status");
            String explain = rs.getString("explain");
            int sid = rs.getInt("sid");
            room.setRoomid(roomid);
            room.setRoomnum(roomnum);
            room.setRoomname(roomname);
            room.setMaxpnum(maxpnum);
            room.setStatus(status);
            room.setExplain(explain);
            room.setSid(sid);
        }

        return roomList;
    }

    public List queryAllMeetingStaff()
        throws Exception
    {
        List msList = new ArrayList();
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = "select * from meetingstaff";
        MeetingStaff ms;
        for(ResultSet rs = stm.executeQuery(sql); rs.next(); msList.add(ms))
        {
            ms = new MeetingStaff();
            int id = rs.getInt("id");
            int meetingid = rs.getInt("meetingid");
            int staffid = rs.getInt("staffid");
            ms.setId(id);
            ms.setMeetingid(meetingid);
            ms.setStaffid(staffid);
        }

        return msList;
    }

    public List queryAllMeeting()
        throws Exception
    {
        List meetList = new ArrayList();
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = "select * from meeting";
        Meeting meeting;
        for(ResultSet rs = stm.executeQuery(sql); rs.next(); meetList.add(meeting))
        {
            meeting = new Meeting();
            int mid = rs.getInt("mid");
            String mname = rs.getString("mname");
            int pnum = rs.getInt("pnum");
            Date starttime = rs.getTimestamp("starttime");
            Date endtime = rs.getTimestamp("endtime");
            Date restime = rs.getTimestamp("restime");
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

        return meetList;
    }

    public List queryAllDepartment()
        throws Exception
    {
        List deptList = new ArrayList();
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = "select * from department";
        Department depart;
        for(ResultSet rs = stm.executeQuery(sql); rs.next(); deptList.add(depart))
        {
            depart = new Department();
            int did = rs.getInt("did");
            String dname = rs.getString("dname");
            int dstatus = rs.getInt("dstatus");
            depart.setDid(did);
            depart.setDname(dname);
            depart.setDstatus(dstatus);
        }

        return deptList;
    }

    public List queryAllStaff()
        throws Exception
    {
        List staffList = new ArrayList();
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = "select * from staff ORDER BY sid DESC";
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

    public Department queryDepartmentsById(int did)
        throws Exception
    {
        Department department = new Department();
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = (new StringBuilder("select * from department where did = ")).append(did).toString();
        ResultSet rs = stm.executeQuery(sql);
        if(rs.next())
        {
            String dname = rs.getString("dname");
            int dstatus = rs.getInt("dstatus");
            department.setDid(did);
            department.setDname(dname);
            department.setDstatus(dstatus);
        }
        return department;
    }

    public List queryMeetingByMRR(String mname, int roomid, int resid)
        throws Exception
    {
        List meetList = new ArrayList();
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = (new StringBuilder("select * from meeting where mname = '")).append(mname).append("' and roomid = ").append(roomid).append(" and resid = ").append(resid).toString();
        Meeting meeting;
        for(ResultSet rs = stm.executeQuery(sql); rs.next(); meetList.add(meeting))
        {
            meeting = new Meeting();
            int mid = rs.getInt("mid");
            int pnum = rs.getInt("pnum");
            Date starttime = rs.getTimestamp("starttime");
            Date endtime = rs.getTimestamp("endtime");
            Date restime = rs.getTimestamp("restime");
            String explain = rs.getString("explain");
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

        return meetList;
    }

    public List queryStaffByDid(int did)
        throws Exception
    {
        List staffList = new ArrayList();
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = (new StringBuilder("select * from staff where did = ")).append(did).toString();
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

    public String selectRoomNameByRoomId(int roomid)
        throws Exception
    {
        String roomname = null;
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = (new StringBuilder("select roomname from meetingroom where roomid = ")).append(roomid).toString();
        ResultSet rs = stm.executeQuery(sql);
        if(rs.next())
            roomname = rs.getString("roomname");
        return roomname;
    }

    public Meeting selectMeetingByMname(String mname)
        throws Exception
    {
        Meeting meeting = new Meeting();
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = (new StringBuilder("select * from meeting where mname = '")).append(mname).append("'").toString();
        ResultSet rs = stm.executeQuery(sql);
        if(rs.next())
        {
            int mid = rs.getInt("mid");
            int pnum = rs.getInt("pnum");
            Date starttime = rs.getTimestamp("starttime");
            Date endtime = rs.getTimestamp("endtime");
            Date restime = rs.getTimestamp("restime");
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
        return meeting;
    }

    public List selectMeetingListByUsername(String username)
        throws Exception
    {
        List meetList = new ArrayList();
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = (new StringBuilder("select * from meeting where mid in (select meetingid from meetingstaff where staffid in (select sid from staff where username = '")).append(username).append("')) ORDER BY starttime DESC").toString();
        Meeting meeting;
        for(ResultSet rs = stm.executeQuery(sql); rs.next(); meetList.add(meeting))
        {
            meeting = new Meeting();
            int mid = rs.getInt("mid");
            String mname = rs.getString("mname");
            int pnum = rs.getInt("pnum");
            Date starttime = rs.getTimestamp("starttime");
            Date endtime = rs.getTimestamp("endtime");
            Date restime = rs.getTimestamp("restime");
            int roomid = rs.getInt("roomid");
            String explain = rs.getString("explain");
            int resid = rs.getInt("resid");
            int status = rs.getInt("status");
            String canclereason = rs.getString("canclereason");
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
            meeting.setCanclereason(canclereason);
        }

        return meetList;
    }

    public List selectMeetingListByUsername7(String username)
        throws Exception
    {
        List meetList = new ArrayList();
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(5, 7);
        Date after7days = calendar.getTime();
        String date1 = sdf.format(date);
        String after7days1 = sdf.format(after7days);
        String sql = (new StringBuilder("select * from meeting where mid in (select meetingid from meetingstaff where staffid in (select sid from staff where username = '")).append(username).append("')) and starttime between str_to_date('").append(date1).append("', '%Y-%m-%d %H:%i:%s') and str_to_date('").append(after7days1).append("', '%Y-%m-%d %H:%i:%s') ORDER BY starttime DESC").toString();
        Meeting meeting;
        for(ResultSet rs = stm.executeQuery(sql); rs.next(); meetList.add(meeting))
        {
            meeting = new Meeting();
            int mid = rs.getInt("mid");
            String mname = rs.getString("mname");
            int pnum = rs.getInt("pnum");
            Date starttime = rs.getTimestamp("starttime");
            Date endtime = rs.getTimestamp("endtime");
            Date restime = rs.getTimestamp("restime");
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

        return meetList;
    }

    public List selectStaffListByMname(String mname)
        throws Exception
    {
        List staffList = new ArrayList();
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = (new StringBuilder("select * from staff where sid in (select staffid from meetingstaff where meetingid in (select mid from meeting where mname = '")).append(mname).append("'))").toString();
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

    public List selectStaffByUsername(String username)
        throws Exception
    {
        List staffList = new ArrayList();
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = (new StringBuilder("select * from staff where username = '")).append(username).append("'").toString();
        Staff staff;
        for(ResultSet rs = stm.executeQuery(sql); rs.next(); staffList.add(staff))
        {
            staff = new Staff();
            int sid = rs.getInt("sid");
            String realname = rs.getString("realname");
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

    public int selectStaffByUserAndPwd(String username, String password)
        throws Exception
    {
        int i = 0;
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = (new StringBuilder("select * from staff where username = '")).append(username).append("' and password = '").append(password).append("'").toString();
        for(ResultSet rs = stm.executeQuery(sql); rs.next();)
            i = 1;

        return i;
    }

    public int selectSidByUsername(String username)
        throws Exception
    {
        int i = -999;
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = (new StringBuilder("select sid from staff where username = '")).append(username).append("'").toString();
        for(ResultSet rs = stm.executeQuery(sql); rs.next();)
            i = rs.getInt("sid");

        return i;
    }

    public int queryMidByMname(String mname)
        throws Exception
    {
        int mid = -999;
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = (new StringBuilder("select mid from meeting where mname = '")).append(mname).append("'").toString();
        for(ResultSet rs = stm.executeQuery(sql); rs.next();)
            mid = rs.getInt("mid");

        return mid;
    }

    public int queryRoomidByRoomname(String roomname)
        throws Exception
    {
        int roomid = 0;
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = (new StringBuilder("select roomid from meetingroom where roomname like '%")).append(roomname).append("%'").toString();
        for(ResultSet rs = stm.executeQuery(sql); rs.next();)
            roomid = rs.getInt("roomid");

        return roomid;
    }

    public int queryResidByResname(String realname)
        throws Exception
    {
        int resid = 0;
        Connection conn = DbUtils.getConn();
        Statement stm = conn.createStatement();
        String sql = (new StringBuilder("select sid from staff where realname like '%")).append(realname).append("%'").toString();
        for(ResultSet rs = stm.executeQuery(sql); rs.next();)
            resid = rs.getInt("sid");

        return resid;
    }
}
