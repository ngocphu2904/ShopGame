package phuquat.shopgame.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import phuquat.shopgame.entity.NguoiDung;
import phuquat.shopgame.entity.TaiKhoan;
import phuquat.shopgame.model.NguoiDungModel;

public class NguoiDungDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	

	public NguoiDung timNguoiDung(String tenDangNhap) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(NguoiDung.class, tenDangNhap);
	}
	
	public void luuNguoiDung(NguoiDung nguoidung) {
		
		nguoidung.setKichHoat(true);
		nguoidung.setKieuNguoiDung("NGUOI_DUNG");
		nguoidung.setTien(0);
		Session session = this.sessionFactory.getCurrentSession();
		session.save(nguoidung);
	}
	public boolean checkuser (NguoiDung nguoidung) {
		
		Session session = sessionFactory.getCurrentSession();//
		String sql = "FROM "+NguoiDung.class.getName()+" E WHERE E.tenDangNhap = :tendangnhap";
		
		Query<?> query = session.createQuery(sql);
		query.setParameter("tendangnhap", nguoidung.getTenDangNhap());
		if(query.list().size() >= 1)
		return true;
		return false;
	}

}
