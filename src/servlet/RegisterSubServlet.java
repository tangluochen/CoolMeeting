// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RegisterSubServlet.java

package servlet;

import bean.Staff;
import biz.AccountBiz;
import java.io.IOException;
import java.io.PrintStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/RegisterSubServlet")
public class RegisterSubServlet extends HttpServlet
{

    public RegisterSubServlet()
    {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        HttpSession s = request.getSession();
        Staff sf = (Staff)s.getAttribute("staff");
        AccountBiz accountBiz = new AccountBiz();
        try
        {
            String realname = request.getParameter("realname");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String confirmpassword = request.getParameter("confirmpassword");
            int did = Integer.parseInt(request.getParameter("did"));
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            Staff staff = new Staff();
            if(password.equals(confirmpassword))
            {
                staff.setRealname(realname);
                staff.setUsername(username);
                staff.setPassword(password);
                staff.setDid(did);
                staff.setPhone(phone);
                staff.setEmail(email);
                accountBiz.insertStaff(staff);
                System.out.println(sf);
                if(sf == null)
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                else
                    request.getRequestDispatcher("QueryStaffSubServlet").forward(request, response);
            } else
            {
                request.setAttribute("errorpwd", "\u5BC6\u7801\u8F93\u5165\u4E0D\u4E00\u81F4 \u91CD\u8BD5");
                request.getRequestDispatcher("RegisterServlet").forward(request, response);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private static final long serialVersionUID = 1L;
}
