package phuquat.shopgame.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import phuquat.shopgame.entity.NguoiDung;

public class NguoiDungDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public NguoiDung timNguoiDung(String tenDangNhap) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(NguoiDung.class, tenDangNhap);
	}
}
