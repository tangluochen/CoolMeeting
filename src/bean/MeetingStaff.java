// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MeetingStaff.java

package bean;


public class MeetingStaff
{

    public MeetingStaff()
    {
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getMeetingid()
    {
        return meetingid;
    }

    public void setMeetingid(int meetingid)
    {
        this.meetingid = meetingid;
    }

    public int getStaffid()
    {
        return staffid;
    }

    public void setStaffid(int staffid)
    {
        this.staffid = staffid;
    }

    private int id;
    private int meetingid;
    private int staffid;
}
