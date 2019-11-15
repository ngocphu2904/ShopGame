package phuquat.shopgame.dao;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
	
	public void xoaHinhAnhTheoTaiKhoan(TaiKhoan taiKhoan) {
		Session session = this.sessionFactory.getCurrentSession();	
		String sql = "DELETE " + HinhAnh.class.getName() + " h WHERE h.taiKhoan.ma = :ma";
		Query<?> query = session.createQuery(sql);
		query.setParameter("ma", taiKhoan.getMa());
		query.executeUpdate();
	}
	
	public HinhAnh layHinhAnhTheoMa(String maHinhAnh){
		Session session = this.sessionFactory.getCurrentSession();	
		String sql = "FROM " + HinhAnh.class.getName() + " h WHERE h.maHinhAnh = :ma";
		Query<?> query = session.createQuery(sql);
		query.setParameter("ma", maHinhAnh);
		return (HinhAnh) query.uniqueResult();
	}
}
