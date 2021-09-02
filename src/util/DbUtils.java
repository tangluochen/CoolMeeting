// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbUtils.java

package util;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtils
{

    public DbUtils()
    {
    }

    public static Connection getConn()
        throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/meeting?useUnicode=true&characterEncoding=UTF-8", "root", "root");
        return conn;
    }

    public void closeConnection(Connection conn)
        throws Exception
    {
        if(conn != null)
            conn.close();
    }

    public static void main(String args[])
    {
        try
        {
            getConn();
            System.out.println("\u6570\u636E\u5E93\u8FDE\u63A5\u6210\u529F");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("\u6570\u636E\u5E93\u8FDE\u63A5\u5931\u8D25");
        }
    }

    private static Connection conn;
}
