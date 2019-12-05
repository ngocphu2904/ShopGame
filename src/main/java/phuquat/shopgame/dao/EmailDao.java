package phuquat.shopgame.dao;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import phuquat.shopgame.cauhinh.MailConfig;
import phuquat.shopgame.entity.NguoiDung;
import phuquat.shopgame.entity.TaiKhoan;

public class EmailDao {
	
	public void guiEmail(NguoiDung nguoiDung, TaiKhoan taiKhoan) {
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
        	
        	String subject = "Mua tài khoản đột kích thành công tại Shop PhuQuat";
        	String text = "Chúc mừng bạn "+nguoiDung.getTenNguoiDung()+" đã mua thành công tài khoản số "+taiKhoan.getMa()+"\n"
            		+"Tài khoản: "+taiKhoan.getTenTaiKhoan()+"\n"+"Mật khẩu: "+taiKhoan.getMatKhauTaiKhoan()+"\n"+"Câu hỏi bảo mật: "+taiKhoan.getCauHoiBaoMat()+"\n"
            		+"Câu trả lời bí mật: "+taiKhoan.getCauTraLoiBaoMat()+"\n"+"CMND: "+taiKhoan.getCMND()+"\n"+"Email tài khoản: "+taiKhoan.getEmailTaiKhoan();
        	
            MimeMessage message = new MimeMessage(session);
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(nguoiDung.getEmail()));
            message.setSubject(subject, "UTF-8");
            message.setText(text, "UTF-8");
 
            // send message
            Transport.send(message);
 
            System.out.println("Da gui mail thanh cong cho "+nguoiDung.getEmail());
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
