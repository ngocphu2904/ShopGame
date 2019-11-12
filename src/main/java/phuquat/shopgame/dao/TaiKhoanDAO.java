package phuquat.shopgame.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import phuquat.shopgame.entity.TaiKhoan;

public class TaiKhoanDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void luuTaiKhoan(TaiKhoan taiKhoan) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(taiKhoan);
	}
	
}
