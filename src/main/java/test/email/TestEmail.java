package test.email;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import com.bstek.bdf2.core.business.IUser;
import com.bstek.bdf2.core.message.EmailSender;
import com.bstek.bdf2.core.message.MessagePacket;
import com.bstek.bdf2.core.model.DefaultUser;

public class TestEmail {
	public static void main(String[] args) throws UnsupportedEncodingException, MessagingException {
		new TestEmail().main1();
	}
	public void main2() throws MessagingException, UnsupportedEncodingException {
		final String smtpFrom = "hksda@bsdn.cn";
		System.out.println("sendEmail....1....");
		Session session = this.getMailSession();
		MimeMessage mimeMsg = new MimeMessage(session);
		mimeMsg.setSubject(MimeUtility.encodeText("okaba","GBK","B"));
		mimeMsg.setFrom(new InternetAddress(smtpFrom));
		System.out.println("sendEmail ....2....");
		List<InternetAddress> addressList = new ArrayList<InternetAddress>();
		addressList.add(new InternetAddress("405263645@qq.com"));					
		InternetAddress[] addressArray = new InternetAddress[addressList.size()];
		addressList.toArray(addressArray);
		mimeMsg.setRecipients(javax.mail.Message.RecipientType.TO,addressArray);
		Multipart multipart = new MimeMultipart();
		MimeBodyPart mimeBodyPartMessage = new MimeBodyPart();
		String charset ="text/html; charset=utf-8";
		mimeBodyPartMessage.setContent("messagegetCon", charset);
		multipart.addBodyPart(mimeBodyPartMessage);
		mimeMsg.setContent(multipart);
		mimeMsg.setSentDate(new Date());
		System.out.println("sendEmail ....3....");
		Transport.send(mimeMsg);
		System.out.println("sendEmail ....Success....");
	}

private Session getMailSession(){
//	String smtpHost = "smtp.163.com";
//	final String smtpPassword = "abc123";
//	final String smtpUser = "bsdn_oc@163.com";;
//	Properties properties = new Properties();
//	properties.put("mail.smtp.host",smtpHost);
//	properties.put("mail.smtp.auth","true");
	String smtpHost = "mail.bsdn.cn.local";
	final String smtpPassword = "q234";
	final String smtpUser = "hksda";;
	Properties properties = new Properties();
	properties.put("mail.smtp.host",smtpHost);
	properties.put("mail.smtp.auth","true");
	Session	session = Session.getDefaultInstance(properties,
			new Authenticator() {
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(smtpUser,smtpPassword);
		}
	});
	return session;
}
	public void main1() {
		EmailSender sender=new EmailSender();
		String smtpHost = "smtp.163.com";
		String smtpPassword = "abc123";
		//pwd=bsdn2017
		String smtpUser = "bsdn_oc@163.com";;
		String smtpPort = null;
		sender.setSmtpHost(smtpHost);
		sender.setSmtpIsAuth(true);
		sender.setSmtpPassword(smtpPassword);
		sender.setSmtpPort(smtpPort);
		sender.setSmtpUser(smtpUser);
		sender.setDefaultSenderEmailAddress(smtpUser);
		MessagePacket mp = new MessagePacket();
	    mp.setContent("哈老你好啊aaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbcccccccccccccccc "+new Date());
	    mp.setTitle("我是bsdn sender[lucas.yue]");
	    DefaultUser u=new DefaultUser();
	    Collection<IUser>uList=new ArrayList();
	    u.setEmail("yyj0y01@sp.bsdn.cn");
	    uList.add(u);
	    mp.setTo(uList);
		try {
			sender.sendMail(mp, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
