package phuquat.shopgame.dao;

import java.util.Properties;

import javax.mail.Session;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Repository;

import phuquat.shopgame.cauhinh.MailConfig;

@Repository
public class EmailDao {
	
	public void guiemail( String emailNguoiNhan, String tenNguoiMua,String id, String tk ,String mk,
						String cauHoiBaoMat, String cauTraLoiBiMat, String emailtk, String CMND) {
		// Get properties object
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", MailConfig.HOST_NAME);
        props.put("mail.smtp.socketFactory.port", MailConfig.SSL_PORT);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.port", MailConfig.SSL_PORT);
 
        // get Session
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(MailConfig.APP_EMAIL, MailConfig.APP_PASSWORD);
            }
        });
 
        // compose message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailNguoiNhan));
            message.setSubject("Mua acc game thành công tại shopacc phuquat");
            message.setText("Chúc mừng bạn "+tenNguoiMua+" đã mua thành công tài khoản số "+id+"\n"
            		+"Tài khoản: "+tk+"\n"+"Mật khẩu: "+mk+"\n"+"Câu hỏi bảo mật: "+cauHoiBaoMat+"\n"
            		+"câu trả lời bí mật: "+cauTraLoiBiMat+"\n"+"CMND: "+CMND+"\n"+"Email tài khoản: "+emailtk);
 
            // send message
            Transport.send(message);
 
            System.out.println("Đã gửi mail thành công cho"+emailNguoiNhan);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
