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
		// System.out.println("ע��User");
		return user;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	/**
	 * ��ת��ע��ҳ��
	 * 
	 * @return
	 */
	public String registPage() {
		return "registPage_success";
	}

	/**
	 * ע���û�
	 */
	@InputConfig(resultName = "registInput")
	public String regist() {
		String checkCode1 = (String) ServletActionContext.getRequest()
				.getSession().getAttribute("checkCode");
		if (checkCode == null || checkCode.equalsIgnoreCase(checkCode1)) {
			this.addActionError("��֤�����");
			return "registInput";

		}
		userService.regist(user);
//		System.out.println(user);
		this.addActionMessage("ע��ɹ�!��ȥ���伤��!");
		return "regist_success";
	}

	/**
	 * �����û�
	 */
	public String active() {
		User exitUser = userService.findByCode(user.getCode());
		if (exitUser != null) {
			exitUser.setState(1);
			userService.update(exitUser);
			this.addActionMessage("����ɹ�����ӭ���룬���¼");
			return "active_success";
		} else {
			this.addActionMessage("����ʧ�ܣ�������ע��");
			return "active_failed";
		}
	}

	/**
	 * ��ת��¼ҳ��
	 */
	public String loginPage() {
		return "loginPage_success";
	}

	/**
	 * ��¼
	 */
	@InputConfig(resultName = "loginInput")
	public String login() {
		User exitUser = userService.login(user);
		if (exitUser == null) {
			this.addActionError("�û��������������˻�δ���������");
			return "loginInput";
		}
		ServletActionContext.getRequest().getSession()
				.setAttribute("exitUser", exitUser);
		return "login_success";
	}

	/**
	 * AjaxУ���û���
	 * 
	 * @throws IOException
	 * 
	 */
	public String checkUserName() throws IOException {
		User exitUser = userService.findByUserName(user.getUserName());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		if (exitUser == null) {
			// �û�������ʹ��
			response.getWriter().print("<font color='green'>�û�������ʹ��</font>");
			System.out.println("�û�������ʹ��");
		} else {
			// �û����Ѿ�����
			response.getWriter().print("<font color='red'>�û����Ѿ�����</font>");
			System.out.println("�û����Ѿ�����");
		}
		return NONE;
	}
	
	public String quit(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit_success";
	}

}
