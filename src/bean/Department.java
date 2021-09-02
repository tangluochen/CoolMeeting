// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Department.java

package bean;


public class Department
{

    public Department()
    {
    }

    public int getDid()
    {
        return did;
    }

    public void setDid(int did)
    {
        this.did = did;
    }

    public String getDname()
    {
        return dname;
    }

    public void setDname(String dname)
    {
        this.dname = dname;
    }

    public int getDstatus()
    {
        return dstatus;
    }

    public void setDstatus(int dstatus)
    {
        this.dstatus = dstatus;
    }

    private int did;
    private String dname;
    private int dstatus;
}
