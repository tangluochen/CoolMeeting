// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CharacterFilter.java

package filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CharacterFilter
    implements Filter
{

    public CharacterFilter()
    {
    }

    public void destory()
    {
    }

    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
        throws IOException, ServletException
    {
        HttpServletRequest request = (HttpServletRequest)arg0;
        HttpServletResponse response = (HttpServletResponse)arg1;
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        arg2.doFilter(arg0, arg1);
    }

    public void init(FilterConfig filterconfig)
        throws ServletException
    {
    }
}
