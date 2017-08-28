package jrk.shop.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class MailUtils {
	public static void sendMail(String to, String code) throws Exception {
		Properties props = new Properties();
		// 设置发送服务器
		props.setProperty("mail.smtp", "localhost");
		// session对象与邮箱服务器连接
		Session session = Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("jrk@shop.com", "jrk");
			}
		});
//		System.out.println(session);
		// 邮件信息
		Message message = new MimeMessage(session);
		// 发件人
		message.setFrom(new InternetAddress("jrk@shop.com"));
		// 收件人
		message.setRecipient(RecipientType.TO, new InternetAddress(to));
		// 设置标题
		message.setSubject("来自SHOP商城的激活邮件");
		// 设置正文
		message.setContent(
				"<h1>来自SHOP商城的激活邮件</h1><br/><h3><a href='http://192.168.1.130:8080/shop1/user_active.action?code="
						+ code
						+ "'>http://192.168.1.130:8080/shop1/user_active.action?code="
						+ code + "</a><h3>", "text/html;charset=Utf-8");

		// 发送对象
		Transport.send(message);

	}
}
