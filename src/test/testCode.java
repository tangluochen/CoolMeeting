// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   testCode.java

package test;

import biz.AccountBiz;
import dao.AccountDao;
import java.util.ArrayList;

public class testCode
{

    public testCode()
    {
        bl = false;
    }

    public boolean panduan()
    {
        return bl;
    }

    public static void main(String args[])
        throws Exception
    {
        AccountBiz biz = new AccountBiz();
        AccountDao dao = new AccountDao();
        java.util.List meetList = new ArrayList();
        java.util.List staffList = new ArrayList();
    }

    boolean bl;
}
