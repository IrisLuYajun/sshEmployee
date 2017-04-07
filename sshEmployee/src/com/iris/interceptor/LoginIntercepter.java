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
 * �Զ�����������������
 * 1���Զ����������̳���AbstractInterceptor������д���е�intercept����
 * 2����struts.xml�ж����������
 * 3������Ӧ��action��ʹ�����������߶���ȫ��������
 */
public class LoginIntercepter extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		System.out.println("������ִ���ˣ�");
		System.out.println("���õ�Action�ࣺ"+arg0.getAction().getClass().getName());
		System.out.println("���õ�action����"+arg0.getProxy().getActionName());
		System.out.println("���õķ�����"+arg0.getProxy().getMethod());
		System.out.println("session���ݣ�"+arg0.getInvocationContext().getSession());
		System.out.println("�û����ǣ�"+arg0.getInvocationContext().getSession().get(Constants.USER_SESSION));
		if(arg0.getProxy().getMethod().equals("login")){
			System.out.println("��½�ˣ�");
			return arg0.invoke();
		};
		ActionContext ctx = arg0.getInvocationContext();
		Map session = ctx.getSession();
		Object user = session.get(Constants.USER_SESSION);
		System.out.println("�û����ǣ�"+user);
		if(user != null) {
			System.out.println("��½�ˣ�");
			return arg0.invoke();
			
		}else{
			System.out.println("û��¼");
			return  Action.LOGIN;
			
		}
		
	}

	

}
