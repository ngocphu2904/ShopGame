package phuquat.shopgame.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import phuquat.shopgame.entity.TaiKhoan;

@Repository
public class TaiKhoanDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void luuTaiKhoan(TaiKhoan taiKhoan) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(taiKhoan);
	}
}
