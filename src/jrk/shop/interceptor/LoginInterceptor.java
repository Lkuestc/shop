package jrk.shop.interceptor;

import jrk.shop.adminuser.AdminUser;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation actionInvocation)
			throws Exception {
		AdminUser existAdminUser = (AdminUser) ServletActionContext
				.getRequest().getSession().getAttribute("existAdminUser");
		if (existAdminUser != null) {
			return actionInvocation.invoke();
		} else {
			ActionSupport action = (ActionSupport) actionInvocation.getAction();
			action.addActionError("Äú»¹Ã»ÓÐµÇÂ¼");
			return action.LOGIN;
		}
	}

}
