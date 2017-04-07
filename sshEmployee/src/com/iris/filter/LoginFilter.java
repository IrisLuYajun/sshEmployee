package com.iris.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iris.utils.Constants;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("dofilter方法执行了！");
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		Object user = request.getSession().getAttribute(Constants.USER_SESSION);
		System.out.println("用户是："+user);
		System.out.println("请求的是"+request.getRequestURI());
		if(!isExcludeURI(request.getRequestURI())){//如果不是访问登录界面
			if(user == null){//如果没登录
				response.sendRedirect(request.getContextPath()+"/index.jsp");
				return;
			}
		};
		
		arg2.doFilter(arg0, arg1);
		
	}
	public static boolean isExcludeURI(String uri){//并非所有的jsp请求都经过过滤器，登录界面的index.jsp就不经过过滤器
		
		return  uri.equals("/sshEmployee/index.jsp");
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
