// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FenYeBiz.java

package biz;

import dao.FenYeDao;
import java.util.List;

public class FenYeBiz
{

    public FenYeBiz()
    {
    }

    public List queryMeetingByMRR(String mname, int roomid, int resid, String Mstartdate, String Menddate, int startTiaoNum, int endTiaoNum, 
            int tiaoNum)
        throws Exception
    {
        FenYeDao dao = new FenYeDao();
        return dao.queryMeetingByMRR(mname, roomid, resid, Mstartdate, Menddate, startTiaoNum, endTiaoNum, tiaoNum);
    }

    public int getCountMM(String mname, int roomid, int resid, String startdate, String enddate)
        throws Exception
    {
        FenYeDao dao = new FenYeDao();
        return dao.getCountMM(mname, roomid, resid, startdate, enddate);
    }

    public List queryStaffByRUS(String realname, String username, int status, int startTiaoNum, int endTiaoNum, int tiaoNum)
        throws Exception
    {
        FenYeDao dao = new FenYeDao();
        return dao.queryStaffByRUS(realname, username, status, startTiaoNum, endTiaoNum, tiaoNum);
    }

    public int getCountS(String realname, String username, int status)
        throws Exception
    {
        FenYeDao dao = new FenYeDao();
        return dao.getCountS(realname, username, status);
    }

    public List queryMeeting(int startTiaoNum, int endTiaoNum, int tiaoNum)
        throws Exception
    {
        FenYeDao dao = new FenYeDao();
        return dao.queryMeeting(startTiaoNum, endTiaoNum, tiaoNum);
    }

    public List queryStaff(int startTiaoNum, int endTiaoNum, int tiaoNum)
        throws Exception
    {
        FenYeDao dao = new FenYeDao();
        return dao.queryStaff(startTiaoNum, endTiaoNum, tiaoNum);
    }

    public int getCountM()
        throws Exception
    {
        FenYeDao dao = new FenYeDao();
        return dao.getCountM();
    }

    public int getCount()
        throws Exception
    {
        FenYeDao dao = new FenYeDao();
        return dao.getCount();
    }
}
