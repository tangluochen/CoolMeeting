// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MeetingRoom.java

package bean;


public class MeetingRoom
{

    public MeetingRoom()
    {
    }

    public int getRoomid()
    {
        return roomid;
    }

    public void setRoomid(int roomid)
    {
        this.roomid = roomid;
    }

    public int getRoomnum()
    {
        return roomnum;
    }

    public void setRoomnum(int roomnum)
    {
        this.roomnum = roomnum;
    }

    public String getRoomname()
    {
        return roomname;
    }

    public void setRoomname(String roomname)
    {
        this.roomname = roomname;
    }

    public int getMaxpnum()
    {
        return maxpnum;
    }

    public void setMaxpnum(int maxpnum)
    {
        this.maxpnum = maxpnum;
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public String getExplain()
    {
        return explain;
    }

    public void setExplain(String explain)
    {
        this.explain = explain;
    }

    public int getSid()
    {
        return sid;
    }

    public void setSid(int sid)
    {
        this.sid = sid;
    }

    private int roomid;
    private int roomnum;
    private String roomname;
    private int maxpnum;
    private int status;
    private String explain;
    private int sid;
}
