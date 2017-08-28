package jrk.shop.user;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	private User user = new User();
	private UserService userService;
	private String checkCode;

	@Override
	public User getModel() {
		// System.out.println("注入User");
		return user;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	/**
	 * 跳转到注册页面
	 * 
	 * @return
	 */
	public String registPage() {
		return "registPage_success";
	}

	/**
	 * 注册用户
	 */
	@InputConfig(resultName = "registInput")
	public String regist() {
		String checkCode1 = (String) ServletActionContext.getRequest()
				.getSession().getAttribute("checkCode");
		if (checkCode == null || checkCode.equalsIgnoreCase(checkCode1)) {
			this.addActionError("验证码错误");
			return "registInput";

		}
		userService.regist(user);
//		System.out.println(user);
		this.addActionMessage("注册成功!请去邮箱激活!");
		return "regist_success";
	}

	/**
	 * 激活用户
	 */
	public String active() {
		User exitUser = userService.findByCode(user.getCode());
		if (exitUser != null) {
			exitUser.setState(1);
			userService.update(exitUser);
			this.addActionMessage("激活成功，欢迎加入，请登录");
			return "active_success";
		} else {
			this.addActionMessage("激活失败，请重新注册");
			return "active_failed";
		}
	}

	/**
	 * 跳转登录页面
	 */
	public String loginPage() {
		return "loginPage_success";
	}

	/**
	 * 登录
	 */
	@InputConfig(resultName = "loginInput")
	public String login() {
		User exitUser = userService.login(user);
		if (exitUser == null) {
			this.addActionError("用户名或密码错误或账户未激活！！！！");
			return "loginInput";
		}
		ServletActionContext.getRequest().getSession()
				.setAttribute("exitUser", exitUser);
		return "login_success";
	}

	/**
	 * Ajax校验用户名
	 * 
	 * @throws IOException
	 * 
	 */
	public String checkUserName() throws IOException {
		User exitUser = userService.findByUserName(user.getUserName());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		if (exitUser == null) {
			// 用户名可以使用
			response.getWriter().print("<font color='green'>用户名可以使用</font>");
			System.out.println("用户名可以使用");
		} else {
			// 用户名已经存在
			response.getWriter().print("<font color='red'>用户名已经存在</font>");
			System.out.println("用户名已经存在");
		}
		return NONE;
	}
	
	public String quit(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit_success";
	}

}
