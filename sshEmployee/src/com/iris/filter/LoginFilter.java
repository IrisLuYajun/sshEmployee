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
		System.out.println("dofilter����ִ���ˣ�");
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		Object user = request.getSession().getAttribute(Constants.USER_SESSION);
		System.out.println("�û��ǣ�"+user);
		System.out.println("�������"+request.getRequestURI());
		if(!isExcludeURI(request.getRequestURI())){//������Ƿ��ʵ�¼����
			if(user == null){//���û��¼
				response.sendRedirect(request.getContextPath()+"/index.jsp");
				return;
			}
		};
		
		arg2.doFilter(arg0, arg1);
		
	}
	public static boolean isExcludeURI(String uri){//�������е�jsp���󶼾�������������¼�����index.jsp�Ͳ�����������
		
		return  uri.equals("/sshEmployee/index.jsp");
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
