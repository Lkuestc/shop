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
		// ���÷��ͷ�����
		props.setProperty("mail.smtp", "localhost");
		// session�������������������
		Session session = Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("jrk@shop.com", "jrk");
			}
		});
//		System.out.println(session);
		// �ʼ���Ϣ
		Message message = new MimeMessage(session);
		// ������
		message.setFrom(new InternetAddress("jrk@shop.com"));
		// �ռ���
		message.setRecipient(RecipientType.TO, new InternetAddress(to));
		// ���ñ���
		message.setSubject("����SHOP�̳ǵļ����ʼ�");
		// ��������
		message.setContent(
				"<h1>����SHOP�̳ǵļ����ʼ�</h1><br/><h3><a href='http://192.168.1.130:8080/shop1/user_active.action?code="
						+ code
						+ "'>http://192.168.1.130:8080/shop1/user_active.action?code="
						+ code + "</a><h3>", "text/html;charset=Utf-8");

		// ���Ͷ���
		Transport.send(message);

	}
}
