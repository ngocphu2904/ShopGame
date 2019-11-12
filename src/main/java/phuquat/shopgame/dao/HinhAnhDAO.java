package phuquat.shopgame.dao;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import phuquat.shopgame.entity.HinhAnh;
import phuquat.shopgame.entity.TaiKhoan;

public class HinhAnhDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public void luuHinhAnh(TaiKhoan taiKhoan, MultipartFile[] files) {
		Session session = this.sessionFactory.getCurrentSession();
		
		for (MultipartFile file : files) {
			HinhAnh hinhAnh = new HinhAnh();
			hinhAnh.setTaiKhoan(taiKhoan);
			try {
				byte[] image = file.getBytes();
				if (image != null && image.length > 0) {
	                hinhAnh.setHinhAnh(image);
	            }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.save(hinhAnh);
		}
		
		
	}
}
