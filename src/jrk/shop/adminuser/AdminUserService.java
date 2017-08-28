package jrk.shop.adminuser;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AdminUserService {
	private AdminUserDao adminUserDao;

	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}

	public AdminUser login(AdminUser adminUser) {

		return adminUserDao.login(adminUser);
	}

}
