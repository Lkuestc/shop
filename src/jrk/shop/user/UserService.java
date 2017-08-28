package jrk.shop.user;

import jrk.shop.utils.MailUtils;
import jrk.shop.utils.UUIDUtils;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * ע���û�
	 * 
	 * @param user
	 */
	public void regist(User user) {

		user.setState(0);// 0 ��ʾδ����; 1 ��ʾ����
		String code = UUIDUtils.getUUID() + UUIDUtils.getUUID();
		user.setCode(code);
		userDao.save(user);
		// �����ʼ�
		try {
			MailUtils.sendMail(user.getEmail(), code);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public User findByCode(String code) {

		return userDao.findByCode(code);

	}

	public void update(User exitUser) {
		userDao.update(exitUser);
	}

	public User login(User user) {
		return userDao.login(user);
	}

	public User findByUserName(String userName) {
		return userDao.findByUserName(userName);
	}

}
