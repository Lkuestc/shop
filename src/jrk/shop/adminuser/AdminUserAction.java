package jrk.shop.adminuser;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminUserAction extends ActionSupport implements
		ModelDriven<AdminUser> {
	private AdminUserService adminUserService;
	private AdminUser adminUser = new AdminUser();

	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}

	@Override
	public AdminUser getModel() {
		return adminUser;
	}

	public String login() {
		AdminUser existAdminUser = adminUserService.login(adminUser);
		if (existAdminUser != null) {
			// ��¼�ɹ�
			ServletActionContext.getRequest().getSession()
					.setAttribute("existAdminUser", existAdminUser);
			return "login_success";
		} else {
			// ��¼ʧ��
			this.addActionError("�û������������");
			return LOGIN;
		}
	}
}
