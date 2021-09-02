// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AccountBiz.java

package biz;

import bean.*;
import dao.AccountDao;
import java.util.List;

public class AccountBiz
{

    public AccountBiz()
    {
    }

    public boolean queryRoleByUsername(String username)
        throws Exception
    {
        AccountDao dao = new AccountDao();
        return dao.queryRoleByUsername(username);
    }

    public int queryStatusByUsername(String username, String password)
        throws Exception
    {
        AccountDao dao = new AccountDao();
        return dao.queryStatusByUsername(username, password);
    }

    public MeetingRoom queryRoomDetailsByRoomname(String roomname)
        throws Exception
    {
        AccountDao dao = new AccountDao();
        return dao.queryRoomDetailsByRoomname(roomname);
    }

    public String queryNameById(int sid)
        throws Exception
    {
        AccountDao dao = new AccountDao();
        return dao.queryNameById(sid);
    }

    public boolean changePwd(String username, String password1, String password2, String password)
        throws Exception
    {
        AccountDao dao = new AccountDao();
        return dao.changePwd(username, password1, password2, password);
    }

    public void updateMeetingRoom(int roomnum, String roomname, int maxpnum, int status, String explain, int roomid)
        throws Exception
    {
        AccountDao dao = new AccountDao();
        dao.updateMeetingRoom(roomnum, roomname, maxpnum, status, explain, roomid);
    }

    public int editDepartment(int did, String dname)
        throws Exception
    {
        AccountDao dao = new AccountDao();
        return dao.editDepartment(did, dname);
    }

    public void deleteDepartmentsById(int did)
        throws Exception
    {
        AccountDao dao = new AccountDao();
        dao.deleteDepartmentsById(did);
    }

    public void deleteMeeting(String mname, String canclereason)
        throws Exception
    {
        AccountDao dao = new AccountDao();
        dao.deleteMeeting(mname, canclereason);
    }

    public void updateStaffStatus(String username, int status)
        throws Exception
    {
        AccountDao dao = new AccountDao();
        dao.updateStaffStatus(username, status);
    }

    public void insertStaff(Staff staff)
        throws Exception
    {
        AccountDao dao = new AccountDao();
        dao.insertStaff(staff);
    }

    public void insertMeetingStaff(MeetingStaff ms)
        throws Exception
    {
        AccountDao dao = new AccountDao();
        dao.insertMeetingStaff(ms);
    }

    public void insertMeeting(Meeting m)
        throws Exception
    {
        AccountDao dao = new AccountDao();
        dao.insertMeeting(m);
    }

    public int insertDepart(String dname)
        throws Exception
    {
        AccountDao dao = new AccountDao();
        return dao.insertDepart(dname);
    }

    public void insertMeetingRoom(int roomnum, String roomname, int maxpnum, int status, String explain, int sid)
        throws Exception
    {
        AccountDao dao = new AccountDao();
        dao.insertMeetingRoom(roomnum, roomname, maxpnum, status, explain, sid);
    }

    public List selectAttendMeetingById(String username)
        throws Exception
    {
        AccountDao dao = new AccountDao();
        return dao.selectAttendMeetingById(username);
    }

    public List selectReserveMeetingByResId(String username)
        throws Exception
    {
        AccountDao dao = new AccountDao();
        return dao.selectReserveMeetingByResId(username);
    }

    public List selectAllDepart()
        throws Exception
    {
        AccountDao dao = new AccountDao();
        return dao.selectAllDepart();
    }

    public String selectReserveNameByMeetingId(int mid)
        throws Exception
    {
        AccountDao dao = new AccountDao();
        return dao.selectReserveNameByMeetingId(mid);
    }

    public List queryMeetingRoomByTime(String sTime, String eTime)
        throws Exception
    {
        AccountDao dao = new AccountDao();
        return dao.queryMeetingRoomByTime(sTime, eTime);
    }

    public List queryAllMeetingRoom()
        throws Exception
    {
        AccountDao dao = new AccountDao();
        return dao.queryAllMeetingRoom();
    }

    public List queryAllMeetingStaff()
        throws Exception
    {
        AccountDao dao = new AccountDao();
        return dao.queryAllMeetingStaff();
    }

    public List queryAllMeeting()
        throws Exception
    {
        AccountDao dao = new AccountDao();
        return dao.queryAllMeeting();
    }

    public List queryAllDepartment()
        throws Exception
    {
        AccountDao dao = new AccountDao();
        return dao.queryAllDepartment();
    }

    public List queryAllStaff()
        throws Exception
    {
        AccountDao dao = new AccountDao();
        return dao.queryAllStaff();
    }

    public Department queryDepartmentsById(int did)
        throws Exception
    {
        AccountDao dao = new AccountDao();
        return dao.queryDepartmentsById(did);
    }

    public List queryMeetingByMRR(String mname, int roomid, int resid)
        throws Exception
    {
        AccountDao dao = new AccountDao();
        return dao.queryMeetingByMRR(mname, roomid, resid);
    }

    public List queryStaffByDid(int did)
        throws Exception
    {
        AccountDao dao = new AccountDao();
        return dao.queryStaffByDid(did);
    }

    public String selectRoomNameByRoomId(int roomid)
        throws Exception
    {
        AccountDao dao = new AccountDao();
        return dao.selectRoomNameByRoomId(roomid);
    }

    public Meeting selectMeetingByMname(String mname)
        throws Exception
    {
        AccountDao dao = new AccountDao();
        return dao.selectMeetingByMname(mname);
    }

    public List selectMeetingListByUsername(String username)
        throws Exception
    {
        AccountDao dao = new AccountDao();
        return dao.selectMeetingListByUsername(username);
    }

    public List selectMeetingListByUsername7(String username)
        throws Exception
    {
        AccountDao dao = new AccountDao();
        return dao.selectMeetingListByUsername7(username);
    }

    public List selectStaffListByMname(String mname)
        throws Exception
    {
        AccountDao dao = new AccountDao();
        return dao.selectStaffListByMname(mname);
    }

    public List selectStaffByUsername(String username)
        throws Exception
    {
        AccountDao dao = new AccountDao();
        return dao.selectStaffByUsername(username);
    }

    public int selectStaffByUserAndPwd(String username, String password)
        throws Exception
    {
        AccountDao dao = new AccountDao();
        return dao.selectStaffByUserAndPwd(username, password);
    }

    public int selectSidByUsername(String username)
        throws Exception
    {
        AccountDao dao = new AccountDao();
        return dao.selectSidByUsername(username);
    }

    public int queryMidByMname(String mname)
        throws Exception
    {
        AccountDao dao = new AccountDao();
        return dao.queryMidByMname(mname);
    }

    public int queryRoomidByRoomname(String roomname)
        throws Exception
    {
        AccountDao dao = new AccountDao();
        return dao.queryRoomidByRoomname(roomname);
    }

    public int queryResidByResname(String resname)
        throws Exception
    {
        AccountDao dao = new AccountDao();
        return dao.queryResidByResname(resname);
    }
}
