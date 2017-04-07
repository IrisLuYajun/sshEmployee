package com.iris.interceptor;

import java.util.Map;

import org.aopalliance.intercept.Invocation;

import com.iris.utils.Constants;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

/*
 * 自定义拦截器共有三步
 * 1、自定义拦截器继承自AbstractInterceptor，并重写其中的intercept方法
 * 2、在struts.xml中定义该拦截器
 * 3、在相应的action下使用拦截器或者定义全局拦截器
 */
public class LoginIntercepter extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		System.out.println("拦截器执行了！");
		System.out.println("调用的Action类："+arg0.getAction().getClass().getName());
		System.out.println("配置的action名："+arg0.getProxy().getActionName());
		System.out.println("调用的方法："+arg0.getProxy().getMethod());
		System.out.println("session内容："+arg0.getInvocationContext().getSession());
		System.out.println("用户名是："+arg0.getInvocationContext().getSession().get(Constants.USER_SESSION));
		if(arg0.getProxy().getMethod().equals("login")){
			System.out.println("登陆了！");
			return arg0.invoke();
		};
		ActionContext ctx = arg0.getInvocationContext();
		Map session = ctx.getSession();
		Object user = session.get(Constants.USER_SESSION);
		System.out.println("用户名是："+user);
		if(user != null) {
			System.out.println("登陆了！");
			return arg0.invoke();
			
		}else{
			System.out.println("没登录");
			return  Action.LOGIN;
			
		}
		
	}

	

}
