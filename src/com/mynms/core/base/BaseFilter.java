package com.mynms.core.base;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 基础 Filter 类，为所有 Filter 类的基础类，
 * 所有 Filter 类都应该继承自该类，此类为 Filter 提供通用的方法
 * @author 聂林
 */
public abstract class BaseFilter implements Filter {

    public void destroy() {

    }

    public void doFilter(ServletRequest arg0, ServletResponse arg1,
            FilterChain arg2) throws IOException, ServletException {
    }

    public void init(FilterConfig arg0) throws ServletException {
    }

}
