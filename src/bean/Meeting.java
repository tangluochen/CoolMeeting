// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Meeting.java

package bean;

import java.util.Date;

public class Meeting
{

    public Meeting()
    {
    }

    public String getCanclereason()
    {
        return canclereason;
    }

    public void setCanclereason(String canclereason)
    {
        this.canclereason = canclereason;
    }

    public int getMid()
    {
        return mid;
    }

    public void setMid(int mid)
    {
        this.mid = mid;
    }

    public String getMname()
    {
        return mname;
    }

    public void setMname(String mname)
    {
        this.mname = mname;
    }

    public int getPnum()
    {
        return pnum;
    }

    public void setPnum(int pnum)
    {
        this.pnum = pnum;
    }

    public Date getStarttime()
    {
        return starttime;
    }

    public void setStarttime(Date starttime)
    {
        this.starttime = starttime;
    }

    public Date getEndtime()
    {
        return endtime;
    }

    public void setEndtime(Date endtime)
    {
        this.endtime = endtime;
    }

    public Date getRestime()
    {
        return restime;
    }

    public void setRestime(Date restime)
    {
        this.restime = restime;
    }

    public int getRoomid()
    {
        return roomid;
    }

    public void setRoomid(int roomid)
    {
        this.roomid = roomid;
    }

    public String getExplain()
    {
        return explain;
    }

    public void setExplain(String explain)
    {
        this.explain = explain;
    }

    public int getResid()
    {
        return resid;
    }

    public void setResid(int resid)
    {
        this.resid = resid;
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    private int mid;
    private String mname;
    private int pnum;
    private Date starttime;
    private Date endtime;
    private Date restime;
    private int roomid;
    private String explain;
    private int resid;
    private int status;
    String canclereason;
}
