package com.mynms.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.mynms.core.base.BaseFilter;

public class MainFilter extends BaseFilter {

    public void doFilter(ServletRequest arg0, ServletResponse arg1,
            FilterChain arg2) throws IOException, ServletException {
    	
        HttpServletRequest request = (HttpServletRequest) arg0;
        request.setCharacterEncoding("utf-8");
        arg1.setCharacterEncoding("utf-8");
        Enumeration<String> names = request.getParameterNames();
        
        while (names.hasMoreElements()) {
            String name = (String) names.nextElement();
            System.out.println(name + "====" + request.getParameter(name));
        }
        arg2.doFilter(arg0, arg1);
    }
}
